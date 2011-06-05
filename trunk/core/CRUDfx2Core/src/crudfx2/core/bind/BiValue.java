package crudfx2.core.bind;

import java.util.*;

public class BiValue<Kind> {

    private Vector<BiValue> _binded = new Vector<BiValue>();
    private Kind _value = null;

    public BiValue() {
    }

    public BiValue(Kind initVal) {
        this._value = initVal;
    }

    public BiValue(BiValue<Kind> bindVal) {
        this.bind(bindVal);
    }

    public Kind get() {
        return _value;
    }

    public void set(Kind newValue) {
        setForEachBindedItem(newValue, new Vector<BiValue>());
    }

    private void setForEachBindedItem(Kind newValue, Vector<BiValue> cashe) {
        if (this._value == null && newValue == null) {
            return;
        }
        if (this._value != null && this._value.equals(newValue)) {
            return;
        }
        this._value = newValue;
        onChange(this._value);
        cashe.add(this);
        for (int i = 0; i < _binded.size(); i++) {
            if (!cashe.contains(_binded.get(i))) {
                _binded.get(i).setForEachBindedItem(newValue, cashe);
            }
        }
        cashe.remove(this);
    }

    public void onChange(Kind newValue) {
    }

    public void bind(BiValue<Kind> to) {
        if (to == null) {
            return;
        }
        if (!this._binded.contains(to)) {
            this._binded.add(to);
        }
        if (!to._binded.contains(this)) {
            to._binded.add(this);
        }
        this.set(to.get());
    }

    public void unbind(BiValue<Kind> to) {
        if (to == null) {
            return;
        }
        this._binded.remove(to);
        to._binded.remove(this);
    }
/*
    public static void main(String[] args) {
        //System.out.println("--- simple binding example");
        BiValue<String> bi1 = new BiValue<String>("a") {

            @Override
            public void onChange(String newValue) {
                //System.out.println("bi1: someone changed value to " + get());
            }
        };
        BiValue<String> bi2 = new BiValue<String>("b") {

            @Override
            public void onChange(String newValue) {
                //System.out.println("bi2: someone changed value to " + get());
            }
        };
        BiValue<String> bi3 = new BiValue<String>("c") {

            @Override
            public void onChange(String newValue) {
                //System.out.println("bi3: someone changed value to " + get());
            }
        };
        System.out.println("now bi1: " + bi1.get() + ", bi2: " + bi2.get() + ", bi3: " + bi3.get());
        System.out.println("bind all");
        bi1.bind(bi2);
        bi2.bind(bi3);
        bi3.bind(bi1);
        System.out.println("now bi1: " + bi1.get() + ", bi2: " + bi2.get() + ", bi3: " + bi3.get());
        System.out.println("let bi1=d");
        bi1.set("d");
        System.out.println("now bi1: " + bi1.get() + ", bi2: " + bi2.get() + ", bi3: " + bi3.get());

    }*/
}
