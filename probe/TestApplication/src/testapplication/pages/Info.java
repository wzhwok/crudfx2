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
            }.title("Information");
        }
        return page;
    }
}
