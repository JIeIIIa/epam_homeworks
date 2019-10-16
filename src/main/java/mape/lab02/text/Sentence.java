package mape.lab02.text;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Sentence implements TextItem {
    public static final Pattern WORD_PATTERN = Pattern.compile("[^,\\s;:\"]+");
    public static final Pattern SENTENCE_PATTERN = Pattern.compile("[^.!?]");

    private final String text;

    private List<TextItem> items;

    public Sentence(List<TextItem> items) {
        this.items = copy(items);
        this.text = makeText(this.items);

    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public TYPE getType() {
        return TYPE.SENTENCE;
    }

    public List<TextItem> getElements() {
        return copy(items);
    }

    private String makeText(List<TextItem> textItems) {
        return textItems
            .stream()
            .map(TextItem::getText)
            .collect(Collectors.joining());
    }

    private List<TextItem> copy(List<TextItem> textItems) {
        return textItems.stream()
            .map(this::createCopy)
            .collect(Collectors.toList());
    }

    private TextItem createCopy(TextItem item) {
        if (TYPE.WORD.equals(item.getType())) {
            return new Word(((Word) item).getChars());
        } else if (TYPE.WORD_DELIMITER.equals(item.getType())) {
            return new WordDelimiter(item.getText());
        } else {
            throw new IllegalArgumentException("Wrong type: " + item.getType());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(text, sentence.text) && items.equals(sentence.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return text;
    }


}
