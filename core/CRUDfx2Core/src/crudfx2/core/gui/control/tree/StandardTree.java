package crudfx2.core.gui.control.tree;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class StandardTree extends Widget {

    private BiSet<TreeItem> _children = new BiSet<TreeItem>();
    //private BindableSet<Integer> _path = new BindableSet<Integer>();

    public BiSet<TreeItem> children() {
        return _children;
    }

    /*public BindableSet<Integer> path() {
    return _path;
    }*/
    public StandardTree(BiSet<TreeItem> children) {
        _children.bind(children);
    }
    /*public StandardTree() {
    
    }
    public StandardTree(//BindableSet<Integer> path,
    TreeItem[] items) {
    //_children.bind(children);
    for (int i = 0; i < items.length; i++) {
    _children.add(items[i]);
    }
    //_path.bind(path);
    }*/
}
