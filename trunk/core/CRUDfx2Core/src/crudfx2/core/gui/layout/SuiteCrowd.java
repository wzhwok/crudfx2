package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SuiteCrowd extends Widget {

    private BiSet<Widget> _suite = new BiSet<Widget>();
    public BiSet<Widget> suite() {
	return _suite;
    }
    public SuiteCrowd item(Widget w) {
	_suite.add(w);
	return this;
    }
    public SuiteCrowd() {
    }
}
