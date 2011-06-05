package crudfx2.core.gui.container;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class TopBottomSplit extends Widget {

    private BiValue<Widget> _top = new BiValue<Widget>();
    private BiValue<Widget> _bottom = new BiValue<Widget>();
    private BiValue<Integer> _split = new BiValue<Integer>();
    public BiValue<Integer> split() {
	return _split;
    }
    public TopBottomSplit split(Integer n) {
	split().set(n);
	return this;
    }
    public TopBottomSplit split(BiValue<Integer> n) {
	split().bind(n);
	return this;
    }
    public BiValue<Widget> top() {
	return _top;
    }
    public TopBottomSplit top(Widget n) {
	top().set(n);
	return this;
    }
    public TopBottomSplit top(BiValue<Widget> n) {
	top().bind(n);
	return this;
    }
    public BiValue<Widget> bottom() {
	return _bottom;
    }
    public TopBottomSplit bottom(Widget n) {
	bottom().set(n);
	return this;
    }
    public TopBottomSplit bottom(BiValue<Widget> n) {
	bottom().bind(n);
	return this;
    }
    public TopBottomSplit() {
    }/*
    public TopBottomSplit(int split, Widget top, Widget bottom) {
    _top.set(top);
    _bottom.set(bottom);
    _split.set(split);
    }
    
    public TopBottomSplit(BiValue<Integer> split, Widget top, Widget bottom) {
    _top.set(top);
    _bottom.set(bottom);
    _split.bind(split);
    }
    
    public TopBottomSplit(BiValue<Integer> split, BiValue<Widget> top, BiValue<Widget> bottom) {
    _top.bind(top);
    _bottom.bind(bottom);
    _split.bind(split);
    }*/

}
