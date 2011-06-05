package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;


public class Hidder extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Boolean> _hide = new BiValue<Boolean>();
    public BiValue<Widget> body() {
	return _body;
    }
    public Hidder body(Widget n) {
	body().set(n);
	return this;
    }
    public Hidder body(BiValue<Widget> n) {
	body().bind(n);
	return this;
    }
    public BiValue<Boolean> hide() {
	return _hide;
    }
    public Hidder hide(Boolean n) {
	hide().set(n);
	return this;
    }
    public Hidder hide(BiValue<Boolean> n) {
	hide().bind(n);
	return this;
    }
    /*
    public Hidder(Boolean hide, Widget body) {
    _hide.set(hide);
    _body.set(body);
    }
    
    public Hidder(BiValue<Boolean> hide, BiValue<Widget> body) {
    _hide.bind(hide);
    _body.bind(body);
    }
     */
    public Hidder() {
    }
}
