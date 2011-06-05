package crudfx2.core.gui.container;
import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
public class Center extends Widget{
    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiValue<Widget> body() {
	return _body;
    }
    public Center body(Widget c) {
	body().set(c);
	return this;
    }
    public Center body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public Center() {
    }
}
