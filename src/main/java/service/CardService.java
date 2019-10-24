package service;

import DAO.CardDao;
import DAO.CardDaoFactory;
import model.Card;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardService {
    private static CardService instance;
    private static CardDao cardDao;

    private CardService(){

    }

    public static CardService getInstance(){
        if(instance==null){
            instance=new CardService();
        }
        try {
            cardDao = new CardDaoFactory().getFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public boolean addCard(String title, String text, String tema){
        return cardDao.addCard(new Card(title,text,tema));
    }

    public boolean deleteCard(Long id){
        return cardDao.deleteCard(cardDao.getCardById(id));
    }

    public Card getCardById(Long id){
        return cardDao.getCardById(id);
    }

    public List<Card> getAllCard(){
        return cardDao.getAllCard();
    }

    public List<Card> getCardByTheme(String tema){
        List<Card> themeCard=new ArrayList<>();
        for (Card card:cardDao.getAllCard()) {
            if(card.getTema().equals(tema)){
                themeCard.add(card);
            }
        }
        return themeCard;
    }
}
