package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.gui.control.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.event .*;

public class NativeMiniBrowser extends JScrollPane implements HyperlinkListener{

    JEditorPane m_browser;

    public NativeMiniBrowser(MiniBrowser unit, Theme ntheme) {
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setBorder(null);
        this.getViewport().setBorder(null);

        m_browser = new JEditorPane();
        m_browser.setEditable(false);
        m_browser.addHyperlinkListener(this);
        //m_locator.addActionListener(lst);
        getViewport().add(m_browser);
        try {
            URL source = new URL("http://javafx.me");
            m_browser.setPage(source);
        } catch (Throwable t) {
        }
    }

    public void hyperlinkUpdate(HyperlinkEvent e) {
        System.out.println(e.getEventType()+": "+
                e.getURL());
    }
}
