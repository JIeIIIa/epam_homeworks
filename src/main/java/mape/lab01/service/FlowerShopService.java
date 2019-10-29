package mape.lab01.service;

import mape.lab01.entity.bouquet.Accessory;
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

    private final BouquetService bouquetService;

    public FlowerShopService(BouquetService bouquetService) {
        this.bouquetService = bouquetService;
    }

    public void run() {
        bouquetService.create();
        int choose;
        do {
            printMenuItem();
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    addFlower();
                    break;
                case 2:
                    removeFlower();
                    break;
                case 3:
                    addAccessory();
                    break;
                case 4:
                    removeAccessory();
                    break;
                case 5:
                    info();
                    break;
                case 6:
                    System.out.println(bouquetService.bouquetAsStringByFreshness());
                    break;
                case 7:
                    filter();
                    break;
                case 8:
                    totalPrice();
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

    private void addFlower() {
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

        bouquetService.addFlower(flower);
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

    private void removeFlower() {
        System.out.print("Remove flower with index>>");
        int index = scanner.nextInt();
        scanner.nextLine();
        AbstractFlower flower = bouquetService.removeFlower(index);
        if (flower == null) {
            System.out.println("Something went wrong( Flower with [index = " + index + "] was not removed.");
        } else {
            System.out.println(flower + "was removed");
            LOG.debug("Flower was removed: {}", flower);
        }
    }

    private void addAccessory() {
        System.out.print("accessory's name>>");
        String name = scanner.nextLine();
        System.out.print("accessory's price>>");
        int price = scanner.nextInt();
        scanner.nextLine();
        Accessory accessory = new Accessory(name, price);

        LOG.debug("Add accessory: {}", accessory);
        bouquetService.addAccessory(accessory);
    }

    private void removeAccessory() {
        System.out.print("Remove accessory with index>>");
        int index = scanner.nextInt();
        scanner.nextLine();
        Accessory accessory = bouquetService.removeAccessory(index);
        if (accessory == null) {
            System.out.println("Something went wrong( Accessory with [index = " + index + "] was not removed.");
        } else {
            LOG.debug("Accessory was removed: {}", accessory);
            System.out.println(accessory + "was removed");
        }
    }

    private void info() {
        LOG.debug(bouquetService.toString());
        System.out.println(bouquetService.toString());
    }

    private void filter() {
        System.out.print("min length>>");
        int min = scanner.nextInt();
        scanner.nextLine();
        System.out.print("max length>>");
        int max = scanner.nextInt();
        scanner.nextLine();
        LOG.trace("filter from {} to {}", min, max);

        List<AbstractFlower> filter;
        try {
            filter = bouquetService.filter(min, max);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("Flowers that were filtered by its length");
        for (AbstractFlower flower : filter) {
            System.out.println("   " + flower);
        }
    }

    private void totalPrice() {
        LOG.info("Total price: {}", bouquetService.totalPrice());
        System.out.println("Total price = " + bouquetService.totalPrice());
    }
}
