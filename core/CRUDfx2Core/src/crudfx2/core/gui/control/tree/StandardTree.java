package crudfx2.core.gui.control.tree;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class StandardTree extends Widget {

    private BiSet<TreeItem> _children = new BiSet<TreeItem>();
    public BiSet<TreeItem> children() {
	return _children;
    }
    public StandardTree treeItem(TreeItem ti) {
	_children.add(ti);
	return this;
    }
    public StandardTree() {
    }
}
