package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Painter;
import com.codename1.ui.geom.GeneralPath;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 * GUI builder created Form
 *
 * @author shai
 */
public class WalkthruForm extends com.codename1.ui.Form {

    public WalkthruForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
        private Resources theme;

    class BgPainter implements Painter {
        private Container parent;
        private Image pic;
        private int textHeight;
        
        public BgPainter(Container parent, Image pic, int textHeight) {
            this.parent = parent;
            this.pic = pic;
            this.textHeight = textHeight;
        }
       
        @Override
        public void paint(Graphics g, Rectangle rect) {
            int mm1 = Display.getInstance().convertToPixels(2);
                
            GeneralPath gp = new GeneralPath();
            float x = parent.getX() + mm1;
            float radius = mm1;
            float y = parent.getY() + mm1;
            float widthF = parent.getWidth() - (2 * mm1);
            float heightF = parent.getHeight()- (2 * mm1);
            gp.moveTo(x + radius, y);
            gp.lineTo(x + widthF - radius, y);
            gp.quadTo(x + widthF, y, x + widthF, y + radius);
            gp.lineTo(x + widthF, y + heightF - radius);
            gp.quadTo(x + widthF, y + heightF, x + widthF - radius, y + heightF);
            gp.lineTo(x + radius, y + heightF);
            gp.quadTo(x, y + heightF, x, y + heightF - radius);
            gp.lineTo(x, y + radius);
            gp.quadTo(x, y, x + radius, y);
            gp.closePath();            

            g.setColor(0xffffff);
            g.setAntiAliased(true);
            int [] clip = g.getClip();
            if(g.isShapeClipSupported()) {
                g.setClip(gp);
            } else {
                // we won't have a round rect but at least we will respect its bounds
                Rectangle r = gp.getBounds();
                g.setClip(r.getX(), r.getY(), r.getWidth(), r.getHeight());
            }
            int pw = pic.getWidth();
            float ratio = ((float)pw) / ((float)pic.getHeight());
            int width = parent.getWidth();
            float height = ((float)width) * ratio;
            int hh = (mm1 * 2) + textHeight;
            if(height < parent.getHeight() - hh) {
                hh = (int)(parent.getHeight() - height);
            }
            
            g.drawImage(pic, parent.getX(), parent.getY(), width, (int)height);
            g.setColor(0xffffff);
            g.setAlpha(255);
            g.fillRect(parent.getX(), parent.getY() + parent.getHeight() - hh, parent.getWidth(), hh);
            g.fillTriangle(parent.getX(), parent.getY() + parent.getHeight() - hh, 
                    parent.getX() + parent.getWidth(), parent.getY() + parent.getHeight() - hh,
                    parent.getX() + parent.getWidth(), parent.getY() + parent.getHeight() - hh - (mm1 * 2));
            g.setClip(clip);
        }
        
    }
    
    public WalkthruForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        
        ButtonGroup bg = new ButtonGroup();
        gui_tab1.setToggle(true);
        gui_tab1.setUIID("Label");
        bg.add(gui_tab1);
        gui_tab1.setSelected(true);
        
        Image bla = resourceObjectInstance.getImage("img_1.jpg");
       
        gui_tab1Root.setLayout(new BorderLayout());
        
        String line1 =  "Address: Esprit,Tunisia"
                + "      Phone: +216 25451567"
                + "     Email: Schooli@gmail.com";

        if(!Display.getInstance().isTablet()) {
            line1 = line1.replace('\n', ' ');
        }

        
        Container content1 = BoxLayout.encloseY(
                new Label("Contact Us", "WelcomeTitle"),
                new Label(resourceObjectInstance.getImage("welcome-separator.png"), "WelcomeTitle"),
                new SpanLabel(line1,"WelcomeBody")
                
        );

        content1.setUIID("WelcomeContent");

        gui_tab1Root.add(BorderLayout.SOUTH, content1);
        
