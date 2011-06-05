package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;


public class ColorFill extends Widget {

    private BiValue<String> _color = new BiValue<String>();
    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiValue<String> color() {
	return _color;
    }
    public ColorFill color(String c) {
	color().set(c);
	return this;
    }
    public ColorFill color(BiValue<String> c) {
	color().bind(c);
	return this;
    }
    public BiValue<Widget> body() {
	return _body;
    }
    public ColorFill body(Widget c) {
	body().set(c);
	return this;
    }
    public ColorFill body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public ColorFill() {//BiValue<Color> color, BiValue<Widget> body) {
	//_color.bind(color);
	//_body.bind(body);
    }
}
