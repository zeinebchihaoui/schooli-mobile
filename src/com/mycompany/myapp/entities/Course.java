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
public class Course {
    private int id;
    private String nom,picture,niveau; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Matiere{" + "id=" + id + ", nom=" + nom + ", picture=" + picture + ", niveau=" + niveau + '}';
    }

    public Course() {
    }

    public Course(int id) {
        this.id = id;
    }

    public Course(String nom, String picture, String niveau) {
        this.nom = nom;
        this.picture = picture;
        this.niveau = niveau;
    }

 
    
}
