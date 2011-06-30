package crudfx2.core.bind;

public class BiInteger extends BiValue<Integer> {

    private BiValue<Double> _double = null;
    private BiValue<String> _string = null;
    private BiInteger me = this;
    public BiInteger() {
    }
    public BiInteger(Integer i) {
	super(i);
    }
    public BiInteger(BiValue<Integer> i) {
	super(i);
    }
    public BiValue<Double> asDouble() {
	if (_double == null) {
	    _double = new BiValue<Double>((double) get()) {

		@Override
		public void onChange(Double newValue) {
		    if (_double != null) {
			if (_double.get() == null) {
			    me.set(null);
			} else {
			    me.set(_double.get().intValue());
			}
		    }
		}
	    };
	    new BiValue<Integer>(this) {

		@Override
		public void onChange(Integer newValue) {
		    _double.set((double) newValue);
		}
	    };
	}
	return _double;
    }
    public BiInteger plus(int value) {
	final int fvalue = value;
	return new BiInteger(new Calculation<Integer>(this, new BiValue<Integer>(get() + fvalue)) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() - fvalue;
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() + fvalue;
	    }
	}.second());
    }
    public BiInteger plus(BiValue<Integer> value) {
	final BiValue<Integer> fvalue = value;
	final Calculation<Integer> clc = new Calculation<Integer>(this, new BiValue<Integer>(get() + fvalue.get())) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() - fvalue.get();
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() + fvalue.get();
	    }
	};
	new BiValue<Integer>(fvalue) {

	    @Override
	    public void onChange(Integer i) {
		clc.second().set(clc.first().get() + fvalue.get());
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiInteger maximum(int value) {
	final int fvalue = value;
	int n = get();
	if (n > fvalue) {
	    n = fvalue;
	}
	BiValue<Integer> m = new BiValue<Integer>(n) {

	    @Override
	    public void onChange(Integer v) {
		if (v > fvalue) {
		    set(fvalue);
		}
	    }
	};
	Calculation<Integer> clc = new Calculation<Integer>(this, m) {

	    @Override
	    public Integer calculateFirst() {
		return get();
	    }
	    @Override
	    public Integer calculateSecond() {
		int n = get();
		if (n > fvalue) {
		    n = fvalue;
		}
		return n;
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiInteger maximum(BiValue<Integer> value) {
	final BiValue<Integer> fvalue = value;
	int n = get();
	if (n > fvalue.get()) {
	    n = fvalue.get();
	}
	BiValue<Integer> m = new BiValue<Integer>(n) {

	    @Override
	    public void onChange(Integer v) {
		if (v > fvalue.get()) {
		    set(fvalue.get());
		}
	    }
	};
	new BiValue<Integer>(fvalue) {

	    @Override
	    public void onChange(Integer v) {
		if (me.get() > v) {
		    me.set(v);
		}
	    }
	};
	final Calculation<Integer> clc = new Calculation<Integer>(this, m) {

	    @Override
	    public Integer calculateFirst() {
		return get();
	    }
	    @Override
	    public Integer calculateSecond() {
		int n = get();
		if (n > fvalue.get()) {
		    n = fvalue.get();
		}
		return n;
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiInteger minimum(int value) {
	final int fvalue = value;
	int n = get();
	if (n < fvalue) {
	    n = fvalue;
	}
	BiValue<Integer> m = new BiValue<Integer>(n) {

	    @Override
	    public void onChange(Integer v) {
		if (v < fvalue) {
		    set(fvalue);
		}
	    }
	};
	Calculation<Integer> clc = new Calculation<Integer>(this, m) {

	    @Override
	    public Integer calculateFirst() {
		return get();
	    }
	    @Override
	    public Integer calculateSecond() {
		int n = get();
		if (n < fvalue) {
		    n = fvalue;
		}
		return n;
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiInteger minimum(BiValue<Integer> value) {
	final BiValue<Integer> fvalue = value;
	int n = get();
	if (n < fvalue.get()) {
	    n = fvalue.get();
	}
	BiValue<Integer> m = new BiValue<Integer>(n) {

	    @Override
	    public void onChange(Integer v) {
		if (v < fvalue.get()) {
		    set(fvalue.get());
		}
	    }
	};
	new BiValue<Integer>(fvalue) {

	    @Override
	    public void onChange(Integer v) {
		if (me.get() < v) {
		    me.set(v);
		}
	    }
	};
	final Calculation<Integer> clc = new Calculation<Integer>(this, m) {

	    @Override
	    public Integer calculateFirst() {
		return get();
	    }
	    @Override
	    public Integer calculateSecond() {
		int n = get();
		if (n < fvalue.get()) {
		    n = fvalue.get();
		}
		return n;
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiInteger multiply(int value) {
	final int fvalue = value;
	return new BiInteger(new Calculation<Integer>(this, new BiValue<Integer>(get() * fvalue)) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() / fvalue;
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() * fvalue;
	    }
	}.second());
    }
    public BiInteger multiply(BiValue<Integer> value) {
	final BiValue<Integer> fvalue = value;
	final Calculation<Integer> clc = new Calculation<Integer>(this, new BiValue<Integer>(get() * fvalue.get())) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() / fvalue.get();
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() * fvalue.get();
	    }
	};
	new BiValue<Integer>(fvalue) {

	    @Override
	    public void onChange(Integer i) {
		clc.second().set(clc.first().get() * fvalue.get());
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiInteger divide(int value) {
	final int fvalue = value;
	return new BiInteger(new Calculation<Integer>(this, new BiValue<Integer>(get() / fvalue)) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() * fvalue;
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() / fvalue;
	    }
	}.second());
    }
    public BiInteger divide(BiValue<Integer> value) {
	final BiValue<Integer> fvalue = value;
	final Calculation<Integer> clc = new Calculation<Integer>(this, new BiValue<Integer>(get() / fvalue.get())) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() * fvalue.get();
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() / fvalue.get();
	    }
	};
	new BiValue<Integer>(fvalue) {

	    @Override
	    public void onChange(Integer i) {
		clc.second().set(clc.first().get() / fvalue.get());
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiInteger minus(int value) {
	final int fvalue = value;
	return new BiInteger(new Calculation<Integer>(this, new BiValue<Integer>(get() - fvalue)) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() + fvalue;
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() - fvalue;
	    }
	}.second());
    }
    public BiInteger minus(BiValue<Integer> value) {
	final BiValue<Integer> fvalue = value;
	final Calculation<Integer> clc = new Calculation<Integer>(this, new BiValue<Integer>(get() - fvalue.get())) {

	    @Override
	    public Integer calculateFirst() {
		return second().get() + fvalue.get();
	    }
	    @Override
	    public Integer calculateSecond() {
		return first().get() - fvalue.get();
	    }
	};
	new BiValue<Integer>(fvalue) {

	    @Override
	    public void onChange(Integer i) {
		clc.second().set(clc.first().get() - fvalue.get());
	    }
	};
	return new BiInteger(clc.second());
    }
    public BiValue<String> asString() {
	if (_string == null) {
	    _string = new BiValue<String>("" + get()) {

		@Override
		public void onChange(String newValue) {
		    if (_string != null) {
			if (_string.get() == null) {
			    me.set(null);
			} else {
			    try {
				me.set(Integer.parseInt(_string.get()));
			    } catch (Throwable t) {
				//ignore
			    }
			}
		    }
		}
	    };
	    new BiValue<Integer>(this) {

		@Override
		public void onChange(Integer newValue) {
		    _string.set("" + newValue);
		}
	    };
	}
	return _string;
    }
    public static BiInteger fromDouble(BiValue<Double> i) {
	BiInteger ii = new BiInteger(i.get().intValue());
	return ii;
    }
    public static void main(String a[]) {
	BiInteger ii = new BiInteger(2);
	/*BiValue<Double> dbl = new BiValue<Double>(ii.asDouble());
	BiValue<String> ss = new BiValue<String>(ii.asString());
	System.out.println(ii.get() + ", " + dbl.get() + ", " + ss.get());
	dbl.set(444444.0);
	System.out.println(ii.get() + ", " + dbl.get() + ", " + ss.get());
	ii.set(2);
	System.out.println(ii.get() + ", " + dbl.get() + ", " + ss.get());
	ss.set("33");
	System.out.println(ii.get() + ", " + dbl.get() + ", " + ss.get());*/
	BiValue<Integer> plu = new BiValue<Integer>(3);
	BiValue nn = ii.maximum(plu);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());
	//System.out.println(">");
	nn.set(21);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());
	ii.set(122);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());
	plu.set(500);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());

    }
}
