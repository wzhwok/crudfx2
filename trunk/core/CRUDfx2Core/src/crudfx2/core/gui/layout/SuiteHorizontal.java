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
    /*    public SuiteHorizontal(Widget[] units) {
    _suite.add(units);
    }
    public SuiteHorizontal(BiSet<Widget> units) {
    _suite.bind(units);
    }*/
}
