package DAO;

import model.Card;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CardDAOHibernateImpl implements DAO.CardDao {
    private static CardDAOHibernateImpl instance;
    private static SessionFactory sessionFactory;

    private CardDAOHibernateImpl(SessionFactory daoSessionFactory) {
        sessionFactory = daoSessionFactory;
        System.out.println("Используем Hibernate");
    }

    public static CardDAOHibernateImpl getInstance(SessionFactory daoSessionFactory) {
        if (instance == null) {

            instance = new CardDAOHibernateImpl(daoSessionFactory);
        }


        return instance;
    }





    @Override
    public boolean addCard(Card card) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(card);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteCard(Card card) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(card);
        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean updateCard(Card card) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(card);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Card> getAllCard() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Card", Card.class);
        List<Card> allCard = query.list();
        session.close();
        return allCard;
    }


    @Override
    public Card getCardById(Long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Card where id=:param");
        query.setParameter("param", id);
        Card singleResult = (Card) query.getSingleResult();
        return singleResult;
    }
}
