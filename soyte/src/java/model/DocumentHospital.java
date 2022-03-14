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
public class DocumentHospital {
    private int id;
    private String doc_name;
    private String doc_text;
    private Date date;
    private int hospital_id;
    private String hospital_name;

    public DocumentHospital() {
    }

    public DocumentHospital(int id, String doc_name, String doc_text, Date date, int hospital_id, String hospital_name) {
        this.id = id;
        this.doc_name = doc_name;
        this.doc_text = doc_text;
        this.date = date;
        this.hospital_id = hospital_id;
        this.hospital_name = hospital_name;
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

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    @Override
    public String toString() {
        return "DocumentHospital{" + "id=" + id + ", doc_name=" + doc_name + ", doc_text=" + doc_text + ", date=" + date + ", hospital_id=" + hospital_id + ", hospital_name=" + hospital_name + '}';
    }
    
    
}
