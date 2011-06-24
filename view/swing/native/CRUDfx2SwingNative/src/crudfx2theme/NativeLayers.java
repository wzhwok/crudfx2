package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.border.*;

public class NativeLayers extends JLayeredPane {
    Vector<LinkedComponent> links = new Vector<LinkedComponent>();
    public NativeLayers(Layers unit, Theme ntheme) {
	//this.setBorder(new EtchedBorder());
	//JLabel label = new JLabel("sdfbsdfbsdfbsdfbsdfb");
	//label.setVisible(true);
	//label.setPreferredSize(new Dimension(100,100));
	//label.setSize(new Dimension(100, 100));
	//this.add(label, new Integer(0));
	//this.add(new JButton("123"), 1);
	//label.setVisible(true);
	//System.out.println(label);
	final Theme theme = ntheme;
	final NativeLayers me=this;
	this.setOpaque(false);
	this.addComponentListener(new ComponentAdapter() {
	    
	    @Override
	    public void componentResized(ComponentEvent e) {
		onResize();
	    }
	});
	new BiSet<Widget>(unit.suite()) {

             @Override
	    public void onAdd(Widget item) {
		JComponent c = theme.createJComponent(item);
		me.add(c);
		links.add(new LinkedComponent(item, c));
	    }
	    @Override
	    public void onDrop(Widget item) {
		//System.out.println("ops!");
		for (int i = 0; i < links.size(); i++) {
		    if (links.get(i).widjet == item) {
			me.remove(links.get(i).jComponent);
			links.remove(links.get(i));
			me.onResize();
			break;
		    }
		}
	    }
        };
	onResize();
    }
   public  void onResize() {
	for (int i = 0; i < this.getComponentCount(); i++) {
	    this.getComponent(i).setSize(this.getSize());
	}
    }
}
