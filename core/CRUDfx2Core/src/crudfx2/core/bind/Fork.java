package crudfx2.core.bind;

public class Fork<Kind> extends BiValue<Kind> {

    private BiValue<Kind> lessThenZero = new BiValue<Kind>();
    private BiValue<Kind> moreOrEqualsZero = new BiValue<Kind>();
    private BiNumber condition = new BiNumber() {

	@Override
	public void onChange(Double newValue) {
	    rebind();

	}
    };

    private void rebind() {
	if (condition.get() < 0) {
	    this.unbind(moreOrEqualsZero);
	    this.bind(lessThenZero);
	} else {
	    this.unbind(lessThenZero);
	    this.bind(moreOrEqualsZero);
	}
    }

    public Fork condition(BiNumber it) {
	condition.bind(it);
	return this;
    }

    public Fork lessThenZero(BiValue<Kind> it) {
	lessThenZero.bind(it);
	return this;
    }

    public Fork moreOrEqualsZero(BiValue<Kind> it) {
	moreOrEqualsZero.bind(it);
	return this;
    }

    public static void main(String a[]) {
	BiNumber n = new BiNumber();
	Fork f = new Fork<String>()//
		.condition(n)//
		.lessThenZero(new BiValue<String>("LESS"))//
		.moreOrEqualsZero(new BiValue<String>("MORE OR EQUALS"))//
		;
	BiValue<String> s = new BiValue<String>();
	s.bind(f);
	System.out.println(n.get() + " / " + f.get() + " / " + s.get());
	n.set(0);
	System.out.println(n.get() + " / " + f.get() + " / " + s.get());
	n.set(1);
	System.out.println(n.get() + " / " + f.get() + " / " + s.get());
	n.set(2);
	System.out.println(n.get() + " / " + f.get() + " / " + s.get());
	n.set(-2);
	System.out.println(n.get() + " / " + f.get() + " / " + s.get());
	n.set(-1);
	System.out.println(n.get() + " / " + f.get() + " / " + s.get());
    }
}
