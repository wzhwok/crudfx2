package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;
import crudfx2.core.view.*;
import crudfx2.core.bind.*;

public class Info {

    static TabPage page = null;
    public static TabPage get(BaseTheme theme,Localization localization) {
	if (page == null) {
	    page = new TabPage() {
		    @Override public boolean approveClosing() {
			return false;
			}
		    }
		.title(localization.get("pageInfoTitle"))
		.body(//new Section()
		    //.body(
		    new MiniBrowser() {
			@Override public void onLink(String url) {
			    //System.out.println("url: "+url);
			    //html("clicked");
			    }
			}
		    .html(theme.text("pages/info.html", "UTF-8")))
	//	    )
	    ;
	    //"<h1>123</h1><p>test page</p><hr/><pre>blablabla\n\tbububu</pre><p><a href='http://ya.ru'>test link</a></p><p>1</p><p>2</p><p>3</p><p>4</p><p>5</p><p>6</p><p>7</p>"));
	    //System.out.println("html: "+theme.text("pages/info.html", "UTF-8"));
	}
	return page;
    }
}
