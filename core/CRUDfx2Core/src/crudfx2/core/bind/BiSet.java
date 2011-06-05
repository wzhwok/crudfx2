package crudfx2.core.bind;

import java.util.*;

public class BiSet<Kind> {

    private Vector<Kind> _set = new Vector<Kind>();
    private Vector<BiSet<Kind>> binded = new Vector<BiSet<Kind>>();
    public int count() {
	return _set.size();
    }
    public Kind get(int n) {
	if (n < _set.size() && n > -1) {
	    return _set.get(n);
	} else {
	    return null;
	}
    }

    public BiSet<Kind> add(Kind[] items) {
	if (items == null) {
	    return this;
	}
	for (int i = 0; i < items.length; i++) {
	    add(items[i]);
	}
	return this;
    }
    public BiSet(Kind[] items) {
	if (items == null) {
	    return;
	}
	for (int i = 0; i < items.length; i++) {
	    _set.add(items[i]);
	}
    }
    public BiSet() {
    }
    public BiSet(BiSet<Kind> s) {
	this.bind(s);
    }
    public BiSet<Kind> add(Kind item) {
	if (item == null) {
	    return this;
	}
	addToEachBindedSet(item, new Vector<BiSet<Kind>>());
	return this;
    }
    private void addToEachBindedSet(Kind item, Vector<BiSet<Kind>> cashe) {
	_set.add(item);
	onAdd(item);
	cashe.add(this);
	for (int i = 0; i < binded.size(); i++) {
	    if (!cashe.contains(binded.get(i))) {
		binded.get(i).addToEachBindedSet(item, cashe);
	    }
	}
	cashe.remove(this);
    }
    public void onAdd(Kind item) {
    }
    public void drop(Kind item) {
	if (item == null) {
	    return;
	}
	dropEach(item, new Vector<BiSet>());
    }
    private void dropEach(Kind item, Vector<BiSet> cashe) {
	_set.remove(item);
	onDrop(item);
	cashe.add(this);
	for (int i = 0; i < binded.size(); i++) {
	    if (!cashe.contains(binded.get(i))) {
		binded.get(i).dropEach(item, cashe);
	    }
	}
	cashe.remove(this);
    }
    public void onDrop(Kind item) {
    }
    public BiSet<Kind> bind(BiSet<Kind> to) {
	if (to == null) {
	    return this;
	}
	for (int i = 0; i < _set.size(); i++) {
	    drop(_set.get(i));
	}
	for (int i = 0; i < to.count(); i++) {
	    this.add(to.get(i));
	}
	if (!this.binded.contains(to)) {
	    this.binded.add(to);
	}
	if (!to.binded.contains(this)) {
	    to.binded.add(this);
	}
	return this;
    }
    public BiSet<Kind> unbind(BiSet<Kind> to) {
	if (to == null) {
	    return this;
	}
	this.binded.remove(to);
	to.binded.remove(this);
	return this;
    }
}
