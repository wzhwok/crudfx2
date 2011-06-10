package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

class ConstraintLayout implements LayoutManager2 {

    protected final static int PREFERRED = 0;
    protected final static int MINIMUM = 1;
    protected final static int MAXIMUM = 2;
    protected int hMargin = 0;
    protected int vMargin = 0;
    private Hashtable constraints;
    protected boolean includeInvisible = false;
    public void addLayoutComponent(String constraint, Component c) {
	setConstraint(c, constraint);
    }
    public void addLayoutComponent(Component c, Object constraint) {
	setConstraint(c, constraint);
    }
    public void removeLayoutComponent(Component c) {
	if (constraints != null) {
	    constraints.remove(c);
	}
    }
    public void setConstraint(Component c, Object constraint) {
	if (constraint != null) {
	    if (constraints == null) {
		constraints = new Hashtable();
	    }
	    constraints.put(c, constraint);
	} else if (constraints != null) {
	    constraints.remove(c);
	}
    }
    public Object getConstraint(Component c) {
	if (constraints != null) {
	    return constraints.get(c);
	}
	return null;
    }
    public void setIncludeInvisible(boolean includeInvisible) {
	this.includeInvisible = includeInvisible;
    }
    public boolean getIncludeInvisible() {
	return includeInvisible;
    }
    protected boolean includeComponent(Component c) {
	return includeInvisible || c.isVisible();
    }
    public Dimension minimumLayoutSize(Container target) {
	return calcLayoutSize(target, MINIMUM);
    }
    public Dimension maximumLayoutSize(Container target) {
	return calcLayoutSize(target, MAXIMUM);
    }
    public Dimension preferredLayoutSize(Container target) {
	return calcLayoutSize(target, PREFERRED);
    }
    public Dimension calcLayoutSize(Container target, int type) {
	Dimension dim = new Dimension(0, 0);
	measureLayout(target, dim, type);
	Insets insets = target.getInsets();
	dim.width += insets.left + insets.right + 2 * hMargin;
	dim.height += insets.top + insets.bottom + 2 * vMargin;
	return dim;
    }
    public void invalidateLayout(Container target) {
    }
    public float getLayoutAlignmentX(Container parent) {
	return 0.5f;
    }
    public float getLayoutAlignmentY(Container parent) {
	return 0.5f;
    }
    public void layoutContainer(Container target) {
	measureLayout(target, null, PREFERRED);
    }
    public void measureLayout(Container target, Dimension dimension, int type) {
    }
    protected Dimension getComponentSize(Component c, int type) {
	if (type == MINIMUM) {
	    return c.getMinimumSize();
	}
	if (type == MAXIMUM) {
	    return c.getMaximumSize();
	}
	return c.getPreferredSize();
    }
}

class ParagraphLayout extends ConstraintLayout {

