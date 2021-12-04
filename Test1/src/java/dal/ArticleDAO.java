/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Article;
import model.Author;
import model.Institution;

/**
 *
 * @author Linh
 */
public class ArticleDAO extends DBContext<Article> {

    @Override
    public ArrayList<Article> list() {
        ArrayList<Article> listA = new ArrayList<>();
        try {
            String sql = "select Article.arid, Article.title, Article.publishedDate, Article.isOpenAcess, \n"
                    + "Author.aid, Author.aname, Institution.iid, Institution.iname from Article inner join Author\n"
                    + "on Article.aid = Author.aid inner join Institution\n"
                    + "on Article.iid = Institution.iid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Article a = new Article();
                a.setArid(rs.getInt(1));
                a.setTitle(rs.getString(2));
                a.setPublishedDate(rs.getDate(3));
                a.setIsOpenAccess(rs.getBoolean(4));

                Author a1 = new Author();
                a1.setAid(rs.getInt(5));
                a1.setAname(rs.getString(6));

                Institution i = new Institution();
                i.setIid(rs.getInt(7));
                i.setIname(rs.getString(8));

                a.setAid(a1);
                a.setIid(i);

                listA.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listA;
    }

    @Override
    public Article get(Article model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Article model) {
        try {
            String sql = "INSERT INTO [dbo].[Article]\n"
                    + "           ([arid]\n"
                    + "           ,[title]\n"
                    + "           ,[publishedDate]\n"
                    + "           ,[isOpenAcess]\n"
                    + "           ,[aid]\n"
                    + "           ,[iid])\n"
                    + "     VALUES\n"
                    + "           (?, ?, ?, ?, ?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getArid());
            stm.setString(2, model.getTitle());
            stm.setDate(3, model.getPublishedDate());
            stm.setBoolean(4, model.isIsOpenAccess());
            stm.setInt(5, model.getAid().getAid());
            stm.setInt(6, model.getIid().getIid());

            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Article model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Article model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
