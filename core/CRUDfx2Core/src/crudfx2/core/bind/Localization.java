package crudfx2.core.bind;

public class Localization {

    GroupSet<String> _strings = new GroupSet<String>();
    public GroupSet<String> strings() {
	return _strings;
    }
    public Localization add(String key, String name, String value) {
	strings().add(key, name, value);
	return this;
    }
    public Localization current(String key) {
	strings().current().set(key);
	return this;
    }
    public BiValue<String> current() {
	return strings().current();
    }
    public BiValue<String> get(String key) {
	if (strings().get(key).get()==null) {
	    strings().get(key).set("?" + key);
	}
	return strings().get(key);
    }
    public Localization current(BiValue<String> key) {
	strings().current().bind(key);
	return this;
    }
}
