package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;

public class NativeJamRight extends JPanel {

    JComponent _jam = null;
    JComponent _unit = null;

    public NativeJamRight(JamRight unit, Theme ntheme) {
        this.setLayout(new BorderLayout());
        final Theme theme = ntheme;
        final JamRight link = unit;
        this.setOpaque(false);
        new BiValue<Widget>(link.right()) {

            @Override
            public void onChange(Widget newValue) {
                if (_jam != null) {
                    remove(_jam);
                }
                if (link.right().get() != null) {
                    _jam = theme.createJComponent(link.right().get());
                    add(_jam, BorderLayout.EAST);
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
