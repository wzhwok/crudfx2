package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
class CrowdLayout implements LayoutManager {

    Dimension calculatedSize = new Dimension(100, 100);
    //int minWidth = 0;
    //int minHeight = 0;
    public void addLayoutComponent(String name, Component comp) {
	System.out.println("addLayoutComponent: " + name + ": " + comp);
    }
    public void removeLayoutComponent(Component comp) {
	System.out.println("removeLayoutComponent: " + comp);
    }
    public Dimension preferredLayoutSize(Container parent) {
	System.out.println("preferredLayoutSize: " + parent);
	/*Dimension d = new Dimension(100, 100);
	if (parent.getParent() != null) {
	//System.out.println(parent.getParent());
	d = parent.getParent().getSize();
	if (parent.getParent().getParent() != null) {
	//System.out.println(parent.getParent().getParent());
	d = parent.getParent().getParent().getSize();
	}
	}*/
	//System.out.println( parent.getSize());

	/*System.out.println(parent.getParent().getParent().getSize());
	
	int count = parent.getComponentCount();
	int w = 0;
	int h = 0;
	for (int i = 0; i < count; i++) {
	Component currentComponent = parent.getComponent(i);
	if (currentComponent.getLocation().x + currentComponent.getSize().width > w) {
	w = currentComponent.getLocation().x + currentComponent.getSize().width;
	}
	if (currentComponent.getLocation().y + currentComponent.getSize().height > h) {
	h = currentComponent.getLocation().y + currentComponent.getSize().height;
	}
	}*/
	//System.out.println(d);
	return calculatedSize;
    }
    public Dimension minimumLayoutSize(Container parent) {
	System.out.println("minimumLayoutSize: " + parent);
	return calculatedSize;
    }
    public void layoutContainer(Container parent) {
	System.out.println("layoutContainer: " + parent);
	int count = parent.getComponentCount();
	int w = parent.getSize().width;
	int h = parent.getSize().height;
	//System.out.println(w+"x"+h);
	int currentX = 0;
	int currentY = 0;
	int maxY = 0;
	//minWidth = 0;
	//minHeight = 0;
	for (int i = 0; i < count; i++) {
	    Component currentComponent = parent.getComponent(i);
	    currentComponent.setSize(currentComponent.getPreferredSize());
	    if ((currentX + currentComponent.getSize().width > w) && (currentX > 0)) {
		currentX = 0;
		currentY = maxY;
	    }
	    currentComponent.setLocation(currentX, currentY);
	    //if (currentX + currentComponent.getSize().width > minWidth) {
	    //minWidth = currentX + currentComponent.getSize().width;
	    //}
	    currentX = currentX + currentComponent.getSize().width;
	    if (currentY + currentComponent.getSize().height > maxY) {
		maxY = currentY + currentComponent.getSize().height;
	    }

	    //System.out.println(": "+parent.getComponent(i).getPreferredSize());
	    //System.out.println(": "+parent.getComponent(i).getSize());
	    //System.out.println(": "+parent.getComponent(i).getLocation());
	}
	w = 0;
	h = 0;
	for (int i = 0; i < count; i++) {
	    Component currentComponent = parent.getComponent(i);
	    if (currentComponent.getLocation().x + currentComponent.getSize().width > w) {
		w = currentComponent.getLocation().x + currentComponent.getSize().width;
	    }
	    if (currentComponent.getLocation().y + currentComponent.getSize().height > h) {
		h = currentComponent.getLocation().y + currentComponent.getSize().height;
	    }
	}
	calculatedSize = new Dimension(w, h);
    }
}

public class NativeSuiteCrowd extends JScrollPane {

    private Vector<Widget> items = new Vector<Widget>();
    Vector<JComponent> comps = new Vector<JComponent>();
    public NativeSuiteCrowd(SuiteCrowd unit, Theme ntheme) {
	final NativeSuiteCrowd me = this;
	final Theme theme = ntheme;
	final JPanel panel=new JPanel();
	this.getViewport().add(panel);
	new BiSet<Widget>(unit.suite()) {

	    public void onAdd(Widget item) {
		panel.add(theme.createJComponent(item));
	    }
	    public void onDrop(Widget item) {
		System.out.println("ops!");
	    }
	};
	this.setOpaque(false);
	this.getViewport().setOpaque(false);
	this.setBorder(null);
	this.getViewport().setBorder(null);
	panel.setLayout(new CrowdLayout());
	this.setOpaque(false);
	this.addComponentListener(new ComponentAdapter() {

	    public void componentResized(ComponentEvent e) {
		/*System.out.println(e);
		System.out.println(panel.getSize());
		System.out.println(me.getSize());
		panel.setPreferredSize(panel.getSize());*/
		/*doLayout();
		sub.doLayout();
		subsub.doLayout();*/
	    }
	});
    }
}
