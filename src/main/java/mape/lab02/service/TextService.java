package mape.lab02.service;

import mape.lab02.text.Char;
import mape.lab02.text.Sentence;
import mape.lab02.text.SentenceDelimiter;
import mape.lab02.text.Text;
import mape.lab02.text.TextItem;
import mape.lab02.text.Word;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static mape.lab02.text.SentenceDelimiter.CHARACTER_SENTENCE_DELIMITER_REGEX;

public class TextService {
    public static final String SENTENCE_SPLIT_REGEX =
        "((?<=(" + CHARACTER_SENTENCE_DELIMITER_REGEX + "))" + "|" +
            "(?=" + CHARACTER_SENTENCE_DELIMITER_REGEX + "+))";

    private SentenceService sentenceService = new SentenceService();
    private WordService wordService = new WordService();

    public Text parse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text should be non null and not empty");
        }

        String[] split = text.split(SENTENCE_SPLIT_REGEX);

        List<TextItem> items = new ArrayList<>(split.length);
        for (String s : split) {
            if (Sentence.SENTENCE_PATTERN.matcher(s).find()) {
                items.add(new Sentence(sentenceService.parse(s)));
            } else {
                items.add(new SentenceDelimiter(s));
            }
        }

        return new Text(items);
    }

    public Stream<Sentence> sentenceStream(Text text) {
        if(text == null) {
            throw new IllegalArgumentException("Argument should be non null");
        }

        return text.getElements()
            .stream()
            .filter(i -> TextItem.TYPE.SENTENCE.equals(i.getType()))
            .map(i -> (Sentence) i)
            .map(i -> new Sentence(i.getElements()));
    }

    public List<Word> sortByCharCount(Text text, final Char ch) {
        if (text == null) {
            throw new IllegalArgumentException("Text should be non null");
        }

        Comparator<Word> wordComparator = Comparator
            .comparingLong((Word w) -> wordService.charCount(w, ch))
//            .reversed()
            .thenComparing(Word::getText);

        return sentenceStream(text)
            .flatMap(sentenceService::wordsStream)
            .sorted(wordComparator)
            .collect(Collectors.toList());
    }

    void setSentenceService(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    public void setWordService(WordService wordService) {
        this.wordService = wordService;
    }
}
