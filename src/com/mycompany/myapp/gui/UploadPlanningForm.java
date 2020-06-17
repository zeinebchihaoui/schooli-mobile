
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Upload;
import com.mycompany.myapp.services.ServiceUpload;
import java.util.ArrayList;

/**
 *
 * @author admin
 */

public class UploadPlanningForm  extends BaseForm{

    public UploadPlanningForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        installSidemenu(resourceObjectInstance);
        setTitle("Plannings");

        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label titre = new Label("  ");
            C1.add(titre);
            add(C1);
    
        ServiceUpload u = new ServiceUpload();
        ArrayList<Upload> list = u.getAllUploads();
     
//        Container C9 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
//
//        tb.addSearchCommand(e -> {
//
//            String text = (String) e.getSource();
//
//            ArrayList<Upload> filtred_upload = new ArrayList<>();
//            for (Upload p : list) {
//                String classe = String.valueOf(p.getClasse());
//                if (classe.startsWith(text)) {
//                    filtred_upload.add(p);
//
//                }
//            }
//            C9.removeAll();
//            setUploads(filtred_upload, res);
//
//            revalidate();
//        });
//         
//        installSidemenu(res);
//        list = ServiceUpload.getAllUploads();
//        setUploads(list, res);
//        add(C9);

        for (int i = 0; i < list.size(); i++) {

            Upload p = list.get(i);

              Container C3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C4 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
              Container C7 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                
                Button Envoyer = new Button("Planning");
                Font font = titre.getUnselectedStyle().getFont();
                Font newFont = Font.createSystemFont(font.getFace(), Font.STYLE_BOLD, font.getSize());
                titre.getUnselectedStyle().setFont(newFont);
                SpanLabel classe = new SpanLabel("Grade" + p.getClasse());
                SpanLabel ligne = new SpanLabel("_________________________________________" );
                
                C3.add(classe);
                C6.add(ligne);
                C7.add(Envoyer);
            
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
    
    protected boolean isCurrentPlannings() {
        return false;
    }

    private void setUploads(ArrayList<Upload> list, Resources res) {
    }
}
