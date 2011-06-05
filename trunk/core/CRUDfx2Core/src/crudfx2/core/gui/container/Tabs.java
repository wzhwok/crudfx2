package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;

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
