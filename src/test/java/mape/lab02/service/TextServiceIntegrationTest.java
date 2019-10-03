package mape.lab02.service;

import mape.lab02.text.Text;
import mape.lab02.text.Word;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

public class TextServiceIntegrationTest {
    private TextService instance;

    @Before
    public void setUp() {
        instance = new TextService();
    }

    @Test
    public void sortWithoutTargetChar() {
        String text = "first,  second,  alfa, star";
        Text parsed = instance.parse(text);

        List<String> result = instance.sortByCharCount(parsed, 'w')
            .stream()
            .map(Word::getText)
            .collect(Collectors.toList());

        Assertions.assertThat(result).containsExactly("alfa", "first", "second", "star");
    }

    @Test
    public void sortWithSameCountTargetChar() {
        String text = "firsta,  asecond,  alf, star";
        Text parsed = instance.parse(text);

        List<String> result = instance.sortByCharCount(parsed, 'a')
            .stream()
            .map(Word::getText)
            .collect(Collectors.toList());

        Assertions.assertThat(result).containsExactly("alf", "asecond", "firsta", "star");
    }

    @Test
    public void sortDifferent() {
        String text = "first?  second!  alfa, star.";
        Text parsed = instance.parse(text);

        List<String> result = instance.sortByCharCount(parsed, 'a')
            .stream()
            .map(Word::getText)
            .collect(Collectors.toList());

        Assertions.assertThat(result).containsExactly("alfa", "star", "first", "second");
    }
}