    public final static int TYPE_MASK = 0x03;
    public final static int STRETCH_H_MASK = 0x04;
    public final static int STRETCH_V_MASK = 0x08;
    public final static int NEW_PARAGRAPH_VALUE = 1;
    public final static int NEW_PARAGRAPH_TOP_VALUE = 2;
    public final static int NEW_LINE_VALUE = 3;
    public final static Integer NEW_PARAGRAPH = new Integer(0x01);
    public final static Integer NEW_PARAGRAPH_TOP = new Integer(0x02);
    public final static Integer NEW_LINE = new Integer(0x03);
    public final static Integer STRETCH_H = new Integer(0x04);
    public final static Integer STRETCH_V = new Integer(0x08);
    public final static Integer STRETCH_HV = new Integer(0x0c);
    public final static Integer NEW_LINE_STRETCH_H = new Integer(0x07);
    public final static Integer NEW_LINE_STRETCH_V = new Integer(0x0b);
    public final static Integer NEW_LINE_STRETCH_HV = new Integer(0x0f);
    //protected int hGapMajor, vGapMajor;
    //protected int hGapMinor, vGapMinor;
    protected int rows;
    protected int colWidth1;
    protected int colWidth2;
    public ParagraphLayout() {
	//this(10, 10, 12, 11, 4, 4);
	this(0, 0, 0, 0, 0, 0);
    }
    public ParagraphLayout(int hMargin, int vMargin, int hGapMajor, int vGapMajor, int hGapMinor, int vGapMinor) {
	this.hMargin = hMargin;
	this.vMargin = vMargin;
	/*this.hGapMajor = hGapMajor;
	this.vGapMajor = vGapMajor;
	this.hGapMinor = hGapMinor;
	this.vGapMinor = vGapMinor;*/
    }
    public void measureLayout(Container target, Dimension dimension, int type) {
	int count = target.getComponentCount();
	if (count > 0) {
	    Insets insets = target.getInsets();
	    Dimension size = target.getSize();
	    int x = 0;
	    int y = 0;
	    int rowHeight = 0;
	    int colWidth = 0;
	    int numRows = 0;
	    boolean lastWasParagraph = false;

	    Dimension[] sizes = new Dimension[count];

	    colWidth1 = colWidth2 = 0;

	    // First pass: work out the column widths and row heights
	    for (int i = 0; i < count; i++) {
		Component c = target.getComponent(i);
		if (includeComponent(c)) {
		    Dimension d = getComponentSize(c, type);
		    int w = d.width;
		    int h = d.height;
		    sizes[i] = d;
		    Integer n = (Integer) getConstraint(c);

		    if (i == 0 || n == NEW_PARAGRAPH || n == NEW_PARAGRAPH_TOP) {
			if (i != 0) {
			    y += rowHeight;
			}
			colWidth1 = Math.max(colWidth1, w);
			colWidth = 0;
			rowHeight = 0;
			lastWasParagraph = true;
		    } else if (n == NEW_LINE || lastWasParagraph) {
			x = 0;
			if (!lastWasParagraph && i != 0) {
			    y += rowHeight;
			}
			colWidth = w;
			colWidth2 = Math.max(colWidth2, colWidth);
			if (!lastWasParagraph) {
			    rowHeight = 0;
			}
			lastWasParagraph = false;
		    } else {
			colWidth += w;
			colWidth2 = Math.max(colWidth2, colWidth);
			lastWasParagraph = false;
		    }
		    rowHeight = Math.max(h, rowHeight);
		}
	    }

	    // Second pass: actually lay out the components
	    if (dimension != null) {
		dimension.width = colWidth1 + colWidth2;
		dimension.height = y + rowHeight;
	    } else {
		int spareHeight = size.height - (y + rowHeight) - insets.top - insets.bottom - 2 * vMargin;
		x = 0;
		y = 0;
		lastWasParagraph = false;
		int start = 0;
		int rowWidth = 0;
		Integer paragraphType = NEW_PARAGRAPH;
		boolean stretchV = false;

		boolean firstLine = true;
		for (int i = 0; i < count; i++) {
		    Component c = target.getComponent(i);
		    if (includeComponent(c)) {
			Dimension d = sizes[i];
			int w = d.width;
			int h = d.height;
			Integer n = (Integer) getConstraint(c);
			int nv = n != null ? n.intValue() : 0;

			if (i == 0 || n == NEW_PARAGRAPH || n == NEW_PARAGRAPH_TOP) {
			    if (i != 0) {
				layoutRow(target, sizes, start, i - 1, y, rowWidth, rowHeight, firstLine, type, paragraphType);
			    }
			    stretchV = false;
			    paragraphType = n;
			    start = i;
			    firstLine = true;
			    if (i != 0) {
				y += rowHeight;
			    }
			    rowHeight = 0;
			    rowWidth = colWidth1;
			    lastWasParagraph = true;
			} else if (n == NEW_LINE || lastWasParagraph) {
			    if (!lastWasParagraph) {
				layoutRow(target, sizes, start, count - 1, y, rowWidth, rowHeight, firstLine, type, paragraphType);
				stretchV = false;
				start = i;
				firstLine = false;
				y += rowHeight;
				rowHeight = 0;
			    }
			    rowWidth += sizes[i].width;
			    lastWasParagraph = false;
			} else {
			    rowWidth += sizes[i].width;
			    lastWasParagraph = false;
			}
			if ((nv & STRETCH_V_MASK) != 0 && !stretchV) {
			    stretchV = true;
			    h += spareHeight;
			}
			rowHeight = Math.max(h, rowHeight);
		    }
		}
		layoutRow(target, sizes, start, count - 1, y, rowWidth, rowHeight, firstLine, type, paragraphType);
	    }
	}

    }
    protected void layoutRow(Container target, Dimension[] sizes, int start, int end, int y, int rowWidth, int rowHeight, boolean paragraph, int type, Integer paragraphType) {
	int x = 0;
	Insets insets = target.getInsets();
	Dimension size = target.getSize();
	int spareWidth = size.width - rowWidth - insets.left - insets.right - 2 * hMargin;

	for (int i = start; i <= end; i++) {
	    Component c = target.getComponent(i);
	    if (includeComponent(c)) {
		Integer n = (Integer) getConstraint(c);
		int nv = n != null ? n.intValue() : 0;
		Dimension d = sizes[i];
		int w = d.width;
		int h = d.height;

		if ((nv & STRETCH_H_MASK) != 0) {
		    w += spareWidth;
		    Dimension max = getComponentSize(c, MAXIMUM);
		    Dimension min = getComponentSize(c, MINIMUM);
		    w = Math.max(min.width, Math.min(max.width, w));
		}
		if ((nv & STRETCH_V_MASK) != 0) {
		    h = rowHeight;
		    Dimension max = getComponentSize(c, MAXIMUM);
		    Dimension min = getComponentSize(c, MINIMUM);
		    h = Math.max(min.height, Math.min(max.height, h));
		}

		if (i == start) {
		    if (paragraph) {
			x = colWidth1 - w;
		    } else {
			x = colWidth1;
		    }
		} else if (paragraph && i == start + 1) {
		    x = colWidth1;
		}
		int yOffset = paragraphType == NEW_PARAGRAPH_TOP ? 0 : (rowHeight - h) / 2;
		if (target.getComponentOrientation().isLeftToRight()) {
		    c.setBounds(insets.left + hMargin + x, insets.top + vMargin + y + yOffset, w, h);
		} else {
		    c.setBounds(size.width - insets.right - insets.left - hMargin - x - w, insets.top + vMargin + y + yOffset, w, h);
		}
		x += w;
	    }
	}
    }
}

