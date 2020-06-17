/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Course;
import com.mycompany.myapp.services.ServiceCourse;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class CourseForm extends BaseForm{

    public CourseForm(com.codename1.ui.util.Resources resourceObjectInstance) {
               installSidemenu(resourceObjectInstance);
               setTitle("Courses");

               setLayout(new BoxLayout(BoxLayout.Y_AXIS));
               Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
               Label titre = new Label(" ");
               C1.add(titre);
               add(C1);
               
        ServiceCourse r = new ServiceCourse();
        ArrayList<Course> list = r.getAllCourses();
     
        for (int i = 0; i < list.size(); i++) {

            Course p = list.get(i);

            Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Button Envoyer = new Button("Course");
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel nom= new SpanLabel("Subject " + p.getNom());
                SpanLabel niveau = new SpanLabel("Grade   " + p.getNiveau());
                SpanLabel ligne = new SpanLabel("_________________________________________" );
                
                 C2.add(nom);
                 C3.add(niveau);
                 C6.add(ligne);
                 C7.add(Envoyer);
            
        C5.add(C2);
        C5.add(C3);
        C5.add(C7);
        C5.add(C6);
        add(C5);
              
        Envoyer.addActionListener((evt) -> {

      FileSystemStorage fs = FileSystemStorage.getInstance();
      String fileName = fs.getAppHomePath() + p.getPicture();
      if(!fs.exists(fileName)) {
      Util.downloadUrlToFile("http://localhost/schooli/web/uploads/brochures/"+p.getPicture(), fileName, true);
      }
      Display.getInstance().execute(fileName);
   
      });
        }
    }
    
    @Override
    protected boolean isCurrentCourse() {
        return true;
    }    
    
    @Override
    protected void initGlobalToolbar() {
        setToolbar(new Toolbar(true));
    }
}
    
