package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;

public class NativeColorFill extends JPanel {

    //public static void main(String[] s) {
    //setBackground("66ff9933");
    //}
    JComponent _unit = null;
    void setBackground(String color) {
	try {
	    //System.out.println(color.substring(0, 1));
	    int r = (new java.math.BigInteger(color.substring(0, 2), 16)).intValue();
	    //System.out.println(r);
	    int g = (new java.math.BigInteger(color.substring(2, 4), 16)).intValue();
	    //System.out.println(g);
	    int b = (new java.math.BigInteger(color.substring(4, 6), 16)).intValue();
	    //System.out.println(b);
	    int a = 255;
	    if (color.length() > 6) {
		a = (new java.math.BigInteger(color.substring(6, 8), 16)).intValue();
	    }
	    //System.out.println(a);
	    Color c = new Color(r, g, b, a);
	    this.setBackground(c);
	} catch (Throwable t) {
	    t.printStackTrace();
	}
    }
    public NativeColorFill(ColorFill unit, Theme ntheme) {
	this.setLayout(new BorderLayout());
	this.setOpaque(true);
	final Theme theme = ntheme;
	final ColorFill link = unit;
	this.setBackground(link.color().get());
	new BiValue<Widget>(link.body()) {

	    @Override
	    public void onChange(Widget newValue) {
		if (_unit != null) {
		    remove(_unit);
		}
		if (link.body().get() != null) {
		    _unit = theme.createJComponent(link.body().get());
		    add(_unit, BorderLayout.CENTER);
		    validate();
		    //System.out.println("done fill body");
		    //System.out.println("parent is "+getParent());
		}
	    }
	};
	new BiValue<String>(link.color()) {

	    @Override
	    public void onChange(String newValue) {
		setBackground(link.color().get());
	    }
	};
	/*if (this.getParent() != null) {
	System.out.println("parent is "+this.getParent());
	this.getParent().doLayout();
	}*/
	//doLayout();
	//System.out.println("done fill");
    }
}
