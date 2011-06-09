package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class Tabs extends Widget {

    private BiSet<TabPage> _pages = new BiSet<TabPage>();
    private BiValue<TabPage> _current = new BiValue<TabPage>();
    public BiValue<TabPage> current() {
	return _current;
    }
    private void addIfNotExists(TabPage pg) {
	//System.out.println("addIfNotExists " + pg.title().get());
	for (int i = 0; i < pages().count(); i++) {
	    if (pages().get(i) == pg) {
		return;
	    }
	   	}
	//System.out.println("not found " + pg.title().get());
	    page(pg);
    }
    public Tabs current(BiValue<TabPage> n) {
	addIfNotExists(n.get());
	current().bind(n);
	return this;
    }
    public Tabs current(TabPage n) {
	//System.out.println("current " + n.title().get());
	addIfNotExists(n);
	current().set(n);
	return this;
    }
    public BiSet<TabPage> pages() {
	return _pages;
    }
    public Tabs page(TabPage p) {
	//System.out.println("page " + p.title().get());
	pages().add(p);
	return this;
    }
    public Tabs() {//BiSet<TabPage> units) {
	//_pages.bind(units);
    }
}
