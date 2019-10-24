package servlets;

import model.Card;
import service.CardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/allcards")
public class Allcards extends HttpServlet {
    private CardService cardService = CardService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Card> allcards = new ArrayList<>();
        allcards = cardService.getAllCard();
        req.setAttribute("list", allcards);
        req.getRequestDispatcher("allcards.jsp").forward(req, resp);
    }
}
