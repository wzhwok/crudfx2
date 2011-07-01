package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SplitLeftRight extends Widget {

    private BiValue<Widget> _left = new BiValue<Widget>();
    private BiValue<Widget> _right = new BiValue<Widget>();
    private BiNumber _split = new BiNumber(200.0);
    public BiNumber split() {
	return _split;
    }
    public SplitLeftRight split(Double n) {
	split().set(n);
	return this;
    }
    public SplitLeftRight split(BiNumber n) {
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
