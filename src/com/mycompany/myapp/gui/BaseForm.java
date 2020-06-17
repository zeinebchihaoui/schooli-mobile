/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author admin
 */
public class BaseForm extends Form {
public void installSidemenu(Resources res) {
        Image selection = res.getImage("selection-in-sidemenu.png");
        
        Image reclamationImage = null;
        if(isCurrentReclamation()) reclamationImage = selection;
        
        Image meettingImage = null;
        if(isCurrentMeetting()) meettingImage = selection;
        
        Image inboxImage = null;
        if(isCurrentInbox()) inboxImage = selection;

        Image eventsImage = null;
        if(isCurrentEvents()) eventsImage = selection;
        
        Image planningsImage = null;
        if(isCurrentPlannings()) planningsImage = selection;
        
        Image calendarImage = null;
        if(isCurrentCalendar()) calendarImage = selection;
        
        Image logoutImage = null;
        if(isCurrentLogout()) logoutImage = selection;
        
        Image trendingImage = null;
        if(isCurrentTrending()) trendingImage = selection;
       
        Image courseImage = null;
        if(isCurrentTrending()) courseImage = selection;
        
        Image wallImage = null;
        if(isCurrentTrending()) wallImage = selection;
        
        Button inboxButton = new Button("Home", inboxImage);
        inboxButton.setUIID("SideCommand");
        inboxButton.getAllStyles().setPaddingBottom(0);
        Container home = FlowLayout.encloseMiddle(inboxButton);
        home.setLeadComponent(inboxButton);
        home.setUIID("SideCommand");
        inboxButton.addActionListener(e -> new InboxForm().show());
        
        getToolbar().addComponentToSideMenu(home);
        getToolbar().addCommandToSideMenu("Events", eventsImage, e -> new ListEventsForm(res).show());
        getToolbar().addCommandToSideMenu("Planning", planningsImage, e -> new UploadPlanningForm(res).show());
        getToolbar().addCommandToSideMenu("Reclamation", reclamationImage, e -> new ListReclamationsForm(res).show());
        getToolbar().addCommandToSideMenu("Meeting", meettingImage, e -> new ListMeetingForm(res).show());
        getToolbar().addCommandToSideMenu("Courses", courseImage, e -> new CourseForm(res).show());
        getToolbar().addCommandToSideMenu("Wall", wallImage, e -> new WallForm(res).show());
//        getToolbar().addCommandToSideMenu("Quiz", null, e -> {});
//        getToolbar().addCommandToSideMenu("Avtivity", null, e -> {});
        getToolbar().addCommandToSideMenu("E-mail", calendarImage, e -> new Email(res).show());
        getToolbar().addCommandToSideMenu("Calendar", calendarImage, e -> new CalendarForm(res).show());
        getToolbar().addCommandToSideMenu("Log Out", logoutImage, e -> new SignInForm(res).show());
        
    }
    protected boolean isCurrentReclamation() {
        return false;
    }
        
    protected boolean isCurrentMeetting() {
        return false;
    }
    
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentEvents() {
        return false;
    }

    protected boolean isCurrentPlannings() {
        return false;
    }
    
    protected boolean isCurrentCalendar() {
        return false;
    }
    
    protected boolean isCurrentLogout() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }
    
    protected boolean isCurrentCourse() {
        return false;
    }
    
    protected boolean isCurrentWall() {
        return false;
    }
}
