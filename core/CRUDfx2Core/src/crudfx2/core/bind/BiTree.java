package crudfx2.core.bind;

import java.util.*;

public class BiTree {

    public static int NODE = 0;
    public static int ATTRIBUTE = 1;
    public static int CDATA = 2;
    public String name = "";
    public String raw = null;
    private BiSet<BiTree> _children = new BiSet<BiTree>();
    public BiTree saxparent = null;
    /*private BiValue<String> _string = null;
    private BiValue<Integer> _integer = null;
    private BiValue<Double> _doubl = null;*/
    private BiNumber _number = null;
    private BiString _string = null;
    public boolean isAttribute = false;
    public boolean isCDATA = false;
    public boolean isText = false;

    public BiTree(String branchName) {
        this(branchName,NODE);
    }

    public BiTree(String branchName, int kind) {
        this.name = branchName;
        if (kind == ATTRIBUTE) {
            isAttribute = true;
        } else {
            if (kind == CDATA) {
                isCDATA = true;
            }
        }
    }

    public BiSet<BiTree> children() {
        return _children;
    }

    public BiTree find(String name) {
        for (int i = 0; i < children().count(); i++) {
            if (children().get(i).name.equals(name)) {
                return children().get(i);
            }
        }
        BiTree b = new BiTree(name);
        children().add(b);
        return b;
    }

    public void gather() {
        if (_string != null) {
            raw = _string.get();
            return;
        }
        if (_number != null) {
            raw = "" + _number.get();
            return;
        }
        /*if (_doubl != null) {
            raw = "" + _doubl.get();
            return;
        }*/
    }

    public BiString asString(String defaultValue) {
        if (_string == null) {
            _string = new BiString(defaultValue);
            if (raw != null) {
                _string.set(raw);
            }
        }
        return _string;
    }
/*
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
*/
    public BiNumber asNumber(double defaultValue) {
        if (_number == null) {
            _number = new BiNumber(defaultValue);
            double n = 0;
            if (raw != null) {
                try {
                    n = Double.parseDouble(raw);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                _number.set(n);
            }
        }
        return _number;
    }
}
