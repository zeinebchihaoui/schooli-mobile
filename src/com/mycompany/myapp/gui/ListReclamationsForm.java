/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;

import java.util.ArrayList;

/**
 *
 * @author Asma
 */
public class ListReclamationsForm extends BaseForm{
    Form instance;

    public ListReclamationsForm(com.codename1.ui.util.Resources resourceObjectInstance) {
                instance=this;
         setTitle("Reclamations");
         installSidemenu(resourceObjectInstance);

         setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label("");
               C1.add(titre);
               add(C1);
        
        ServiceReclamation r = new ServiceReclamation();
        ArrayList<Reclamation> list = r.getAllReclamations();
     
        for (int i = 0; i < list.size(); i++) {

            Reclamation p = list.get(i);
       
              Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel fullname= new SpanLabel("Full name:   " + p.getFullname());
                SpanLabel email = new SpanLabel("Email:   " + p.getEmail());
                SpanLabel phone = new SpanLabel("Phone:    "+ p.getPhone());
                SpanLabel message = new SpanLabel("Message:    "+ p.getMessage());
                SpanLabel ligne = new SpanLabel("_________________________________________" );
                
                 C2.add(fullname);
                 C3.add(email);
                 C4.add(phone);
                 C7.add(message);
                 C6.add(ligne);
            
        C5.add(C2);
        C5.add(C3);
        C5.add(C4);
        C5.add(C7);
        C5.add(C6);
        add(C5);
        }
        
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD ,new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        new AddReclamationForm(instance).show();
                    }
                });
    }
    
    protected boolean isCurrentReclamation() {
            return false;
        }
       
}
