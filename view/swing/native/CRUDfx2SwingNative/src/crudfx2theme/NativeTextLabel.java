package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
//import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import crudfx2theme.nuvola.*;

public class NativeTextLabel extends JLabel {

    StandardLabel _unit;
     Theme theme;
    public NativeTextLabel(StandardLabel unit, Theme ntheme) {
	super();
        theme = ntheme;
	_unit = unit;
	this.setVerticalTextPosition(JLabel.BOTTOM);
	this.setHorizontalTextPosition(JLabel.CENTER);
	new BiValue<String>(_unit.title()) {

	    @Override
	    public void onChange(String newValue) {
		setText(_unit.title().get());
	    }
	};
	new BiValue<String>(_unit.icon()) {

	    @Override
	    public void onChange(String newValue) {
		setIcon(theme.icon(_unit.icon().get()));
	    }
	};
    }
}
