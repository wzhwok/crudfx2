package crudfx2.core.gui.layout;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;


public class Sizer extends Widget {

    private BiValue<Widget> _body = new BiValue<Widget>();
    private BiValue<Integer> _width = new BiValue<Integer>();
    private BiValue<Integer> _height = new BiValue<Integer>();

    public BiValue<Widget> body() {
        return _body;
    }

    public BiValue<Integer> width() {
        return _width;
    }

    public BiValue<Integer> height() {
        return _height;
    }

    public Sizer(int width, int height, Widget body) {
        _width.set(width);
        _height.set(height);
        _body.set(body);
    }

    public Sizer(BiValue<Integer> width, BiValue<Integer> height, BiValue<Widget> body) {
        _width.bind(width);
        _height.bind(height);
        _body.bind(body);
    }
}
