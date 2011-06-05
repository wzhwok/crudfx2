package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;

public class TabPage {

    private BiValue<String> _title = new BiValue<String>();
    private BiValue<String> _icon = new BiValue<String>();
    private BiValue<Widget> _body = new BiValue<Widget>();
    public BiValue<String> title() {
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
    public BiValue<String> icon() {
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
}
