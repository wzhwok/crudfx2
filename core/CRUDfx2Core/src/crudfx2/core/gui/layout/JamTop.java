package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamTop extends Widget {

    private BiValue<Widget> _top = new BiValue<Widget>();
    private BiValue<Widget> _body = new BiValue<Widget>();

    public BiValue<Widget> body() {
        return _body;
    }

    public BiValue<Widget> top() {
        return _top;
    }

    public JamTop(Widget top, Widget body) {
        _top.set(top);
        _body.set(body);
    }

    public JamTop(BiValue<Widget> top, BiValue<Widget> body) {
        _top.bind(top);
        _body.bind(body);
    }

    public JamTop() {
    }
}
