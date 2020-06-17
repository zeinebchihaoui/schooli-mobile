/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.services.OpinionDAO;

/**
 *
 * @author admin
 */
public class Email extends BaseForm{

    public Email(com.codename1.ui.util.Resources resourceObjectInstance) {
 
        installSidemenu(resourceObjectInstance);
        setTitle("E-mail");

        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(BoxLayout.yCenter());
        Container C2 = new Container(BoxLayout.yCenter());
        Container C3 = new Container(BoxLayout.yCenter());
        Container C4 = new Container(BoxLayout.yCenter());
        Container C5 = new Container(BoxLayout.yCenter());
        Container C6 = new Container(BoxLayout.yCenter());
        Container C7 = new Container(BoxLayout.yCenter());
        Container C8 = new Container(BoxLayout.yCenter());
        
        SpanLabel lign = new SpanLabel("  " );
        SpanLabel ligne = new SpanLabel("  " );
        SpanLabel lignx = new SpanLabel("  " );
        SpanLabel lig = new SpanLabel("  " );
        SpanLabel li = new SpanLabel("  " );
        SpanLabel l = new SpanLabel("  " );
        SpanLabel lix = new SpanLabel("  " );
        SpanLabel lx = new SpanLabel("  " );
        
                C1.add(lign);
                C2.add(ligne);
                C3.add(lignx);
                C4.add(lig);
                C5.add(li);
                C6.add(l);
                C7.add(lix);
                C8.add(lx);
                
                add(C1);
                add(C2);
                add(C3);
                add(C4);
                add(C5);
                add(C6);
                add(C7);
                add(C8);
 
    Button btnValider = new Button("Send e-mail");
    btnValider.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            new OpinionDAO();
                }
            });
        add(btnValider);
}
}