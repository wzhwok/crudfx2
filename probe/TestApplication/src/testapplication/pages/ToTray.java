package testapplication.pages;
import crudfx2.core.gui.control.*;
import crudfx2.core.gui.control.button.*;
import crudfx2.core.gui.container.*;
import crudfx2.core.gui.layout.*;
import crudfxicons.*;
import crudfx2.core.view.*;
public class ToTray {
    
    static TabPage page = null;
    static BaseTheme baseTheme;
    public static TabPage get(BaseTheme theme) {
        baseTheme=theme;
        if (page == null) {
            page = new TabPage()
                    .title("System tray")
                    .body(new Center()
                        .body(new StandardButton(){
                                @Override public void onClick() {
                                    //baseTheme.inform("khbjyby");
                                    //baseTheme.warn("Some warning");
				    baseTheme.hide();
                                    }
                                }
                            .title("Hide to system tray")
                            )
                        )
                    ;
        }
        return page;
    }
}
