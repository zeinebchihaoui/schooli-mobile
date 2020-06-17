package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
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
import com.mycompany.myapp.entities.Wall;
import com.mycompany.myapp.services.ServiceWall;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author admin
 */

public class WallForm extends BaseForm{
    
    Form current;
    public ObservableList<Wall> data = FXCollections.observableArrayList();
    private Resources theme  = UIManager.initFirstTheme("/theme");
    
    public WallForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        current = this; 
         
        installSidemenu(resourceObjectInstance);
        setTitle("Posts");
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(BoxLayout.yCenter());
        Label titre = new Label("");
               C1.add(titre);
               add(C1);
               
        ServiceWall e1 = new ServiceWall();
        ArrayList<Wall> list = e1.getAllWalls();

        for (int i = 0; i < list.size(); i++) {

            Wall wal = list.get(i);
            
                Container C2 = new Container(BoxLayout.yCenter());
                Container c3=new Container(BoxLayout.yCenter());
                Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                
    ImageViewer imagey=new ImageViewer(theme.getImage(wal.getImage()));

            EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(650, 550, 0xffff0000), true);
            URLImage logo = URLImage.createToStorage(placeholder, wal.getContenu()+".cache",
                "http://localhost/my_project/web/uploads/images/"+ wal.getImage());
            
            ImageViewer ivLogo=new ImageViewer();
            ivLogo.setImage(logo);

            System.out.println("image"+wal.getImage());

                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel contenu= new SpanLabel(" " + wal.getContenu());
                SpanLabel image= new SpanLabel(" " + ivLogo);
                SpanLabel ligne = new SpanLabel("___________________________________________  " );

                C2.add(contenu);
                c3.add(imagey);
                C4.add(ligne);

        add(C2);
        add(c3);
        add(C4);
        
        }
  
    }

}


