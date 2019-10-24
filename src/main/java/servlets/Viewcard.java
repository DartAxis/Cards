package servlets;

import model.Card;
import service.CardService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

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
        Long ind=CardService.indexes.get(id);
        req.setAttribute("ind",ind);
        req.getRequestDispatcher("card.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long ind=Long.parseLong(req.getParameter("ind"));
        System.out.println(ind);
        if(ind<=0){
            ind=1L;
        }
        Long id=null;
        for(Map.Entry<Long,Long> pair:CardService.indexes.entrySet()){
            if(ind.equals(pair.getValue())){
                id=pair.getKey();
            }
        }
        if(id==null){ ind=1L;
            for(Map.Entry<Long,Long> pair:CardService.indexes.entrySet()){
                if(ind.equals(pair.getValue())){
                    id=pair.getKey();
                }
            }
        }
        resp.sendRedirect("/card?id="+id.toString());
    }
}
