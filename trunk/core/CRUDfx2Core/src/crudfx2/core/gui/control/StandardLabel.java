package crudfx2.core.gui.control;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class StandardLabel extends Widget {

    private BiValue<String> _title = new BiValue<String>();
    private BiValue<String> _icon = new BiValue<String>();
    public BiValue<String> title() {
	return _title;
    }
    public StandardLabel title(String s) {
	title().set(s);
	return this;
    }
    public StandardLabel title(BiValue<String> s) {
	title().bind(s);
	return this;
    }
    public BiValue<String> icon() {
	return _icon;
    }
    public StandardLabel icon(String s) {
	icon().set(s);
	return this;
    }
    public StandardLabel icon(BiValue<String> s) {
	icon().bind(s);
	return this;
    }
    public StandardLabel() {
    }
}
