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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserDetail;
/**
 *
 * @author quang
 */
public class ProfileDBContext extends DBContext{
    public UserDetail getDetailbyid(int id){
       String sql="select * from User_detail where user_id=?"; 
       try{
           PreparedStatement p=connection.prepareStatement(sql);
           p.setInt(1, id);
           ResultSet r=p.executeQuery();
           if(r.next())
               return new UserDetail(id, r.getString("user_name"), r.getDate("date_of_birth"), r.getString("address"), r.getString("phone"), r.getString("image"), r.getInt("hospital_id"));
       }catch(Exception e){
           Logger.getLogger(ProfileDBContext.class.getName()).log(Level.SEVERE, null,e);
       }
       return null;
    }
    public void updateprofile(UserDetail u){
        String sql="update User_detail set user_name=?,date_of_birth=?,address=?,phone=?,image=? where user_id=?";
        try{
           PreparedStatement p=connection.prepareStatement(sql);
           p.setString(1, u.getUser_name());
           p.setDate(2, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(u.getDate_of_birth())));
           p.setString(3, u.getAddress());
           p.setString(4, u.getPhone());
           p.setString(5, u.getImage());
           p.setInt(6, u.getUser_id());
           p.executeUpdate();
       }catch(SQLException e){
           Logger.getLogger(ProfileDBContext.class.getName()).log(Level.SEVERE, null,e);
       }
    }
}
