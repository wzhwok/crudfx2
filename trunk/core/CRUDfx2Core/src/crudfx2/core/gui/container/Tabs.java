package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;


public class Tabs extends Widget {

    private BiSet<TabPage> _pages = new BiSet<TabPage>();
    public BiSet<TabPage> pages() {
	return _pages;
    }
    public Tabs page(TabPage p) {
	pages().add(p);
	return this;
    }
    
    public Tabs() {//BiSet<TabPage> units) {
	//_pages.bind(units);
    }
    
}
