package crudfx2.core.bind;

public class BiNumber extends BiValue<Double> {

    //private BiValue<Double> _double = null;
    private BiValue<String> _string = null;
    private BiNumber me = this;

    public BiNumber() {
    }

    public BiNumber(Double i) {
	super(i);
    }

    public BiNumber(Integer i) {
	super(i.doubleValue());
    }

    public BiNumber(BiValue<Double> i) {
	super(i);
    }

    public void set(int newValue) {
	set((double) newValue);
    }
    /*public BiValue<Double> asDouble() {
    if (_double == null) {
    _double = new BiValue<Double>((double) get()) {
    
    @Override
    public void onChange(Double newValue) {
    if (_double != null) {
    if (_double.get() == null) {
    me.set(null);
    } else {
    me.set(_double.get().DoubleValue());
    }
    }
    }
    };
    new BiValue<Double>(this) {
    
    @Override
    public void onChange(Double newValue) {
    _double.set((double) newValue);
    }
    };
    }
    return _double;
    }*/

    public BiNumber plus(Double value) {
	final Double fvalue = value;
	return new BiNumber(new Calculation<Double>(this, new BiValue<Double>(get() + fvalue)) {

	    @Override
	    public Double calculateFirst() {
		return second().get() - fvalue;
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() + fvalue;
	    }
	}.second());
    }

    public BiNumber plus(BiNumber value) {
	final BiValue<Double> fvalue = value;
	final Calculation<Double> clc = new Calculation<Double>(this, new BiValue<Double>(get() + fvalue.get())) {

	    @Override
	    public Double calculateFirst() {
		return second().get() - fvalue.get();
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() + fvalue.get();
	    }
	};
	new BiValue<Double>(fvalue) {

	    @Override
	    public void onChange(Double i) {
		clc.second().set(clc.first().get() + fvalue.get());
	    }
	};
	return new BiNumber(clc.second());
    }

    public BiNumber maximum(Double value) {
	final Double fvalue = value;
	Double n = get();
	if (n > fvalue) {
	    n = fvalue;
	}
	BiValue<Double> m = new BiValue<Double>(n) {

	    @Override
	    public void onChange(Double v) {
		if (v > fvalue) {
		    set(fvalue);
		}
	    }
	};
	Calculation<Double> clc = new Calculation<Double>(this, m) {

	    @Override
	    public Double calculateFirst() {
		return get();
	    }

	    @Override
	    public Double calculateSecond() {
		Double n = get();
		if (n > fvalue) {
		    n = fvalue;
		}
		return n;
	    }
	};
	return new BiNumber(clc.second());
    }

    public BiNumber maximum(BiNumber value) {
	final BiValue<Double> fvalue = value;
	Double n = get();
	if (n > fvalue.get()) {
	    n = fvalue.get();
	}
	BiValue<Double> m = new BiValue<Double>(n) {

	    @Override
	    public void onChange(Double v) {
		if (v > fvalue.get()) {
		    set(fvalue.get());
		}
	    }
	};
	new BiValue<Double>(fvalue) {

	    @Override
	    public void onChange(Double v) {
		if (me.get() > v) {
		    me.set(v);
		}
	    }
	};
	final Calculation<Double> clc = new Calculation<Double>(this, m) {

	    @Override
	    public Double calculateFirst() {
		return get();
	    }

	    @Override
	    public Double calculateSecond() {
		Double n = get();
		if (n > fvalue.get()) {
		    n = fvalue.get();
		}
		return n;
	    }
	};
	return new BiNumber(clc.second());
    }

    public BiNumber minimum(Double value) {
	final Double fvalue = value;
	Double n = get();
	if (n < fvalue) {
	    n = fvalue;
	}
	BiValue<Double> m = new BiValue<Double>(n) {

	    @Override
	    public void onChange(Double v) {
		if (v < fvalue) {
		    set(fvalue);
		}
	    }
	};
	Calculation<Double> clc = new Calculation<Double>(this, m) {

	    @Override
	    public Double calculateFirst() {
		return get();
	    }

	    @Override
	    public Double calculateSecond() {
		Double n = get();
		if (n < fvalue) {
		    n = fvalue;
		}
		return n;
	    }
	};
	return new BiNumber(clc.second());
    }

    public BiNumber minimum(BiNumber value) {
	final BiValue<Double> fvalue = value;
	Double n = get();
	if (n < fvalue.get()) {
	    n = fvalue.get();
	}
	BiValue<Double> m = new BiValue<Double>(n) {

	    @Override
	    public void onChange(Double v) {
		if (v < fvalue.get()) {
		    set(fvalue.get());
		}
	    }
	};
	new BiValue<Double>(fvalue) {

	    @Override
	    public void onChange(Double v) {
		if (me.get() < v) {
		    me.set(v);
		}
	    }
	};
	final Calculation<Double> clc = new Calculation<Double>(this, m) {

	    @Override
	    public Double calculateFirst() {
		return get();
	    }

	    @Override
	    public Double calculateSecond() {
		Double n = get();
		if (n < fvalue.get()) {
		    n = fvalue.get();
		}
		return n;
	    }
	};
	return new BiNumber(clc.second());
    }

