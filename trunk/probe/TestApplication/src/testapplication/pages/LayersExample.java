package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.control.button.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;
import crudfx2.core.view.*;
import crudfx2.core.bind.*;

public class LayersExample {

    static TabPage page = null;
    static BaseTheme baseTheme;

    public static TabPage get(BaseTheme theme,BiNumber splitSize) {
        baseTheme=theme;
        if (page == null) {
	    page=ExamplePage.get(theme
		    , new Sizer()
			.body(new Layers()
			    .item(new JamTop()
				.top(new StandardButton()
				    .title("Button")
				    .icon(CRUDfxIcons.i16_system)
				    )
				)	
			    .item(new JamLeft()
				.left(new BigButton()
				    .title("Button 2222")
				    .icon(CRUDfxIcons.i16_system)
				    )
				)
			    )
			.width(200.0)
			.height(200.0)
		    , new BiString("Section")
		    , "pages/section.html"
		    , splitSize);
        }
        return page;
    }
}
