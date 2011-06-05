package crudfx2.core.bind;

public class Calculation<Kind> {

    private boolean lockFirst = false;
    private boolean lockSecond = false;
    private BiValue<Kind> _first = new BiValue<Kind>() {

        @Override
        public void onChange(Kind newValue) {
            if (lockFirst) {
                return;
            }
            lockFirst = true;
            if (!lockSecond) {
                second().set(calculateSecond());
            }
            lockFirst = false;
        }
    };
    private BiValue<Kind> _second = new BiValue<Kind>() {

        @Override
        public void onChange(Kind newValue) {
            if (lockSecond) {
                return;
            }
            lockSecond = true;
            if (!lockFirst) {
                first().set(calculateFirst());
            }
            lockSecond = false;
        }
    };

    public Calculation(BiValue<Kind> f, BiValue<Kind> s) {
        first().bind(f);
        second().bind(s);
    }

    public Kind calculateFirst() {
        return second().get();
    }

    public Kind calculateSecond() {
        return first().get();
    }

    public BiValue<Kind> first() {
        return _first;
    }

    public BiValue<Kind> second() {
        return _second;
    }
/*
    public static void main(String[] args) {
        final BiValue<Double> tFahrenheit = new BiValue<Double>(0.0);
        final BiValue<Double> tCelsius = new BiValue<Double>(0.0);
        new Calculation(tFahrenheit, tCelsius) {

            @Override
            public Double calculateFirst() {
                return tCelsius.get() * 9.0 / 5.0 + 32.0;
            }

            @Override
            public Double calculateSecond() {
                return (tFahrenheit.get() - 32) * 5.0 / 9.0;
            }
        };
        System.out.println("let tFahrenheit=100");
        tFahrenheit.set(100.0);
        System.out.println("now tFahrenheit: " + tFahrenheit.get() + ", tCelsius: " + tCelsius.get());
        System.out.println("let tCelsius=100");
        tCelsius.set(100.0);
        System.out.println("now tFahrenheit: " + tFahrenheit.get() + ", tCelsius: " + tCelsius.get());
    }*/
}
