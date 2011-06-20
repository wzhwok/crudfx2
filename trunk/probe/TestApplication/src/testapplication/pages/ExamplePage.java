package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.*;
import crudfx2.core.gui.control.button.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;
import crudfx2.core.view.*;
import crudfx2.core.bind.*;

public class ExamplePage {
    public static TabPage get(BaseTheme theme,Widget widget,BiValue<String>title,String description,BiValue<Integer> splitSize) {
	TabPage page = new TabPage()
	    .title(title)
	    .body(new SplitTopBottom()
		.split(splitSize)
		.top(new Center()
		    .body(widget)
		    )
		.bottom(new MiniBrowser()
		    .html(theme.text(description, "UTF-8"))
		    )	
		)
	    ;        
        return page;
    }
}
