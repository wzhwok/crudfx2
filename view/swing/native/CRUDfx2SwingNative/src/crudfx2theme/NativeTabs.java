package crudfx2theme;

import crudfx2.core.bind.*;
import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

class TabPanel extends JPanel {

    JComponent _unit = null;
    public TabPage link;
    Theme theme;
    //JPanel content=new JPanel();
    public TabPanel(TabPage page, Theme ntheme) {
	link = page;
	theme = ntheme;
	this.setOpaque(false);
	this.setLayout(new BorderLayout());
	new BiValue<Widget>(link.body()) {

	    @Override
	    public void onChange(Widget newValue) {
		//System.out.println(newValue);
		if (_unit != null) {
		    remove(_unit);
		}
		if (link.body().get() != null) {
		    _unit = theme.createJComponent(link.body().get());
		    add(_unit, BorderLayout.CENTER);
		    validate();
		}
		repaint();
		validate();
	    }
	};
    }
}

class TabHeader extends JPanel {

    public JButton button = new JButton("");
    public JLabel label = new JLabel("label");
    public TabHeader(Theme ntheme, Icon closeIcon) {
	label.setOpaque(false);
	button.setPreferredSize(new Dimension(16, 8));
	button.setToolTipText("close this tab");
	button.setIcon(closeIcon);
	button.setContentAreaFilled(false);
	button.setFocusable(false);
	button.setBorder(BorderFactory.createEtchedBorder());
	button.setBorderPainted(false);
	button.setCursor(Theme.handCursor);
	this.setOpaque(false);
	this.setLayout(new BorderLayout());
	this.add(button, BorderLayout.EAST);
	this.add(label, BorderLayout.CENTER);
	button.addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		closeClicked();
	    }
	});

    }
    public void closeClicked() {
    }
}

public class NativeTabs extends JTabbedPane {

    Icon closeIcon;
    Tabs link;
    Theme theme;
    public NativeTabs(Tabs unit, Theme ntheme) {
	theme = ntheme;
	link = unit;
	this.setOpaque(false);
	closeIcon = new ImageIcon(this.getClass().getResource("close8.png"));
	//System.out.println();
	
//ChangeListener l=new ChangeListener();

	new BiSet<TabPage>(link.pages()) {

	    @Override
	    public void onAdd(TabPage item) {
		final TabPage cur = item;
		final TabHeader head = new TabHeader(theme, closeIcon) {

		    @Override
		    public void closeClicked() {
			//System.out.println("drop "+cur);
			//link.pages().drop(cur);
			if (cur.approveClosing()) {
			    link.pages().drop(cur);
			    cur.onClose();
			}
		    }
		};
		addTab(cur.title().get(), new TabPanel(cur, theme));
		setTabComponentAt(count() - 1, head);
		new BiValue<String>(cur.title()) {

		    @Override
		    public void onChange(String newValue) {
			head.label.setText(cur.title().get());
		    }
		};
		new BiValue<String>(cur.icon()) {

		    @Override
		    public void onChange(String newValue) {
			//System.out.println()
			head.label.setIcon(theme.icon(cur.icon().get()));
		    }
		};
	    }
	    @Override
	    public void onDrop(TabPage item) {
		//System.out.println("onDrop "+item);
		for (int i = 0; i < getTabCount(); i++) {
		    Component c = getComponentAt(i);
		    //System.out.println("test "+c);
		    if (c instanceof TabPanel) {
			TabPanel tp = (TabPanel) c;
			if (tp.link == item) {
			    removeTabAt(i);
			    break;
			}
		    }
		}
	    }
	};
	addChangeListener(new ChangeListener() {

	    public void stateChanged(ChangeEvent evt) {
		JTabbedPane pane = (JTabbedPane) evt.getSource();
		int sel = pane.getSelectedIndex();
		//System.out.println(sel);
		if (link.pages().count() >= sel) {
		    link.current().set(link.pages().get(sel));
		    //System.out.println("stateChanged "+link.current().get().title().get());
		}
	    }
	});
	new BiValue<TabPage>(link.current()) {

	    @Override
	    public void onChange(TabPage item) {
		//System.out.println("current onChange "+item.title().get());
		for (int i = 0; i < getTabCount(); i++) {
		    Component c = getComponentAt(i);
		    //System.out.println("test "+c);
		    if (c instanceof TabPanel) {
			TabPanel tp = (TabPanel) c;
			if (tp.link == item) {
			    setSelectedIndex(i);
			    break;
			}
		    }
		}
	    }
	};
    }
}
