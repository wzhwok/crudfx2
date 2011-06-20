package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.control.button.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;
import crudfx2.core.view.*;
import crudfx2.core.bind.*;

public class SectionPage {

    static TabPage page = null;
    static BaseTheme baseTheme;

    public static TabPage get(BaseTheme theme,BiValue<Integer> splitSize) {
        baseTheme=theme;
        if (page == null) {
	    page=ExamplePage.get(theme
		    , new Section().body(new StandardButton().title("Button")).title("test")//.fold(true)
		    , new BiValue<String>("Section")
		    , "pages/section.html"
		    , splitSize);
        }
        return page;
    }
}
