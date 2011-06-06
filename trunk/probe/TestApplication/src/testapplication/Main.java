package testapplication;

import crudfx2.core.gui.control.button.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.gui.layout.Sizer;
import crudfx2.core.gui.layout.Indent;
import crudfx2.core.gui.*;
import crudfx2.core.view.*;
import crudfx2.core.gui.menu.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.gui.control.tree.*;
import crudfx2.core.gui.container.*;
//import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.bind.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	//final BaseTheme theme = new crudfx2substance.SuTheme();
	final BaseTheme theme = new crudfx2theme.Theme();
	final Localization localization=new Localization();
	final BaseWindow window = new BaseWindow("CrudfxExplorer.xml", theme){
	    @Override public void onClose() {
                theme.log(0, "done");
                }
	    @Override public boolean approveClosing() {
                return theme.confirm(localization.get("exitConfirmation").get());
                }
            };
	
	localization.current(window.configuration().find("properies").find("language").find("").asString("English"));
	setupLocalization(localization);
	final BiValue<Boolean> en = new BiValue<Boolean>(false) {@Override public void onChange(Boolean checked) {if (checked) localization.current().set("English");}};
	final BiValue<Boolean> ru = new BiValue<Boolean>(true) {@Override public void onChange(Boolean checked) {if (checked) localization.current().set("Russian");}};
	new Calculation<Boolean>(ru, en) {
	    @Override public Boolean calculateFirst() { return !en.get();}
	    @Override public Boolean calculateSecond() { return !ru.get();} };
	window
	    .title(localization.get("applicationTitle"))
	    .footer(new StandardLabel()
		.title("...")
		)
	    .body(new SplitLeftRight()
		.left(new StandardTree()
		    .treeItem(new TreeLeaf()
			.title("leaf 1")
			)
		    .treeItem(new TreeBranch()
			.title("branch 1")
			.treeItem(new TreeLeaf()
			    .title("sub leaf")
			    )
			)
		    .treeItem(new TreeLeaf()
			.title("leaf 2")
			)
		    )
		.right(new Tabs()
		    .page(new TabPage(){
			@Override public boolean approveClosing() {
			    return theme.confirm(localization.get("closeTabConfirmation").get());
			    }
			@Override public void onClose() {
			    theme.log(0, "tab closed");
			    }
			}
			.title("info")
			.body(new StandardLabel()
			    .title("Blabla-blabla-blabla")
			    .icon("i32x32/core.png")
			    )
			)
		    )
		)
	    .icon("icon16.png")
	    .menuPad(new MenuPad()
		.title(localization.get("menuFile"))
		.item(new Submenu()
		    .title(localization.get("menuFileLanguage"))
		    .item(new MenuCheck()
			.title(localization.get("menuFileLanguageRussian"))
			.checked(ru))
		    .item(new MenuCheck()
			.title(localization.get("menuFileLanguageEnglish"))
			.checked(en)))
		.item(new MenuSeparator())
		.item(new MenuAction(){
			@Override public void onSelect() {
			    theme.exit();
			    }
			}
		    .title(localization.get("menuFileExit"))
		    .icon("i16x16/undo.png")))
	    .menuPad(new MenuPad()
		.title(localization.get("menuHelp"))
		.item(new MenuAction(){
			@Override public void onSelect() {
			    theme.inform( "This is test");
			    }
			}
		    .title(localization.get("menuHelpAbout"))
		    .icon("i16x16/messagebox_info.png")))
	.toolbar(new SuiteHorizontal()
		.item(new BigFlatButton(){
		    @Override public void onClick() {
			localization.current().set("English");
			}
		    }
		    .title(localization.get("menuFileLanguageEnglish"))
		    .icon("images/en.png")
		    )
		.item(new BigFlatButton(){
		    @Override public void onClick() {
			localization.current().set("Russian");
			}
		    }
		    .title(localization.get("menuFileLanguageRussian"))
		    .icon("images/ru.png")
		    )
		)
	    ;
	if (localization.current().get().equals("Russian")) {
            ru.set(true);
            } 
	else {
            en.set(true);
            }
        theme.log(0, "start");
	theme.startup(window);
    }
    static void setupLocalization(Localization localization){
        localization
	    .add("Russian", "applicationTitle", "Палитра компонентов")
	    .add("English", "applicationTitle", "Component palette")
	    .add("Russian", "menuFile", "Файл")
	    .add("English", "menuFile", "File")
	    .add("Russian", "menuFileLanguage", "Язык")
	    .add("English", "menuFileLanguage", "Language")
	    .add("Russian", "menuFileLanguageRussian", "Русский")
	    .add("English", "menuFileLanguageRussian", "Russian")
	    .add("Russian", "menuFileLanguageEnglish", "Английский")
	    .add("English", "menuFileLanguageEnglish", "English")
	    .add("Russian", "menuFileExit", "Выход")
	    .add("English", "menuFileExit", "Exit")
	    .add("Russian", "menuHelp", "Справка")
	    .add("English", "menuHelp", "Help")		
	    .add("Russian", "menuHelpAbout", "О программе")
	    .add("English", "menuHelpAbout", "About")
	    .add("Russian", "closeTabConfirmation", "Закрыть эту вкладку?")
	    .add("English", "closeTabConfirmation", "Do you want to close the tab?")
	    .add("Russian", "exitConfirmation", "Выйти из приложения?")
	    .add("English", "exitConfirmation", "Do you want top exit?");
    }
}
