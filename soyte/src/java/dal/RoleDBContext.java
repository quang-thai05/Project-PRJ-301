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
import model.Role;

/**
 *
 * @author quang
 */
public class RoleDBContext extends DBContext {

   public ArrayList<Role> getRoles() {
      ArrayList<Role> roleList = new ArrayList<>();
      try {
         String sql = "SELECT * FROM [Role]";
         PreparedStatement stm = connection.prepareStatement(sql);
         ResultSet rs = stm.executeQuery();
         while (rs.next()) {
            Role role = new Role();
            role.setRole_id(rs.getInt("role_id"));
            role.setRole_name(rs.getString("role_name"));
            roleList.add(role);
         }
      } catch (SQLException ex) {
         Logger.getLogger(RoleDBContext.class.getName()).log(Level.SEVERE, null, ex);
      }
      return roleList;
   }

}
