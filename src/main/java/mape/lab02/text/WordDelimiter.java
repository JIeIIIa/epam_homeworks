package mape.lab02.text;

import java.util.Objects;
import java.util.regex.Pattern;

public class WordDelimiter implements TextItem {
    public static final String CHARACTER_WORD_DELIMITER_REGEX = "[,\\s;:\"()\\[\\]]";
    public static final Pattern WORD_DELIMITER_PATTERN = Pattern.compile(CHARACTER_WORD_DELIMITER_REGEX + "+");;

    private final String text;

    public WordDelimiter(String text) {
        this.text = text;
    }

    @Override
    public TextItem.TYPE getType() {
        return TextItem.TYPE.WORD_DELIMITER;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordDelimiter that = (WordDelimiter) o;
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
