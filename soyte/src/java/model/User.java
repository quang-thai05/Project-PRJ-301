/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.UserDBContext;

/**
 *
 * @author quang
 */
public class User {

   private int id;
   private String email;
   private String password;
   private boolean active;
   private String OTP;

   public User() {
   }

   public User(int id, String email, String password, boolean active, String OTP) {
      this.id = id;
      this.email = email;
      this.password = password;
      this.active = active;
      this.OTP = OTP;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }

   public String getOTP() {
      return OTP;
   }

   public void setOTP(String OTP) {
      this.OTP = OTP;
   }

}
