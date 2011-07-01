package crudfx2theme;

import crudfx2.core.gui.layout.Indent;
import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class NativeIndent extends JPanel {

    JComponent _unit = null;
    public NativeIndent(Indent unit, Theme ntheme) {
	this.setLayout(new BorderLayout());
	final Theme theme = ntheme;
	final Indent link = unit;
	this.setOpaque(false);
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
		}
	    }
	};

	new BiNumber(link.left()) {

	    @Override
	    public void onChange(Double newValue) {
		setBorder(new EmptyBorder(link.top().get().intValue(), link.left().get().intValue(), link.bottom().get().intValue(), link.right().get().intValue()));
	    }
	};
	new BiNumber(link.top()) {

	    @Override
	    public void onChange(Double newValue) {
		setBorder(new EmptyBorder(link.top().get().intValue(), link.left().get().intValue(), link.bottom().get().intValue(), link.right().get().intValue()));
	    }
	};
	new BiNumber(link.bottom()) {

	    @Override
	    public void onChange(Double newValue) {
		setBorder(new EmptyBorder(link.top().get().intValue(), link.left().get().intValue(), link.bottom().get().intValue(), link.right().get().intValue()));
	    }
	};
	new BiNumber(link.right()) {

	    @Override
	    public void onChange(Double newValue) {
		setBorder(new EmptyBorder(link.top().get().intValue(), link.left().get().intValue(), link.bottom().get().intValue(), link.right().get().intValue()));
	    }
	};

	validate();
    }
}
