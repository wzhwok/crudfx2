package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;


public class Indent extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Integer> _left = new BiValue<Integer>(0);
    private BiValue<Integer> _top = new BiValue<Integer>(0);
    private BiValue<Integer> _right = new BiValue<Integer>(0);
    private BiValue<Integer> _bottom = new BiValue<Integer>(0);
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
    public BiValue<Integer> left() {
	return _left;
    }
    public Indent left(Integer n) {
	left().set(n);
	return this;
    }
    public Indent left(BiValue<Integer> n) {
	left().bind(n);
	return this;
    }
    public BiValue<Integer> top() {
	return _top;
    }
    public Indent top(Integer n) {
	top().set(n);
	return this;
    }
    public Indent top(BiValue<Integer> n) {
	top().bind(n);
	return this;
    }
    public BiValue<Integer> right() {
	return _right;
    }
    public Indent right(Integer n) {
	right().set(n);
	return this;
    }
    public Indent right(BiValue<Integer> n) {
	right().bind(n);
	return this;
    }
    public BiValue<Integer> bottom() {
	return _bottom;
    }
    public Indent bottom(Integer n) {
	bottom().set(n);
	return this;
    }
    public Indent bottom(BiValue<Integer> n) {
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