        gui_tab1Root.getUnselectedStyle().setBgPainter(new BgPainter(gui_tab1Root, bla, content1.getPreferredH() +
                content1.getUnselectedStyle().getPaddingTop() + 
                content1.getUnselectedStyle().getPaddingBottom() + 
                content1.getUnselectedStyle().getMarginTop() + 
                content1.getUnselectedStyle().getMarginBottom()));
                

        gui_Tabs_1.addSelectionListener((i, ii) -> {
            switch(ii) {
                case 0:
                    gui_tab1.setSelected(true);
                    break;
            }
        });

        gui_Tabs_1.hideTabs();
        gui_Tabs_1.getContentPane().setUIID("Container");
    }

    @Override
    protected Component createStatusBar() {
        Component c = super.createStatusBar();
        c.getUnselectedStyle().setPadding(0, 0, 0, 0);
        return c;
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    protected com.codename1.ui.Tabs gui_Tabs_1 = new com.codename1.ui.Tabs();
    protected com.codename1.ui.Container gui_tab1Root = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    protected com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.RadioButton gui_tab1 = new com.codename1.ui.RadioButton();
    protected com.codename1.ui.Container gui_Container_6 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    protected com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    protected com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
       
        gui_Button_1.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();

            if(sourceComponent.getParent().getLeadParent() != null && (sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.MultiButton || sourceComponent.getParent().getLeadParent() instanceof com.codename1.components.SpanButton)) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            
            if(sourceComponent == gui_Button_1) {
                onButton_1ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setInlineStylesTheme(resourceObjectInstance);
        setUIID("Welcome");
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("");
        setName("WalkthruForm");
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Tabs_1);
                gui_Tabs_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Tabs_1.setName("Tabs_1");
        gui_Tabs_1.addTab("Tab 0" ,gui_tab1Root);
        gui_tab1Root.setUIID("Card");
                gui_tab1Root.setInlineStylesTheme(resourceObjectInstance);
        gui_tab1Root.setName("tab1Root");
                
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Container_4);
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
        gui_Container_4.addComponent(gui_Container_3);
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_3.addComponent(gui_tab1);
        gui_tab1.setSelected(false);
        gui_tab1.setUIID("Label");
                gui_tab1.setInlineStylesTheme(resourceObjectInstance);
        gui_tab1.setName("tab1");
        gui_tab1.setIcon(resourceObjectInstance.getImage("walthru-radio-unselected.png"));
        gui_tab1.setPressedIcon(resourceObjectInstance.getImage("walthru-radio-selected.png"));
       
        gui_Container_4.addComponent(gui_Container_6);
        gui_Container_6.setUIID("GetStartedButton");
                gui_Container_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_6.setName("Container_6");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_6.addComponent(gui_Button_1);
        gui_Container_6.addComponent(gui_Label_1);
        gui_Button_1.setText("Get Started");
        gui_Button_1.setUIID("GetStartedButton");
                gui_Button_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Button_1.setName("Button_1");
        gui_Button_1.setTextPosition(com.codename1.ui.Component.LEFT);
        gui_Label_1.setUIID("GetStartedRedArrow");
                gui_Label_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Label_1.setName("Label_1");
        com.codename1.ui.FontImage.setMaterialIcon(gui_Label_1,"\ue5c8".charAt(0));
                gui_Container_3.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_3.setName("Container_3");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_3.getLayout()).setValign(com.codename1.ui.Component.CENTER);
        gui_Container_6.setUIID("GetStartedButton");
                gui_Container_6.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_6.setName("Container_6");
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setAlign(com.codename1.ui.Component.CENTER);
        ((com.codename1.ui.layouts.FlowLayout)gui_Container_6.getLayout()).setValign(com.codename1.ui.Component.CENTER);
                gui_Tabs_1.setInlineStylesTheme(resourceObjectInstance);
        gui_Tabs_1.setName("Tabs_1");
                gui_Container_4.setInlineStylesTheme(resourceObjectInstance);
        gui_Container_4.setName("Container_4");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
    public void ontab3ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
    }

    public void onButton_1ActionEvent(com.codename1.ui.events.ActionEvent ev) {
        
        new SignInForm().show();
//        Authentification a= new Authentification(theme);

    }

}