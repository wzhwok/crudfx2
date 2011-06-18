package crudfx2.core.bind;

public class Compute {

    Calculation<Double> _calculation;
    BiValue<Integer> _round = null;//new BiValue<Integer>();

    public Compute(BiValue<Double> base) {
        _calculation = new Calculation(base, new BiValue<Double>(base.get()));
    }

    public Compute(Calculation<Double> calculation) {
        _calculation = calculation;
    }

    public BiValue<Double> result() {
        return _calculation.second();
    }

    public BiValue<Integer> round() {
        if (_round == null) {
            //BiValue<Integer>real=new BiValue<Integer>();
            _round = new BiValue<Integer>() {

                @Override
                public void onChange(Integer newValue) {
                    _calculation.second().set((double) newValue);
                }
            };
            new BiValue<Double>(result()) {

                @Override
                public void onChange(Double newValue) {
                    _round.set(newValue.intValue());
                    //System.out.println(newValue);
                }
            };
        }
        return _round;
    }

    public Compute plus(double v) {
        final double vv = v;
        double t = _calculation.second().get();
        Calculation<Double> calcPlus = new Calculation<Double>(_calculation.second(), new BiValue<Double>(vv)) {

            @Override
            public Double calculateFirst() {
                return second().get() - vv;
            }

            @Override
            public Double calculateSecond() {
                return first().get() + vv;
            }
        };
        _calculation.second().set(t);
        Compute e = new Compute(calcPlus);
        return e;
    }

    public Compute multiply(double v) {
        final double vv = v;
        double t = _calculation.second().get();
        Calculation<Double> calcPlus = new Calculation<Double>(_calculation.second(), new BiValue<Double>(vv)) {

            @Override
            public Double calculateFirst() {
                return second().get() / vv;
            }

            @Override
            public Double calculateSecond() {
                return first().get() * vv;
            }
        };
        _calculation.second().set(t);
        Compute e = new Compute(calcPlus);
        return e;
    }

    public Compute divide(double v) {
        final double vv = v;
        double t = _calculation.second().get();
        Calculation<Double> calcPlus = new Calculation<Double>(_calculation.second(), new BiValue<Double>(vv)) {

            @Override
            public Double calculateFirst() {
                return second().get() * vv;
            }

            @Override
            public Double calculateSecond() {
                return first().get() / vv;
            }
        };
        _calculation.second().set(t);
        Compute e = new Compute(calcPlus);
        return e;
    }

    public Compute minus(double v) {
        final double vv = v;
        double t = _calculation.second().get();
        Calculation<Double> calcPlus = new Calculation<Double>(_calculation.second(), new BiValue<Double>(vv)) {

            @Override
            public Double calculateFirst() {
                return second().get() + vv;
            }

            @Override
            public Double calculateSecond() {
                return first().get() - vv;
            }
        };
        _calculation.second().set(t);
        Compute e = new Compute(calcPlus);
        return e;
    }

    public static Compute integer(BiValue<Integer> base) {
        /*final BiValue<Integer> ibase = new BiValue<Integer>(base) {
        
        @Override
        public void onChange(Integer newValue) {
        System.out.println("i: " + newValue);
        }
        };
        BiValue<Double> d = new BiValue<Double>(0.0) {
        
        @Override
        public void onChange(Double newValue) {
        System.out.println("d: " + newValue);
        ibase.set(newValue.intValue());
        }
        };*/
        final BiValue<Double> d = new BiValue<Double>((double) base.get());
        final BiValue<Integer> ibase = new BiValue<Integer>(base);
        new BiValue<Double>(d) {

            @Override
            public void onChange(Double newValue) {
                //System.out.println("d: " + newValue);
                ibase.set(newValue.intValue());
            }
        };
        new BiValue<Integer>(base) {

            @Override
            public void onChange(Integer newValue) {
                //System.out.println("i: " + newValue);
                d.set((double) newValue);
            }
        };
        Compute c = new Compute(d);
        return c;
    }
/*
    public static void main(String[] args) {
        
        //33.0 / 91.4
        //100.0 / 212.0
        //37.77777777777778 / 100.0
         
        //BiValue<Double> celsius = new BiValue<Double>(33.0);
        BiValue<Integer> celsius = new BiValue<Integer>(33);
        //BiValue<Double> fahrenheit = new BiValue<Double>(21.0);
        //fahrenheit.bind(new Compute(celsius).multiply(9.0).divide(5.0).plus(32.0).result());
        BiValue<Integer> fahrenheit = new BiValue<Integer>(44);
        //fahrenheit.bind(new Compute(celsius).multiply(9.0).divide(5.0).plus(32.0).round());
        fahrenheit.bind(Compute.integer(celsius).multiply(9.0).divide(5.0).plus(32.0).round());
        System.out.println("Celsius / Fahrenheit");
        System.out.println(celsius.get() + " / " + fahrenheit.get());
        celsius.set(100);
        System.out.println(celsius.get() + " / " + fahrenheit.get());
        fahrenheit.set(100);
        System.out.println(celsius.get() + " / " + fahrenheit.get());
    }*/
}
