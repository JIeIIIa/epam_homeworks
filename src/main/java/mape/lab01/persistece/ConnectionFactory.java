package mape.lab01.persistece;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static final Logger LOG = LogManager.getLogger(ConnectionFactory.class);

    private ConnectionFactory() {
    }

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
//        try {
//            properties.load(ConnectionFactory.class.getResourceAsStream("/db.properties"));

            MysqlDataSource mySqlDataSource = new MysqlDataSource();
            mySqlDataSource.setUrl("jdbc:mysql://localhost:3306");
            mySqlDataSource.setDatabaseName("flower_shop");
            mySqlDataSource.setCharacterEncoding("UTF-8");
            mySqlDataSource.setUser("root");
            mySqlDataSource.setPassword("password");

            dataSource = mySqlDataSource;
//        } catch (IOException e) {
//            LOG.error("error");
//        }
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
