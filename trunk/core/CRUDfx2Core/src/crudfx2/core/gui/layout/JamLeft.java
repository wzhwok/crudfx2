package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class JamLeft extends Widget {

    private BiValue<Widget> _left = new BiValue<Widget>();
    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiValue<Widget> body() {
	return _body;
    }
    public JamLeft body(Widget c) {
	body().set(c);
	return this;
    }
    public JamLeft body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public BiValue<Widget> left() {
	return _left;
    }
    public JamLeft left(Widget c) {
	left().set(c);
	return this;
    }
    public JamLeft left(BiValue<Widget> c) {
	left().bind(c);
	return this;
    }
    public JamLeft() {
    }
}
