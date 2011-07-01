package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;


public class TabPage {

    private BiString _title = new BiString();
    private BiString _icon = new BiString();
    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiString title() {
	return _title;
    }
    public TabPage title(String n) {
	title().set(n);
	return this;
    }
    public TabPage title(BiValue<String> n) {
	title().bind(n);
	return this;
    }
    public BiString icon() {
	return _icon;
    }
    public TabPage icon(String n) {
	icon().set(n);
	return this;
    }
    public TabPage icon(BiValue<String> n) {
	icon().bind(n);
	return this;
    }
    public BiValue<Widget> body() {
	return _body;
    }
    public TabPage body(Widget n) {
	body().set(n);
	return this;
    }
    public TabPage body(BiValue<Widget> n) {
	body().bind(n);
	return this;
    }
    public TabPage() {
    }
    /*public TabPage(BiValue<String> title, BiValue<String> icon,BiValue<Widget> body) {
    _title.bind(title);
    _icon.bind(icon);
    _body.bind(body);
    }*/
    public void onClose() {
        //BindTools.saveToHome(key, configuration());
        //_theme.saveConfiguration(key, _configuration);
    }

    public boolean approveClosing() {
        return true;
    }
}
