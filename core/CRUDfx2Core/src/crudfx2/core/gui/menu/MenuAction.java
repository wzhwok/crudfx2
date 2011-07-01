package crudfx2.core.gui.menu;

import crudfx2.core.bind.*;

public class MenuAction extends MenuUnit {

    private BiString _title = new BiString();
    private BiString _icon = new BiString();

    public BiString title() {
        return _title;
    }

    public MenuAction title(String t) {
        title().set(t);
        return this;
    }

    public MenuAction title(BiValue<String> t) {
        title().bind(t);
        return this;
    }

    public BiString icon() {
        return _icon;
    }

    public MenuAction icon(String t) {
        icon().set(t);
        return this;
    }

    public MenuAction icon(BiValue<String> t) {
        icon().bind(t);
        return this;
    }

    /*public MenuAction(BiString icon, BiString ititle) {
        title().bind(ititle);
        icon().bind(icon);
    }*/

    public MenuAction() {
    }

    public void onSelect() {
    }
}
