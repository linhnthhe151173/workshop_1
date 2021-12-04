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
import model.Author;

/**
 *
 * @author Linh
 */
public class AuthorDAO extends DBContext<Author>{

    @Override
    public ArrayList<Author> list() {
        ArrayList<Author> listA = new ArrayList<>();
        try {
            String sql = "select * from Author";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Author a = new Author();
                a.setAid(rs.getInt(1));
                a.setAname(rs.getString(2));
                
                listA.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listA;
    }

    @Override
    public Author get(Author model) {
        try {
            String sql = "select * from Author where aid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getAid());
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Author a = new Author();
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(Author model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Author model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Author model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
