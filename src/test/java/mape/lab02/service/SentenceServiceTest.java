package mape.lab02.service;

import mape.lab02.text.Char;
import mape.lab02.text.TextItem;
import mape.lab02.text.Word;
import mape.lab02.text.WordDelimiter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class SentenceServiceTest {
    private SentenceService instance;
    private WordService wordService;

    @Before
    public void setUp() {
        wordService = Mockito.mock(WordService.class);
        instance = new SentenceService();
        instance.setWordService(wordService);
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
    public void parseOnlyWord() {
        String text = "hello";

        List<Char> helloList = asList(new Char('h'), new Char('e'), new Char('l'), new Char('l'), new Char('o'));
        when(wordService.parse("hello"))
            .thenReturn(new Word(helloList));
        TextItem expected = new Word(helloList);

        List<TextItem> result = instance.parse(text);

        assertThat(result)
            .hasSize(1)
            .containsExactly(expected);
    }

    @Test
    public void parseOnlyWordDelimiter() {
        String text = " ";
        TextItem expected = new WordDelimiter(" ");

        List<TextItem> result = instance.parse(text);

        assertThat(result)
            .hasSize(1)
            .containsExactly(expected);
    }

    @Test
    public void parseSentenceStartsWithWord() {
        String text = "hello [world)";

        List<Char> helloList = asList(new Char('h'), new Char('e'), new Char('l'), new Char('l'), new Char('o'));
        List<Char> worldList = asList(new Char('w'), new Char('o'), new Char('r'), new Char('l'), new Char('d'));
        when(wordService.parse("hello"))
            .thenReturn(new Word(helloList));
        when(wordService.parse("world"))
            .thenReturn(new Word(worldList));
        List<TextItem> expected = asList(
            new Word(helloList), new WordDelimiter(" "),
            new WordDelimiter("["), new Word(worldList), new WordDelimiter(")"));

        List<TextItem> result = instance.parse(text);

        assertThat(result)
            .hasSize(expected.size())
            .isEqualTo(expected);
    }

    @Test
    public void parseSentenceStartsWithDelimiter() {
        String text = "; hello world";

        List<Char> helloList = asList(new Char('h'), new Char('e'), new Char('l'), new Char('l'), new Char('o'));
        List<Char> worldList = asList(new Char('w'), new Char('o'), new Char('r'), new Char('l'), new Char('d'));
        when(wordService.parse("hello"))
            .thenReturn(new Word(helloList));
        when(wordService.parse("world"))
            .thenReturn(new Word(worldList));
        List<TextItem> expected = asList(
            new WordDelimiter(";"), new WordDelimiter(" "),
            new Word(helloList), new WordDelimiter(" "),
            new Word(worldList));

        List<TextItem> result = instance.parse(text);

        assertThat(result)
            .hasSize(expected.size())
            .isEqualTo(expected);
    }

    @Test(expected = IllegalArgumentException.class)
    public void wordsFromNull() {
        instance.wordsStream(null);
    }

    @Test
    public void wordsStreamSuccess() {
        List<Char> helloList = asList(new Char('h'), new Char('e'), new Char('l'), new Char('l'), new Char('o'));
        List<Char> worldList = asList(new Char('w'), new Char('o'), new Char('r'), new Char('l'), new Char('d'));
        List<TextItem> items = asList(
            new WordDelimiter(";"), new WordDelimiter(" "),
            new Word(helloList), new WordDelimiter(" "),
            new Word(worldList));
        List<Word> expected = asList(new Word(helloList), new Word(worldList));

        List<Word> result = instance.wordsStream(items).collect(Collectors.toList());

        assertThat(result).isEqualTo(expected);
    }
}