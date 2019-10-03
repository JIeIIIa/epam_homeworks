package mape.hw06;


import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class CounterServiceTest {

    private CounterService counterService;

    @Before
    public void setUp() {
        counterService = new CounterService();
    }

    @Test
    public void countEmptyList() {
        List<Integer> list = Collections.emptyList();

        Map<Integer, Long> result = counterService.count(list);

        assertThat(result).size().isEqualTo(0);
    }

    @Test
    public void countListWithSameElements() {
        List<Integer> list = Arrays.asList(42, 42, 42, 42);
        Map<Integer, Long> expected = new HashMap<>();
        expected.put(42, 4L);
        Map<Integer, Long> result = counterService.count(list);

        assertThat(result).size().isEqualTo(1);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void countSuccess() {
        List<Integer> list = Arrays.asList(42, 25, 42, 42, 13, 13);
        Map<Integer, Long> expected = new HashMap<>();
        expected.put(42, 3L);
        expected.put(25, 1L);
        expected.put(13, 2L);
        Map<Integer, Long> result = counterService.count(list);

        assertThat(result).size().isEqualTo(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void countWithStreamEmptyList() {
        List<Integer> list = Collections.emptyList();

        Map<Integer, Long> result = counterService.countWithStream(list);

        assertThat(result).size().isEqualTo(0);
    }

    @Test
    public void countWithStreamListWithSameElements() {
        List<Integer> list = Arrays.asList(42, 42, 42, 42);
        Map<Integer, Long> expected = new HashMap<>();
        expected.put(42, 4L);
        Map<Integer, Long> result = counterService.countWithStream(list);

        assertThat(result).size().isEqualTo(1);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void countWithStreamSuccess() {
        List<Integer> list = Arrays.asList(42, 25, 42, 42, 13, 13);
        Map<Integer, Long> expected = new HashMap<>();
        expected.put(42, 3L);
        expected.put(25, 1L);
        expected.put(13, 2L);
        Map<Integer, Long> result = counterService.countWithStream(list);

        assertThat(result).size().isEqualTo(3);
        assertThat(result).isEqualTo(expected);
    }
}