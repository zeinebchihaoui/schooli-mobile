
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Event1;
import com.mycompany.myapp.services.ServiceEvent1;
import java.util.ArrayList;

/**
 *
 * @author admin
 */

public class ListEvents1Form extends Form{
    Form instance;
    Resources theme;

    public ListEvents1Form(Form previous) {
                instance=this;
                setTitle("Details");

      setLayout(new BoxLayout(BoxLayout.Y_AXIS));
         Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
         Label titre = new Label(" ");
               C1.add(titre);
               add(C1);
               
        ServiceEvent1 evt = new ServiceEvent1();
        ArrayList<Event1> list = evt.getAllEvents1();
     
        for (int i = 0; i < list.size(); i++) {

            Event1 ev = list.get(i);   
    
              Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel date= new SpanLabel("Date:   " + ev.getDate());
                SpanLabel type= new SpanLabel("Type:   " + ev.getType());
                SpanLabel lieu = new SpanLabel("Location:   " + ev.getLieu());
                SpanLabel prix = new SpanLabel("Price:    "+ ev.getPrix());
                SpanLabel details = new SpanLabel("Details:    "+ ev.getDetails());
                SpanLabel ligne = new SpanLabel("_________________________________________" );
                 
                 C2.add(date);
                 C3.add(type);
                 C4.add(lieu);
                 C5.add(prix);
                 C6.add(details);
                 C7.add(ligne);
            
        add(C2);
        add(C3);
        add(C4);
        add(C5);
        add(C6);
        add(C7);
        }
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
     
}
