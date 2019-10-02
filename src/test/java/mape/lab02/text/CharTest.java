package mape.lab02.text;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CharTest {

    @Test(expected = IllegalArgumentException.class)
    public void createCharFromNull() {
        new Char(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCharFromNullEmptyString() {
        new Char("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createCharFromTooLargeString() {
        new Char("large");
    }

    @Test
    public void createSuccess() {
        Char ch = new Char("t");

        assertThat(ch.getText()).isEqualTo("t");
    }

    @Test
    public void getType() {
        Char ch = new Char("t");

        assertThat(ch.getType()).isEqualTo(TextItem.TYPE.CHAR);
    }
}