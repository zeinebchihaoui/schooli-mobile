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
import com.mycompany.myapp.entities.Meeting;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ama
 */

public class ServiceMeeting {

    public ArrayList<Meeting> meetings;
    
    public static ServiceMeeting instance=null;
    public boolean resultOK;
    private final ConnectionRequest req;

    public ServiceMeeting() {
         req = new ConnectionRequest();
    }

    public static ServiceMeeting getInstance() {
        if (instance == null) {
            instance = new ServiceMeeting();
        }
        return instance;
    }

    public ArrayList<Meeting> parseMeetings(String jsonText){
        try {
            meetings=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> meetingsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)meetingsListJson.get("root");
            for(Map<String,Object> obj : list){
                Meeting m = new Meeting();
                float id = Float.parseFloat(obj.get("id").toString());
                m.setId((int)id);
                m.setEmetteur(obj.get("emetteur").toString());
                m.setRecepteur(obj.get("recepteur").toString());
                m.setSujet(obj.get("sujet").toString());
                m.setDescription(obj.get("description").toString());
                meetings.add(m);
            }            
            
        } catch (IOException ex) {
            
        }
        return meetings;
    }
    
    public ArrayList<Meeting> getAllMeetings(){
        String url = Statics.BASE_URL+"/Meeting/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                meetings = parseMeetings(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }

           
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return meetings;
    }
}
