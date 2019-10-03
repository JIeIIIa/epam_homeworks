package mape.lab02.service;

import mape.lab02.text.Char;
import mape.lab02.text.Word;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordService {

    public Word parse(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word should be non null");
        }

        List<Char> chars = Arrays.stream(word.split(""))
            .map(Char::new)
            .collect(Collectors.toList());

        return new Word(chars);
    }

    public long charCount(Word word, char ch) {
        if (word == null) {
            throw new IllegalArgumentException("Word should be non null");
        }

        return word.getChars().stream()
            .map(Char::getText)
            .filter(c -> c.equals("" + ch))
            .count();
    }
}
