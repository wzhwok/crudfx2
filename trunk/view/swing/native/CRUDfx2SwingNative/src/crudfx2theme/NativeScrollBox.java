package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.gui.container.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NativeScrollBox extends JScrollPane {

    JComponent _content = null;
    public NativeScrollBox(ScrollBox unit, Theme ntheme) {
	final Theme theme = ntheme;
	final ScrollBox link = unit;
	this.setOpaque(false);
	this.getViewport().setOpaque(false);
	this.setBorder(null);
	this.getViewport().setBorder(null);
	//this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS );
	//JButton b=new JButton("sdfgsdfb");
	//b.setSize(900,900);
	//b.setPreferredSize(new Dimension(90,90));
	//this.getViewport().setLayout(null);
	//getViewport().add(b);
	final JPanel sub = new JPanel();
	sub.setLayout(new BorderLayout());
	final JPanel subsub = new JPanel();
	subsub.setLayout(new BorderLayout());
	this.getViewport().add(sub);
	sub.add(subsub, BorderLayout.NORTH);
	
	new BiValue<Widget>(link.body()) {

	    @Override
	    public void onChange(Widget newValue) {
		if (_content != null) {
		    subsub.remove(_content);
		}
		if (link.body().get() != null) {
		    _content = theme.createJComponent(link.body().get());
		    subsub.add(_content, BorderLayout.WEST);
		    validate();
		}
		repaint();
		validate();
	    }
	};
	repaint();
	validate();
    }
}
