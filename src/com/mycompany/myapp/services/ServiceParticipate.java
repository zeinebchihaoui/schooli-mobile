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
import com.mycompany.myapp.entities.Participate;
import static com.mycompany.myapp.services.ServiceParticipate.instance;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public class ServiceParticipate {
    public ArrayList<Participate> participates;
    
    public static ServiceParticipate instance=null;
    public boolean resultOK;
    private final ConnectionRequest req;

    public ServiceParticipate() {
         req = new ConnectionRequest();
    }

    public static ServiceParticipate getInstance() {
        if (instance == null) {
            instance = new ServiceParticipate();
        }
        return instance;
    }    

    public boolean addParticipate(Participate p) {
        String url = Statics.BASE_URL + "/Event/new" +"?nom="+ p.getNom() + "&prenom=" + p.getPrenom() + "&num=" + p.getNum();
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

    public ArrayList<Participate> parseParticipates(String jsonText){
        try {
            participates=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> participatesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)participatesListJson.get("root");
            for(Map<String,Object> obj : list){
                Participate p = new Participate();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setId((int)id);
                p.setNom(obj.get("nom").toString());
                p.setPrenom(obj.get("prenom").toString());
                p.setNum(obj.get("num").toString());

                participates.add(p);
            }
                       
        } catch (IOException ex) {
            
        }
        return participates;
    }
    
}
