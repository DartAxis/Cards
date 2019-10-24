package util;

import model.Card;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
    private static Connection connection;
    private static SessionFactory sessionFactory;

    public static Connection getConnection() {
        if (connection == null) {
            connection = getMysqlConnection();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Card.class);
        System.out.println("считываем параметры Hibernate");
        configuration.setProperty("hibernate.dialect", Config.read("DbDialect"));
        configuration.setProperty("hibernate.connection.driver_class", Config.read("DriverClass"));
        configuration.setProperty("hibernate.connection.url", Config.read("DBURL"));
        configuration.setProperty("hibernate.connection.username", Config.read("DbLogin"));
        configuration.setProperty("hibernate.connection.password", Config.read("DbPassword"));
        configuration.setProperty("hibernate.show_sql", Config.read("ShowSql"));
        configuration.setProperty("hibernate.hbm2ddl.auto", Config.read("hbm2ddl"));
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Connection getMysqlConnection() {
        try {
            System.out.println("считываем параметры JDBC");
            DriverManager.registerDriver((Driver) Class.forName(Config.read("DriverClass")).newInstance());
            Connection connection = DriverManager.getConnection(Config.read("DBURL"), Config.read("DbLogin"), Config.read("DbPassword"));
            connection.setAutoCommit(true);
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }
    }
}
