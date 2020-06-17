/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Meeting;
import com.mycompany.myapp.services.ServiceMeeting;
import java.util.ArrayList;

/**
 *
 * @author Asma
 */
public class ListMeetingForm extends BaseForm{

    public ListMeetingForm(com.codename1.ui.util.Resources resourceObjectInstance) {
                installSidemenu(resourceObjectInstance);
        setTitle("Meetings");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label(" ");
               C1.add(titre);
               add(C1);
               
        ServiceMeeting r = new ServiceMeeting();
        ArrayList<Meeting> list = r.getAllMeetings();

        for (int i = 0; i < list.size(); i++) {

            Meeting p = list.get(i);
              
       Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
       Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel emetteur= new SpanLabel("Sender:   " + p.getEmetteur());
                SpanLabel recepteur = new SpanLabel("Receiver:   " + p.getRecepteur());
                SpanLabel sujet = new SpanLabel("Subject:    "+ p.getSujet());
                SpanLabel description = new SpanLabel("Message:    "+ p.getDescription());
                SpanLabel ligne = new SpanLabel("_________________________________________" );
                
                 C2.add(emetteur);
                 C3.add(recepteur);
                 C4.add(sujet);
                 C7.add(description);
                 C6.add(ligne);
                            
        C5.add(C2);
        C5.add(C3);
        C5.add(C4);
        C5.add(C7);
        C5.add(C6);
        add(C5);
        }
       
    }
   protected boolean isCurrentMeetting() {
        return false;
    }
  
}
