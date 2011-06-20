package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.control.button.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;
import crudfx2.core.view.*;
import crudfx2.core.bind.*;

public class Alert {

    static TabPage page = null;
    static BaseTheme baseTheme;

    public static TabPage get(BaseTheme theme,BiValue<Integer> splitSize) {
        baseTheme=theme;
        if (page == null) {
	    page=ExamplePage.get(theme
		    , new StandardButton(){
			    @Override public void onClick() {
				baseTheme.warn("Some warning test without formatting.");
				}
			    }
			.title("Show warning")		    
		    , new BiValue<String>("Alert")
		    , "pages/alert.html"
		    , splitSize);
            /*page = new TabPage()
                    .title("Alert")
                    .body(new SplitTopBottom()
			.split(splitSize)
			.top(new Center()
			    .body(new StandardButton(){
				    @Override public void onClick() {
					baseTheme.warn("Some warning test without formatting.");
					}
				    }
				.title("Show warning")
				)
			    )
			.bottom(new MiniBrowser()
			    .html(theme.text("pages/alert.html", "UTF-8"))
			    )	
			)
                    ;*/
        }
        return page;
    }
}
