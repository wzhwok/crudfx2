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
	BiValue<String> negative = new BiValue<String>("LESS");
	BiValue<String> positive = new BiValue<String>("MORE OR EQUALS");
	Fork f = new Fork<String>()//
		.condition(n)//
		.lessThenZero(negative)//
		.moreOrEqualsZero(positive)//
		;
	BiValue<String> s = new BiValue<String>();
	s.bind(f);
	System.out.println("condition: " + n.get() + ", fork: " + f.get() + ", string: " + s.get() + ", negative: " + negative.get() + ", positive: " + positive.get());
	n.set(+0);
	System.out.println("n.set(+0); > condition: " + n.get() + ", fork: " + f.get() + ", string: " + s.get() + ", negative: " + negative.get() + ", positive: " + positive.get());
	n.set(+1);
	System.out.println("n.set(+1); > condition: " + n.get() + ", fork: " + f.get() + ", string: " + s.get() + ", negative: " + negative.get() + ", positive: " + positive.get());
	n.set(-1);
	System.out.println("n.set(-1); > condition: " + n.get() + ", fork: " + f.get() + ", string: " + s.get() + ", negative: " + negative.get() + ", positive: " + positive.get());
	f.set("less");
	System.out.println("f.set(\"less\"); > condition: " + n.get() + ", fork: " + f.get() + ", string: " + s.get() + ", negative: " + negative.get() + ", positive: " + positive.get());
	n.set(+1);
	System.out.println("n.set(+1); > condition: " + n.get() + ", fork: " + f.get() + ", string: " + s.get() + ", negative: " + negative.get() + ", positive: " + positive.get());
	f.set("more");
	System.out.println("f.set(\"more\"); > condition: " + n.get() + ", fork: " + f.get() + ", string: " + s.get() + ", negative: " + negative.get() + ", positive: " + positive.get());
    }
}
