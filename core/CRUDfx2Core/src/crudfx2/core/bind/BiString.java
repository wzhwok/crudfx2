package crudfx2.core.bind;

public class BiString extends BiValue<String> {

    public BiString() {
    }
    public BiString(String i) {
	super(i);
    }
    public BiString(BiValue<String> i) {
	super(i);
    }
    public BiString plus(String value) {
	final String fvalue = value;
	return new BiString(new Calculation<String>(this, new BiValue<String>(get() + fvalue)) {

	    @Override
	    public String calculateFirst() {
		return second().get();
	    }
	    @Override
	    public String calculateSecond() {
		return first().get() + fvalue;
	    }
	}.second());
    }
    public BiString plus(BiValue<String> value) {
	final BiValue<String> fvalue = value;
	final Calculation<String> clc = new Calculation<String>(this, new BiValue<String>(get() + fvalue.get())) {

	    @Override
	    public String calculateFirst() {
		return second().get();
	    }
	    @Override
	    public String calculateSecond() {
		return first().get() + fvalue.get();
	    }
	};
	new BiValue<String>(fvalue) {

	    @Override
	    public void onChange(String i) {
		clc.second().set(clc.first().get() + fvalue.get());
	    }
	};
	return new BiString(clc.second());
    }
    public static void main(String a[]) {
	BiString a1 = new BiString("1111");
	BiString a2 = new BiString("2222");
	BiString a3 = new BiString("--");
	System.out.println(a1.get() + " / " + a2.get()+ " / " + a3.get());
	a1 = a2.plus(a3);
	System.out.println(a1.get() + " / " + a2.get()+ " / " + a3.get());
	a2.set("4");
	System.out.println(a1.get() + " / " + a2.get()+ " / " + a3.get());
	a3.set("!!!");
	System.out.println(a1.get() + " / " + a2.get()+ " / " + a3.get());
    }
}
