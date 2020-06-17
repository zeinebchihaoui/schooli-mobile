/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Upload {
    private int id;
    private String picture;
    private String classe ;

    public Upload() {
    }

    public Upload(int id) {
        this.id = id;
    }

    public Upload(int id, String picture, String classe) {
        this.id = id;
        this.picture = picture;
        this.classe = classe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    

   

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.picture);
        hash = 67 * hash + Objects.hashCode(this.classe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Upload other = (Upload) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.picture, other.picture)) {
            return false;
        }
        if (!Objects.equals(this.classe, other.classe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Upload{" + "id=" + id + ", picture=" + picture + ", classe=" + classe + '}';
    }

    
    
}
