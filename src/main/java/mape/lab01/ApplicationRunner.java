package mape.lab01;

import mape.lab01.persistence.ConnectionFactory;
import mape.lab01.service.FlowerShopService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class ApplicationRunner implements CommandLineRunner {
    private static final Logger LOG = LogManager.getLogger(ApplicationRunner.class);

    private final FlowerShopService shopService;

    public ApplicationRunner(FlowerShopService shopService) {
        this.shopService = shopService;
    }

    public static void main(String[] args) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            LOG.info("Connection success...");
        } catch (SQLException e) {
            LOG.error("Connection error: {}", e.toString());
        }
        SpringApplication.run(ApplicationRunner.class, args);
    }

    @Override
    public void run(String... args) {
        shopService.run();
    }
}
