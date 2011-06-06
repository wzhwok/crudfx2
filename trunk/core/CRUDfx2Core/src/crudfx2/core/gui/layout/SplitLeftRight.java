package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SplitLeftRight extends Widget {

    private BiValue<Widget> _left = new BiValue<Widget>();
    private BiValue<Widget> _right = new BiValue<Widget>();
    private BiValue<Integer> _split = new BiValue<Integer>(200);
    public BiValue<Integer> split() {
	return _split;
    }
    public SplitLeftRight split(Integer n) {
	split().set(n);
	return this;
    }
    public SplitLeftRight split(BiValue<Integer> n) {
	split().bind(n);
	return this;
    }
    public BiValue<Widget> left() {
	return _left;
    }
    public SplitLeftRight left(Widget c) {
	left().set(c);
	return this;
    }
    public SplitLeftRight left(BiValue<Widget> c) {
	left().bind(c);
	return this;
    }
    public BiValue<Widget> right() {
	return _right;
    }
    public SplitLeftRight right(Widget c) {
	right().set(c);
	return this;
    }
    public SplitLeftRight right(BiValue<Widget> c) {
	right().bind(c);
	return this;
    }
    public SplitLeftRight() {
    }
}
