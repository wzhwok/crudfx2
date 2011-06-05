package crudfx2.core.gui.control.tree;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class TreeLeaf extends TreeItem {

    public void onClick() {
    }
/*
    public TreeLeaf(String title) {
        _title.set(title);
    }*/

    public TreeLeaf(BiValue<String> title) {
        _title.bind(title);
    }
}
