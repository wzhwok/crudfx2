package crudfx2theme;

import crudfx2.core.gui.layout.SplitLeftRight;
import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.container.*;
import javax.swing.*;
import java.beans.*;

public class NativeSplitLeftRight extends JSplitPane {

    JComponent _left = null;
    JComponent _right = null;

    public NativeSplitLeftRight(SplitLeftRight unit, Theme ntheme) {
        final Theme theme = ntheme;
        final SplitLeftRight link = unit;
        this.setOpaque(false);
        this.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        new BiValue<Widget>(link.left()) {

            @Override
            public void onChange(Widget newValue) {
                if (_left != null) {
                    remove(_left);
                }
                if (link.left().get() != null) {
                    _left = theme.createJComponent(link.left().get());
                    setLeftComponent(_left);
                }
            }
        };
        new BiValue<Widget>(link.right()) {

            @Override
            public void onChange(Widget newValue) {
                if (_right != null) {
                    remove(_right);
                }
                if (link.right().get() != null) {
                    _right = theme.createJComponent(link.right().get());
                    setRightComponent(_right);
                }
            }
        };
        new BiValue<Integer>(link.split()) {

            @Override
            public void onChange(Integer newValue) {
                setDividerLocation(link.split().get());
            }
        };
        this.addPropertyChangeListener(new PropertyChangeListener() {

            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals(JSplitPane.LAST_DIVIDER_LOCATION_PROPERTY)) {
                    link.split().set(getDividerLocation());
                }
            }
        });
    }
}
