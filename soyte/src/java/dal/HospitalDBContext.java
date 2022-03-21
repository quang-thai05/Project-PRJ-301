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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hospital;

/**
 *
 * @author quang
 */
public class HospitalDBContext extends DBContext {

   public ArrayList<Hospital> getAllHospital() {
      ArrayList<Hospital> list = new ArrayList<>();
      try {
         String sql = "SELECT * FROM [Hospital]";
         PreparedStatement stm = connection.prepareStatement(sql);
         ResultSet rs = stm.executeQuery();

         while (rs.next()) {
            Hospital h = new Hospital();
            h.setId(rs.getInt("hospital_id"));
            h.setName(rs.getString("hospital_name"));
            h.setAddress(rs.getString("hospital_address"));
            list.add(h);
         }
      } catch (SQLException e) {
         Logger.getLogger(HospitalDBContext.class.getName()).log(Level.SEVERE, null, e);
      }
      return list;
   }

   public Hospital getById(int id) {
      try {
         String sql = "SELECT * FROM [Hospital] where [hospital_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, id);
         ResultSet rs = stm.executeQuery();
         while (rs.next()) {
            Hospital h = new Hospital();
            h.setId(rs.getInt("hospital_id"));
            h.setName(rs.getString("hospital_name"));
            h.setAddress(rs.getString("hospital_address"));
            return h;
         }
      } catch (SQLException e) {
         Logger.getLogger(HospitalDBContext.class.getName()).log(Level.SEVERE, null, e);
      }
      return null;
   }

}
