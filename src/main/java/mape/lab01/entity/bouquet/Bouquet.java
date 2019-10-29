package mape.lab01.entity.bouquet;

import mape.lab01.entity.flower.AbstractFlower;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private final List<AbstractFlower> flowers = new ArrayList<>();
    private final List<Accessory> accessories = new ArrayList<>();

    public List<AbstractFlower> getFlowers() {
        return flowers;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    @Override
    public String toString() {
        return Bouquet.toString(flowers, accessories);
    }

    public static String toString(List<AbstractFlower> flowers, List<Accessory> accessories) {
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
