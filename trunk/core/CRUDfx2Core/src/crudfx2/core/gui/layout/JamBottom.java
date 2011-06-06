package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamBottom extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Widget> _bottom = new BiValue<Widget>();
    public BiValue<Widget> body() {
	return _body;
    }
    public JamBottom body(Widget c) {
	body().set(c);
	return this;
    }
    public JamBottom body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public BiValue<Widget> bottom() {
	return _bottom;
    }
    public JamBottom bottom(Widget c) {
	bottom().set(c);
	return this;
    }
    public JamBottom bottom(BiValue<Widget> c) {
	bottom().bind(c);
	return this;
    }
    public JamBottom() {
    }
}
