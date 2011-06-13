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
import testapplication.pages.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.bind.*;
import java.awt.*;
import javax.swing.*;
import crudfxicons.*;

public class Main {
    //static TabPage infoPage=null;
    /*static TabPage icons16=null;
    static TabPage icons32=null;
    static TabPage icons128=null;
    static TabPage iconsAll=null;*/
    public static void main(String[] args) {
	//final BaseTheme theme = new crudfx2theme.Theme(){
	final BaseTheme theme = new crudfx2substance.SuTheme(){
            @Override public ImageIcon icon(String path) {
                ImageIcon ii= new ImageIcon(path);
                if(ii.getIconWidth()<0){
                    ii=CRUDfxIcons.icon(path);
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
	    .icon(CRUDfxIcons.i32_computer)
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
	return new StandardTree()
                    .treeItem(new TreeBranch()
			.title("Visual components")
			.treeItem(new TreeBranch()
			    .title("General controls")
                            .treeItem(new TreeLeaf(){
                                    @Override public void onClick(){
                                        ftabs.current(Alert.get(ftheme));
                                        }
                                    }
                                .title("Alert")
                                .icon(CRUDfxIcons.i16_system)
                                )
			    )
			) 
		    .treeItem(new TreeBranch()
			.title(localization.get("treeMenuIcons"))
                        .icon(CRUDfxIcons.i16_folder)
                        .openedIcon(CRUDfxIcons.i16_folder_documents)
			.treeItem(new TreeLeaf(){
				@Override public void onClick(){
				    ftabs.current(Icons16.get());
				    }
				}
			    .title("16 x 16")
                            .icon(CRUDfxIcons.i16_copy)
			    )
                        .treeItem(new TreeLeaf(){
                                    @Override public void onClick(){
                                        ftabs.current(Icons32.get());
                                        }
                                    }
                                .title("32 x 32")
                                .icon(CRUDfxIcons.i16_copy)
                                )
                        .treeItem(new TreeLeaf(){
                                    @Override public void onClick(){
                                        ftabs.current(Icons128.get());
                                        }
                                    }
                                .title("128 x 128")
                                .icon(CRUDfxIcons.i16_copy)
                                )
			)
		    .treeItem(new TreeLeaf(){
			    @Override public void onClick(){
				/*if(infoPage==null){
				    infoPage=new TabPage(){
					@Override public boolean approveClosing() {
					    return false;//ftheme.confirm(flocalization.get("closeTabConfirmation").get());
					    }
					@Override public void onClose() {
					    //
					    }
					}
				    .title("Information")
				    .body(new StandardLabel()
					.title("Blabla-blabla-blabla")
					.icon(CRUDfxIcons.i128_statistics)
					);
				    }
				    ftabs.current(infoPage);*/
                                ftabs.current(Info.get());
				}
			    }
			.title("Information")
                        .icon(CRUDfxIcons.i16_favorites)
			);
    }
    static Widget createBody(Localization localization,BaseTheme theme){
	final BaseTheme ftheme=theme;
	final Localization flocalization=localization;
	final Tabs tabs=new Tabs()	
                .page(Info.get());
                
                
		   /* .page(new TabPage()
			.title("Test2")
			.body(new StandardLabel()
			    .title("2")
			    .icon(CRUDfxIcons.i128_users)
			    )
			)
		    .page(new TabPage()
			.title("Test3")
			.body(new StandardLabel()
			    .title("333")
			    .icon(CRUDfxIcons.i128_select_all)
			    )
			)
		    .current(new TabPage()
			.title("Crowd")*/
			/*.body(new SuiteCrowd()
			    .item(new StandardButton()
				.title("123")
				)
			    .item(new StandardButton()
				.title("2222")
				)
			    .item(new StandardButton()
				.title("33333")
				)
			    .item(new StandardButton()
				.title("4444")
				)
			    .item(new StandardButton()
				.title("555")
				)
			    .item(new StandardButton()
				.title("66666")
				)
			    .item(new StandardButton()
				.title("77")
				)
			    )*/
			//)
		    //;
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
		.icon(CRUDfxIcons.i16_paste));
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
		.icon(CRUDfxIcons.i16_zoom));	
    }
    /*static TabPage getPageIcons32(){
	if(icons32==null){
	    icons32=new TabPage()
		.title("32x32")
		    .body(new SuiteCrowd()           
			.item(new StandardLabel().title("i32_calendar  ").icon(CRUDfxIcons.i32_calendar))
                        .item(new StandardLabel().title("i32_computer  ").icon(CRUDfxIcons.i32_computer))
                        .item(new StandardLabel().title("i32_copy  ").icon(CRUDfxIcons.i32_copy))
                        .item(new StandardLabel().title("i32_cut  ").icon(CRUDfxIcons.i32_cut))
                        .item(new StandardLabel().title("i32_database  ").icon(CRUDfxIcons.i32_database))
                        .item(new StandardLabel().title("i32_decrypt  ").icon(CRUDfxIcons.i32_decrypt))
                        .item(new StandardLabel().title("i32_delete  ").icon(CRUDfxIcons.i32_delete))
                        .item(new StandardLabel().title("i32_down  ").icon(CRUDfxIcons.i32_down))
                        .item(new StandardLabel().title("i32_edit  ").icon(CRUDfxIcons.i32_edit))
                        .item(new StandardLabel().title("i32_favorites  ").icon(CRUDfxIcons.i32_favorites))
                        .item(new StandardLabel().title("i32_folder  ").icon(CRUDfxIcons.i32_folder))
                        .item(new StandardLabel().title("i32_folder_documents  ").icon(CRUDfxIcons.i32_folder_documents))
                        .item(new StandardLabel().title("i32_internet  ").icon(CRUDfxIcons.i32_internet))
                        .item(new StandardLabel().title("i32_message  ").icon(CRUDfxIcons.i32_message))
                        .item(new StandardLabel().title("i32_next  ").icon(CRUDfxIcons.i32_next))
                        .item(new StandardLabel().title("i32_ok_apply  ").icon(CRUDfxIcons.i32_ok_apply))
                        .item(new StandardLabel().title("i32_optical_data  ").icon(CRUDfxIcons.i32_optical_data))
                        .item(new StandardLabel().title("i32_password  ").icon(CRUDfxIcons.i32_password))
                        .item(new StandardLabel().title("i32_paste  ").icon(CRUDfxIcons.i32_paste))
                        .item(new StandardLabel().title("i32_phone  ").icon(CRUDfxIcons.i32_phone))
                        .item(new StandardLabel().title("i32_previous  ").icon(CRUDfxIcons.i32_previous))
                        .item(new StandardLabel().title("i32_printer  ").icon(CRUDfxIcons.i32_printer))
                        .item(new StandardLabel().title("i32_quickopen  ").icon(CRUDfxIcons.i32_quickopen))
                        .item(new StandardLabel().title("i32_receive  ").icon(CRUDfxIcons.i32_receive))
                        .item(new StandardLabel().title("i32_redo  ").icon(CRUDfxIcons.i32_redo))
                        .item(new StandardLabel().title("i32_refresh  ").icon(CRUDfxIcons.i32_refresh))
                        .item(new StandardLabel().title("i32_select_all  ").icon(CRUDfxIcons.i32_select_all))
                        .item(new StandardLabel().title("i32_statistics  ").icon(CRUDfxIcons.i32_statistics))
                        .item(new StandardLabel().title("i32_system  ").icon(CRUDfxIcons.i32_system))
                        .item(new StandardLabel().title("i32_undo  ").icon(CRUDfxIcons.i32_undo))
                        .item(new StandardLabel().title("i32_up  ").icon(CRUDfxIcons.i32_up))
                        .item(new StandardLabel().title("i32_user_away  ").icon(CRUDfxIcons.i32_user_away))
                        .item(new StandardLabel().title("i32_user_invisible  ").icon(CRUDfxIcons.i32_user_invisible))
                        .item(new StandardLabel().title("i32_user_online  ").icon(CRUDfxIcons.i32_user_online))
                        .item(new StandardLabel().title("i32_users  ").icon(CRUDfxIcons.i32_users))
                        .item(new StandardLabel().title("i32_warning  ").icon(CRUDfxIcons.i32_warning))
                        .item(new StandardLabel().title("i32_wireless  ").icon(CRUDfxIcons.i32_wireless))
                        .item(new StandardLabel().title("i32_zoom  ").icon(CRUDfxIcons.i32_zoom))
			);
	    }
	return icons32;
	}
    static TabPage getPageIcons128(){
	if(icons128==null){
	    icons128=new TabPage()
		.title("128x128")
		    .body(new SuiteCrowd()           
			.item(new StandardLabel().title("i128_calendar  ").icon(CRUDfxIcons.i128_calendar))
                        .item(new StandardLabel().title("i128_computer  ").icon(CRUDfxIcons.i128_computer))
                        .item(new StandardLabel().title("i128_copy  ").icon(CRUDfxIcons.i128_copy))
                        .item(new StandardLabel().title("i128_cut  ").icon(CRUDfxIcons.i128_cut))
                        .item(new StandardLabel().title("i128_database  ").icon(CRUDfxIcons.i128_database))
                        .item(new StandardLabel().title("i128_decrypt  ").icon(CRUDfxIcons.i128_decrypt))
                        .item(new StandardLabel().title("i128_delete  ").icon(CRUDfxIcons.i128_delete))
                        .item(new StandardLabel().title("i128_down  ").icon(CRUDfxIcons.i128_down))
                        .item(new StandardLabel().title("i128_edit  ").icon(CRUDfxIcons.i128_edit))
                        .item(new StandardLabel().title("i128_favorites  ").icon(CRUDfxIcons.i128_favorites))
                        .item(new StandardLabel().title("i128_folder  ").icon(CRUDfxIcons.i128_folder))
                        .item(new StandardLabel().title("i128_folder_documents  ").icon(CRUDfxIcons.i128_folder_documents))
                        //.item(new StandardLabel().title("i128_folder_open  ").icon(CRUDfxIcons.i128_folder_open))
                        .item(new StandardLabel().title("i128_internet  ").icon(CRUDfxIcons.i128_internet))
                        .item(new StandardLabel().title("i128_message  ").icon(CRUDfxIcons.i128_message))
                        .item(new StandardLabel().title("i128_next  ").icon(CRUDfxIcons.i128_next))
                        .item(new StandardLabel().title("i128_ok_apply  ").icon(CRUDfxIcons.i128_ok_apply))
                        .item(new StandardLabel().title("i128_optical_data  ").icon(CRUDfxIcons.i128_optical_data))
                        .item(new StandardLabel().title("i128_password  ").icon(CRUDfxIcons.i128_password))
                        .item(new StandardLabel().title("i128_paste  ").icon(CRUDfxIcons.i128_paste))
                        .item(new StandardLabel().title("i128_phone  ").icon(CRUDfxIcons.i128_phone))
                        .item(new StandardLabel().title("i128_previous  ").icon(CRUDfxIcons.i128_previous))
                        .item(new StandardLabel().title("i128_printer  ").icon(CRUDfxIcons.i128_printer))
                        .item(new StandardLabel().title("i128_quickopen  ").icon(CRUDfxIcons.i128_quickopen))
                        .item(new StandardLabel().title("i128_receive  ").icon(CRUDfxIcons.i128_receive))
                        .item(new StandardLabel().title("i128_redo  ").icon(CRUDfxIcons.i128_redo))
                        .item(new StandardLabel().title("i128_refresh  ").icon(CRUDfxIcons.i128_refresh))
                        .item(new StandardLabel().title("i128_select_all  ").icon(CRUDfxIcons.i128_select_all))
                        .item(new StandardLabel().title("i128_statistics  ").icon(CRUDfxIcons.i128_statistics))
                        .item(new StandardLabel().title("i128_system  ").icon(CRUDfxIcons.i128_system))
                        .item(new StandardLabel().title("i128_undo  ").icon(CRUDfxIcons.i128_undo))
                        .item(new StandardLabel().title("i128_up  ").icon(CRUDfxIcons.i128_up))
                        .item(new StandardLabel().title("i128_user_away  ").icon(CRUDfxIcons.i128_user_away))
                        .item(new StandardLabel().title("i128_user_invisible  ").icon(CRUDfxIcons.i128_user_invisible))
                        .item(new StandardLabel().title("i128_user_online  ").icon(CRUDfxIcons.i128_user_online))
                        .item(new StandardLabel().title("i128_users  ").icon(CRUDfxIcons.i128_users))
                        .item(new StandardLabel().title("i128_warning  ").icon(CRUDfxIcons.i128_warning))
                        .item(new StandardLabel().title("i128_wireless  ").icon(CRUDfxIcons.i128_wireless))
                        .item(new StandardLabel().title("i128_zoom  ").icon(CRUDfxIcons.i128_zoom))
			);
	    }
	return icons128;
	}
    static TabPage getPageIcons16(){
	if(icons16==null){
	    icons16=new TabPage()
		.title("16x16")
		//.body(new ScrollBox()
		    .body(new SuiteCrowd()           
			.item(new StandardLabel().title("i16_calendar  ").icon(CRUDfxIcons.i16_calendar))
                        .item(new StandardLabel().title("i16_computer  ").icon(CRUDfxIcons.i16_computer))
                        .item(new StandardLabel().title("i16_copy  ").icon(CRUDfxIcons.i16_copy))
                        .item(new StandardLabel().title("i16_cut  ").icon(CRUDfxIcons.i16_cut))
                        .item(new StandardLabel().title("i16_database  ").icon(CRUDfxIcons.i16_database))
                        .item(new StandardLabel().title("i16_decrypt  ").icon(CRUDfxIcons.i16_decrypt))
                        .item(new StandardLabel().title("i16_delete  ").icon(CRUDfxIcons.i16_delete))
                        .item(new StandardLabel().title("i16_down  ").icon(CRUDfxIcons.i16_down))
                        .item(new StandardLabel().title("i16_edit  ").icon(CRUDfxIcons.i16_edit))
                        .item(new StandardLabel().title("i16_favorites  ").icon(CRUDfxIcons.i16_favorites))
                        .item(new StandardLabel().title("i16_folder  ").icon(CRUDfxIcons.i16_folder))
                        .item(new StandardLabel().title("i16_folder_documents  ").icon(CRUDfxIcons.i16_folder_documents))
                        .item(new StandardLabel().title("i16_internet  ").icon(CRUDfxIcons.i16_internet))
                        .item(new StandardLabel().title("i16_message  ").icon(CRUDfxIcons.i16_message))
                        .item(new StandardLabel().title("i16_next  ").icon(CRUDfxIcons.i16_next))
                        .item(new StandardLabel().title("i16_ok_apply  ").icon(CRUDfxIcons.i16_ok_apply))
                        .item(new StandardLabel().title("i16_optical_data  ").icon(CRUDfxIcons.i16_optical_data))
                        .item(new StandardLabel().title("i16_password  ").icon(CRUDfxIcons.i16_password))
                        .item(new StandardLabel().title("i16_paste  ").icon(CRUDfxIcons.i16_paste))
                        .item(new StandardLabel().title("i16_phone  ").icon(CRUDfxIcons.i16_phone))
                        .item(new StandardLabel().title("i16_previous  ").icon(CRUDfxIcons.i16_previous))
                        .item(new StandardLabel().title("i16_printer  ").icon(CRUDfxIcons.i16_printer))
                        .item(new StandardLabel().title("i16_quickopen  ").icon(CRUDfxIcons.i16_quickopen))
                        .item(new StandardLabel().title("i16_receive  ").icon(CRUDfxIcons.i16_receive))
                        .item(new StandardLabel().title("i16_redo  ").icon(CRUDfxIcons.i16_redo))
                        .item(new StandardLabel().title("i16_refresh  ").icon(CRUDfxIcons.i16_refresh))
                        .item(new StandardLabel().title("i16_select_all  ").icon(CRUDfxIcons.i16_select_all))
                        .item(new StandardLabel().title("i16_statistics  ").icon(CRUDfxIcons.i16_statistics))
                        .item(new StandardLabel().title("i16_system  ").icon(CRUDfxIcons.i16_system))
                        .item(new StandardLabel().title("i16_undo  ").icon(CRUDfxIcons.i16_undo))
                        .item(new StandardLabel().title("i16_up  ").icon(CRUDfxIcons.i16_up))
                        .item(new StandardLabel().title("i16_user_away  ").icon(CRUDfxIcons.i16_user_away))
                        .item(new StandardLabel().title("i16_user_invisible  ").icon(CRUDfxIcons.i16_user_invisible))
                        .item(new StandardLabel().title("i16_user_online  ").icon(CRUDfxIcons.i16_user_online))
                        .item(new StandardLabel().title("i16_users  ").icon(CRUDfxIcons.i16_users))
                        .item(new StandardLabel().title("i16_warning  ").icon(CRUDfxIcons.i16_warning))
                        .item(new StandardLabel().title("i16_wireless  ").icon(CRUDfxIcons.i16_wireless))
                        .item(new StandardLabel().title("i16_zoom  ").icon(CRUDfxIcons.i16_zoom))
			)
		    //)
		;
	    }
	return icons16;
	}*/
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
	    .add("English", "treeMenuIcons", "Icons")
	    .add("Russian", "treeMenuIconsAll", "Все размеры")
	    .add("English", "treeMenuIconsAll", "All sizes")
	    ;
    }
}
