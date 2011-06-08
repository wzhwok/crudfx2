package crudfx2theme;

import crudfx2.core.gui.control.button.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.control.*;
import java.awt.event.*;
import javax.swing.*;
import crudfx2theme.nuvola.*;

public class NativeStandardButton extends JButton {
Theme theme;
    StandardButton _unit;
    
    public NativeStandardButton(StandardButton unit, Theme ntheme) {
	super("");
        theme=ntheme;
	_unit = unit;
	addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		_unit.onClick();
	    }
	});
	new BiValue<String>(_unit.title()) {

	    @Override
	    public void onChange(String newValue) {
		setText(_unit.title().get());
	    }
	};
	new BiValue<String>(_unit.icon()) {

	    @Override
	    public void onChange(String newValue) {
		setIcon(theme.icon(_unit.icon().get()));
	    }
	};
        if (unit instanceof StandardFlatButton) {
            setBorderPainted(false);
            setContentAreaFilled(false);
            this.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseEntered(MouseEvent e) {
                    setBorderPainted(true);
                    setContentAreaFilled(true);
                    repaint();
                    validate();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBorderPainted(false);
                    setContentAreaFilled(false);
                    repaint();
                    validate();
                }
            });
        }
    }
}
