package DAO;

import model.Card;


import java.sql.Connection;
import java.util.List;

public class CardDaoJDBCImpl implements DAO.CardDao {
    private static CardDaoJDBCImpl instance;
    private static Connection connection;

    private CardDaoJDBCImpl(Connection daoConnection) {
        connection = daoConnection;
        System.out.println("Используем JDBC");

    }

    public static CardDaoJDBCImpl getInstance(Connection daoConnection) {
        if (instance == null) {
            instance = new CardDaoJDBCImpl(daoConnection);

        }

        return instance;
    }

    @Override
    public boolean addCard(Card card) {
        return false;
    }

    @Override
    public boolean deleteCard(Card card) {
        return false;
    }

    @Override
    public boolean updateCard(Card card) {
        return false;
    }

    @Override
    public List<Card> getAllCard() {
        return null;
    }

    @Override
    public Card getCardById(Long id) {
        return null;
    }
}
