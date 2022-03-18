/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import model.User;

/**
 *
 * @author quang
 */
public class UserDBContext extends DBContext {

   public List<User> getUsers() {
      List<User> userList = new ArrayList<>();
      try {
         String sql = "SELECT * FROM [User]";

         PreparedStatement stm = connection.prepareStatement(sql);
         ResultSet rs = stm.executeQuery();
         while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setActive(rs.getBoolean("active"));
            user.setOTP(rs.getString("OTP"));
            userList.add(user);
         }
      } catch (SQLException e) {
      }
      return userList;
   }

   public User getUserByEmail(String email) {
      try {
         String sql = "SELECT * FROM [User] WHERE [email] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setString(1, email);
         ResultSet rs = stm.executeQuery();
         while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("user_id"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setActive(rs.getBoolean("active"));
            user.setOTP(rs.getString("OTP"));
            return user;
         }
      } catch (SQLException e) {
      }
      return null;
   }

   public void createUser(User user) {
      try {
         String sql = "INSERT INTO [User] (email, password, active, OTP) VALUES (?, ?, ?, ?)";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setString(1, user.getEmail());
         stm.setString(2, user.getPassword());
         stm.setBoolean(3, user.isActive());
         stm.setString(4, user.getOTP());
         stm.executeUpdate();
      } catch (SQLException e) {
      }
   }

   public void changePass(String password, int id) {
      try {
         String sql = "UPDATE [User] SET [password] = ? where [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setString(1, password);
         stm.setInt(2, id);
         stm.executeUpdate();
      } catch (SQLException e) {
      }
   }

   public void active(int id) {
      try {
         String sql = "UPDATE [User] SET [active] = 1 where [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, id);
         stm.executeUpdate();
      } catch (SQLException e) {
      }
   }

   public void deActive(int id) {
      try {
         String sql = "UPDATE [User] SET [active] = 0 where [user_id] = ?";
         PreparedStatement stm = connection.prepareStatement(sql);
         stm.setInt(1, id);
         stm.executeUpdate();
      } catch (SQLException e) {
      }
   }

   public String generateOTP() {
      Random random = new Random();
      String otp = String.valueOf(100000 + random.nextInt(999999));
      return otp;
   }

   public String generateRandomPassword() {
      String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
      SecureRandom random = new SecureRandom();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < 8; i++) {
         int randomIndex = random.nextInt(chars.length());
         sb.append(chars.charAt(randomIndex));
      }
      return sb.toString();
   }

   public static void main(String[] args) {
      //System.out.println(new UserDBContext().getUserByEmail("user@gmail.com"));
      System.out.println(new UserDBContext().generateRandomPassword());
   }
}
