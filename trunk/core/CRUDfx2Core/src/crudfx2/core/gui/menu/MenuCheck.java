package crudfx2.core.gui.menu;

import crudfx2.core.bind.*;

public class MenuCheck extends MenuUnit {

    private BiValue<String> _title = new BiValue<String>();
    private BiValue<Boolean> _checked = new BiValue<Boolean>();
    public BiValue<String> title() {
	return _title;
    }
    public MenuCheck title(String t) {
	title().set(t);
	return this;
    }
    public MenuCheck title(BiValue<String> t) {
	title().bind(t);
	return this;
    }
    public BiValue<Boolean> checked() {
	return _checked;
    }
    public MenuCheck checked(BiValue<Boolean> t) {
	checked().bind(t);
	return this;
    }
    public MenuCheck checked(Boolean t) {
	checked().set(t);
	return this;
    }
  /*  public MenuCheck(BiValue<Boolean> check, BiValue<String> ititle) {
	title().bind(ititle);
	checked().bind(check);
    }*/
    public MenuCheck() {
    }
}
