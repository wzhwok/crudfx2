package crudfx2.core.bind;

import java.util.*;

public class Wood {

    public static int NODE = 0;
    public static int ATTRIBUTE = 1;
    public static int CDATA = 2;
    public String name = "";
    public String raw = null;
    private BiSet<Wood> _children = new BiSet<Wood>();
    public Wood saxparent = null;
    private BiValue<String> _string = null;
    private BiValue<Integer> _integer = null;
    private BiValue<Double> _doubl = null;
    public boolean isAttribute = false;
    public boolean isCDATA = false;
    public boolean isText = false;

    public Wood(String branchName) {
        this(branchName,NODE);
    }

    public Wood(String branchName, int kind) {
        this.name = branchName;
        if (kind == ATTRIBUTE) {
            isAttribute = true;
        } else {
            if (kind == CDATA) {
                isCDATA = true;
            }
        }
    }

    public BiSet<Wood> children() {
        return _children;
    }

    public Wood find(String name) {
        for (int i = 0; i < children().count(); i++) {
            if (children().get(i).name.equals(name)) {
                return children().get(i);
            }
        }
        Wood b = new Wood(name);
        children().add(b);
        return b;
    }

    public void gather() {
        if (_string != null) {
            raw = _string.get();
            return;
        }
        if (_integer != null) {
            raw = "" + _integer.get();
            return;
        }
        if (_doubl != null) {
            raw = "" + _doubl.get();
            return;
        }
    }

    public BiValue<String> asString(String defaultValue) {
        if (_string == null) {
            _string = new BiValue<String>(defaultValue);
            if (raw != null) {
                _string.set(raw);
            }
        }
        return _string;
    }

    public BiValue<Integer> asInteger(int defaultValue) {
        if (_integer == null) {
            _integer = new BiValue<Integer>(defaultValue);
            int n = 0;
            if (raw != null) {
                try {
                    n = Integer.parseInt(raw);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                _integer.set(n);
            }
        }
        return _integer;
    }

    public BiValue<Double> asDouble(double defaultValue) {
        if (_doubl == null) {
            _doubl = new BiValue<Double>(defaultValue);
            double n = 0;
            if (raw != null) {
                try {
                    n = Double.parseDouble(raw);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                _doubl.set(n);
            }
        }
        return _doubl;
    }
}