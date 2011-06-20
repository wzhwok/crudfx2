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
    //TitledBorder border;
    public NativeSection(Section unit, Theme ntheme) {
	this.setLayout(new BorderLayout());
	final Theme theme = ntheme;
	final Section link = unit;
	this.setOpaque(false);
	//final JToggleButton tgl = new JToggleButton();
	//add(tgl, BorderLayout.NORTH);
	EtchedBorder etchedBorder=new EtchedBorder();
	final TitledBorder titledBorder=new TitledBorder(etchedBorder,"");//link.title().get());
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

    }
}
