package mape.lab01.bouquet;

import mape.lab01.Valuable;
import mape.lab01.flower.AbstractFlower;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bouquet {
    private final List<AbstractFlower> flowers = new ArrayList<>();
    private final List<Accessory> accessories = new ArrayList<>();

    List<AbstractFlower> getFlowers() {
        return flowers;
    }

    List<Accessory> getAccessories() {
        return accessories;
    }

    public void addFlower(AbstractFlower flower) {
        flowers.add(flower);
    }

    public AbstractFlower removeFlower(int index) {
        validateIndex(flowers, index);
        return flowers.remove(index);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public Accessory removeAccessory(int index) {
        validateIndex(accessories, index);
        return accessories.remove(index);
    }

    private <T> void validateIndex(List<T> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IllegalArgumentException("Wrong index = " + index + ",   size = " + list.size());
        }
    }

    public int totalPrice() {
        return Stream
            .concat(flowers.stream(), accessories.stream())
            .map(Valuable::getPrice)
            .reduce(0, Integer::sum);
    }

    public String printByFreshness() {
        Comparator<AbstractFlower> freshLevelComparator = Comparator
            .comparingInt(AbstractFlower::getFreshnessLevel)
            .reversed();
        List<AbstractFlower> sorted = new ArrayList<>(flowers);
        sorted.sort(freshLevelComparator);

        return toString(sorted, accessories);
    }

    public List<AbstractFlower> filter(int minLength, int maxLength) {
        if (minLength > maxLength) {
            throw new IllegalArgumentException("Min length must be less or equal to max length");
        }
        return flowers
            .stream()
            .filter(f -> minLength <= f.getLength() && f.getLength() <= maxLength)
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return toString(flowers, accessories);
    }

    private String toString(List<AbstractFlower> flowers, List<Accessory> accessories) {
        StringBuilder sb = new StringBuilder("Bouquet\n");
        for (int i = 0; i< flowers.size(); i++) {
            sb.append(String.format("   %3d: %s\n", i, flowers.get(i)));
        }
        sb.append("with accessories\n");
        for (int i = 0; i< accessories.size(); i++) {
            sb.append(String.format("   %3d: %s\n", i, accessories.get(i)));
        }
        return sb.toString();
    }
}
