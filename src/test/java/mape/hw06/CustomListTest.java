package mape.hw06;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomListTest {

    private CustomList<Integer> list;

    @Before
    public void setUp() {
        list = new CustomList<>();
    }

    @Test
    public void emptyList() {
        assertThat(list.isEmpty()).isTrue();
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    public void nonEmptyList() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertThat(list.isEmpty()).isFalse();
        assertThat(list.size()).isEqualTo(3);

    }

    @Test
    public void addFirst() {
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        assertThat(list.get(0)).isEqualTo(3);
        assertThat(list.get(1)).isEqualTo(2);
        assertThat(list.get(2)).isEqualTo(1);
    }

    @Test
    public void addLast() {
        list.addFirst(1);
        list.addFirst(2);
        list.addLast(3);

        assertThat(list.get(0)).isEqualTo(2);
        assertThat(list.get(1)).isEqualTo(1);
        assertThat(list.get(2)).isEqualTo(3);
    }

    @Test
    public void add() {
        list.addFirst(1);
        list.addLast(2);
        list.add(3, 1);

        assertThat(list.get(0)).isEqualTo(1);
        assertThat(list.get(1)).isEqualTo(3);
        assertThat(list.get(2)).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithIllegalIndex() {
        list.add(42, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addWithTooLargeIndex() {
        list.addFirst(1);
        list.addLast(2);
        list.add(3, 1);

        list.add(42, 42);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWithTooLargeIndex() {
        list.addFirst(1);
        list.addLast(2);
        list.add(3, 1);

        list.get(42);
    }

    @Test
    public void iterator() {
        list.addFirst(1);
        list.addLast(2);
        list.add(3, 1);
        list.addLast(42);
        int[] expected = {1 ,3, 2, 42};
        int index = 0;

        for (Integer element : list) {
            assertThat(element).isEqualTo(expected[index]);
            index++;
        }
    }
}