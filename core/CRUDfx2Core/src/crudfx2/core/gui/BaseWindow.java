package crudfx2.core.gui;

import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.view.*;
import crudfx2.core.gui.toolbar.*;

public class BaseWindow {

    public String key = "";
    private Wood _configuration;
    private BiValue<String> _title = new BiValue<String>();
    private BiValue<String> _icon = new BiValue<String>();
    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Widget> _footer = new BiValue<Widget>();
    private BiSet<MenuPad> _menu = new BiSet<MenuPad>();
    //private BiSet<ToolbarUnit> _toolbar = new BiSet<ToolbarUnit>();
    private BiValue<Widget> _toolbar = new BiValue<Widget>();
    private BaseTheme _theme;
    //GroupSet<String> _localization = new GroupSet<String>();

    public BiSet<MenuPad> menu() {
        return _menu;
    }

    /*public BaseWindow menu(MenuPad p) {
        menu().add(p);
        return this;
    }*/
    public BaseWindow menu(BiSet<MenuPad> u) {
	//for(int i=0;i<u.count();i++){
	//    _menu.add(u.get(i));
	//}
        //_toolbar.add(u);
	_menu.bind(u);
        return this;
    }

    /*public GroupSet<String> localization() {
        return _localization;
    }*/

    /*public BaseWindow localization(String key, String name, String value) {
        localization().add(key, name, value);
        return this;
    }*/
/*
    public BaseWindow current(String key) {
        localization().current().set(key);
        return this;
    }

    public BaseWindow current(BiValue<String> key) {
        localization().current().bind(key);
        return this;
    }*/

    /*public BiSet<ToolbarUnit> toolbar() {
        return _toolbar;
    }

    public BaseWindow toolbar(BiSet<ToolbarUnit> u) {
        _toolbar.bind(u);
        return this;
    }*/

    public Wood configuration() {
        return _configuration;
    }

    public BiValue<String> title() {
        return _title;
    }

    public BaseWindow title(BiValue<String> t) {
        title().bind(t);
        return this;
    }

    public BaseWindow title(String t) {
        title().set(t);
        return this;
    }

    public BiValue<String> icon() {
        return _icon;
    }

    public BaseWindow icon(BiValue<String> i) {
        icon().bind(i);
        return this;
    }

    public BaseWindow icon(String i) {
        icon().set(i);
        return this;
    }

    public BiValue<Widget> body() {
        return _body;
    }

    public BaseWindow body(BiValue<Widget> b) {
        body().bind(b);
        return this;
    }

    public BaseWindow body(Widget b) {
        body().set(b);
        return this;
    }

    public BiValue<Widget> footer() {
        return _footer;
    }

    public BaseWindow footer(BiValue<Widget> f) {
        footer().bind(f);
        return this;
    }

    public BaseWindow footer(Widget f) {
        footer().set(f);
        return this;
    }

    
    
     public BiValue<Widget> toolbar() {
        return _toolbar;
    }

    public BaseWindow toolbar(BiValue<Widget> f) {
        toolbar().bind(f);
        return this;
    }

    public BaseWindow toolbar(Widget f) {
        toolbar().set(f);
        return this;
    }
    
    
    public BaseWindow(String applicationKey//, BiValue<String> applicationIcon
            , BaseTheme theme) {
        _theme = theme;
        key = applicationKey;
        //_icon.bind(applicationIcon);
        _configuration = theme.loadConfiguration(key);
        //BindTools.loadFromXMLFile(BindTools.homeFile(key));
        if (_configuration.name.equals("")) {
            _configuration = new Wood("configuration");
        }
    }

    public void onClose() {
        //BindTools.saveToHome(key, configuration());
        //_theme.saveConfiguration(key, _configuration);
    }

    public boolean approveClosing() {
        return true;
    }
}
