package mape.lab02.service;

import mape.lab02.text.Word;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class WordServiceTest {

    private WordService instance;

    @Before
    public void setUp() {
        instance = new WordService();
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseNullString() {
        instance.parse(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseEmptyString() {
        instance.parse("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void charCountInNullWord() {
        instance.charCount(null, 'a');
    }

    @Test
    public void wordHasNoSameChar() {
        Word word = instance.parse("Hello");

        long result = instance.charCount(word, 'a');

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void charCountInWordWithDesiredChar() {
        Word word = instance.parse("Hello");

        long result = instance.charCount(word, 'l');

        assertThat(result).isEqualTo(2);
    }
}