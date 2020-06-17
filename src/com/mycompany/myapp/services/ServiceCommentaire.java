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
import com.codename1.ui.Dialog;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Commentaire;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */

public class ServiceCommentaire {
    public ArrayList<Commentaire> commentaires;
    
    public static ServiceCommentaire instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceCommentaire() {
         req = new ConnectionRequest();
    }

    public static ServiceCommentaire getInstance() {
        if (instance == null) {
            instance = new ServiceCommentaire();
        }
        return instance;
    }    
    
    public boolean addCommentaire(Commentaire c) {        
        String url = Statics.BASE_URL + "/Event/newss" +"?description="+ c.getDescription();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this); 
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
        public ArrayList<Commentaire> parseCommentaires(String jsonText){
        try {
            commentaires=new ArrayList<>();
            JSONParser j = new JSONParser();
           
            Map<String,Object> events1ListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)events1ListJson.get("root");
            
            for(Map<String,Object> obj : list){
                
                Commentaire c = new Commentaire();
                
                c.setDescription(obj.get("description").toString());
                
                commentaires.add(c);
            }
        } catch (IOException ex) {
            
        }         
        return commentaires;
    }
        

    public ArrayList<Commentaire> getAllCommentaire(){
        String url = Statics.BASE_URL+"/Event/allss";
        System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                commentaires = parseCommentaires(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return commentaires;
    }
    
     public void update(Commentaire c) {
        req.setPost(true);
        String url =  Statics.BASE_URL + "/Event/update1/"+c.getId() ;
        req.setHttpMethod("POST");
        
        req.addArgument("Commentaire", String.valueOf(c.getId()));

        NetworkManager.getInstance().addToQueueAndWait(req);
    }
     
     public void supp(Commentaire ct) {
        String url =  Statics.BASE_URL + "/Event/supp/" + ct.getId() ;

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(url);
        con.setPost(true);
        con.addResponseListener((NetworkEvent evt) -> {
            byte[] data = (byte[]) evt.getMetaData();
            String s = new String(data);
            if (!s.equals("")) {
                Dialog.show("Confirmation", "success", "Ok", null);

            } else {
                Dialog.show("Erreur", "erreur", "Ok", null);

            }
        });

        NetworkManager.getInstance().addToQueueAndWait(con);

    }
         
}
