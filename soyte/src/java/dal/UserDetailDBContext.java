/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.UserDetail;

/**
 *
 * @author quang
 */
public class UserDetailDBContext extends DBContext{
    public UserDetail getUserDetailByUserId(int id){
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
                return ud;
            }
        } catch (SQLException e) {
        }
        return null;
    }
    
    public void createUserDetail(UserDetail ud){
        try {
            String sql = "INSERT INTO [User_detail] (user_name, date_of_birth, address, phone, image) VALUES (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, ud.getUser_name());
            stm.setDate(2, ud.getDate_of_birth());
            stm.setString(3, ud.getAddress());
            stm.setString(4, ud.getPhone());
            stm.setString(5, ud.getImage());
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }
    public static void main(String[] args) {
        System.out.println(new UserDetailDBContext().getUserDetailByUserId(1));
    }
    
}
