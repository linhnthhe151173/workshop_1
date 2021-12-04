package controller.article;

import dal.ArticleDAO;
import dal.AuthorDAO;
import dal.InstitutionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Author;
import model.Institution;

/**
 *
 * @author Linh
 */
@WebServlet(name = "CreateController", urlPatterns = {"/article/create"})
public class CreateController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<Author> listAu = new ArrayList<>();
        AuthorDAO daoAu = new AuthorDAO();
        listAu = daoAu.list();
        
        ArrayList<Institution> listIns = new ArrayList<>();
        InstitutionDAO daoIns = new InstitutionDAO();
        listIns = daoIns.list();
        
        request.setAttribute("listAu", listAu);
        request.setAttribute("listIns", listIns);
        request.getRequestDispatcher("../view/article/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        Date date = Date.valueOf(request.getParameter("date"));
        Boolean open = Boolean.parseBoolean(request.getParameter("open"));
        int author = Integer.parseInt(request.getParameter("author"));
        int ins = Integer.parseInt(request.getParameter("ins"));
        
        Author a = new Author();
        a.setAid(author);
        AuthorDAO daoAu = new AuthorDAO();
        a = daoAu.get(a);
        
        Institution i = new Institution();
        i.setIid(ins);
        InstitutionDAO daoIns = new InstitutionDAO();
        i = daoIns.get(i);
        
        Article ar = new Article(id, title, date, open, a, i);
        ArticleDAO daoAr = new ArticleDAO();
        daoAr.create(ar);
        response.sendRedirect("show");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
