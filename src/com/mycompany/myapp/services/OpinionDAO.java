/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.messaging.Message;
import com.codename1.ui.Display;

/**
 *
 * @author admin
 */

public class OpinionDAO {
     public OpinionDAO(){
    
    Message m = new Message(" ");

    Display.getInstance().sendMessage(new String[] {"schoolischooli370@gmail.com"}, " ", m);
                
    }
}
