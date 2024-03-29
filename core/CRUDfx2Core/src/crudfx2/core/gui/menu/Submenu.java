package crudfx2.core.gui.menu;

import crudfx2.core.bind.*;

public class Submenu extends MenuUnit {

    private BiString _title = new BiString();
    private BiSet<MenuUnit> _items = new BiSet<MenuUnit>();
    public BiString title() {
	return _title;
    }
    public BiSet<MenuUnit> items() {
	return _items;
    }
    public Submenu title(String t) {
	title().
		set(t);
	return this;
    }
    public Submenu title(BiValue<String> t) {
	title().bind(t);
	return this;
    }
    public Submenu item(MenuUnit item) {
	items().add(item);
	return this;
    }
    public Submenu() {
    }
   /* public Submenu(BiString ititle, MenuUnit[] inItems) {
	title().bind(ititle);
	//items().set(new BindableSet<MenuItemUnit>());
	initItems(inItems);
    }
    private void initItems(MenuUnit[] inItems) {
	for (int i = 0; i < inItems.length; i++) {
	    items().add(inItems[i]);
	}
    }*/
}
