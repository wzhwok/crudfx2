package crudfx2theme;

import crudfx2.core.gui.layout.Indent;
import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;

public class NativeSectionHide extends JPanel {

    JComponent _unit = null;

    public NativeSectionHide(SectionHide unit, Theme ntheme) {
        this.setLayout(new BorderLayout());
        final Theme theme = ntheme;
        final SectionHide link = unit;
        this.setOpaque(false);
        final JToggleButton tgl = new JToggleButton();
        add(tgl, BorderLayout.NORTH);
        tgl.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean selected = tgl.getModel().isSelected();
                link.hide().set(selected);
            }
        });
        new BiValue<Widget>(link.body()) {

            @Override
            public void onChange(Widget newValue) {
                if (_unit != null) {
                    remove(_unit);
                }
                if (link.body().get() != null) {
                    _unit = theme.createJComponent(link.body().get());
                    _unit.setVisible(!link.hide().get());
                    //System.out.println(link.hide().get());
                    add(_unit, BorderLayout.CENTER);                    
                    //validate();
                    //repaint();
                }
            }
        };
        new BiValue<Boolean>(link.hide()) {

            @Override
            public void onChange(Boolean newValue) {
                if (_unit != null) {
                    //System.out.println(link.hide().get());
                    _unit.setVisible(!link.hide().get());
                    tgl.setSelected(link.hide().get());
                }
            }
        };
        new BiValue<String>(link.title()) {

            @Override
            public void onChange(String newValue) {
                tgl.setText(link.title().get());
            }
        };
        
    }
}
