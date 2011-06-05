package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;


public class Indent extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Integer> _left = new BiValue<Integer>();
    private BiValue<Integer> _top = new BiValue<Integer>();
    private BiValue<Integer> _right = new BiValue<Integer>();
    private BiValue<Integer> _bottom = new BiValue<Integer>();

    public BiValue<Widget> body() {
        return _body;
    }

    public BiValue<Integer> left() {
        return _left;
    }

    public BiValue<Integer> top() {
        return _top;
    }

    public BiValue<Integer> right() {
        return _right;
    }

    public BiValue<Integer> bottom() {
        return _bottom;
    }

    public Indent(int top, int left, int bottom, int right, Widget body) {
        _top.set(top);
        _left.set(left);
        _bottom.set(bottom);
        _right.set(right);
        _body.set(body);
    }

    public Indent(BiValue<Integer> top, BiValue<Integer> left, BiValue<Integer> bottom, BiValue<Integer> right, BiValue<Widget> body) {
        _top.bind(top);
        _left.bind(left);
        _bottom.bind(bottom);
        _right.bind(right);
        _body.bind(body);
    }
}
