/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dal.UserDAO;

/**
 *
 * @author quangthai
 */
public class User {
    private int id;
    private int role_id;
    private String email;
    private String password;
    private boolean active;
    private String OTP;

    public User() {
    }

    public User(int id, int role_id, String email, String password, boolean active, String OTP) {
        this.id = id;
        this.role_id = role_id;
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", role_id=" + role_id + ", email=" + email + ", password=" + password + ", active=" + active + ", OTP=" + OTP + '}';
    }
    
    public static void main(String[] args) {
        System.out.println(new UserDAO().getUsers());
    }
}
