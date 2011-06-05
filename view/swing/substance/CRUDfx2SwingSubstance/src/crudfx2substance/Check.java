package crudfx2substance;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.FontUIResource;


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

public class Check extends JFrame {

    public Check() {
        //super(
          //      "Substance test with very very very very very very very very very very very very very very long title");

        //final ClassLoader cl = Thread.currentThread().getContextClassLoader();
        /*if (UIManager.getLookAndFeel() instanceof SubstanceLookAndFeel) {
        setIconImage(SubstanceLogo.getLogoImage(SubstanceLookAndFeel
        .getCurrentSkin(this.getRootPane()).getColorScheme(
        DecorationAreaType.PRIMARY_TITLE_PANE,
        ColorSchemeAssociationKind.FILL,
        ComponentState.ENABLED)));
        }*/
      
        //setLayout(new BorderLayout());
/*
        jtp = new JTabbedPane();
        try {
            mainTabPreviewPainter = new MyMainTabPreviewPainter();
            jtp.putClientProperty(LafWidget.TABBED_PANE_PREVIEW_PAINTER,
                    mainTabPreviewPainter);
        } catch (Throwable e) {
        }*/
       // jtp.getModel().addChangeListener(new TabSwitchListener());

       
        setPreferredSize(new Dimension(400, 400));
        this.setSize(getPreferredSize());
        setMinimumSize(getPreferredSize());

/*

        JPanel verticalButtonPanel = new JPanel();
        verticalButtonPanel.setLayout(new GridLayout(1, 3));
        verticalButtonPanel.add(new JButton("Vert button 1"));
        verticalButtonPanel.add(new JButton("Vert button 2"));
        JPanel smallVerticalButtonPanel = new JPanel();
        smallVerticalButtonPanel.setLayout(new GridLayout(4, 4));
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                JButton vertButton = new JButton("vert");
                vertButton.setToolTipText("Vertical button " + row + ":" + col);
                smallVerticalButtonPanel.add(vertButton);
            }
        }
        verticalButtonPanel.add(smallVerticalButtonPanel);*/
    //    jtp.addTab("V-Buttons", verticalButtonPanel);

   

        // sample menu bar
        //JMenuBar jmb = new JMenuBar();
       /*
        JMenu coloredMenu = new JMenu("Colors");
        coloredMenu.setMnemonic('0');
        JMenuItem coloredMI = new JMenuItem("Italic red");
        coloredMI.setFont(coloredMI.getFont().deriveFont(Font.ITALIC));
        coloredMI.setForeground(Color.red);
        coloredMenu.add(coloredMI);
        JRadioButtonMenuItem coloredRBMI = new JRadioButtonMenuItem(
                "Bold green");
        coloredRBMI.setFont(coloredRBMI.getFont().deriveFont(Font.BOLD));
        coloredRBMI.setForeground(Color.green);
        coloredMenu.add(coloredRBMI);
        JCheckBoxMenuItem coloredCBMI = new JCheckBoxMenuItem("Big blue");
        coloredCBMI.setFont(coloredCBMI.getFont().deriveFont(32f));
        coloredCBMI.setForeground(Color.blue);
        coloredMenu.add(coloredCBMI);
        JMenu coloredM = new JMenu("Always big magenta");
        coloredM.setForeground(Color.magenta);
        coloredM.setFont(coloredM.getFont().deriveFont(24f));
        coloredMenu.add(coloredM);
        jmb.add(coloredMenu);

        
        JMenu jm4 = new JMenu("Disabled");
        jm4.add(new JMenuItem("dummy4"));
        jm4.setMnemonic('4');
        jmb.add(jm4);
        jm4.setEnabled(false);

        // LAF changing
        
        setJMenuBar(jmb);
*/
       /* TabCloseCallback closeCallbackMain = new TabCloseCallback() {

            public TabCloseKind onAreaClick(JTabbedPane tabbedPane,
                    int tabIndex, MouseEvent mouseEvent) {
                if (mouseEvent.getButton() != MouseEvent.BUTTON2) {
                    return TabCloseKind.NONE;
                }
                if (mouseEvent.isShiftDown()) {
                    return TabCloseKind.ALL;
                }
                return TabCloseKind.THIS;
            }

            public TabCloseKind onCloseButtonClick(JTabbedPane tabbedPane,
                    int tabIndex, MouseEvent mouseEvent) {
                if (mouseEvent.isAltDown()) {
                    return TabCloseKind.ALL_BUT_THIS;
                }
                if (mouseEvent.isShiftDown()) {
                    return TabCloseKind.ALL;
                }
                return TabCloseKind.THIS;
            }

            public String getAreaTooltip(JTabbedPane tabbedPane, int tabIndex) {
                return null;
            }

            public String getCloseButtonTooltip(JTabbedPane tabbedPane,
                    int tabIndex) {
                StringBuffer result = new StringBuffer();
                result.append("<html><body>");
                result.append("Mouse click closes <b>"
                        + tabbedPane.getTitleAt(tabIndex) + "</b> tab");
                result.append("<br><b>Alt</b>-Mouse click closes all tabs but <b>"
                        + tabbedPane.getTitleAt(tabIndex) + "</b> tab");
                result.append("<br><b>Shift</b>-Mouse click closes all tabs");
                result.append("</body></html>");
                return result.toString();
            }
        };
*/
       /* jtp.putClientProperty(SubstanceLookAndFeel.TABBED_PANE_CLOSE_CALLBACK,
                closeCallbackMain);*/
     /*   SubstanceLookAndFeel.registerTabCloseChangeListener(new TabCloseListener() {

            public void tabClosed(JTabbedPane tabbedPane,
                    Component tabComponent) {
                out("Closed tab");
            }

            public void tabClosing(JTabbedPane tabbedPane,
                    Component tabComponent) {
                out("Closing tab");
            }
        });*/
/*
        SubstanceLookAndFeel.registerTabCloseChangeListener(jtp,
                new VetoableTabCloseListener() {

                    public void tabClosed(JTabbedPane tabbedPane,
                            Component tabComponent) {
                        out("Closed tab - specific");
                    }

                    public void tabClosing(JTabbedPane tabbedPane,
                            Component tabComponent) {
                        out("Closing tab - specific");
                    }

                    public boolean vetoTabClosing(JTabbedPane tabbedPane,
                            Component tabComponent) {
                        int userCloseAnswer = JOptionPane.showConfirmDialog(
                                Check.this,
                                "Are you sure you want to close '"
                                + tabbedPane.getTitleAt(tabbedPane.indexOfComponent(tabComponent))
                                + "' tab?", "Confirm dialog",
                                JOptionPane.YES_NO_OPTION);
                        return (userCloseAnswer == JOptionPane.NO_OPTION);
                    }
                });*/
/*
        SubstanceLookAndFeel.registerTabCloseChangeListener(jtp,
                new VetoableMultipleTabCloseListener() {

                    public void tabsClosed(JTabbedPane tabbedPane,
                            Set<Component> tabComponents) {
                        out("Closed " + tabComponents.size()
                                + " tabs - specific");
                    }

                    public void tabsClosing(JTabbedPane tabbedPane,
                            Set<Component> tabComponents) {
                        out("Closing " + tabComponents.size()
                                + " tabs - specific");
                    }

                    public boolean vetoTabsClosing(JTabbedPane tabbedPane,
                            Set<Component> tabComponents) {
                        int userCloseAnswer = JOptionPane.showConfirmDialog(
                                Check.this, "Are you sure you want to close "
                                + tabComponents.size() + " tabs?",
                                "Confirm dialog", JOptionPane.YES_NO_OPTION);
                        return (userCloseAnswer == JOptionPane.NO_OPTION);
                    }
                });
*/
        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                //System.out.println("Size " + getSize());
            }
        });

    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                boolean hasLafSpecified = false;
                try {
                    hasLafSpecified = (System.getProperty("swing.defaultlaf") != null);
                } catch (Throwable t) {
                    // JNLP sandbox
                }

                // LAFAdapter.startWidget();

                try {
                    if (!hasLafSpecified) {
                        out(" CREATING LAF ");
                        long time0 = System.currentTimeMillis();
                        LookAndFeel laf = new SubstanceGeminiLookAndFeel();
                        long time1 = System.currentTimeMillis();
                        out(" LAF CREATED " + (time1 - time0));
                        out(" SETTING LAF ");
                        long time2 = System.currentTimeMillis();
                        UIManager.setLookAndFeel(laf);
                        long time3 = System.currentTimeMillis();
                        out(" LAF SET " + (time3 - time2));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //SubstanceLookAndFeel.setToUseConstantThemesOnDialogs(true);
                UIManager.put(
                        SubstanceLookAndFeel.TABBED_PANE_CLOSE_BUTTONS_PROPERTY,
                        Boolean.TRUE);
                UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS,
                        Boolean.TRUE);
                // try {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);

                long time2 = System.currentTimeMillis();

                // UIManager.put("Button.defaultButtonFollowsFocus",
                // Boolean.TRUE);

                Check c = new Check();
                c.addComponentListener(new ComponentAdapter() {

                    @Override
                    public void componentResized(ComponentEvent e) {
                        super.componentResized(e);
                        ((JFrame) e.getComponent()).getRootPane().repaint();
                    }
                });
                c.setPreferredSize(new Dimension(820, 560));
                c.setMinimumSize(new Dimension(150, 100));
                c.pack();
                Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
                // center the frame in the physical screen
                c.setLocation((d.width - c.getWidth()) / 2, (d.height - c.getHeight()) / 2);

                c.setVisible(true);
                c.setDefaultCloseOperation(System.getProperty("javawebstart.version") != null ? JFrame.EXIT_ON_CLOSE
                        : JFrame.DISPOSE_ON_CLOSE);
                long time3 = System.currentTimeMillis();
                out("App " + (time3 - time2));

                // Thread cpuTracker = new Thread() {
                // @Override
                // public void run() {
                // OperatingSystemMXBean bean = ManagementFactory
                // .getOperatingSystemMXBean();
                // while (true) {
                // System.out.println(bean.getSystemLoadAverage());
                // try {
                // Thread.sleep(5000);
                // } catch (Throwable t) {
                // t.printStackTrace();
                // }
                // }
                // };
                // };
                // cpuTracker.setDaemon(true);
                // cpuTracker.start();
            }
        });
    }

    public static void out(Object obj) {
        try {
            System.out.println(obj);
        } catch (Exception exc) {
            // ignore - is thrown on Mac in WebStart (security access)
        }
    }

    public static Icon getIcon(String iconName) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        URL url = cl.getResource("test/check/icons/" + iconName + ".gif");
        if (url != null) {
            return new ImageIcon(url);
        }
        url = cl.getResource("test/check/icons/" + iconName + ".png");
        if (url != null) {
            return new ImageIcon(url);
        }
        return null;
    }

    public static JToolBar getToolbar(String label, int size, boolean hasStrings) {
        JToolBar toolBar = new JToolBar();

        JButton buttonCut = new JButton(hasStrings ? "cut" : null, getIcon(size
                + "/edit-cut"));
        buttonCut.putClientProperty(
                SubstanceLookAndFeel.BUTTON_NO_MIN_SIZE_PROPERTY, Boolean.TRUE);
        toolBar.add(buttonCut);
        JButton buttonCopy = new JButton(hasStrings ? "copy" : null,
                getIcon(size + "/edit-copy"));
        buttonCopy.putClientProperty(
                SubstanceLookAndFeel.BUTTON_NO_MIN_SIZE_PROPERTY, Boolean.TRUE);
        buttonCopy.setEnabled(false);
        toolBar.add(buttonCopy);
        JButton buttonPaste = new JButton(getIcon(size + "/edit-paste"));
        toolBar.add(buttonPaste);
        JButton buttonSelectAll = new JButton(
                getIcon(size + "/edit-select-all"));
        toolBar.add(buttonSelectAll);
        JButton buttonDelete = new JButton(getIcon(size + "/edit-delete"));
        toolBar.add(buttonDelete);
        toolBar.addSeparator();

        // add an inner toolbar to check the painting of toolbar
        // gradient and drop shadows under different skins.
        JToolBar innerToolbar = new JToolBar(JToolBar.HORIZONTAL);
        innerToolbar.setFloatable(false);
        JToggleButton buttonFormatCenter = new JToggleButton(getIcon(size
                + "/format-justify-center"));
        buttonFormatCenter.putClientProperty(
                SubstanceLookAndFeel.CORNER_RADIUS, Float.valueOf(5.0f));
        innerToolbar.add(buttonFormatCenter);
        JToggleButton buttonFormatLeft = new JToggleButton(getIcon(size
                + "/format-justify-left"));
        innerToolbar.add(buttonFormatLeft);
        JToggleButton buttonFormatRight = new JToggleButton(getIcon(size
                + "/format-justify-right"));
        innerToolbar.add(buttonFormatRight);
        JToggleButton buttonFormatFill = new JToggleButton(getIcon(size
                + "/format-justify-fill"));
        buttonFormatFill.putClientProperty(SubstanceLookAndFeel.CORNER_RADIUS,
                Float.valueOf(0.0f));
        innerToolbar.add(buttonFormatFill);

        toolBar.add(innerToolbar);
        toolBar.addSeparator();

        if (size > 20) {
            JToolBar innerToolbar2 = new JToolBar(JToolBar.HORIZONTAL);
            innerToolbar2.setFloatable(false);

            JPanel innerPanel = new JPanel(
                    new FlowLayout(FlowLayout.LEFT, 0, 0));
            innerToolbar2.add(innerPanel, BorderLayout.CENTER);

            final JToggleButton buttonStyleBold = new JToggleButton(
                    getIcon(size + "/format-text-bold"));
            Set<Side> rightSide = EnumSet.of(Side.RIGHT);
            buttonStyleBold.putClientProperty(
                    SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, rightSide);
            buttonStyleBold.putClientProperty(
                    SubstanceLookAndFeel.CORNER_RADIUS, Float.valueOf(3.0f));

            final JToggleButton buttonStyleItalic = new JToggleButton(
                    getIcon(size + "/format-text-italic"));
            buttonStyleItalic.putClientProperty(
                    SubstanceLookAndFeel.CORNER_RADIUS, Float.valueOf(0.0f));
            buttonStyleItalic.putClientProperty(
                    SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, rightSide);

            final JToggleButton buttonStyleUnderline = new JToggleButton(
                    getIcon(size + "/format-text-underline"));
            buttonStyleUnderline.putClientProperty(
                    SubstanceLookAndFeel.CORNER_RADIUS, Float.valueOf(0.0f));
            buttonStyleUnderline.putClientProperty(
                    SubstanceLookAndFeel.BUTTON_OPEN_SIDE_PROPERTY, rightSide);

            final JToggleButton buttonStyleStrikethrough = new JToggleButton(
                    getIcon(size + "/format-text-strikethrough"));
            buttonStyleStrikethrough.putClientProperty(
                    SubstanceLookAndFeel.BUTTON_SIDE_PROPERTY, EnumSet.of(Side.LEFT));
            buttonStyleStrikethrough.putClientProperty(
                    SubstanceLookAndFeel.CORNER_RADIUS, Float.valueOf(3.0f));
            buttonStyleBold.setSelected(true);

            innerPanel.add(buttonStyleBold);
            innerPanel.add(buttonStyleItalic);
            innerPanel.add(buttonStyleUnderline);
            innerPanel.add(buttonStyleStrikethrough);

            toolBar.add(innerToolbar2);
        }

        toolBar.add(Box.createGlue());
        JButton buttonExit = new JButton(getIcon(size + "/process-stop"));
        buttonExit.setToolTipText("Closes the test application");
        buttonExit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        toolBar.add(buttonExit);

        return toolBar;
    }
/*
    public static class MyMainTabPreviewPainter extends DefaultTabPreviewPainter {

        protected TabOverviewKind tabOverviewKind;

        public void setTabOverviewKind(TabOverviewKind tabOverviewKind) {
            this.tabOverviewKind = tabOverviewKind;
        }

        @Override
        public TabOverviewKind getOverviewKind(JTabbedPane tabPane) {
            if (tabOverviewKind == null) {
                return super.getOverviewKind(tabPane);
            }
            return tabOverviewKind;
        }
    }

    public JTabbedPane getMainTabbedPane() {
        return this.jtp;
    }*/
}
