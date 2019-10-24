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
        req.setAttribute("ind",CardService.indexes.get(id));
        req.getRequestDispatcher("card.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long ind=Long.parseLong(req.getParameter("ind"));
        /*
        Set<Map.Entry<String,Object>> entrySet=map.entrySet();

Object desiredObject=new Object();//что хотим найти
for (Map.Entry<String,Object> pair : entrySet) {
    if (desiredObject.equals(pair.getValue())) {
        return pair.getKey();// нашли наше значение и возвращаем  ключ
    }
}
         */
    }
}
