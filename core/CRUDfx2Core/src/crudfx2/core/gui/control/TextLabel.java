package crudfx2.core.gui.control;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class TextLabel extends Widget {

    private BiValue<String> _title = new BiValue<String>();

    public BiValue<String> title() {
        return _title;
    }

    public TextLabel title(String s) {
        title().set(s);
        return this;
    }

    public TextLabel title(BiValue<String> s) {
        title().bind(s);
        return this;
    }

    public TextLabel() {
    }
}
