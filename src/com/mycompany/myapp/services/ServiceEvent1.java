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
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Event1;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */

public class ServiceEvent1 {
    public ArrayList<Event1> events1;
    
    public static ServiceEvent1 instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceEvent1() {
         req = new ConnectionRequest();
    }

    public static ServiceEvent1 getInstance() {
        if (instance == null) {
            instance = new ServiceEvent1();
        }
        return instance;
    }    
    
   static Map g;

        public ArrayList<Event1> parseEvents1(String jsonText){
        try {
            events1=new ArrayList<>();
            JSONParser j = new JSONParser();
           
            Map<String,Object> events1ListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            g = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            for (int i = 0; i < g.size(); i++) {

            List<Map<String,Object>> list = (List<Map<String,Object>>)events1ListJson.get("root");
            for(Map<String,Object> obj : list){
                
                Event1 ev = new Event1();
 
           //Map<String, Object> mapDateEvent = (Map<String, Object>) g.get("date");
//            
//                float dateevent = Float.parseFloat(mapDateEvent.get("timestamp").toString());
//                String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date((long) (dateevent * 1000L)));
//                ev.setDate(date);

//              Date date = Date.parseDate(obj.get("date").toString());
             
             try {
                    int i = 0;

                    Date date =new SimpleDateFormat("dd/MM/yyyy").parse(list.get(i).get("date").toString());
                } catch (Exception ex) {
                    
                }
                //ev.setDate(obj.get("date").toString());
                ev.setType(obj.get("type").toString());
                ev.setLieu(obj.get("lieu").toString());
                ev.setPrix(((int)Float.parseFloat(obj.get("prix").toString())));
                ev.setDetails(obj.get("details").toString());
//                Map<String, Object> event1 = (Map<String, Object>) g.get("event1");

                events1.add(ev);
            }
        } catch (IOException ex) {
            
        }         
        return events1;
    }
        
    public ArrayList<Event1> getAllEvents1(){
        String url = Statics.BASE_URL+"/Event/alls";
        System.out.println(url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events1 = parseEvents1(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return events1;
    }
}
