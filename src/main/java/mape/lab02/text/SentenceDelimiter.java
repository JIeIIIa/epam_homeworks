package mape.lab02.text;

import java.util.Objects;

public class SentenceDelimiter implements TextItem {
    public static final String CHARACTER_SENTENCE_DELIMITER_REGEX = "[.!?]";
    private final String text;

    public SentenceDelimiter(String text) {
        this.text = text;
    }

    @Override
    public TextItem.TYPE getType() {
        return TYPE.SENTENCE_DELIMITER;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SentenceDelimiter that = (SentenceDelimiter) o;
        return Objects.equals(text, that.text);
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