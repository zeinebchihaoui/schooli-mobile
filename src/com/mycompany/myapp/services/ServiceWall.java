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
import com.mycompany.myapp.entities.Wall;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Asma
 */
public class ServiceWall {
     public ArrayList<Wall> walls;
    
    public static ServiceWall instance=null;
    public boolean resultOK;
    private final ConnectionRequest req;

    public ServiceWall() {
         req = new ConnectionRequest();
    }

    public static ServiceWall getInstance() {
        if (instance == null) {
            instance = new ServiceWall();
        }
        return instance;
    }

    public ArrayList<Wall> parseWalls(String jsonText){
        try {
            walls=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> wallsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)wallsListJson.get("root");
            for(Map<String,Object> obj : list){
                Wall w = new Wall();
                float id = Float.parseFloat(obj.get("id").toString());
                w.setId((int)id);
                w.setContenu(obj.get("contenu").toString());
                w.setImage(obj.get("image").toString());
                
                walls.add(w);
            }

        } catch (IOException ex) {
            
        }
        return walls;
    }
    
      public ArrayList<Wall> getAllWalls(){
        String url = Statics.BASE_URL+"/Wall/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                walls = parseWalls(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
 
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return walls;
    }
    
}
