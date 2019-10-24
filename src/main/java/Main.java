import model.Card;
import service.CardService;

public class Main {
    public static void main(String[] args) {
        CardService cardService=CardService.getInstance();

        cardService.addCard("test title","test text", "test tema");
    }
}
