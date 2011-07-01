package crudfx2.core.gui.control;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class MiniBrowser extends Widget {

    private BiString _html = new BiString();
    public BiString html() {
	return _html;
    }
    public MiniBrowser html(String s) {
	html().set(s);
	return this;
    }
    public MiniBrowser html(BiValue<String> s) {
	html().bind(s);
	return this;
    }
    public void onLink(String url) {
    }
}