    public BiNumber multiply(Double value) {
	final Double fvalue = value;
	return new BiNumber(new Calculation<Double>(this, new BiValue<Double>(get() * fvalue)) {

	    @Override
	    public Double calculateFirst() {
		return second().get() / fvalue;
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() * fvalue;
	    }
	}.second());
    }

    public BiNumber multiply(BiNumber value) {
	final BiValue<Double> fvalue = value;
	final Calculation<Double> clc = new Calculation<Double>(this, new BiValue<Double>(get() * fvalue.get())) {

	    @Override
	    public Double calculateFirst() {
		return second().get() / fvalue.get();
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() * fvalue.get();
	    }
	};
	new BiValue<Double>(fvalue) {

	    @Override
	    public void onChange(Double i) {
		clc.second().set(clc.first().get() * fvalue.get());
	    }
	};
	return new BiNumber(clc.second());
    }

    public BiNumber divide(Double value) {
	final Double fvalue = value;
	return new BiNumber(new Calculation<Double>(this, new BiValue<Double>(get() / fvalue)) {

	    @Override
	    public Double calculateFirst() {
		return second().get() * fvalue;
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() / fvalue;
	    }
	}.second());
    }


    public BiNumber divide(BiNumber value) {
	final BiNumber fvalue = value;
	final Calculation<Double> clc = new Calculation<Double>(this, new BiValue<Double>(get() / fvalue.get())) {

	    @Override
	    public Double calculateFirst() {
		return second().get() * fvalue.get();
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() / fvalue.get();
	    }
	};
	new BiNumber(fvalue) {

	    @Override
	    public void onChange(Double i) {
		clc.second().set(clc.first().get() / fvalue.get());
	    }
	};
	return new BiNumber(clc.second());
    }

    public BiNumber minus(Double value) {
	final Double fvalue = value;
	return new BiNumber(new Calculation<Double>(this, new BiValue<Double>(get() - fvalue)) {

	    @Override
	    public Double calculateFirst() {
		return second().get() + fvalue;
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() - fvalue;
	    }
	}.second());
    }

    public BiNumber minus(BiNumber value) {
	final BiValue<Double> fvalue = value;
	final Calculation<Double> clc = new Calculation<Double>(this, new BiValue<Double>(get() - fvalue.get())) {

	    @Override
	    public Double calculateFirst() {
		return second().get() + fvalue.get();
	    }

	    @Override
	    public Double calculateSecond() {
		return first().get() - fvalue.get();
	    }
	};
	new BiValue<Double>(fvalue) {

	    @Override
	    public void onChange(Double i) {
		clc.second().set(clc.first().get() - fvalue.get());
	    }
	};
	return new BiNumber(clc.second());
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
				me.set(Double.parseDouble(_string.get()));
			    } catch (Throwable t) {
				//ignore
			    }
			}
		    }
		}
	    };
	    new BiValue<Double>(this) {

		@Override
		public void onChange(Double newValue) {
		    _string.set("" + newValue);
		}
	    };
	}
	return _string;
    }
    /*public static BiNumber fromDouble(BiValue<Double> i) {
    BiNumber ii = new BiNumber(i.get().DoubleValue());
    return ii;
    }*/

    public static void main(String a[]) {
	//BiNumber ii = new BiNumber(2.0);
	/*BiValue<Double> dbl = new BiValue<Double>(ii.asDouble());
	BiValue<String> ss = new BiValue<String>(ii.asString());
	System.out.prDoubleln(ii.get() + ", " + dbl.get() + ", " + ss.get());
	dbl.set(444444.0);
	System.out.prDoubleln(ii.get() + ", " + dbl.get() + ", " + ss.get());
	ii.set(2);
	System.out.prDoubleln(ii.get() + ", " + dbl.get() + ", " + ss.get());
	ss.set("33");
	System.out.prDoubleln(ii.get() + ", " + dbl.get() + ", " + ss.get());*/
	/*BiValue<Double> plu = new BiValue<Double>(3.0);
	BiValue<Double> nn = ii.maximum(plu);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());
	//System.out.prDoubleln(">");
	nn.set(21.0);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());
	ii.set(122.0);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());
	plu.set(500.0);
	System.out.println(ii.get() + ", " + nn.get() + ", " + plu.get());*/
	BiNumber tCelsius = new BiNumber(0);
	BiNumber tFahrenheit = new BiNumber(tCelsius).multiply(9.0).divide(5.0).plus(32.0);
	System.out.println("tFahrenheit: " + tFahrenheit.get() + ", tCelsius: " + tCelsius.get());
	tFahrenheit.set(100);
	System.out.println("tFahrenheit: " + tFahrenheit.get() + ", tCelsius: " + tCelsius.get());
	tCelsius.set(100);
	System.out.println("tFahrenheit: " + tFahrenheit.get() + ", tCelsius: " + tCelsius.get());
/*
	BiNumber n1 = new BiNumber(0);
	BiNumber n2 = new BiNumber(0);
	n1.bind(n2.plus(9.0).negativePositive(1.0, 2.0));
	System.out.println("1: " + n1.get() + ", 2: " + n2.get());
	n1.set(100);
	System.out.println("1: " + n1.get() + ", 2: " + n2.get());
	n2.set(100);
	System.out.println("1: " + n1.get() + ", 2: " + n2.get());
*/
    }
}
