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
import javax.swing.event.*;
import javax.swing.text.html.*;

public class NativeMiniBrowser extends JScrollPane implements HyperlinkListener {
    
    JEditorPane browser = new JEditorPane();
    HTMLEditorKit kit = new HTMLEditorKit();
    MiniBrowser _unit;
    public NativeMiniBrowser(MiniBrowser unit, Theme ntheme) {
	this.setOpaque(false);
	this.getViewport().setOpaque(false);
	this.setBorder(null);
	this.getViewport().setBorder(null);
	_unit = unit;
	//m_browser = new JEditorPane();
	browser.setEditorKit(kit);
	browser.setEditable(false);
	browser.addHyperlinkListener(this);
	//m_locator.addActionListener(lst);
	getViewport().add(browser);
	//try {
	//URL source = new URL("http://javafx.me");
	//m_browser.setPage(source);
	//browser.setText("<h1>123</h1><p>test page</p><hr/><pre>blablabla\n\tbububu</pre><p><a href='http://ya.ru'>test link</a></p><p>1</p><p>2</p><p>3</p><p>4</p><p>5</p><p>6</p><p>7</p>");
	//} catch (Throwable t) {
	//}
	new BiValue<String>(_unit.html()) {

	    @Override
	    public void onChange(String newValue) {
		browser.setText(_unit.html().get());
	    }
	};
    }
    public void hyperlinkUpdate(HyperlinkEvent e) {
	//System.out.println(e.getEventType()+": "+                e.getURL());
	if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	    _unit.onLink("" + e.getURL());
	}
    }
}
