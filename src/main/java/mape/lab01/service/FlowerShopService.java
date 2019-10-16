package mape.lab01.service;

import mape.lab01.bouquet.Accessory;
import mape.lab01.bouquet.Bouquet;
import mape.lab01.entity.flower.AbstractFlower;
import mape.lab01.entity.flower.Chamomile;
import mape.lab01.entity.flower.Lily;
import mape.lab01.entity.flower.Rose;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

@Service
public class FlowerShopService {
    private static final Logger LOG = LogManager.getLogger(FlowerShopService.class);

    private static Scanner scanner = new Scanner(System.in);

    public void run() {
        LOG.info("Application was started...");
        Bouquet bouquet = new Bouquet();
        int choose;
        do {
            printMenuItem();
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    addFlower(bouquet);
                    break;
                case 2:
                    removeFlower(bouquet);
                    break;
                case 3:
                    addAccessory(bouquet);
                    break;
                case 4:
                    removeAccessory(bouquet);
                    break;
                case 5:
                    info(bouquet);
                    break;
                case 6:
                    System.out.println(bouquet.toStringByFreshness());
                    break;
                case 7:
                    filter(bouquet);
                    break;
                case 8:
                    totalPrice(bouquet);
                    break;
                case 0:
                    exit(0);
                default:
                    System.out.println("ERROR! Unknown menu item!");
            }
        } while (true);
    }

    private void printMenuItem() {
        System.out.println("1 - add flower to bouquet");
        System.out.println("2 - remove flower from ");
        System.out.println("3 - add a new accessory");
        System.out.println("4 - remove an accessory");
        System.out.println("5 - information about bouquet");
        System.out.println("6 - sort by freshness level");
        System.out.println("7 - filter flowers by its length");
        System.out.println("8 - total price");
        System.out.println();
        System.out.println("0 - exit");
        System.out.print(">>");
    }

    private void addFlower(Bouquet bouquet) {
        LOG.debug("Add flower");
        System.out.println("Choose a flower to add to bouquet:");
        System.out.println("1 - chamomile");
        System.out.println("2 - lily");
        System.out.println("any other char/string - rose");
        System.out.print(">>");

        String choose = scanner.nextLine();
        System.out.println("Enter information about a flower:");
        System.out.print("length>>");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.print("freshness level>>");
        int freshnessLevel = scanner.nextInt();
        scanner.nextLine();
        System.out.print("price>>");
        int price = scanner.nextInt();
        scanner.nextLine();

        AbstractFlower flower;
        flower = createFlower(choose);
        flower.setLength(length);
        flower.setFreshnessLevel(freshnessLevel);
        flower.setPrice(price);

        bouquet.addFlower(flower);
    }

    private AbstractFlower createFlower(String choose) {
        AbstractFlower flower;
        switch (choose) {
            case "1":
                LOG.debug("Creating chamomile...");
                System.out.print("chamomile's petals>>");
                int petals = scanner.nextInt();
                scanner.nextLine();
                flower = new Chamomile(petals);
                break;
            case "2":
                LOG.debug("Creating lily...");
                System.out.print("lily's size>>");
                int size = scanner.nextInt();
                scanner.nextLine();
                flower = new Lily(size);
                break;
            default:
                LOG.debug("Creating rose...");
                System.out.print("rose's thorns>>");
                int thorns = scanner.nextInt();
                scanner.nextLine();
                flower = new Rose(thorns);
                break;
        }
        LOG.trace("Flower was created: {}", flower);
        return flower;
    }

    private void removeFlower(Bouquet bouquet) {
        System.out.print("Remove flower with index>>");
        int index = scanner.nextInt();
        scanner.nextLine();
        AbstractFlower flower = bouquet.removeFlower(index);
        if (flower == null) {
            System.out.println("Something went wrong( Flower with [index = " + index + "] was not removed.");
        } else {
            System.out.println(flower + "was removed");
            LOG.debug("Flower was removed: {}", flower);
        }
    }

    private void addAccessory(Bouquet bouquet) {
        System.out.print("accessory's name>>");
        String name = scanner.nextLine();
        System.out.print("accessory's price>>");
        int price = scanner.nextInt();
        scanner.nextLine();
        Accessory accessory = new Accessory(name, price);

        LOG.debug("Add accessory: {}", accessory);
        bouquet.addAccessory(accessory);
    }

    private void removeAccessory(Bouquet bouquet) {
        System.out.print("Remove accessory with index>>");
        int index = scanner.nextInt();
        scanner.nextLine();
        Accessory accessory = bouquet.removeAccessory(index);
        if (accessory == null) {
            System.out.println("Something went wrong( Accessory with [index = " + index + "] was not removed.");
        } else {
            LOG.debug("Accessory was removed: {}", accessory);
            System.out.println(accessory + "was removed");
        }
    }

    private void info(Bouquet bouquet) {
        LOG.debug(bouquet);
        System.out.println(bouquet);
    }

    private void filter(Bouquet bouquet) {
        System.out.print("min length>>");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.print("max length>>");
        int max = scanner.nextInt();
        scanner.nextLine();
        LOG.trace("filter from {} to {}", min, max);

        List<AbstractFlower> filter;
        try {
            filter = bouquet.filter(min, max);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Flowers that were filtered by its length");
        for (AbstractFlower flower : filter) {
            System.out.println("   " + flower);
        }
    }

    private void totalPrice(Bouquet bouquet) {
        LOG.info("Total price: {}", bouquet.totalPrice());
        System.out.println("Total price = " + bouquet.totalPrice());
    }
}
