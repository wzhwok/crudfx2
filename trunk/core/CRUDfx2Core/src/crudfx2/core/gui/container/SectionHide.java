package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import java.util.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.gui.layout.*;

public class SectionHide extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Boolean> _hide = new BiValue<Boolean>();
    private BiValue<String> _title = new BiValue<String>();
    public BiValue<Widget> body() {
	return _body;
    }
    public SectionHide body(Widget n) {
	body().set(n);
	return this;
    }
    public SectionHide body(BiValue<Widget> n) {
	body().bind(n);
	return this;
    }
    public BiValue<Boolean> hide() {
	return _hide;
    }
    public SectionHide hide(Boolean n) {
	hide().set(n);
	return this;
    }
    public SectionHide hide(BiValue<Boolean> n) {
	hide().bind(n);
	return this;
    }
    public BiValue<String> title() {
	return _title;
    }
    public SectionHide title(String n) {
	title().set(n);
	return this;
    }
    public SectionHide title(BiValue<String> n) {
	title().bind(n);
	return this;
    }
    public SectionHide() {
    }/*
    public SectionHide(Boolean hide, String title, Widget body) {
    _title.set(title);
    _hide.set(hide);
    _body.set(body);
    }
    
    public SectionHide(BiValue<Boolean> hide, BiValue<String> title, BiValue<Widget> body) {
    _title.bind(title);
    _hide.bind(hide);
    _body.bind(body);
    }*/

}
