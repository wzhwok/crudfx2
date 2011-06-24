package crudfx2theme;

import crudfx2.core.gui.*;
import javax.swing.*;

public class LinkedComponent extends JComponent {

    public Widget widjet;
    public JComponent jComponent;
    public LinkedComponent(Widget widjet, JComponent jComponent) {
	this.widjet = widjet;
	this.jComponent = jComponent;
    }
}
