package crudfx2.core.bind;

import java.util.*;

public class GroupSet<Kind> {

    Hashtable<String, BiValue<Kind>> currentValues = new Hashtable<String, BiValue<Kind>>();
    Hashtable<String, Hashtable<String, BiValue<Kind>>> sets = new Hashtable<String, Hashtable<String, BiValue<Kind>>>();
    BiValue<String> _current = new BiValue<String>("") {

        @Override
        public void onChange(String newValue) {
            refreshSet();
        }
    };

    public BiValue<String> current() {
        return _current;
    }

    public BiValue<Kind> get(String key) {
        BiValue<Kind> v = currentValues.get(key);
        if (v == null) {
            v = new BiValue<Kind>();
        }
        currentValues.put(key, v);
        return v;
    }

    private void refreshSet() {
        //System.out.println(_current.get());
        Hashtable<String, BiValue<Kind>> choosenSet = findSet(_current.get());
        for (Enumeration<String> e = choosenSet.keys(); e.hasMoreElements();) {
            String k = e.nextElement();
            get(k).set(choosenSet.get(k).get());
            //System.out.println(k);
        }
    }

    private Hashtable<String, BiValue<Kind>> findSet(String group) {
        Hashtable<String, BiValue<Kind>> s = sets.get(group);
        if (s == null) {
            s = new Hashtable<String, BiValue<Kind>>();
            sets.put(group, s);
        }
        return s;
    }

    public void add(String group, String key, Kind value) {
        Hashtable<String, BiValue<Kind>> s = findSet(group);
        BiValue<Kind> v = s.get(key);
        if (v == null) {
            v = new BiValue< Kind>();
            s.put(key, v);
        }
        v.set(value);
        refreshSet();
    }
/*
    public static void main(String[] a) {
        GroupSet<String> g = new GroupSet<String>();
        g.add("lower", "first", "one");
        g.add("upper", "first", "ONE");
        g.add("lower", "second", "two");
        g.add("upper", "second", "TWO");
        g.add("lower", "third", "three");
        g.add("upper", "third", "THREE");
        BiValue<String> first = new BiValue<String>(g.get("first"));
        BiValue<String> second = new BiValue<String>(g.get("second"));
        BiValue<String> third = new BiValue<String>(g.get("third"));
        g.current().set("lower");
        System.out.println(first.get()+" / "+second.get()+" / "+third.get());
        g.current().set("upper");
        System.out.println(first.get()+" / "+second.get()+" / "+third.get());
        g.current().set("unknown");
        System.out.println(first.get()+" / "+second.get()+" / "+third.get());
    }*/
}
