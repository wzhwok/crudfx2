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
import javax.swing.*;

public class InfoFrame extends JDialog {

    NativeMainWindow _nativeMainWindow;

    public InfoFrame(String message, NativeMainWindow nativeMainWindow) {
        _nativeMainWindow = nativeMainWindow;
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int w = 200;
        final int h = 100;
        //this.setLocation(-200, 100);
        this.setSize(w, h);

        this.setLocation(screenSize.width - w - 100, screenSize.height);

        this.setLayout(new BorderLayout());
        JLabel ti = new JLabel(nativeMainWindow.getTitle());
        ti.setIcon(new ImageIcon(nativeMainWindow.getIconImage()));
        JLabel ms = new JLabel(message);
        //this.add(ti, BorderLayout.NORTH);
        JPanel mp = new JPanel(new BorderLayout());
        this.add(mp, BorderLayout.CENTER);
        mp.add(ms, BorderLayout.NORTH);
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                _nativeMainWindow.requestFocus();
            }
        });
        this.setUndecorated(true);
        //this.setDefaultLookAndFeelDecorated(false);
        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        this.getRootPane().setBorder(new javax.swing.border.EtchedBorder());

        this.setAlwaysOnTop(true);
        this.setVisible(true);
        final Ticker tkr = new Ticker() {

            @Override
            public void onFinish() {
                //dispose();
                new Ticker() {

                    @Override
                    public void onFinish() {
                        dispose();
                    }
                }.count(1).delay(5000).start();
            }
        }.count(15).delay(50);
        tkr.current().bind(new BiValue<Integer>(0) {

            @Override
            public void onChange(Integer newValue) {
                double v = (double) newValue;
                v = 6.0 * v * ((Math.PI / 90.0) / 2.0);
                double g = Math.sin(v);
                setLocation(screenSize.width - w - 100, screenSize.height - (int) (g * h * 2.0));
            }
        });
        tkr.start();
    }
}
