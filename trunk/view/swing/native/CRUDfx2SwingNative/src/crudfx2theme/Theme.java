package crudfx2theme;

import crudfx2.core.gui.control.button.*;


import crudfx2.core.gui.layout.*;

import javax.swing.*;
import java.awt.*;
import crudfx2.core.gui.*;
import crudfx2.core.view.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.gui.control.tree.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.bind.*;
import java.awt.event.*;
import crudfx2theme.nuvola.*;
import java.io.*;
import java.util.*;

public class Theme extends BaseTheme {

    protected NativeMainWindow nativeMainWindow = null;
    protected BaseWindow mainwin = null;
    public static Cursor handCursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);

    public Theme() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public Wood loadConfiguration(String key) {
        return BindTools.loadFromXMLFile(BindTools.homeFile(key));
    }

    public void saveConfiguration(String key, Wood cfg) {
        BindTools.saveToHome(key, cfg);
    }

    public boolean confirm(String message) {
        Component c = null;
        String title = "";
        if (nativeMainWindow != null) {
            c = nativeMainWindow;
            title = nativeMainWindow.getTitle();
        }
        int n = JOptionPane.showConfirmDialog(c, message, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (n == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public void warn(String message) {
        Component c = null;
        String title = "";
        if (nativeMainWindow != null) {
            c = nativeMainWindow;
            title = nativeMainWindow.getTitle();
        }
        JOptionPane.showMessageDialog(c, message, title, JOptionPane.WARNING_MESSAGE);
        //log(0,""+c);
    }

    public void inform(String message) {
        /*Component c = null;
        String title = "";
        if (nativeMainWindow != null) {
        c = nativeMainWindow;
        title = nativeMainWindow.getTitle();
        }
        JOptionPane.showMessageDialog(c, message, title, JOptionPane.INFORMATION_MESSAGE);*/
        new InfoFrame(message, this.nativeMainWindow);
    }

    public void exit() {
        if (nativeMainWindow != null) {
            //System.out.println(mainwin);
            if (mainwin.approveClosing()) {
                System.exit(0);
            }
        }
    }

    public void log(int key, String message) {
        System.out.print(new Date());
        System.out.print(": ");
        System.out.print(key);
        System.out.print(": ");
        System.out.println(message);
    }

    public JComponent createJComponent(Widget unit) {
        //System.out.println(unit);
        if (unit == null) {
            return null;
        }
        if (unit instanceof StandardButton) {
            return new NativeStandardButton((StandardButton) unit, this);
        }
        if (unit instanceof BigButton) {
            return new NativeBigButton((BigButton) unit, this);
        }
        if (unit instanceof ColorFill) {
            return new NativeColorFill((ColorFill) unit, this);
        }
        if (unit instanceof StandardLabel) {
            return new NativeTextLabel((StandardLabel) unit, this);
        }
        if (unit instanceof JamLeft) {
            return new NativeJamLeft((JamLeft) unit, this);
        }
        if (unit instanceof JamRight) {
            return new NativeJamRight((JamRight) unit, this);
        }
        if (unit instanceof JamTop) {
            return new NativeJamTop((JamTop) unit, this);
        }
        if (unit instanceof JamBottom) {
            return new NativeJamBottom((JamBottom) unit, this);
        }
        if (unit instanceof Sizer) {
            return new NativeSizer((Sizer) unit, this);
        }
        if (unit instanceof Indent) {
            return new NativeIndent((Indent) unit, this);
        }
        if (unit instanceof SplitLeftRight) {
            return new NativeSplitLeftRight((SplitLeftRight) unit, this);
        }
        if (unit instanceof SplitTopBottom) {
            return new NativeSplitTopBottom((SplitTopBottom) unit, this);
        }
        if (unit instanceof StandardTree) {
            return new NativeTree((StandardTree) unit, this);
        }
        if (unit instanceof Hidder) {
            return new NativeHidder((Hidder) unit, this);
        }
        if (unit instanceof StandardToggle) {
            return new NativeToggle((StandardToggle) unit);
        }
        if (unit instanceof SectionHide) {
            return new NativeSectionHide((SectionHide) unit, this);
        }
        if (unit instanceof SuiteHorizontal) {
            return new NativeSuiteHorizontal((SuiteHorizontal) unit, this);
        }
        if (unit instanceof SuiteVertical) {
            return new NativeSuiteVertical((SuiteVertical) unit, this);
        }
        if (unit instanceof ScrollBox) {
            return new NativeScrollBox((ScrollBox) unit, this);
        }
        if (unit instanceof Tabs) {
            return new NativeTabs((Tabs) unit, this);
        }
        if (unit instanceof Center) {
            return new NativeCenter((Center) unit, this);
        }
        JLabel bad = new JLabel(unit.getClass().getName());
        bad.setOpaque(true);
        bad.setBackground(new Color(150, 0, 0));
        bad.setForeground(new Color(255, 255, 255));
        return bad;
    }

    public ImageIcon icon(String path) {

        //return IconLoader.icon(path);
        return new ImageIcon(path);

    }

    public void startup(BaseWindow win) {
        //System.out.println(win);
        mainwin = win;
        nativeMainWindow = new NativeMainWindow(win, this);
        //System.out.println(win);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                //nativeMainWindow.setVisible(true);

                nativeMainWindow.setVisible(true);

                //nativeMainWindow.repaint(1000);
                //nativeMainWindow.doLayout();
                //System.out.println("done");
            }
        });
    }
}
