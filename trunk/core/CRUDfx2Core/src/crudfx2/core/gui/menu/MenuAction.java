package crudfx2.core.gui.menu;

import crudfx2.core.bind.*;

public class MenuAction extends MenuUnit {

    private BiValue<String> _title = new BiValue<String>();
    private BiValue<String> _icon = new BiValue<String>();

    public BiValue<String> title() {
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

    public BiValue<String> icon() {
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

    /*public MenuAction(BiValue<String> icon, BiValue<String> ititle) {
        title().bind(ititle);
        icon().bind(icon);
    }*/

    public MenuAction() {
    }

    public void onSelect() {
    }
}
