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
import model.Document;
import model.DocumentHospital;

/**
 *
 * @author quang
 */
public class DocumentDBContext extends DBContext {

    public List<Document> getAll() {
        List<Document> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Document";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Document d = new Document();
                d.setId(rs.getInt("doc_id"));
                d.setDoc_name(rs.getString("doc_subject"));
                d.setDoc_text(rs.getString("doc_text"));
                d.setDate(rs.getDate("doc_date"));
                d.setHospital_id(rs.getInt("hospital_id"));
                list.add(d);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public void createDocument(Document d) {
        try {
            String sql = "INSERT INTO [Document](doc_subject, doc_text, doc_date, hospital_id) VALUES (?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, d.getDoc_name());
            stm.setString(2, d.getDoc_text());
            stm.setDate(3, d.getDate());
            stm.setInt(4, d.getHospital_id());
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateDocument(Document d, int id) {
        try {
            String sql = "UPDATE [Document] SET doc_subject = ? , doc_text = ?, doc_date = ?, hospital_id = ? WHERE doc_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, d.getDoc_name());
            stm.setString(2, d.getDoc_text());
            stm.setDate(3, d.getDate());
            stm.setInt(4, d.getHospital_id());
            stm.setInt(5, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteDocument(int id) {
        try {
            String sql = "DELETE FROM Document where doc_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public List<DocumentHospital> getAllList2() {
        List<DocumentHospital> list = new ArrayList();
        try {
            String sql = "SELECT * FROM Document d join Hospital h ON d.hospital_id = h.hospital_id";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DocumentHospital dh = new DocumentHospital();
                dh.setId(rs.getInt("doc_id"));
                dh.setDoc_name(rs.getString("doc_subject"));
                dh.setDoc_text(rs.getString("doc_text"));
                dh.setDate(rs.getDate("doc_date"));
                dh.setHospital_id(rs.getInt("hospital_id"));
                dh.setHospital_name(rs.getString("hospital_name"));
                list.add(dh);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public List<DocumentHospital> getListByHospitalId(int id) {
        List<DocumentHospital> list = new ArrayList();
        try {
            String sql = "SELECT * FROM Document d join Hospital h ON d.hospital_id = h.hospital_id where h.hospital_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DocumentHospital dh = new DocumentHospital();
                dh.setId(rs.getInt("doc_id"));
                dh.setDoc_name(rs.getString("doc_subject"));
                dh.setDoc_text(rs.getString("doc_text"));
                dh.setDate(rs.getDate("doc_date"));
                dh.setHospital_id(rs.getInt("hospital_id"));
                dh.setHospital_name(rs.getString("hospital_name"));
                list.add(dh);
            }
        } catch (SQLException e) {
        }
        return list;
    }
    
    public Document getDocumentById(int id){
        try {
            String sql = "SELECT * FROM [Document] WHERE doc_id = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {    
                Document d = new Document();
                d.setId(rs.getInt("doc_id"));
                d.setDoc_name(rs.getString("doc_subject"));
                d.setDoc_text(rs.getString("doc_text"));
                d.setDate(rs.getDate("doc_date"));
                d.setHospital_id(rs.getInt("hospital_id"));
                return d;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new DocumentDBContext().getAllList2());
    }
}
