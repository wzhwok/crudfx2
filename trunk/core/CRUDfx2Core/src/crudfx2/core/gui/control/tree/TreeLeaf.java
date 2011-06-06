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
    public TreeLeaf() {//BiValue<String> title) {
	//_title.bind(title);
    }
    public TreeLeaf title(String t) {
	this.title().set(t);
	return this;
    }
    public TreeLeaf title(BiValue<String> t) {
	this.title().bind(t);
	return this;
    }
    public TreeLeaf icon(String t) {
	this.icon().set(t);
	return this;
    }
    public TreeLeaf icon(BiValue<String> t) {
	this.icon().bind(t);
	return this;
    }
    
}
