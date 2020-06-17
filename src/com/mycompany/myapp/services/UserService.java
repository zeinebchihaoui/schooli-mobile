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
import com.mycompany.myapp.entities.fos_user_table;
import com.mycompany.myapp.utils.DataSource;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hp
 */
public class UserService {
    private ConnectionRequest request;

    private boolean responseResult;
    public ArrayList<fos_user_table> user;

    public UserService() {
        request = DataSource.getInstance().getRequest();
    }

    public boolean addUser(fos_user_table user ){
        String url = Statics.BASE_URL + "/user/" + user.getEmail()+ "/" + user.getMotPasse();

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200;
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }

    public fos_user_table getUser(String email, String motPass) {
        String url = Statics.BASE_URL + "/index1_user/"+email+"/"+motPass;

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                user = parseUser(new String(request.getResponseData()));
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return (user.isEmpty()?null:user.get(0));
    }

    public ArrayList<fos_user_table> parseUser(String jsonText) {
        try {
            user = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> userListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) userListJson.get("root");
            for (Map<String, Object> obj : list) {
                int id = (int)Float.parseFloat(obj.get("id").toString());
                String email = obj.get("email").toString();
                String motPasse = obj.get("password").toString();
                
                user.add(new fos_user_table(id, email, motPasse));
            }

        } catch (IOException ex) {
        }

        return user;
    }
    
}
