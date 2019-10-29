package mape.lab01.persistence;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Properties;

public class ConnectionFactory {
    private static final Logger LOG = LogManager.getLogger(ConnectionFactory.class);

    private ConnectionFactory() {
    }

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
            dataSource = createPGDataSource(properties)
                    .orElseGet(() ->
                            createMysqlDataSource(properties)
                                    .orElseThrow(IllegalStateException::new));
    }

    private static Optional<MysqlDataSource> createMysqlDataSource(Properties properties){
        try {
            properties.load(ConnectionFactory.class.getResourceAsStream("/db.properties"));

            MysqlDataSource source = new MysqlDataSource();
            source.setURL(properties.getProperty("DB_URL"));
            source.setDatabaseName(properties.getProperty("DB_NAME"));
            source.setCharacterEncoding(properties.getProperty("DB_CHARSET"));
            source.setUser(properties.getProperty("DB_USERNAME"));
            source.setPassword(properties.getProperty("DB_PASSWORD"));

            LOG.info("Use MySQL");
            return Optional.of(source);
        } catch (IOException e) {
            LOG.error("Failure reading db.properties");
            return Optional.empty();
        }
    }

    private static Optional<DataSource> createPGDataSource(Properties properties) {
        try {
            properties.load(ConnectionFactory.class.getResourceAsStream("/db-postgresql.properties"));

            PGSimpleDataSource source = new PGSimpleDataSource();
            source.setURL(properties.getProperty("DB_URL"));
            source.setDatabaseName(properties.getProperty("DB_NAME"));
            source.setUser(properties.getProperty("DB_USERNAME"));
            source.setPassword(properties.getProperty("DB_PASSWORD"));

            LOG.info("Use PostgreSQL");
            return Optional.of(source);
        } catch (IOException e) {
            LOG.error("Failure reading db-postgresql.properties");
            return Optional.empty();
        }
    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            LOG.error("Error while connection creation", e);
        }
        return connection;
    }
}
