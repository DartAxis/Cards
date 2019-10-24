package servlets;

import model.Card;
import service.CardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/card")
public class Viewcard extends HttpServlet {
    private CardService cardService=CardService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id=Long.parseLong(req.getParameter("id"));
        Card card=cardService.getCardById(id);
        req.setAttribute("card",card);
        System.out.println(card.getTema());
        System.out.println(card.getTitle());
        System.out.println(card.getText());

        req.getRequestDispatcher("card.jsp").forward(req, resp);

    }
}
