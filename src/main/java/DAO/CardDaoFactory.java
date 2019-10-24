package DAO;

import util.Config;
import util.DBConn;

import java.io.*;

public class CardDaoFactory {
    public DAO.CardDao getFactory() throws IOException {
        System.out.println("Делаем выбод движка");
        if (Config.read("Driver").equals("Hibernate")) {
            return CardDAOHibernateImpl.getInstance(DBConn.getSessionFactory());
        } else {
            return CardDaoJDBCImpl.getInstance(DBConn.getConnection());
        }

    }
}
