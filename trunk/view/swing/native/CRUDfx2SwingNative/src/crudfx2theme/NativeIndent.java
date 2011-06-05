package crudfx2theme;

import crudfx2.core.gui.layout.Indent;
import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class NativeIndent extends JPanel {

    JComponent _unit = null;

    public NativeIndent(Indent unit, Theme ntheme) {
        this.setLayout(new BorderLayout());
        final Theme theme = ntheme;
        final Indent link = unit;
        this.setOpaque(false);
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

        new BiValue<Integer>(link.left()) {

            @Override
            public void onChange(Integer newValue) {
                setBorder(new EmptyBorder(link.top().get(), link.left().get(), link.bottom().get(), link.right().get()));
            }
        };
        new BiValue<Integer>(link.top()) {

            @Override
            public void onChange(Integer newValue) {
                setBorder(new EmptyBorder(link.top().get(), link.left().get(), link.bottom().get(), link.right().get()));
            }
        };
        new BiValue<Integer>(link.bottom()) {

            @Override
            public void onChange(Integer newValue) {
                setBorder(new EmptyBorder(link.top().get(), link.left().get(), link.bottom().get(), link.right().get()));
            }
        };
        new BiValue<Integer>(link.right()) {

            @Override
            public void onChange(Integer newValue) {
                setBorder(new EmptyBorder(link.top().get(), link.left().get(), link.bottom().get(), link.right().get()));
            }
        };

        validate();
    }
}
