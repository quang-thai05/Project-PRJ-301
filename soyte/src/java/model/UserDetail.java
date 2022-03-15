/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author quang
 */
public class UserDetail {

   private int user_id;
   private String user_name;
   private Date date_of_birth;
   private String address;
   private String phone;
   private String image;
   private int hospital_id;
   private int role_id;

   public UserDetail() {
   }

   public UserDetail(int user_id, String user_name, Date date_of_birth, String address, String phone, String image, int hospital_id) {
      this.user_id = user_id;
      this.user_name = user_name;
      this.date_of_birth = date_of_birth;
      this.address = address;
      this.phone = phone;
      this.image = image;
      this.hospital_id = hospital_id;
   }

   public UserDetail(String user_name, Date date_of_birth, String address, String phone, String image, int hospital_id, int role_id) {
      this.user_name = user_name;
      this.date_of_birth = date_of_birth;
      this.address = address;
      this.phone = phone;
      this.image = image;
      this.hospital_id = hospital_id;
      this.role_id = role_id;
   }

   public int getUser_id() {
      return user_id;
   }

   public void setUser_id(int user_id) {
      this.user_id = user_id;
   }

   public String getUser_name() {
      return user_name;
   }

   public void setUser_name(String user_name) {
      this.user_name = user_name;
   }

   public Date getDate_of_birth() {
      return date_of_birth;
   }

   public void setDate_of_birth(Date date_of_birth) {
      this.date_of_birth = date_of_birth;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public int getHospital_id() {
      return hospital_id;
   }

   public void setHospital_id(int hospital_id) {
      this.hospital_id = hospital_id;
   }

   public int getRole_id() {
      return role_id;
   }

   public void setRole_id(int role_id) {
      this.role_id = role_id;
   }
}
