package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamTop extends Widget {

    private BiValue<Widget> _top = new BiValue<Widget>();
    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiValue<Widget> body() {
	return _body;
    }
    public JamTop body(Widget c) {
	body().set(c);
	return this;
    }
    public JamTop body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public BiValue<Widget> top() {
	return _top;
    }
    public JamTop top(Widget c) {
	top().set(c);
	return this;
    }
    public JamTop top(BiValue<Widget> c) {
	top().bind(c);
	return this;
    }
    public JamTop() {
    }
}
