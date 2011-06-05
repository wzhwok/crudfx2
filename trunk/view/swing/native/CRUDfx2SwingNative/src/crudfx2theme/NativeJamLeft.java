package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;

public class NativeJamLeft extends JPanel {

    JComponent _jam = null;
    JComponent _unit = null;

    public NativeJamLeft(JamLeft unit, Theme ntheme) {
        this.setLayout(new BorderLayout());
        final Theme theme = ntheme;
        final JamLeft link = unit;
        this.setOpaque(false);
        new BiValue<Widget>(link.left()) {

            @Override
            public void onChange(Widget newValue) {
                if (_jam != null) {
                    remove(_jam);
                }
                if (link.left().get() != null) {
                    _jam = theme.createJComponent(link.left().get());
                    add(_jam, BorderLayout.WEST);
                    validate();
                }
                repaint();
                validate();
            }
        };
        new BiValue<Widget>(link.body()) {

            @Override
            public void onChange(Widget newValue) {
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
        repaint();
        validate();
    }
}
