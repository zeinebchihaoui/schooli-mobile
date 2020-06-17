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
public class Wall {
    private int id;
    private String contenu,image ; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Wall{" + "id=" + id + ", contenu=" + contenu + ", image=" + image + '}';
    }

    public Wall() {
    }

    public Wall(int id) {
        this.id = id;
    }

    public Wall(String contenu, String image) {
        this.contenu = contenu;
        this.image = image;
    }

    public Wall(int id, String contenu, String image) {
        this.id = id;
        this.contenu = contenu;
        this.image = image;
    }

   
}
