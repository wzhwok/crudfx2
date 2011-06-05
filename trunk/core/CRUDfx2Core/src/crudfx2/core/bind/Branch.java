package crudfx2.core.bind;

import java.util.*;

public class Branch {

    public String name = "";
    protected String raw = null;
    public Vector<Branch> children = new Vector<Branch>();
    protected Branch saxparent = null;
    private BiValue<String> string = null;
    private BiValue<Integer> integer = null;
    private BiValue<Double> doubl = null;
    public boolean isAttribute = false;
    public boolean isCDATA = false;

    public Branch(String branchName) {
        this.name = branchName;
    }

    public Branch find(String name) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).name.equals(name)) {
                return children.get(i);
            }
        }
        Branch b = new Branch(name);
        children.add(b);
        return b;
    }

    public void gather() {
        if (string != null) {
            raw = string.get();
            return;
        }
        if (integer != null) {
            raw = "" + integer.get();
            return;
        }
        if (doubl != null) {
            raw = "" + doubl.get();
            return;
        }
    }

    public BiValue<String> asString(String defaultValue) {
        if (string == null) {
            string = new BiValue<String>(defaultValue);
            if (raw != null) {                
                string.set(raw);
            }
        }
        return string;
    }

    public BiValue<Integer> asInteger(int defaultValue) {
        if (integer == null) {
            integer = new BiValue<Integer>(defaultValue);
            int n = 0;
            if (raw != null) {                
                try {
                    n = Integer.parseInt(raw);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                integer.set(n);
            }
        }
        return integer;
    }

    public BiValue<Double> asDouble(double defaultValue) {
        if (doubl == null) {
            doubl = new BiValue<Double>(defaultValue);
            double n = 0;
            if (raw != null) {                
                try {
                    n = Double.parseDouble(raw);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
                doubl.set(n);
            }
        }
        return doubl;
    }
}
