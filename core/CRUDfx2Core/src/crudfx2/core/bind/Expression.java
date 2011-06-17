package crudfx2.core.bind;

public class Expression {

    Calculation<Integer> _calculation;

    public Expression(BiValue<Integer> base) {
        _calculation = new Calculation(base, new BiValue<Integer>(base.get()));
    }

    public Expression(Calculation<Integer> calculation) {
        _calculation = calculation;
    }

    public BiValue<Integer> result() {
        return _calculation.second();
    }

    public Expression plus(int v) {
        final int vv = v;
        int t = _calculation.second().get();
        Calculation<Integer> calcPlus = new Calculation<Integer>(_calculation.second(), new BiValue<Integer>(vv)) {

            @Override
            public Integer calculateFirst() {
                return second().get() - vv;
            }

            @Override
            public Integer calculateSecond() {
                return first().get() + vv;
            }
        };
        _calculation.second().set(t);
        Expression e = new Expression(calcPlus);
        return e;
    }

    public Expression multiply(int v) {
        final int vv = v;
        int t = _calculation.second().get();
        Calculation<Integer> calcPlus = new Calculation<Integer>(_calculation.second(), new BiValue<Integer>(vv)) {

            @Override
            public Integer calculateFirst() {
                return second().get() / vv;
            }

            @Override
            public Integer calculateSecond() {
                return first().get() * vv;
            }
        };
        _calculation.second().set(t);
        Expression e = new Expression(calcPlus);
        return e;
    }

    public Expression divide(int v) {
        final int vv = v;
        int t = _calculation.second().get();
        Calculation<Integer> calcPlus = new Calculation<Integer>(_calculation.second(), new BiValue<Integer>(vv)) {

            @Override
            public Integer calculateFirst() {
                return second().get() * vv;
            }

            @Override
            public Integer calculateSecond() {
                return first().get() / vv;
            }
        };
        _calculation.second().set(t);
        Expression e = new Expression(calcPlus);
        return e;
    }

    public Expression minus(int v) {
        final int vv = v;
        int t = _calculation.second().get();
        Calculation<Integer> calcPlus = new Calculation<Integer>(_calculation.second(), new BiValue<Integer>(vv)) {

            @Override
            public Integer calculateFirst() {
                return second().get() + vv;
            }

            @Override
            public Integer calculateSecond() {
                return first().get() - vv;
            }
        };
        _calculation.second().set(t);
        Expression e = new Expression(calcPlus);
        return e;
    }

    public static void main(String[] args) {
        BiValue<Integer> cls = new BiValue<Integer>(40);
        BiValue<Integer> rez = new BiValue<Integer>(new Expression(cls).multiply(9).divide(5).plus(32).result());
        System.out.println("Celsius / Fahrenheit");
        System.out.println(cls.get() + " / " + rez.get());
        cls.set(100);
        System.out.println(cls.get() + " / " + rez.get());
        rez.set(100);
        System.out.println(cls.get() + " / " + rez.get());
    }
}
