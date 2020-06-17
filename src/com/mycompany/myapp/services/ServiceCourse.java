/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Course;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asma
 */

public class ServiceCourse {
     public ArrayList<Course> courses;
    
    public static ServiceCourse instance=null;
    public boolean resultOK;
    private final ConnectionRequest req;

    public ServiceCourse() {
         req = new ConnectionRequest();
    }

    public static ServiceCourse getInstance() {
        if (instance == null) {
            instance = new ServiceCourse();
        }
        return instance;
    }
       
    public ArrayList<Course> parseCourses(String jsonText){
        try {
            courses=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> meetingsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)meetingsListJson.get("root");
            for(Map<String,Object> obj : list){
                Course m = new Course();
                float id = Float.parseFloat(obj.get("id").toString());
                m.setId((int)id);
                m.setNom(obj.get("nom").toString());
                m.setNiveau(obj.get("niveau").toString());
                m.setPicture(obj.get("picture").toString());
                courses.add(m);
            }
        } catch (IOException ex) {
            
        }
        return courses;
    }
    
    public ArrayList<Course> getAllCourses(){
        String url = Statics.BASE_URL+"/Course/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                courses = parseCourses(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return courses;
    }
}
