package mape.lab01;

import mape.lab01.persistece.ConnectionFactory;
import mape.lab01.service.FlowerShopService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {
    private final FlowerShopService shopService;

    public ApplicationRunner(FlowerShopService shopService) {
        this.shopService = shopService;
    }

    public static void main(String[] args) {
        try(Connection connection = ConnectionFactory.getConnection()) {

        } catch (SQLException e) {
            System.out.println("Connection error: " + e);
        }
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) {
        shopService.run();
    }
}
