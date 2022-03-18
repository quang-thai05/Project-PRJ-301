/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.UserDetail;

/**
 *
 * @author quang
 */
public class UserDetailDBContext extends DBContext {

   public UserDetail getUserDetailByUserId(int id) {
      try {
         String sql = "SELECT * FROM [User_detail] where [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, id);
         ResultSet rs = stm.executeQuery();
         while (rs.next()) {
            UserDetail ud = new UserDetail();
            ud.setUser_id(rs.getInt("user_id"));
            ud.setUser_name(rs.getString("user_name"));
            ud.setDate_of_birth(rs.getDate("date_of_birth"));
            ud.setAddress(rs.getString("address"));
            ud.setPhone(rs.getString("phone"));
            ud.setImage(rs.getString("image"));
            ud.setHospital_id(rs.getInt("hospital_id"));
            ud.setRole_id(rs.getInt("role_id"));
            return ud;
         }
      } catch (SQLException e) {
      }
      return null;
   }

   public List<UserDetail> getUserDetailByRoleId(int role) {
      List<UserDetail> list = new ArrayList<>();
      try {
         String sql = "SELECT * FROM [User_detail] where [role_id] = ? and [user_name] != ''";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, role);
         ResultSet rs = stm.executeQuery();
         while (rs.next()) {
            UserDetail ud = new UserDetail();
            ud.setUser_id(rs.getInt("user_id"));
            ud.setUser_name(rs.getString("user_name"));
            ud.setDate_of_birth(rs.getDate("date_of_birth"));
            ud.setAddress(rs.getString("address"));
            ud.setPhone(rs.getString("phone"));
            ud.setImage(rs.getString("image"));
            ud.setHospital_id(rs.getInt("hospital_id"));
            ud.setRole_id(rs.getInt("role_id"));
            list.add(ud);
         }
      } catch (SQLException e) {
      }
      return list;
   }

   public void createUserDetail(UserDetail ud) {
      try {
         String sql = "INSERT INTO [User_detail] (user_name, date_of_birth, address, phone, image, hospital_id, role_id) VALUES (?,?,?,?,?,?,3)";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setString(1, ud.getUser_name());
         stm.setDate(2, ud.getDate_of_birth());
         stm.setString(3, ud.getAddress());
         stm.setString(4, ud.getPhone());
         stm.setString(5, ud.getImage());
         stm.setInt(6, ud.getHospital_id());
         stm.executeUpdate();
      } catch (SQLException e) {
      }
   }

   public void updateUserDetail(UserDetail ud, int id) {
      try {
         String sql = "UPDATE [User_detail] SET [user_name] = ?, [date_of_birth] = ?, [address] = ?, [phone] = ?, [image] = ? where [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setString(1, ud.getUser_name());
         stm.setDate(2, ud.getDate_of_birth());
         stm.setString(3, ud.getAddress());
         stm.setString(4, ud.getPhone());
         stm.setString(5, ud.getImage());
         stm.setInt(6, id);
         stm.executeUpdate();
      } catch (SQLException e) {
      }
   }

   public void updateToDoctor(int id) {
      try {
         String sql = "Update [User_detail] SET [role_id] = 2 WHERE [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, id);
         stm.executeUpdate();
      } catch (Exception e) {
      }
   }

   public void updateToPatient(int id) {
      try {
         String sql = "Update [User_detail] SET [role_id] = 3 WHERE [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, id);
         stm.executeUpdate();
      } catch (Exception e) {
      }
   }

   public void changeHospital(int h_id, int u_id) {
      try {
         String sql = "Update [User_detail] SET [hospital_id] = ? where [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, h_id);
         stm.setInt(2, u_id);
         stm.executeUpdate();
      } catch (Exception e) {
      }
   }

   public static void main(String[] args) {
      System.out.println(new UserDetailDBContext().getUserDetailByUserId(1));
   }

}
