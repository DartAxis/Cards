package DAO;

import model.Card;

import java.util.List;

public interface CardDao {
    public boolean addCard(Card card);
    public boolean deleteCard(Card card);
    public boolean updateCard(Card card);
    public List<Card> getAllCard();
    public Card getCardById(Long id);
}
