package crudfx2.core.gui.control.tree;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public abstract class TreeItem {

    protected BiValue<String> _title = new BiValue<String>();
    protected BiValue<String> _icon = new BiValue<String>();
    public BiValue<String> title() {
	return _title;
    }
    public BiValue<String> icon() {
	return _icon;
    }
}