class CrowdLayout implements LayoutManager {

    public void addLayoutComponent(String name, Component comp) {
	System.out.println("addLayoutComponent: " + name + ": " + comp);
    }
    public void removeLayoutComponent(Component comp) {
	System.out.println("removeLayoutComponent: " + comp);
    }
    public Dimension preferredLayoutSize(Container parent) {
	System.out.println("preferredLayoutSize: " + parent);
	return new Dimension(100, 100);
    }
    public Dimension minimumLayoutSize(Container parent) {
	System.out.println("minimumLayoutSize: " + parent);
	return new Dimension(100, 100);
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
	for (int i = 0; i < count; i++) {
	    Component currentComponent = parent.getComponent(i);
	    currentComponent.setSize(currentComponent.getPreferredSize());
	    if ((currentX + currentComponent.getSize().width > w) && (currentX > 0)) {
		currentX = 0;
		currentY = maxY;
	    }
	    currentComponent.setLocation(currentX, currentY);
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
    public NativeSuiteCrowd(SuiteCrowd unit, Theme ntheme) {
	final NativeSuiteCrowd me = this;
	new BiSet<Widget>(unit.suite()) {
	};
	//this.setLayout(new FlowLayout(FlowLayout.LEFT));
	this.setLayout(new CrowdLayout());
	this.setOpaque(false);
	//this.setPreferredSize(new Dimension(500,300));
	//this.setSize(new Dimension(500,300));

	this.add(new JButton("test 1 button"));
	this.add(new JButton("<html>test 2 button<br/>end</html>"));
	//add(Box.createHorizontalStrut(20000));
	//this.add(Box.createHorizontalGlue());

	this.add(new JButton("test 3 button"));
	this.add(new JButton("test 4 button"), ParagraphLayout.NEW_PARAGRAPH);
	this.add(new JButton("test 5 button with long line"));
	//add(Box.createHorizontalStrut(20000));
	this.add(new JButton("test 6 button"), ParagraphLayout.NEW_PARAGRAPH);
	this.add(new JButton("test 7 button"));
    }
}
