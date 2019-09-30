package mape.lab01.bouquet;

import mape.lab01.flower.AbstractFlower;
import mape.lab01.flower.Chamomile;
import mape.lab01.flower.Lily;
import mape.lab01.flower.Rose;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class BouquetTest {

    private Bouquet instance;
    private Rose rose;
    private Lily lily;
    private Chamomile chamomile;

    @Before
    public void setUp() {
        instance = new Bouquet();

        rose = new Rose(42);
        rose.setLength(10);
        rose.setFreshnessLevel(100);
        rose.setPrice(123);

        lily = new Lily(22);
        lily.setLength(31);
        lily.setFreshnessLevel(97);
        lily.setPrice(321);

        chamomile = new Chamomile(5);
        chamomile.setLength(5);
        chamomile.setFreshnessLevel(42);
        chamomile.setPrice(25);
    }

    @Test
    public void addFlower() {

        AbstractFlower expected = copy(rose);

        instance.addFlower(rose);

        assertThat(instance.getFlowers()).containsExactly(expected);
        assertThat(instance.getAccessories()).hasSize(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFlowerByWrongIndex() {
        instance.addFlower(rose);
        instance.addFlower(lily);

        AbstractFlower removed = instance.removeFlower(6);

        assertThat(removed).isNull();
        assertThat(instance.getFlowers()).containsExactlyInAnyOrder(copy(rose), copy(lily));
    }

    @Test
    public void removeFlowerSuccess() {
        instance.addFlower(rose);
        instance.addFlower(lily);
        instance.addFlower(chamomile);

        AbstractFlower removed = instance.removeFlower(1);

        assertThat(removed).isNotNull().isEqualTo(copy(lily));
        assertThat(instance.getFlowers()).containsExactlyInAnyOrder(copy(rose), copy(chamomile));
    }

    @Test
    public void addAccessory() {
        Accessory accessory = new Accessory("testAccessory", 32);
        Accessory expected = copy(accessory);

        instance.addAccessory(accessory);

        assertThat(instance.getFlowers()).hasSize(0);
        assertThat(instance.getAccessories()).containsExactly(expected);
        ;
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeAccessoryByWrongIndex() {
        Accessory first = new Accessory("first", 123);
        Accessory second = new Accessory("second", 234);
        instance.addAccessory(first);
        instance.addAccessory(second);
        Accessory removed = instance.removeAccessory(6);

        assertThat(removed).isNull();
        assertThat(instance.getAccessories()).containsExactlyInAnyOrder(copy(first), copy(second));
    }

    @Test
    public void removeAccessorySuccess() {
        Accessory first = new Accessory("first", 123);
        Accessory second = new Accessory("second", 234);
        Accessory third = new Accessory("third", 345);
        instance.addAccessory(first);
        instance.addAccessory(second);
        instance.addAccessory(third);
        Accessory removed = instance.removeAccessory(0);

        assertThat(removed).isNotNull();
        assertThat(instance.getAccessories())
            .hasSize(2)
            .containsExactlyInAnyOrder(copy(third), copy(second));
    }

    @Test
    public void emptyBouquetPrice() {
        int price = instance.totalPrice();

        assertThat(price).isEqualTo(0);
    }

    @Test
    public void totalPriceForNonEmptyBouquet() {
        instance.addFlower(rose);
        instance.addFlower(lily);
        instance.addFlower(chamomile);
        instance.addAccessory(new Accessory("first", 22));
        instance.addAccessory(new Accessory("second", 33));

        assertThat(instance.totalPrice()).isEqualTo(524);
    }

    @Test
    public void printEmptyBouquetByFreshness() {
        String expected = "Bouquet\n" + "with accessories\n";

        assertThat(instance.printByFreshness()).isEqualTo(expected);
    }

    @Test
    public void printByFreshness() {
        instance.addFlower(chamomile);
        instance.addFlower(rose);
        instance.addFlower(lily);

        String expected = "Bouquet\n" +
            "     0: Rose{NAME='Rose', length=10, price=123, freshnessLevel=100, thorns=42}\n" +
            "     1: Lily{ NAME='Lily', length=31, price=321, freshnessLevel=97, size=22}\n" +
            "     2: Chamomile{ NAME='Chamomile', length=5, price=25, freshnessLevel=42, petals=5}\n" +
            "with accessories\n";

        assertThat(instance.printByFreshness()).isEqualTo(expected);
    }

    @Test
    public void filterWhenNoFlowers() {
        List<AbstractFlower> result = instance.filter(10, 100);

        assertThat(result).isNotNull().hasSize(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void filterWIthWrongRange() {
        instance.addFlower(rose);
        instance.addFlower(lily);
        instance.addFlower(chamomile);

        instance.filter(100, 1);
    }

    @Test
    public void filterSuccess() {
        instance.addFlower(rose);
        instance.addFlower(lily);
        instance.addFlower(chamomile);

        List<AbstractFlower> result = instance.filter(10, 100);

        assertThat(result)
            .isNotNull()
            .hasSize(2)
            .containsExactlyInAnyOrder(copy(rose), copy(lily));
    }

    private AbstractFlower copy(AbstractFlower flower) {
        AbstractFlower duplicate;
        if (flower instanceof Rose) {
            duplicate = new Rose(((Rose) flower).getThorns());
        } else if (flower instanceof Chamomile) {
            duplicate = new Chamomile(((Chamomile) flower).getPetals());
        } else if (flower instanceof Lily) {
            duplicate = new Lily(((Lily) flower).getSize());
        } else {
            throw new IllegalArgumentException("Unknown flower type");
        }
        duplicate.setLength(flower.getLength());
        duplicate.setFreshnessLevel(flower.getFreshnessLevel());
        duplicate.setPrice(flower.getPrice());

        return duplicate;
    }

    private Accessory copy(Accessory accessory) {
        return new Accessory(accessory.getName(), accessory.getPrice());
    }
}