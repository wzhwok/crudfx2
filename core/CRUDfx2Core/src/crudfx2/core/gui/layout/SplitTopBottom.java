package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SplitTopBottom extends Widget {

    private BiValue<Widget> _top = new BiValue<Widget>();
    private BiValue<Widget> _bottom = new BiValue<Widget>();
    private BiNumber _split = new BiNumber();
    public BiNumber split() {
	return _split;
    }
    public SplitTopBottom split(Double n) {
	split().set(n);
	return this;
    }
    public SplitTopBottom split(BiNumber n) {
	split().bind(n);
	return this;
    }
    public BiValue<Widget> top() {
	return _top;
    }
    public SplitTopBottom top(Widget c) {
	top().set(c);
	return this;
    }
    public SplitTopBottom top(BiValue<Widget> c) {
	top().bind(c);
	return this;
    }
    public BiValue<Widget> bottom() {
	return _bottom;
    }
    public SplitTopBottom bottom(Widget c) {
	bottom().set(c);
	return this;
    }
    public SplitTopBottom bottom(BiValue<Widget> c) {
	bottom().bind(c);
	return this;
    }
    public SplitTopBottom() {
    }
}
