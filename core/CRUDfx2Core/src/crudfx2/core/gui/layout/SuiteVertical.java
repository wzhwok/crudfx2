package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SuiteVertical extends Widget {

    private BiSet<Widget> _suite = new BiSet<Widget>();

    public BiSet<Widget> suite() {
        return _suite;
    }

    public SuiteVertical(Widget[] units) {
        _suite.add(units);
    }

    public SuiteVertical(BiSet<Widget> units) {
        _suite.bind(units);
    }
}
