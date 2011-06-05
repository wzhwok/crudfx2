package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;

public class NativeJamBottom extends JPanel {

    JComponent _jam = null;
    JComponent _unit = null;

    public NativeJamBottom(JamBottom unit, Theme ntheme) {
        this.setLayout(new BorderLayout());
        final Theme theme = ntheme;
        final JamBottom link = unit;
        this.setOpaque(false);
        new BiValue<Widget>(link.bottom()) {

            @Override
            public void onChange(Widget newValue) {
                if (_jam != null) {
                    remove(_jam);
                }
                if (link.bottom().get() != null) {
                    _jam = theme.createJComponent(link.bottom().get());
                    add(_jam, BorderLayout.SOUTH);
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
