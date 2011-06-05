package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class CenterLayout implements LayoutManager {

    public CenterLayout() {
    }
    private Dimension layoutSize(Container parent, boolean minimum) {
	Dimension dim = new Dimension(0, 0);
	Dimension d;
	synchronized (parent.getTreeLock()) {
	    int n = parent.getComponentCount();
	    for (int i = 0; i < n; i++) {
		Component c = parent.getComponent(i);
		if (c.isVisible()) {
		    d = minimum ? c.getMinimumSize() : c.getPreferredSize();
		    dim.width = Math.max(dim.width, d.width);
		    dim.height = dim.height + d.height;
		}
	    }
	}
	Insets insets = parent.getInsets();
	dim.width = dim.width + insets.left + insets.right;
	dim.height = dim.height + insets.top + insets.bottom;
	return dim;
    }
    public void layoutContainer(Container parent) {
	Insets insets = parent.getInsets();
	synchronized (parent.getTreeLock()) {
	    int n = parent.getComponentCount();
	    Dimension pd = parent.getSize();
	    int y = 0;
	    for (int i = 0; i < n; i++) {
		Component c = parent.getComponent(i);
		Dimension d = c.getPreferredSize();
		y = y + d.height;
	    }
	    y = (pd.height - y) / 2;
	    for (int i = 0; i < n; i++) {
		Component c = parent.getComponent(i);
		Dimension d = c.getPreferredSize();
		int x = insets.left;
		int wid = d.width;
		x = (pd.width - d.width) / 2;
		c.setBounds(x, y, wid, d.height);
		y = y + d.height;
	    }
	}
    }
    public Dimension minimumLayoutSize(Container parent) {
	return layoutSize(parent, false);
    }
    public Dimension preferredLayoutSize(Container parent) {
	return layoutSize(parent, false);
    }
    public void addLayoutComponent(String name, Component comp) {
    }
    public void removeLayoutComponent(Component comp) {
    }
}

public class NativeCenter extends JPanel {

    JComponent _unit = null;
    public NativeCenter(Center unit, Theme ntheme) {
	this.setLayout(new CenterLayout());
	final Theme theme = ntheme;
	final Center link = unit;
	this.setOpaque(false);
	new BiValue<Widget>(unit.body()) {

	    @Override
	    public void onChange(Widget newValue) {
		if (_unit != null) {
		    remove(_unit);
		}
		if (link.body().get() != null) {
		    _unit = theme.createJComponent(link.body().get());
		    add(_unit, BorderLayout.WEST);
		    validate();
		}
		repaint();
		validate();
	    }
	};
    }
}
