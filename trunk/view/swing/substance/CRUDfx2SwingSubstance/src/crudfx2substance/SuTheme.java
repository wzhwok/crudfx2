package crudfx2substance;

import javax.swing.*;
import org.pushingpixels.substance.api.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.gui.layout.Sizer;
import crudfx2.core.gui.layout.Indent;
import crudfx2.core.gui.*;
import crudfx2.core.view.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.gui.control.tree.*;
import crudfx2.core.gui.container.*;
//import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.bind.*;
import java.awt.*;

import org.pushingpixels.lafwidget.LafWidget;
import org.pushingpixels.lafwidget.tabbed.DefaultTabPreviewPainter;
import org.pushingpixels.lafwidget.utils.LafConstants.TabOverviewKind;
import org.pushingpixels.substance.api.*;
import org.pushingpixels.substance.api.SubstanceConstants.Side;
import org.pushingpixels.substance.api.SubstanceConstants.TabCloseKind;
import org.pushingpixels.substance.api.fonts.FontSet;
import org.pushingpixels.substance.api.skin.SkinChangeListener;
import org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel;
import org.pushingpixels.substance.api.tabbed.*;

public class SuTheme extends crudfx2theme.Theme {

    public SuTheme() {
        /* SwingUtilities.invokeLater(new Runnable() {
        
        public void run() {
        try {
        SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
        laf.setSkin("org.pushingpixels.substance.api.skin.BusinessSkin");
        UIManager.setLookAndFeel(laf);
        
        UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
        System.out.println("substance");
        } catch (Throwable t) {
        t.printStackTrace();
        }
        }
        });*/
    }

    void setSkin(SubstanceLookAndFeel laf, BaseWindow win) {
        String sk = win.configuration().find("skin").find("")
                .asString("org.pushingpixels.substance.api.skin.OfficeBlue2007Skin").get();
        //System.out.println("Skin is " + sk);
        try {
            laf.setSkin(sk);
        } catch (Throwable t) {
            t.printStackTrace();
            /*System.out.println(t.getMessage());
            try {
                laf.setSkin("org.pushingpixels.substance.api.skin.BusinessSkin");
            } catch (Throwable tt) {
                //tt.printStackTrace();
                System.out.println(tt.getMessage());
            }*/
        }
        //System.out.println("Skin done " + sk);
    }

    public void startup(BaseWindow _w) {
        
        //final BaseWindow win = _w;
        mainwin=_w;
        final SuTheme me = this;
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
                //laf.setSkin("org.pushingpixels.substance.api.skin.BusinessSkin");
                //if(win.configuration().find("skin").find("").asString("").get().t)
                try {
                    UIManager.setLookAndFeel(laf);
                    //String sk = win.configuration().find("skin").find("").asString("").get();
                    //System.out.println("Skin is " + sk);
                    //laf.setSkin(sk);
                } catch (Throwable t) {
                    t.printStackTrace();
                    //System.out.println(t.getMessage());
                    //setDefaultSkin(laf, win);
                }

                SubstanceLookAndFeel.registerSkinChangeListener(new SkinChangeListener() {

                    @Override
                    public void skinChanged() {
                        String nm = SubstanceLookAndFeel.getCurrentSkin().getClass().getCanonicalName();
                        //System.out.println("changed " + nm);
                        mainwin.configuration().find("skin").find("").asString("").set(nm);
                    }
                });
                setSkin(laf, mainwin);
                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
                //nativeMainWindow.setVisible(true);
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                //nativeMainWindow.setDefaultLookAndFeelDecorated(true);
                //nativeMainWindow.setUndecorated(true);




//System.out.println(win);
                //crudfx2theme.NativeMainWindow 
                        nativeMainWindow = new crudfx2theme.NativeMainWindow(mainwin, me);
//System.out.println(win);
                nativeMainWindow.setVisible(true);
                //System.out.println("startup4");

                //nativeMainWindow.repaint(1000);
                //nativeMainWindow.doLayout();
                //System.out.println("done");
               /* JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(300, 300);
                f.setVisible(true);*/
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                try {
                    SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
                    laf.setSkin("org.pushingpixels.substance.api.skin.BusinessSkin");
                    UIManager.setLookAndFeel(laf);

                    JFrame.setDefaultLookAndFeelDecorated(true);
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);

                    SubstanceLookAndFeel.registerSkinChangeListener(new SkinChangeListener() {

                        @Override
                        public void skinChanged() {

                            //System.out.println("changed " + SubstanceLookAndFeel.getCurrentSkin().getClass().getCanonicalName());
                        }
                    });

                    laf.setSkin("org.pushingpixels.substance.api.skin.EmeraldDuskSkin");

                    JFrame f = new JFrame();
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    f.setSize(300, 300);
                    f.setVisible(true);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        });
    }
}
