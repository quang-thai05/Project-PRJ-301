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
import model.Role;

/**
 *
 * @author quangthai
 */
public class RoleDBContext extends DBContext{
    public List<Role> getRoles(){
        List<Role> roleList = new ArrayList<>();
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
        } catch (SQLException e) {
        }
        return roleList;
    }
    
    public static void main(String[] args) {
        System.out.println(new RoleDBContext().getRoles());
    }
}
