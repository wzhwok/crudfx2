package crudfx2.core.gui.control.button;


import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
public class BigButton extends Widget{
  
    private BiValue<String> _title = new BiValue<String>();
    private BiValue<String> _icon = new BiValue<String>();
    private BiValue<Boolean> _flat = new BiValue<Boolean>();
    /*public BiValue<Boolean> flat() {
	return _flat;
    }
    public BigButton flat(Boolean n) {
	flat().set(n);
	return this;
    }
    public BigButton flat(BiValue<Boolean> n) {
	flat().bind(n);
	return this;
    }*/
    public BiValue<String> title() {
	return _title;
    }
    public BigButton title(String n) {
	title().set(n);
	return this;
    }
    public BigButton title(BiValue<String> n) {
	title().bind(n);
	return this;
    }
    public BiValue<String> icon() {
	return _icon;
    }
    public BigButton icon(String n) {
	icon().set(n);
	return this;
    }
    public BigButton icon(BiValue<String> n) {
	icon().bind(n);
	return this;
    }
    public void onClick() {
    }
    public BigButton() {
    }  
}
