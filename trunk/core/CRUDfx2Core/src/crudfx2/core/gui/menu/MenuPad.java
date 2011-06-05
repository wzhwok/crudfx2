package crudfx2.core.gui.menu;

import crudfx2.core.bind.*;

public class MenuPad {

    private BiValue<String> _title = new BiValue<String>();
    private BiSet<MenuUnit> _items = new BiSet<MenuUnit>();

    public BiValue<String> title() {
        return _title;
    }

    public BiSet<MenuUnit> items() {
        return _items;
    }
    /*
    public MenuPad(String inTitle, MenuUnit[] inItems) {
    this.title().set(inTitle);
    initItems(inItems);
    }
     */

    public MenuPad item(MenuUnit u) {
        items().add(u);
        return this;
    }

    public MenuPad title(String t) {
        title().set(t);
        return this;
    }

    public MenuPad title(BiValue<String> t) {
        title().bind(t);
        return this;
    }

    public MenuPad() {
    }
/*
    public MenuPad(BiValue<String> inTitle, MenuUnit[] inItems) {
        this.title().bind(inTitle);
        initItems(inItems);
    }

    private void initItems(MenuUnit[] inItems) {
        for (int i = 0; i < inItems.length; i++) {
            items().add(inItems[i]);
        }
    }*/
}
