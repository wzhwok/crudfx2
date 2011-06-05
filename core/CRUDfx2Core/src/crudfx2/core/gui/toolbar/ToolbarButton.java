package crudfx2.core.gui.toolbar;

import crudfx2.core.bind.*;

public class ToolbarButton extends ToolbarUnit {

    private BiValue<String> _title = new BiValue<String>();
    private BiValue<String> _icon = new BiValue<String>();
    public BiValue<String> title() {
	return _title;
    }
    public BiValue<String> icon() {
	return _icon;
    }
    public ToolbarButton icon(String t) {
	icon().set(t);
	return this;
    }
    public ToolbarButton icon(BiValue<String> t) {
	icon().bind(t);
	return this;
    }
    public ToolbarButton title(String t) {
	title().set(t);
	return this;
    }
    public ToolbarButton title(BiValue<String> t) {
	title().bind(t);
	return this;
    }
    public ToolbarButton() {//BiValue<String> inIcon, BiValue<String> inTitle) {
	//title().bind(inTitle);
	//icon().bind(inIcon);
    }
    public void onClick() {
    }
}
