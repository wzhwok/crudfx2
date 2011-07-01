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
    public static TabPage get(BaseTheme theme,Widget widget,BiString title,String description,BiNumber splitSize) {
	TabPage page = new TabPage()
	    .title(title)
	    .body(new SplitTopBottom()
		.split(splitSize)
		.top(//new Section()
		    //.body(
			new ScrollBox()
			.body(widget)
			//)
		    )
		.bottom(new Section()
		    .body(new MiniBrowser()
			.html(theme.text(description, "UTF-8"))
			)
		    )
		)
	    ;
        return page;
    }
}
