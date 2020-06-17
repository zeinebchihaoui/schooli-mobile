/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.OnOffSwitch;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

/**
 *
 * @author hp
 */
public class Inscription extends com.codename1.ui.Form{
    
    Form instance;
    Resources theme;
    EncodedImage enc;
    
    public Inscription(Form previous){
    
        Form f =  new Form("Form", BoxLayout.y());      
        TextField tfNom = new TextField("", "First Name");
        TextField tfPrenom = new TextField("", "Last Name");
        TextField tfEmail = new TextField("", "Email");
        TextField tfPwd =  new TextField("","Password");
        Picker date =new Picker();
        tfPwd.setConstraint(TextField.PASSWORD);     
        
        Container c = new Container(BoxLayout.x());
        Label l = new Label("Gender : ");
        OnOffSwitch onOff = new OnOffSwitch();    
        
        c.add(l);
        c.add(onOff);  
       
        CheckBox chParent = new CheckBox("Parent");
        CheckBox chEnfant = new CheckBox("Student");
        CheckBox chEnseignant = new CheckBox("Teacher");
       
        Button btnValider = new Button("Connexion");    
        
        f.add(tfNom);
        f.add(tfPrenom);
        f.add(tfEmail);
        f.add(tfPwd);
        f.add(date);
        f.add(c);
        f.add(chParent);
        f.add(chEnfant);
        f.add(chEnseignant);
        f.add(btnValider);
        
        f.show();
        
        btnValider.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
         Form f2 = new Form(BoxLayout.y());
         Label lNom = new Label("First Name : "+ tfNom.getText());
         Label lPrenom = new Label("Last Name : "+ tfPrenom.getText());
         Label lEmail = new Label("Email : "+ tfEmail.getText());
         Label lPwd = new Label("Password : "+ tfPwd.getText());
         Label lDate= new Label("Date of Birth : "+ date.getDate().toString());
         
         Label lGender = new Label("Gender : ");
          
         if(onOff.isValue())lGender.setText("Gender : Man");
         else lGender.setText("Gender : Women");
         Label lProfil = new Label();
         String ch ="Profile : ";
         if(chEnfant.isSelected())ch+= " Student,";
         if(chEnseignant.isSelected())ch+= " Teacher,";
         if(chParent.isSelected())ch+= " Parent,";
        
         lProfil.setText(ch);
         f2.add(lNom);
         f2.add(lPrenom);
         f2.add(lEmail);
         f2.add(lPwd);
         f2.add(lDate);
         f2.add(lGender);
         f2.add(lProfil);
         f2.show();
         
          }
      });

    }   
    
}
