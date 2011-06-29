package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class NativeSection extends JPanel {

    JComponent _unit = null;
    static Image hidden = new ImageIcon(NativeTree.class.getResource("hidden.png")).getImage();
    static Image shown = new ImageIcon(NativeTree.class.getResource("shown.png")).getImage();
    //static Color  bg=new Color(255,0,0,125);
    public NativeSection(Section unit, Theme ntheme) {
	this.setLayout(new BorderLayout());
	final Theme theme = ntheme;
	final Section link = unit;
	this.setOpaque(false);
	EtchedBorder etchedBorder = new EtchedBorder();
	final TitledBorder titledBorder = new TitledBorder(etchedBorder, "") {

	    boolean _computeIntersection(Rectangle dest, int rx, int ry, int rw, int rh) {
		int x1 = Math.max(rx, dest.x);
		int x2 = Math.min(rx + rw, dest.x + dest.width);
		int y1 = Math.max(ry, dest.y);
		int y2 = Math.min(ry + rh, dest.y + dest.height);
		dest.x = x1;
		dest.y = y1;
		dest.width = x2 - x1;
		dest.height = y2 - y1;
		if (dest.width <= 0 || dest.height <= 0) {
		    return false;
		}
		return true;
	    }
	    boolean _isLeftToRight(Component c) {
		return c.getComponentOrientation().isLeftToRight();
	    }
	    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		Border border = getBorder();
		if (getTitle() == null || getTitle().equals("")) {
		    if (border != null) {
			border.paintBorder(c, g, x, y, width, height);
		    }
		    return;
		}
		Rectangle grooveRect = new Rectangle(x + EDGE_SPACING, y + EDGE_SPACING, width - (EDGE_SPACING * 2), height - (EDGE_SPACING * 2));
		Font font = g.getFont();
		Color color = g.getColor();
		g.setFont(getFont(c));
		//JComponent jc = (c instanceof JComponent) ? (JComponent) c : null;
		//FontMetrics fm = SwingUtilities2.getFontMetrics(jc, g);
		FontMetrics fm = g.getFontMetrics();
		int fontHeight = fm.getHeight();
		int descent = fm.getDescent();
		int ascent = fm.getAscent();
		int diff;
		//int stringWidth = SwingUtilities2.stringWidth(jc, fm,			getTitle());
		int stringWidth = fm.stringWidth(getTitle()) + 16;
		Insets insets;
		if (border != null) {
		    insets = border.getBorderInsets(c);
		} else {
		    insets = new Insets(0, 0, 0, 0);
		}
		int titlePos = getTitlePosition();
		Point _textLoc = new Point();
		switch (titlePos) {
		    case ABOVE_TOP:
			diff = ascent + descent + (Math.max(EDGE_SPACING, TEXT_SPACING * 2) - EDGE_SPACING);
			grooveRect.y += diff;
			grooveRect.height -= diff;
			_textLoc.y = grooveRect.y - (descent + TEXT_SPACING);
			break;
		    case TOP:
		    case DEFAULT_POSITION:
			diff = Math.max(0, ((ascent / 2) + TEXT_SPACING) - EDGE_SPACING);
			grooveRect.y = grooveRect.y + diff;
			grooveRect.height = grooveRect.height - diff;
			_textLoc.y = (grooveRect.y - descent) + (insets.top + ascent + descent) / 2;
			break;
		    case BELOW_TOP:
			_textLoc.y = grooveRect.y + insets.top + ascent + TEXT_SPACING;
			break;
		    case ABOVE_BOTTOM:
			_textLoc.y = (grooveRect.y + grooveRect.height) - (insets.bottom + descent + TEXT_SPACING);
			break;
		    case BOTTOM:
			grooveRect.height -= fontHeight / 2;
			_textLoc.y = ((grooveRect.y + grooveRect.height) - descent) + ((ascent + descent) - insets.bottom) / 2;
			break;
		    case BELOW_BOTTOM:
			grooveRect.height -= fontHeight;
			_textLoc.y = grooveRect.y + grooveRect.height + ascent + TEXT_SPACING;
			break;
		}
		int justification = getTitleJustification();
		if (_isLeftToRight(c)) {
		    if (justification == LEADING || justification == DEFAULT_JUSTIFICATION) {
			justification = LEFT;
		    } else {
			if (justification == TRAILING) {
			    justification = RIGHT;
			}
		    }
		} else {
		    if (justification == LEADING || justification == DEFAULT_JUSTIFICATION) {
			justification = RIGHT;
		    } else {
			if (justification == TRAILING) {
			    justification = LEFT;
			}
		    }
		}
		switch (justification) {
		    case LEFT:
			_textLoc.x = grooveRect.x + TEXT_INSET_H + insets.left;
			break;
		    case RIGHT:
			_textLoc.x = (grooveRect.x + grooveRect.width) - (stringWidth + TEXT_INSET_H + insets.right);
			break;
		    case CENTER:
			_textLoc.x = grooveRect.x + ((grooveRect.width - stringWidth) / 2);
			break;
		}
		// If title is positioned in middle of border AND its fontsize
		// is greater than the border's thickness, we'll need to paint 
		// the border in sections to leave space for the component's background 
		// to show through the title.
		//
		if (border != null) {
		    if (((titlePos == TOP || titlePos == DEFAULT_POSITION) && (grooveRect.y > _textLoc.y - ascent)) || (titlePos == BOTTOM && (grooveRect.y + grooveRect.height < _textLoc.y + descent))) {
			Rectangle clipRect = new Rectangle();
			// save original clip
			Rectangle saveClip = g.getClipBounds();
			// paint strip left of text
			clipRect.setBounds(saveClip);
			if (_computeIntersection(clipRect, x, y, _textLoc.x - 1 - x, height)) {
			    g.setClip(clipRect);
			    border.paintBorder(c, g, grooveRect.x, grooveRect.y, grooveRect.width, grooveRect.height);
			}
			// paint strip right of text
			clipRect.setBounds(saveClip);
			if (_computeIntersection(clipRect, _textLoc.x + stringWidth + 1, y, x + width - (_textLoc.x + stringWidth + 1), height)) {
			    g.setClip(clipRect);
			    border.paintBorder(c, g, grooveRect.x, grooveRect.y, grooveRect.width, grooveRect.height);
			}
			if (titlePos == TOP || titlePos == DEFAULT_POSITION) {
			    // paint strip below text
			    clipRect.setBounds(saveClip);
			    if (_computeIntersection(clipRect, _textLoc.x - 1, _textLoc.y + descent, stringWidth + 2, y + height - _textLoc.y - descent)) {
				g.setClip(clipRect);
				border.paintBorder(c, g, grooveRect.x, grooveRect.y, grooveRect.width, grooveRect.height);
			    }
			} else { // titlePos == BOTTOM
			    // paint strip above text
			    clipRect.setBounds(saveClip);
			    if (_computeIntersection(clipRect, _textLoc.x - 1, y, stringWidth + 2, _textLoc.y - ascent - y)) {
				g.setClip(clipRect);
				border.paintBorder(c, g, grooveRect.x, grooveRect.y, grooveRect.width, grooveRect.height);
			    }
			}
			// restore clip
			g.setClip(saveClip);
		    } else {
			border.paintBorder(c, g, grooveRect.x, grooveRect.y, grooveRect.width, grooveRect.height);
		    }
		}
		g.setColor(getTitleColor());
		//SwingUtilities2.drawString(jc, g, getTitle(), _textLoc.x, _textLoc.y);

		g.drawString(getTitle(), _textLoc.x + 16, _textLoc.y);
		if (link.fold().get()) {
		    g.drawImage(hidden, _textLoc.x + 2, _textLoc.y - 8, null);
		} else {
		    g.drawImage(shown, _textLoc.x + 2, _textLoc.y - 8, null);
		}
		g.setFont(font);
		g.setColor(color);
	    }
	};//link.title().get());
	this.setBorder(titledBorder);
	/*tgl.addActionListener(new ActionListener() {
	
	public void actionPerformed(ActionEvent e) {
	boolean selected = tgl.getModel().isSelected();
	link.fold().set(selected);
	}
	});*/
	new BiValue<Widget>(link.body()) {

	    @Override
	    public void onChange(Widget newValue) {
		if (_unit != null) {
		    remove(_unit);
		}
		if (link.body().get() != null) {
		    _unit = theme.createJComponent(link.body().get());

		    //System.out.println(link.hide().get());
		    //System.out.println("////////////////////////");
		    //_unit.setVisible(!link.hide().get());
		    add(_unit, BorderLayout.CENTER);
		    if (link.fold().get() == null) {
			link.fold().set(false);
		    }
		}
	    }
	};
	new BiValue<Boolean>(link.fold()) {

	    @Override
	    public void onChange(Boolean newValue) {
		if (_unit != null) {
		    _unit.setVisible(!link.fold().get());
		    //tgl.setSelected(link.fold().get());
		}
	    }
	};
	new BiValue<String>(link.title()) {

	    @Override
	    public void onChange(String newValue) {
		//tgl.setText(link.title().get());
		titledBorder.setTitle(newValue);
	    }
	};
	//this.repaint();
	//this.doLayout();
	//this.invalidate();
	this.addMouseListener(new MouseAdapter() {

	    @Override
	    public void mouseClicked(MouseEvent e) {
		if (e.getPoint().y < 12) {
		    if (link.title().get() != null) {
			if (link.title().get().length() > 0) {
			    link.fold().set(!link.fold().get());
			    doLayout();
			    invalidate();
			    repaint();
			}
		    }
		}
		//System.out.println(e.getPoint());
	    }
	    public void mouseEntered(MouseEvent e) {
		if (e.getPoint().y < 12) {
		    if (link.title().get() != null) {
			if (link.title().get().length() > 0) {
			    setCursor(Theme.handCursor);
			    return;
			}
		    }
		}
		setCursor(Cursor.getDefaultCursor());
	    }
	    public void mouseMoved(MouseEvent e) {
		if (e.getPoint().y < 12) {
		    if (link.title().get() != null) {
			if (link.title().get().length() > 0) {
			    setCursor(Theme.handCursor);
			    return;
			}
		    }
		}
		setCursor(Cursor.getDefaultCursor());
	    }
	    public void mouseExited(MouseEvent e) {
		setCursor(Cursor.getDefaultCursor());
	    }
	});

    }
}
