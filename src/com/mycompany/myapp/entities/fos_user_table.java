/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author hp
 */
public class fos_user_table {
    
    private int id;
    private String email ;
    private String motPasse ;
    
    public fos_user_table(int id, String email, String motPasse){
        
        this.id = id;
        this.email=email;
        this.motPasse=motPasse;
    
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

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email=" + email + ", motPasse=" + motPasse + '}';
    }
    
}
