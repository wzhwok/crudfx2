package crudfx2.core.gui.control.tree;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class TreeBranch extends TreeItem {

    protected BiSet<TreeItem> _children = new BiSet<TreeItem>();
    protected BiValue<Boolean> _fold = new BiValue<Boolean>();
    public BiSet<TreeItem> children() {
	return _children;
    }
    public TreeBranch treeItem(TreeItem ti) {
	_children.add(ti);
	return this;
    }
    public BiValue<Boolean> fold() {
	return _fold;
    }
    public TreeBranch title(String t) {
	this.title().set(t);
	return this;
    }
    public TreeBranch title(BiValue<String> t) {
	this.title().bind(t);
	return this;
    }
    /*public void onSpread() {
    }
    
    public void onFold() {
    }*/
    /*public TreeBranch(String title, TreeItem[] items) {
    _title.set(title);
    for (int i = 0; i < items.length; i++) {
    _children.add(items[i]);
    }
    }*/
    public TreeBranch() {
    }
}
