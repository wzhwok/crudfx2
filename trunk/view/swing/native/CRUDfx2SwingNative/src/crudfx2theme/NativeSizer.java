package crudfx2theme;

import crudfx2.core.gui.layout.Sizer;
import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;

public class NativeSizer extends JPanel {

    JComponent _unit = null;

    public NativeSizer(Sizer unit, Theme ntheme) {
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        final Theme theme = ntheme;
        final Sizer link = unit;
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
            }
        };

        new BiValue<Integer>(link.width()) {

            @Override
            public void onChange(Integer newValue) {
                setPreferredSize(new Dimension(link.width().get(), link.height().get()));
                setSize(new Dimension(link.width().get(), link.height().get()));
            }
        };
        new BiValue<Integer>(link.height()) {

            @Override
            public void onChange(Integer newValue) {
                setPreferredSize(new Dimension(link.width().get(), link.height().get()));
                setSize(new Dimension(link.width().get(), link.height().get()));
            }
        };
        validate();
    }
}
