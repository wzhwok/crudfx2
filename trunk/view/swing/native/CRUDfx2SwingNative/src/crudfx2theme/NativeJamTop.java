package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;

public class NativeJamTop extends JPanel {

    JComponent _jam = null;
    JComponent _unit = null;

    public NativeJamTop(JamTop unit, Theme ntheme) {
        this.setLayout(new BorderLayout());
        final Theme theme = ntheme;
        final JamTop link = unit;
        this.setOpaque(false);
        new BiValue<Widget>(link.top()) {

            @Override
            public void onChange(Widget newValue) {
                if (_jam != null) {
                    remove(_jam);
                }
                if (link.top().get() != null) {
                    _jam = theme.createJComponent(link.top().get());
                    add(_jam, BorderLayout.NORTH);
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
                }
                repaint();
                validate();
            }
        };
        repaint();
        validate();
    }
}
