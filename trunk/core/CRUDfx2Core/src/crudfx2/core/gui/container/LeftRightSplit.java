package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class LeftRightSplit extends Widget {

    private BiValue<Widget> _left = new BiValue<Widget>();
    private BiValue<Widget> _right = new BiValue<Widget>();
    private BiValue<Integer> _split = new BiValue<Integer>();
    public BiValue<Integer> split() {
	return _split;
    }
    public LeftRightSplit split(Integer n) {
	split().set(n);
	return this;
    }
    public LeftRightSplit split(BiValue<Integer> n) {
	split().bind(n);
	return this;
    }
    public BiValue<Widget> left() {
	return _left;
    }
    public LeftRightSplit left(Widget n) {
	left().set(n);
	return this;
    }
    public LeftRightSplit left(BiValue<Widget> n) {
	left().bind(n);
	return this;
    }
    public BiValue<Widget> right() {
	return _right;
    }
    public LeftRightSplit right(Widget n) {
	right().set(n);
	return this;
    }
    public LeftRightSplit right(BiValue<Widget> n) {
	right().bind(n);
	return this;
    }
    public LeftRightSplit() {
    }
    /*public LeftRightSplit(int split, Widget left, Widget right) {
    _left.set(left);
    _right.set(right);
    _split.set(split);
    }
    public LeftRightSplit(BiValue<Integer> split, Widget left, Widget right) {
    _left.set(left);
    _right.set(right);
    _split.bind(split);
    }
    public LeftRightSplit(BiValue<Integer> split, BiValue<Widget> left, BiValue<Widget> right) {
    _left.bind(left);
    _right.bind(right);
    _split.bind(split);
    }*/
}
