package crudfx2.core.bind;

public class Expression {

    Calculation<Double> _calculation;
    public Expression(BiValue<Double> base) {
	_calculation = new Calculation(base, new BiValue<Double>(0.0));
    }
    public Expression(Calculation<Double> calculation) {
	_calculation = calculation;
    }
    public BiValue<Double> result() {
	return _calculation.second();
    }
    public Expression plus(double v) {
	final double vv=v;
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
	Expression e = new Expression(calcPlus);
	return e;
    }
    public static void main(String[] args) {
	BiValue<Double> base = new BiValue<Double>(3.0);
	BiValue<Double> rez = new BiValue<Double>(new Expression(base).result());
	//ff=new BiValue<Double>(Calculation.expression(cc).minus(8));

	System.out.println(base.get() + " / " + rez.get());
	base.set(1.0);
	System.out.println(base.get() + " / " + rez.get());
	rez.set(2.0);
	System.out.println(base.get() + " / " + rez.get());
    }
}
