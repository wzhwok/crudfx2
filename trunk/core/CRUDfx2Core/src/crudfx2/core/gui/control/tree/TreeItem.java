package crudfx2.core.gui.control.tree;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public abstract class TreeItem {

    protected BiString _title = new BiString();
    protected BiString _icon = new BiString();
    public BiString title() {
	return _title;
    }
    public BiString icon() {
	return _icon;
    }
}
