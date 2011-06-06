package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class Sizer extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Integer> _width = new BiValue<Integer>();
    private BiValue<Integer> _height = new BiValue<Integer>();
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
    public BiValue<Integer> width() {
	return _width;
    }
    public Sizer width(Integer n) {
	width().set(n);
	return this;
    }
    public Sizer width(BiValue<Integer> n) {
	width().bind(n);
	return this;
    }
    public BiValue<Integer> height() {
	return _height;
    }
    public Sizer height(Integer n) {
	height().set(n);
	return this;
    }
    public Sizer height(BiValue<Integer> n) {
	height().bind(n);
	return this;
    }
    public Sizer() {
    }
}
