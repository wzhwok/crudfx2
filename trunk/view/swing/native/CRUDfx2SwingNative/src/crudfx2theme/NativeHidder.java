package crudfx2theme;

import crudfx2.core.gui.layout.Indent;
import crudfx2.core.gui.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;

public class NativeHidder extends JPanel {

    JComponent _unit = null;

    public NativeHidder(Hidder unit, Theme ntheme) {
        //System.out.println("hidder");
        this.setLayout(new BorderLayout());
        final Theme theme = ntheme;
        final Hidder link = unit;
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

        new BiValue<Boolean>(link.hide()) {

            @Override
            public void onChange(Boolean newValue) {
                //crudfx2theme.NativeStandardButton i=(crudfx2theme.NativeStandardButton)_unit;
                //i.setBackground(Color.CYAN);
                //System.out.println(link.hide().get()+ " /" +_unit);
                //_unit.setVisible(false);
                setVisible(!link.hide().get());
            }
        };
//setVisible(false);

        validate();
    }
}
