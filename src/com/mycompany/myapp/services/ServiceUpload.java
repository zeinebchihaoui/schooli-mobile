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
import com.mycompany.myapp.entities.Upload;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class ServiceUpload {
    public ArrayList<Upload> uploads;
    
    public static ServiceUpload instance=null;
    public boolean resultOK;
    private final ConnectionRequest req;

    public ServiceUpload() {
         req = new ConnectionRequest();
    }

    public static ServiceUpload getInstance() {
        if (instance == null) {
            instance = new ServiceUpload();
        }
        return instance;
    }
    
    
    public ArrayList<Upload> parseCourses(String jsonText){
        try {
            uploads=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> meetingsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)meetingsListJson.get("root");
            for(Map<String,Object> obj : list){
                Upload o = new Upload();
                float id = Float.parseFloat(obj.get("id").toString());
                o.setId((int)id);
                o.setClasse(obj.get("classe").toString());
                o.setPicture(obj.get("picture").toString());
                uploads.add(o);
            }
            
            
        } catch (IOException ex) {
            
        }
        return uploads;
    }
    
    public ArrayList<Upload> getAllUploads(){
        String url = Statics.BASE_URL+"/Planning/allu";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                uploads = parseCourses(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }

           
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return uploads;
    }
}
