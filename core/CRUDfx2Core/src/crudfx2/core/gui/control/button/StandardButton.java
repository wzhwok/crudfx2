package crudfx2.core.gui.control.button;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class StandardButton extends Widget {

    private BiString _title = new BiString();
    private BiString _icon = new BiString();
    public BiString title() {
	return _title;
    }
    public StandardButton title(String n) {
	title().set(n);
	return this;
    }
    public StandardButton title(BiValue<String> n) {
	title().bind(n);
	return this;
    }
    public BiString icon() {
	return _icon;
    }
    public StandardButton icon(String n) {
	icon().set(n);
	return this;
    }
    public StandardButton icon(BiValue<String> n) {
	icon().bind(n);
	return this;
    }
    public void onClick() {
    }
    public StandardButton() {
    }
}
