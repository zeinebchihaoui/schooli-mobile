/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Participate;
import com.mycompany.myapp.services.ServiceParticipate;

/**
 *
 * @author admin
 */
public class ParticipateForm extends Form {
    
     public ParticipateForm(Form previous) {
        setTitle("Save");
        setLayout(BoxLayout.y());
        
        TextField tfNom = new TextField("","First Name");
        TextField tfPrenoml = new TextField("","Last Name");
        TextField tfNum = new TextField("","Phone");
        Button btnValider = new Button("Save");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfNom.getText().length()==0)||(tfPrenoml.getText().length()==0)||(tfNum.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Participate p = new Participate(tfNom.getText(), tfPrenoml.getText(), tfNum.getText());
                        if( ServiceParticipate.getInstance().addParticipate(p))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Phone must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfNom,tfPrenoml,tfNum,btnValider);
       
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack());        
    }
    
}
