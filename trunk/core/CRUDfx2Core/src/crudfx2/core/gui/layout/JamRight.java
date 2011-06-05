package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamRight extends Widget {

    private BiValue<Widget> _right = new BiValue<Widget>();
    private BiValue<Widget> _body = new BiValue<Widget>();

    public BiValue<Widget> body() {
        return _body;
    }

    public BiValue<Widget> right() {
        return _right;
    }

    public JamRight(Widget body, Widget right) {
        _right.set(right);
        _body.set(body);
    }

    public JamRight(BiValue<Widget> body, BiValue<Widget> right) {
        _right.bind(right);
        _body.bind(body);
    }
}
