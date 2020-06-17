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
public class Profil {

    private String nom;
    private String prenom;
    private String email;
    private String num;
    private String role;
    private String img;

    public Profil(String nom, String prenom, String email, String num, String role, String img) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num = num;
        this.role = role;
        this.img = img;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Profil{" + "nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", num=" + num + ", role=" + role + ", img=" + img + '}';
    }
    
    
    
    
    
    
    
}
