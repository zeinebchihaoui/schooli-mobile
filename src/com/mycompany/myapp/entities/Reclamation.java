/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Asma
 */
public class Reclamation {
    
    private int id,phone;
    private String fullname,email,message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "" + "phone=" + phone + ", fullname=" + fullname + ", email=" + email + ", message=" + message + '}';
    }

    public Reclamation(int id, int phone, String fullname, String email, String message) {
        this.id = id;
        this.phone = phone;
        this.fullname = fullname;
        this.email = email;
        this.message = message;
    }

    public Reclamation(int phone, String fullname, String email, String message) {
        this.phone = phone;
        this.fullname = fullname;
        this.email = email;
        this.message = message;
    }

    public Reclamation(int id) {
        this.id = id;
    }

    public Reclamation() {
    }
    
}
