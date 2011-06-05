package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamLeft extends Widget {

    private BiValue<Widget> _left = new BiValue<Widget>();
    private BiValue<Widget> _body = new BiValue<Widget>();

    public BiValue<Widget> body() {
        return _body;
    }

    public BiValue<Widget> left() {
        return _left;
    }

    public JamLeft(Widget left, Widget body) {
        _left.set(left);
        _body.set(body);
    }

    public JamLeft(BiValue<Widget> left, BiValue<Widget> body) {
        _left.bind(left);
        _body.bind(body);
    }
    public JamLeft() {
    }
}
