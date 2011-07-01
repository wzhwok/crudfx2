package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;


public class Indent extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiNumber _left = new BiNumber(0.0);
    private BiNumber _top = new BiNumber(0.0);
    private BiNumber _right = new BiNumber(0.0);
    private BiNumber _bottom = new BiNumber(0.0);
    public BiValue<Widget> body() {
	return _body;
    }
    public Indent body(Widget c) {
	body().set(c);
	return this;
    }
    public Indent body(BiValue<Widget> c) {
	body().bind(c);
	return this;
    }
    public BiNumber left() {
	return _left;
    }
    public Indent left(Double n) {
	left().set(n);
	return this;
    }
    public Indent left(BiNumber n) {
	left().bind(n);
	return this;
    }
    public BiNumber top() {
	return _top;
    }
    public Indent top(Double n) {
	top().set(n);
	return this;
    }
    public Indent top(BiNumber n) {
	top().bind(n);
	return this;
    }
    public BiNumber right() {
	return _right;
    }
    public Indent right(Double n) {
	right().set(n);
	return this;
    }
    public Indent right(BiNumber n) {
	right().bind(n);
	return this;
    }
    public BiNumber bottom() {
	return _bottom;
    }
    public Indent bottom(Double n) {
	bottom().set(n);
	return this;
    }
    public Indent bottom(BiNumber n) {
	bottom().bind(n);
	return this;
    }
    public Indent() {//int top, int left, int bottom, int right, Widget body) {
        /*_top.set(top);
	_left.set(left);
	_bottom.set(bottom);
	_right.set(right);
	_body.set(body);*/
    }
    /*
    public Indent(BiValue<Integer> top, BiValue<Integer> left, BiValue<Integer> bottom, BiValue<Integer> right, BiValue<Widget> body) {
    _top.bind(top);
    _left.bind(left);
    _bottom.bind(bottom);
    _right.bind(right);
    _body.bind(body);
    }*/
}
