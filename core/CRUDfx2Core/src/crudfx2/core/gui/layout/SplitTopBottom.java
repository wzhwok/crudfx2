package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public class SplitTopBottom extends Widget {

    private BiValue<Widget> _top = new BiValue<Widget>();
    private BiValue<Widget> _bottom = new BiValue<Widget>();
    private BiValue<Integer> _split = new BiValue<Integer>();

    public BiValue<Integer> split() {
        return _split;
    }

    public BiValue<Widget> top() {
        return _top;
    }

    public BiValue<Widget> bottom() {
        return _bottom;
    }

    public SplitTopBottom(int split, Widget top, Widget bottom) {
        _top.set(top);
        _bottom.set(bottom);
        _split.set(split);
    }

    public SplitTopBottom(BiValue<Integer> split, Widget top, Widget bottom) {
        _top.set(top);
        _bottom.set(bottom);
        _split.bind(split);
    }

    public SplitTopBottom(BiValue<Integer> split, BiValue<Widget> top, BiValue<Widget> bottom) {
        _top.bind(top);
        _bottom.bind(bottom);
        _split.bind(split);
    }
}
