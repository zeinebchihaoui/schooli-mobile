/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.fos_user_table;
import com.mycompany.myapp.services.UserService;

/**
 *
 * @author hp
 */
public class Authentification extends BaseForm{
        Form current;

    public Authentification(Resources theme){
      current = this; 

      Form loginForm = new Form(BoxLayout.y());
      Form homeForm = new Form("Connexion");

        Label name = new Label();

        homeForm.getToolbar().addMaterialCommandToOverflowMenu(
                "Logout", FontImage.MATERIAL_EXIT_TO_APP,
                 new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                loginForm.showBack();
            }
        });

        TextField tfEmail = new TextField(null,"User Name");
        TextField tfMotPasse = new TextField(null,"Password");
        tfMotPasse.setConstraint(TextField.PASSWORD);
        Button valider = new Button("Login");

        valider.addActionListener((evt) -> {
            String email = tfEmail .getText();
            String motPasse = tfMotPasse.getText();
              if ((tfEmail.getText().length() == 0) || (tfMotPasse.getText().length() == 0)) {
                Dialog.show("Alerte", "veuillez remplir tous les champs", "OK", null);
            } else {
                
                    fos_user_table user = new UserService().getUser(tfEmail .getText(), tfMotPasse.getText());
                    if(user!=null) {
                        Dialog.show("SUCCESS", "User connecté", "OK", null);
                        new InboxForm(theme).show();
                    } else {
                        
                        Dialog.show("ERROR", "Server error", "OK", null);
                } 
            }
        });
        
        Button btnS = new Button("Sign up");        
        btnS.addActionListener(ev -> new Inscription(current).show());
        
        loginForm.add(tfEmail);
        loginForm.add(tfMotPasse);
        loginForm.add(valider);
        loginForm.add(btnS);
        loginForm.show();
                
    }

}
