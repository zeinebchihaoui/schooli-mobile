package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.services.ServiceEvent;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author admin
 */

public class ListEventsForm extends BaseForm{
    
    Form current;
    public ObservableList<Event> data = FXCollections.observableArrayList();
    private Resources theme  = UIManager.initFirstTheme("/theme");
    public static Resources res;

    public ListEventsForm(com.codename1.ui.util.Resources resourceObjectInstance ) {
 
        installSidemenu(resourceObjectInstance);

        current = this; 
        setTitle("Events");
        
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(BoxLayout.yCenter());
        Label titre = new Label("");
               C1.add(titre);
               add(C1);
               
        ServiceEvent e1 = new ServiceEvent();
        ArrayList<Event> list = e1.getAllEvents();

        for (int i = 0; i < list.size(); i++) {

            Event eve = list.get(i);
            
                Container C2 = new Container(BoxLayout.yCenter());
                Container c3=new Container(BoxLayout.yCenter());
                
            ImageViewer imagey=new ImageViewer(theme.getImage(eve.getImage()));

            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(650, 550, 0xffff0000), true);
            URLImage logo = URLImage.createToStorage(placeholder, eve.getTitre()+".cache",
                "http://localhost/schooli/web/uploads/images/"+ eve.getImage());
            
            ImageViewer ivLogo=new ImageViewer();
            ivLogo.setImage(logo);

            System.out.println("image"+eve.getImage());

                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel titree= new SpanLabel(" " + eve.getTitre());
                SpanLabel image= new SpanLabel(" " + ivLogo);

                C2.add(titree);
                c3.add(imagey);

        add(C2);
        add(c3);
        
        Button btnListEvents1 = new Button("More Details");    
        btnListEvents1.addActionListener(ev -> new ListEvents1Form(current).show());
        addAll(btnListEvents1);
               
        Button btnListCommentaires = new Button("Comment");        
        btnListCommentaires.addActionListener(c -> new ListCommentairesForm(current).show());
        addAll(btnListCommentaires);
        
        Button btnListParticipate = new Button("Participate");        
        btnListParticipate.addActionListener(c -> new ParticipateForm(current).show());
        addAll(btnListParticipate);
        
        } 

    }
    
    @Override
    protected boolean isCurrentEvents() {
        return true;
    }

}


