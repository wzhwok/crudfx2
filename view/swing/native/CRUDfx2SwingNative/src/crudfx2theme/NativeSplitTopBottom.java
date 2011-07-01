package crudfx2theme;

import crudfx2.core.gui.layout.SplitTopBottom;
import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.container.*;
import javax.swing.*;
import java.beans.*;

public class NativeSplitTopBottom extends JSplitPane {

    JComponent _top = null;
    JComponent _bottom = null;
    public NativeSplitTopBottom(SplitTopBottom unit, Theme ntheme) {
	final Theme theme = ntheme;
	final SplitTopBottom link = unit;
	this.setOpaque(false);
	this.setOrientation(JSplitPane.VERTICAL_SPLIT);

	new BiValue<Widget>(link.top()) {

	    @Override
	    public void onChange(Widget newValue) {
		if (_top != null) {
		    remove(_top);
		}
		if (link.top().get() != null) {
		    _top = theme.createJComponent(link.top().get());
		    setTopComponent(_top);
		}
	    }
	};
	new BiValue<Widget>(link.bottom()) {

	    @Override
	    public void onChange(Widget newValue) {
		if (_bottom != null) {
		    remove(_bottom);
		}
		if (link.bottom().get() != null) {
		    _bottom = theme.createJComponent(link.bottom().get());
		    setRightComponent(_bottom);
		}
	    }
	};
	new BiNumber(link.split()) {

	    @Override
	    public void onChange(Double newValue) {
		setDividerLocation(link.split().get().intValue());
	    }
	};
	this.addPropertyChangeListener(new PropertyChangeListener() {

	    public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals(JSplitPane.LAST_DIVIDER_LOCATION_PROPERTY)) {
		    link.split().set(getDividerLocation());
		}
	    }
	});
    }
}
