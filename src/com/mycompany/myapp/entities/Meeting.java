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
public class Meeting {
    private int id;
    private String emetteur,recepteur,sujet,description; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmetteur() {
        return emetteur;
    }

    public void setEmetteur(String emetteur) {
        this.emetteur = emetteur;
    }

    public String getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(String recepteur) {
        this.recepteur = recepteur;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Meeting{" + ""  + "emetteur=" + emetteur + ", recepteur=" + recepteur + ", sujet=" + sujet + ", description=" + description + '}';
    }

    public Meeting() {
    }

    public Meeting(int id) {
        this.id = id;
    }

    public Meeting(String emetteur, String recepteur, String sujet, String description) {
        this.emetteur = emetteur;
        this.recepteur = recepteur;
        this.sujet = sujet;
        this.description = description;
    }
    
    
    
    
}
