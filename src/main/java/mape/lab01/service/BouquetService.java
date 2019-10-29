package mape.lab01.service;

import mape.lab01.Valuable;
import mape.lab01.entity.bouquet.Accessory;
import mape.lab01.entity.bouquet.Bouquet;
import mape.lab01.entity.flower.AbstractFlower;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BouquetService {
    private final static Logger LOG = LogManager.getLogger(BouquetService.class);

    private Bouquet bouquet = new Bouquet();

    public void create() {
        bouquet = new Bouquet();
    }

    List<AbstractFlower> getFlowers() {
        return bouquet.getFlowers();
    }

    List<Accessory> getAccessories() {
        return bouquet.getAccessories();
    }

    public void addFlower(AbstractFlower flower) {
        LOG.trace("Add flower: {}", flower);
        List<AbstractFlower> flowers = bouquet.getFlowers();
        flowers.add(flower);
    }

    public AbstractFlower removeFlower(int index) {
        LOG.trace("Remove flower: index = {}", index);
        List<AbstractFlower> flowers = bouquet.getFlowers();
        validateIndex(flowers, index);
        return flowers.remove(index);
    }

    public void addAccessory(Accessory accessory) {
        LOG.trace("Add accessory: {}", accessory);
        List<Accessory> accessories = bouquet.getAccessories();
        accessories.add(accessory);
    }

    public Accessory removeAccessory(int index) {
        LOG.trace("Remove accessory: index = {}", index);
        List<Accessory> accessories = bouquet.getAccessories();
        validateIndex(accessories, index);
        return accessories.remove(index);
    }

    private <T> void validateIndex(List<T> list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IllegalArgumentException("Wrong index = " + index + ",   size = " + list.size());
        }
    }

    public int totalPrice() {
        final List<AbstractFlower> flowers = bouquet.getFlowers();
        final List<Accessory> accessories = bouquet.getAccessories();
        return Stream
                .concat(flowers.stream(), accessories.stream())
                .map(Valuable::getPrice)
                .reduce(0, Integer::sum);
    }

    public String bouquetAsStringByFreshness() {
        Comparator<AbstractFlower> freshLevelComparator = Comparator
                .comparingInt(AbstractFlower::getFreshnessLevel)
                .reversed();
        List<AbstractFlower> sorted = new ArrayList<>(bouquet.getFlowers());
        sorted.sort(freshLevelComparator);

        return Bouquet.toString(sorted, bouquet.getAccessories());
    }

    public List<AbstractFlower> filter(int minLength, int maxLength) {
        if (minLength > maxLength) {
            throw new IllegalArgumentException("Min length must be less or equal to max length");
        }
        return bouquet.getFlowers()
                .stream()
                .filter(f -> minLength <= f.getLength() && f.getLength() <= maxLength)
                .collect(Collectors.toList());
    }

    public String bouquetAsString() {
        return bouquet.toString();
    }
}
