package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class CrowdLayout implements LayoutManager {

    //int minWidth = 0;
    //int minHeight = 0;
    public void addLayoutComponent(String name, Component comp) {
	//System.out.println("addLayoutComponent: " + name + ": " + comp);
    }
    public void removeLayoutComponent(Component comp) {
	//System.out.println("removeLayoutComponent: " + comp);
    }
    public Dimension preferredLayoutSize(Container parent) {
	//System.out.println("preferredLayoutSize: " + parent);
	return new Dimension(0, 0);
    }
    public Dimension minimumLayoutSize(Container parent) {
	//System.out.println("minimumLayoutSize: " + parent);
	return new Dimension(0, 0);
    }
    public void layoutContainer(Container parent) {
	//System.out.println("layoutContainer: " + parent);
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
    }
}

public class NativeSuiteCrowd extends JPanel {

    private Vector<Widget> items = new Vector<Widget>();
    Vector<JComponent> comps = new Vector<JComponent>();
    public NativeSuiteCrowd(SuiteCrowd unit, Theme ntheme) {
	final NativeSuiteCrowd me = this;
	final Theme theme = ntheme;
	new BiSet<Widget>(unit.suite()) {

	    public void onAdd(Widget item) {
		me.add(theme.createJComponent(item));
	    }
	    public void onDrop(Widget item) {
		System.out.println("ops!");
	    }
	};
	this.setLayout(new CrowdLayout());
	this.setOpaque(false);
    }
}
