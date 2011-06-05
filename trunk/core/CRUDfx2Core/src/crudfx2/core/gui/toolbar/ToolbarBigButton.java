package crudfx2.core.gui.toolbar;

import crudfx2.core.bind.*;

public class ToolbarBigButton extends ToolbarUnit {

    private BiValue<String> _title = new BiValue<String>();
    private BiValue<String> _icon = new BiValue<String>();
    public BiValue<String> title() {
	return _title;
    }
    public BiValue<String> icon() {
	return _icon;
    }
    public ToolbarBigButton icon(String t) {
	icon().set(t);
	return this;
    }
    public ToolbarBigButton icon(BiValue<String> t) {
	icon().bind(t);
	return this;
    }
    public ToolbarBigButton title(String t) {
	title().set(t);
	return this;
    }
    public ToolbarBigButton title(BiValue<String> t) {
	title().bind(t);
	return this;
    }
    public ToolbarBigButton() {//BiValue<String> inIcon, BiValue<String> inTitle) {
	//title().bind(inTitle);
	//icon().bind(inIcon);
    }
    public void onClick() {
    }
}
