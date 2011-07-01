package crudfx2.core.gui.control;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class StandardLabel extends Widget {

    private BiString _title = new BiString();
    private BiString _icon = new BiString();
    public BiString title() {
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
    public BiString icon() {
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
