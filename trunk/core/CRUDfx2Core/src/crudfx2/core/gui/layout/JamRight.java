package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamRight extends Widget {

    private BiValue<Widget> _right = new BiValue<Widget>();
    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiValue<Widget> body() {
	return _body;
    }
    public JamRight body(Widget c) {
	body().set(c);
	return this;
    }
    public JamRight body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public BiValue<Widget> right() {
	return _right;
    }
    public JamRight right(Widget c) {
	right().set(c);
	return this;
    }
    public JamRight right(BiValue<Widget> c) {
	right().bind(c);
	return this;
    }
    public JamRight() {
    }
}
