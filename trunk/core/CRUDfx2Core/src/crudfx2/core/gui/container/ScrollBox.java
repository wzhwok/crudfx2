package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;



public class ScrollBox extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiValue<Widget> body() {
	return _body;
    }
    public ScrollBox body(Widget n) {
	body().set(n);
	return this;
    }
    public ScrollBox body(BiValue<Widget> n) {
	body().bind(n);
	return this;
    }
    /*  public ScrollBox(Widget body) {
    _body.set(body);
    }
    
    public ScrollBox(BiValue<Widget> body) {
    _body.bind(body);
    }*/
    public ScrollBox() {
    }
}
