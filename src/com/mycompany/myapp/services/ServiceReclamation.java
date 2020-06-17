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
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ama
 */
public class ServiceReclamation {

    public ArrayList<Reclamation> reclamations;
    
    public static ServiceReclamation instance=null;
    public boolean resultOK;
    private final ConnectionRequest req;

    public ServiceReclamation() {
         req = new ConnectionRequest();
    }

    public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
    }

    public boolean addReclamation(Reclamation r) {
        String url = Statics.BASE_URL + "/Reclamation/news" +"?fullname="+ r.getFullname() + "&email=" + r.getEmail() + "&phone=" + r.getPhone() + "&message=" + r.getMessage();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<Reclamation> parseReclamations(String jsonText){
        try {
            reclamations=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> reclamationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)reclamationsListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamation r = new Reclamation();
                float id = Float.parseFloat(obj.get("id").toString());
                r.setId((int)id);
                r.setFullname(obj.get("fullname").toString());
                r.setEmail(obj.get("email").toString());
                r.setPhone(((int)Float.parseFloat(obj.get("phone").toString())));
                r.setMessage(obj.get("message").toString());
                reclamations.add(r);
            }
                       
        } catch (IOException ex) {
            
        }
        return reclamations;
    }
    
    public ArrayList<Reclamation> getAllReclamations(){
        String url = Statics.BASE_URL+"/Reclamation/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamations = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
           
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }
    
}
