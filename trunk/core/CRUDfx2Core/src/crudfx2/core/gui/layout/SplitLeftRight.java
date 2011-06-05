package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SplitLeftRight extends Widget {

    private BiValue<Widget> _left = new BiValue<Widget>();
    private BiValue<Widget> _right = new BiValue<Widget>();
    private BiValue<Integer> _split = new BiValue<Integer>();

    public BiValue<Integer> split() {
        return _split;
    }

    public BiValue<Widget> left() {
        return _left;
    }

    public BiValue<Widget> right() {
        return _right;
    }

   /* public SplitLeftRight(int split, Widget left, Widget right) {
        _left.set(left);
        _right.set(right);
        _split.set(split);
    }*/
public SplitLeftRight(BiValue<Integer> split, Widget left, Widget right) {
        _left.set(left);
        _right.set(right);
        _split.bind(split);
    }
    /*public SplitLeftRight(BiValue<Integer> split, BiValue<Widget> left, BiValue<Widget> right) {
        _left.bind(left);
        _right.bind(right);
        _split.bind(split);
    }*/
}
