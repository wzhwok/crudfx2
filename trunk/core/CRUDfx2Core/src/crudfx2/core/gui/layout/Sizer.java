package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class Sizer extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiNumber _width = new BiNumber();
    private BiNumber _height = new BiNumber();
    public BiValue<Widget> body() {
	return _body;
    }
    public Sizer body(Widget c) {
	body().set(c);
	return this;
    }
    public Sizer body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public BiNumber width() {
	return _width;
    }
    public Sizer width(Double n) {
	width().set(n);
	return this;
    }
    public Sizer width(BiNumber n) {
	width().bind(n);
	return this;
    }
    public BiNumber height() {
	return _height;
    }
    public Sizer height(Double n) {
	height().set(n);
	return this;
    }
    public Sizer height(BiNumber n) {
	height().bind(n);
	return this;
    }
    public Sizer() {
    }
}
