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
public class Document {
    private int id;
    private String doc_name;
    private String doc_text;
    private Date date;
    private int hospital_id;

    public Document() {
    }

    public Document(int id, String doc_name, String doc_text, Date date, int hospital_id) {
        this.id = id;
        this.doc_name = doc_name;
        this.doc_text = doc_text;
        this.date = date;
        this.hospital_id = hospital_id;
    }
    
      public Document(String doc_name, String doc_text, Date date, int hospital_id) {
        this.doc_name = doc_name;
        this.doc_text = doc_text;
        this.date = date;
        this.hospital_id = hospital_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_text() {
        return doc_text;
    }

    public void setDoc_text(String doc_text) {
        this.doc_text = doc_text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    

    @Override
    public String toString() {
        return "Document{" + "id=" + id + ", doc_name=" + doc_name + ", doc_text=" + doc_text + ", date=" + date + '}';
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }
    
    
}
