package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SuiteHorizontal extends Widget {

    private BiSet<Widget> _suite = new BiSet<Widget>();
    public BiSet<Widget> suite() {
	return _suite;
    }
    public SuiteHorizontal item(Widget w) {
	_suite.add(w);
	return this;
    }
    public SuiteHorizontal() {
    }
}
