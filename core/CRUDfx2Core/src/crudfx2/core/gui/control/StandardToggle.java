package crudfx2.core.gui.control;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class StandardToggle extends Widget {

    private BiValue<String> _title = new BiValue<String>();
    private BiValue<Boolean> _toggled = new BiValue<Boolean>();
    public BiValue<String> title() {
	return _title;
    }
    public StandardToggle title(String n) {
	title().set(n);
	return this;
    }
    public StandardToggle title(BiValue<String> n) {
	title().bind(n);
	return this;
    }
    public BiValue<Boolean> toggled() {
	return _toggled;
    }
    public StandardToggle toggled(Boolean n) {
	toggled().set(n);
	return this;
    }
    public StandardToggle toggled(BiValue<Boolean> n) {
	toggled().bind(n);
	return this;
    }
    /*public StandardToggle(String title, Boolean toggled) {
    _title.set(title);
    _toggled.set(toggled);
    }
    
    public StandardToggle(BiValue<String> title, BiValue<Boolean> toggled) {
    _title.bind(title);
    _toggled.bind(toggled);
    }*/
    public StandardToggle() {
    }
}
