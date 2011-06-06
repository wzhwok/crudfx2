package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
//import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class NativeTextLabel extends JLabel {

    TextLabel _unit;

    public NativeTextLabel(TextLabel unit) {
        super();
        _unit = unit;

        new BiValue<String>(_unit.title()) {

            @Override
            public void onChange(String newValue) {
                setText(_unit.title().get());
            }
        };
    }
}
