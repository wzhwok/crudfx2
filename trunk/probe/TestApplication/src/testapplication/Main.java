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
import javax.swing.*;

public class Main {
static TabPage infoPage=null;
    public static void main(String[] args) {
	//final BaseTheme theme = new crudfx2theme.Theme(){
	final BaseTheme theme = new crudfx2substance.SuTheme(){
            @Override public ImageIcon icon(String path) {
                ImageIcon ii= new ImageIcon(path);
                if(ii.getIconWidth()<0){
                    ii=crudfxicons.CRUDfxIcons.icon(path);
                    }
                return ii;
                }
	    };
	final Localization localization=new Localization();
	setupLocalization(localization);
	final BaseWindow window = new BaseWindow("CrudfxExplorer.xml", theme){
	    @Override public void onClose() {
                theme.log(0, "done");
                }
	    @Override public boolean approveClosing() {
                return theme.confirm(localization.get("exitConfirmation").get());
                }
            };
	localization.current(window.configuration().find("properies").find("language").find("").asString("English"));
	window
	    .title(localization.get("applicationTitle"))
	    .footer(createFooter(localization,theme))
	    .body(createBody(localization,theme))
	    .icon(crudfxicons.CRUDfxIcons.i32Devices_computer_icon)
	    .menuPad(createFileMenu(localization,theme))
	    .menuPad(createHelpMenu(localization,theme))
	    .toolbar(createToolbar(localization,theme));	
        theme.log(0, "start");
	theme.startup(window);
    }
    static StandardTree createTree(Localization localization,BaseTheme theme,Tabs tabs){
	final BaseTheme ftheme=theme;
	final Localization flocalization=localization;
	final Tabs ftabs=tabs;
	//System.out.println(crudfxicons.CRUDfxIcons.i16Actions_document_decrypt_icon);
	return new StandardTree()
		    .treeItem(new TreeLeaf()
			.title("leaf 1")
			.icon(crudfxicons.CRUDfxIcons.i16Actions_document_decrypt_icon)
		//"i16x16/filenew.png")
			)
		    .treeItem(new TreeBranch()
			.title("branch 1")
                        .icon(crudfxicons.CRUDfxIcons.i16Places_folder_icon)
                //"i16x16/folder_orange.png")
                        .openedIcon(crudfxicons.CRUDfxIcons.i16Places_folder_documents_icon)
			.treeItem(new TreeLeaf()
			    .title("sub leaf")
                            .icon(crudfxicons.CRUDfxIcons.i16Actions_edit_delete_icon)
			    )
			)
		    .treeItem(new TreeBranch()
			.title(localization.get("treeMenuIcons"))
                        .icon(crudfxicons.CRUDfxIcons.i16Places_folder_icon)
                        .openedIcon(crudfxicons.CRUDfxIcons.i16Places_folder_documents_icon)
			.treeItem(new TreeLeaf()
			    .title("sub leaf")
                            .icon(crudfxicons.CRUDfxIcons.i16Actions_edit_delete_icon)
			    )
			)
		    .treeItem(new TreeLeaf(){
			    @Override public void onClick(){
				//System.out.println("click");
				if(infoPage==null){
				    //System.out.println("create");
				    infoPage=new TabPage(){
					@Override public boolean approveClosing() {
					    return ftheme.confirm(flocalization.get("closeTabConfirmation").get());
					    }
					@Override public void onClose() {
					    //ftheme.log(0, "tab closed");
					    }
					}
				    .title("info")
				    .body(new StandardLabel()
					.title("Blabla-blabla-blabla")
					.icon(crudfxicons.CRUDfxIcons.i128Actions_view_statistics_icon)
					);
				    }
				    ftabs.current(infoPage);
				}
			    }
			.title("add test page")
                        .icon(crudfxicons.CRUDfxIcons.i16Status_user_invisible_icon)
			);
    }
    static Widget createBody(Localization localization,BaseTheme theme){
	final BaseTheme ftheme=theme;
	final Localization flocalization=localization;
	final Tabs tabs=new Tabs()		    
		    .page(new TabPage()
			.title("Test2")
			.body(new StandardLabel()
			    .title("2")
			    .icon(crudfxicons.CRUDfxIcons.i128Apps_system_users_icon)
			    )
			)
		    .page(new TabPage()
			.title("Test3")
			.body(new StandardLabel()
			    .title("333")
			    .icon(crudfxicons.CRUDfxIcons.i128Actions_edit_select_all_icon)
			    )
			)
		    .current(new TabPage()
			.title("Crowd")
			.body(new SuiteCrowd())
			)
		    ;
	return new SplitLeftRight()
		.left(createTree(localization,theme,tabs))
		.right(tabs);
	}
    static Widget createFooter(Localization localization,BaseTheme theme){
	return new StandardLabel()
		.title("...");
	}
    static Widget createToolbar(Localization localization,BaseTheme theme){
	final Localization flocalization=localization;
	return new SuiteHorizontal()
	    .item(new BigFlatButton(){
		@Override public void onClick() {
		    flocalization.current().set("English");
		    }
		}
		.title(localization.get("menuFileLanguageEnglish"))
		.icon("images/en.png")
		)
	    .item(new BigFlatButton(){
		@Override public void onClick() {
		    flocalization.current().set("Russian");
		    }
		}
		.title(localization.get("menuFileLanguageRussian"))
		.icon("images/ru.png")
		);
	}
    static MenuPad createHelpMenu(Localization localization,BaseTheme theme){
	final BaseTheme ftheme=theme;
	return new MenuPad()
	    .title(localization.get("menuHelp"))
	    .item(new MenuAction(){
		    @Override public void onSelect() {
			ftheme.inform( "This is test");
			}
		    }
		.title(localization.get("menuHelpAbout"))
		.icon(crudfxicons.CRUDfxIcons.i16Actions_edit_paste_icon));
	}
    static MenuPad createFileMenu(Localization localization,BaseTheme theme){
	final BaseTheme ftheme=theme;
	final Localization flocalization=localization;
	//final BiValue<String> current=new BiValue<String> (localization.current());
	final BiValue<Boolean> en = new BiValue<Boolean>(false) {
	    @Override public void onChange(Boolean checked) {
		if (checked) flocalization.current().set("English");
		}
	    };
	final BiValue<Boolean> ru = new BiValue<Boolean>(true) {
	    @Override public void onChange(Boolean checked) {
		if (checked) flocalization.current().set("Russian");
		}
	    };
	new Calculation<Boolean>(ru, en) {
	    @Override public Boolean calculateFirst() { return !en.get();}
	    @Override public Boolean calculateSecond() { return !ru.get();} };
	new BiValue<String>(flocalization.current()){
	    @Override public void onChange(String key) {
		en.set(key.equals("English"));
		}
	    };
	return new MenuPad()
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
			ftheme.exit();
			}
		    }
		.title(localization.get("menuFileExit"))
		.icon(crudfxicons.CRUDfxIcons.i16Actions_page_zoom_icon));	
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
	    .add("English", "exitConfirmation", "Do you want to exit?")
	    .add("Russian", "treeMenuIcons", "Иконки")
	    .add("English", "treeMenuIcons", "Icons");
    }
}
