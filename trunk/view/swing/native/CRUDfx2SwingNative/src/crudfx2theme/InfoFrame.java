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

public class InfoFrame extends JFrame {

    public InfoFrame(String message, NativeMainWindow nativeMainWindow) {
        this.setLocation(10, 100);
        this.setSize(200,300);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        JLabel ti=new JLabel(nativeMainWindow.getTitle());        
        JLabel ms=new JLabel(message);
        this.add(ti,BorderLayout.NORTH);
        JPanel mp=new JPanel(new BorderLayout());
        this.add(mp,BorderLayout.CENTER);
        mp.add(ms,BorderLayout.NORTH);
    }
}
