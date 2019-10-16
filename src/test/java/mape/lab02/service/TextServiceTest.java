package mape.lab02.service;

import mape.lab02.text.Char;
import mape.lab02.text.Sentence;
import mape.lab02.text.SentenceDelimiter;
import mape.lab02.text.Text;
import mape.lab02.text.TextItem;
import mape.lab02.text.Word;
import mape.lab02.text.WordDelimiter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class TextServiceTest {
    private TextService instance;
    private SentenceService sentenceService;

    @Before
    public void setUp() {
        sentenceService = Mockito.mock(SentenceService.class);
        instance = new TextService();
        instance.setSentenceService(sentenceService);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNull() {
        instance.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyString() {
        instance.parse("");
    }

    @Test
    public void parseOnlySentence() {
        String text = "hello";

        List<Char> helloList = asList(new Char('h'), new Char('e'), new Char('l'), new Char('l'), new Char('o'));
        when(sentenceService.parse("hello")).thenReturn(singletonList(new Word(helloList)));
        Text expected = new Text(singletonList(new Sentence(singletonList(new Word(helloList)))));

        Text result = instance.parse(text);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void parseOnlySentenceDelimiter() {
        String text = "!";
        Text expected = new Text(singletonList(new SentenceDelimiter("!")));

        Text result = instance.parse(text);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void parseText() {
        String text = "hello! world";

        List<Char> helloList = asList(new Char('h'), new Char('e'), new Char('l'), new Char('l'), new Char('o'));
        List<Char> worldList = asList(new Char('w'), new Char('o'), new Char('r'), new Char('l'), new Char('d'));
        List<TextItem> first = singletonList(new Word(helloList));
        when(sentenceService.parse("hello")).thenReturn(first);
        List<TextItem> second = asList(new WordDelimiter("["), new Word(worldList));
        when(sentenceService.parse(" world")).thenReturn(second);
        Text expected = new Text(asList(
            new Sentence(first), new SentenceDelimiter("!"), new Sentence(second)));

        Text result = instance.parse(text);

        assertThat(result)
            .isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void sentenceStreamFromNull() {
        instance.sentenceStream(null);
    }

    @Test
    public void sentenceStreamSuccess() {
        List<Char> helloList = asList(new Char('h'), new Char('e'), new Char('l'), new Char('l'), new Char('o'));
        List<Char> worldList = asList(new Char('w'), new Char('o'), new Char('r'), new Char('l'), new Char('d'));
        List<TextItem> items = asList(
            new WordDelimiter(";"), new WordDelimiter(" "),
            new Word(helloList), new WordDelimiter(" "),
            new Word(worldList));
        Sentence sentence = new Sentence(items);
        List<Sentence> expected = singletonList(sentence);
        Text text = new Text(asList(new SentenceDelimiter("?"), sentence, new SentenceDelimiter("!")));

        List<Sentence> result = instance.sentenceStream(text).collect(Collectors.toList());

        assertThat(result).isEqualTo(expected);
    }
}