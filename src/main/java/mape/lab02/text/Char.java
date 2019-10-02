package mape.lab02.text;

import java.util.Objects;

public class Char implements TextItem {
    private final char ch;

    public Char(String ch) {
        if(ch == null || ch.length() != 1) {
            throw new IllegalArgumentException();
        }

        this.ch = ch.charAt(0);
    }

    public Char(char ch) {
        this.ch = ch;
    }

    @Override
    public String getText() {
        return "" + ch;
    }

    @Override
    public TYPE getType() {
        return TYPE.CHAR;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Char aChar = (Char) o;
        return ch == aChar.ch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ch);
    }
}
