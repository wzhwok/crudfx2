package crudfx2.core.gui.control.tree;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class TreeBranch extends TreeItem {

    protected BiSet<TreeItem> _children = new BiSet<TreeItem>();
    protected BiValue<Boolean> _fold = new BiValue<Boolean>();
    protected BiString _openedIcon = new BiString();
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
    public TreeBranch icon(String t) {
	this.icon().set(t);
	return this;
    }
    public TreeBranch icon(BiValue<String> t) {
	this.icon().bind(t);
	return this;
    }
    public BiString openedIcon() {
	return _openedIcon;
    }
     public TreeBranch openedIcon(String t) {
	this.openedIcon().set(t);
	return this;
    }
    public TreeBranch openedIcon(BiValue<String> t) {
	this.openedIcon().bind(t);
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
