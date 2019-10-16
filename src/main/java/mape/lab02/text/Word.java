package mape.lab02.text;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Word implements TextItem {

    private List<Char> items;
    private String word;

    public Word(List<Char> chars) {
        this.items = copy(chars);
        this.word = makeText(this.items);
    }

    @Override
    public TYPE getType() {
        return TYPE.WORD;
    }

    @Override
    public String getText() {
        return word;
    }

    public List<Char> getChars() {
        return copy(items);
    }

    private String makeText(List<Char> chars) {
        return chars.stream()
            .map(Char::getText)
            .collect(Collectors.joining());
    }

    private List<Char> copy(List<Char> chars) {
        return chars.stream()
            .map(i -> new Char(i.getText()))
            .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word that = (Word) o;
        return Objects.equals(word, that.word) && items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word;
    }
}
