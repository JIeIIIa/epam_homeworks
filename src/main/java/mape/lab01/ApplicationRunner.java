package mape.lab01;

import mape.lab01.service.FlowerShopService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {
    private final FlowerShopService shopService;

    public ApplicationRunner(FlowerShopService shopService) {
        this.shopService = shopService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) {
        shopService.run();
    }
}
