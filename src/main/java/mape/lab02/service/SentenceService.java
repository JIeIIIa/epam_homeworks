package mape.lab02.service;

import mape.lab02.text.Sentence;
import mape.lab02.text.TextItem;
import mape.lab02.text.Word;
import mape.lab02.text.WordDelimiter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import static mape.lab02.text.WordDelimiter.CHARACTER_WORD_DELIMITER_REGEX;
import static mape.lab02.text.WordDelimiter.WORD_DELIMITER_PATTERN;

public class SentenceService {
    private static final String SENTENCE_SPLIT_REGEX =
        "((?<=(" + CHARACTER_WORD_DELIMITER_REGEX + "))|(?=" + CHARACTER_WORD_DELIMITER_REGEX + "+))";

    private WordService wordService = new WordService();

    public List<TextItem> parse(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Text should be non null and not empty");
        }

        String[] split = text.split(SENTENCE_SPLIT_REGEX);

        List<TextItem> items = new ArrayList<>(split.length);
        for (String s : split) {
            if (WORD_DELIMITER_PATTERN.matcher(s).find()) {
                items.add(new WordDelimiter(s));
            } else {
                items.add(wordService.parse(s));
            }
        }
        return items;
    }

    public Stream<Word> wordsStream(Sentence sentence) {
        if(sentence == null) {
            throw new IllegalArgumentException("Argument should be non null");
        }

        return sentence.getElements()
            .stream()
            .filter(i -> TextItem.TYPE.WORD.equals(i.getType()))
            .map(i -> (Word) i)
            .map(i -> new Word(i.getChars()));
    }

    void setWordService(WordService wordService) {
        this.wordService = wordService;
    }
}
