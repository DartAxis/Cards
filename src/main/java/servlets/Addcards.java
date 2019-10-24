package servlets;

import service.CardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/addcard")
public class Addcards extends HttpServlet {
    private CardService cardService=CardService.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addcards.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        String tema = req.getParameter("tema");

        if (cardService.addCard(title,text,tema)) {
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("/allcards");
        }
    }
}
