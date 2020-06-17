/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Commentaire;
import com.mycompany.myapp.services.ServiceCommentaire;
import java.util.ArrayList;

/**
 *
 * @author admin
 */

public class ListCommentairesForm extends Form{
    Form instance;
    Resources theme;
    Form f;

    public ListCommentairesForm(Form previous) {
        instance=this;
        setTitle("Comments");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label titre = new Label(" ");
               C1.add(titre);
               add(C1);
               
        ServiceCommentaire c = new ServiceCommentaire();
        ArrayList<Commentaire> list = c.getAllCommentaire();

        for (int i = 0; i < list.size(); i++) {

            Commentaire cm = list.get(i);
            Commentaire co = list.get(i);

              Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel description= new SpanLabel(" " + cm.getDescription());
//                SpanLabel ligne = new SpanLabel("________________________________________" );
                
                 C2.add(description);
//                 C4.add(ligne);
        
        Commentaire ct = new Commentaire();

        Button btnDelete = new Button("Delete");
        btnDelete.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent evt) { 
                ServiceCommentaire.getInstance().supp(ct)  ;
            }});

                add(C2);
//                add(C4);
                add(btnDelete);               
                }

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
        
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ADD ,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new AddCommentaireForm(instance).show();
            }
        });
    }
    
}
