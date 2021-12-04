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
import model.Institution;

/**
 *
 * @author Linh
 */
public class InstitutionDAO extends DBContext<Institution>{

    @Override
    public ArrayList<Institution> list() {
        ArrayList<Institution> listA = new ArrayList<>();
        try {
            String sql = "select * from Institution";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Institution a = new Institution();
                a.setIid(rs.getInt(1));
                a.setIname(rs.getString(2));
                
                listA.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listA;
    }

    @Override
    public Institution get(Institution model) {
        try {
            String sql = "select * from Institution where iid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getIid());
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Institution i = new Institution(rs.getInt(1), rs.getString(2));

                return i;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void create(Institution model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Institution model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Institution model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
