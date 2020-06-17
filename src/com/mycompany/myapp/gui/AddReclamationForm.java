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
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;

/**
 *
 * @author Asma
 */
public class AddReclamationForm extends Form {
    
     public AddReclamationForm(Form previous) {
        setTitle("Save");
        setLayout(BoxLayout.y());
        
        TextField tfFullname = new TextField("","Full Name");
        TextField tfEmail = new TextField("","Email");
        TextField tfPhone = new TextField("","Phone");
        TextField tfMessage= new TextField("", "Message");
        Button btnValider = new Button("Add Reclamation");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfFullname.getText().length()==0)||(tfEmail.getText().length()==0)||(tfPhone.getText().length()==0)||(tfMessage.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Reclamation r = new Reclamation(Integer.parseInt(tfPhone.getText()), tfFullname.getText(), tfEmail.getText(), tfMessage.getText());
                        if( ServiceReclamation.getInstance().addReclamation(r))
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Phone must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfFullname,tfEmail,tfPhone,tfMessage,btnValider);
       
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack());        
    } 
    
}
