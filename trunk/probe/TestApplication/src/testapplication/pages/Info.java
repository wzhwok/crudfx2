package testapplication.pages;

import crudfx2.core.gui.control.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;

public class Info {

    static TabPage page = null;
    public static TabPage get() {
	if (page == null) {
	    page = new TabPage() {

		@Override
		public boolean approveClosing() {
		    return false;
		}
	    }.title("Information").body(new MiniBrowser() {

		public void onLink(String url) {
		    //System.out.println(url);
		    html("clicked");
		}
	    }.html("<h1>123</h1><p>test page</p><hr/><pre>blablabla\n\tbububu</pre><p><a href='http://ya.ru'>test link</a></p><p>1</p><p>2</p><p>3</p><p>4</p><p>5</p><p>6</p><p>7</p>"));
	}
	return page;
    }
}
