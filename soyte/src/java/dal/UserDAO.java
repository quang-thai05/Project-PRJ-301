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
import model.User;

/**
 *
 * @author quangthai
 */
public class UserDAO extends DBContext{
    
    public List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        try {
            String sql = "SELECT * FROM [User]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                User user = new User();
                user.setId(rs.getInt("user_id"));
                user.setRole_id(rs.getInt("role_id"));
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
   
    
}
