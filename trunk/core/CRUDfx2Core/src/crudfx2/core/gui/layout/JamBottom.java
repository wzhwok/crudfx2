package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamBottom extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Widget> _bottom = new BiValue<Widget>();

    public BiValue<Widget> body() {
        return _body;
    }

    public BiValue<Widget> bottom() {
        return _bottom;
    }

    public JamBottom(Widget body, Widget bottom) {
        _body.set(body);
        _bottom.set(bottom);
    }

    public JamBottom(BiValue<Widget> body, BiValue<Widget> bottom) {
        _body.bind(body);
        _bottom.bind(bottom);
    }
}
