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
import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.bind.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
	final BaseTheme theme = new crudfx2substance.SuTheme();
	//final BaseTheme theme = new crudfx2theme.Theme();
	final BaseWindow window = new BaseWindow("CrudfxExplorer.xml", theme){
            public void onClose() {
                theme.log(0, "done");
                }
            public boolean approveClosing() {
                return theme.confirm("Exit from app");
                }
            };
	final Localization localization=new Localization();
	//setupLocalization(localization);
	localization.current(window.configuration().find("properies").find("language").find("").asString("English"));
	setupLocalization(localization);
	//window.localization().current().bind(window.configuration().find("properies").find("language").find("").asString("English"));
	final BiValue<Boolean> en = new BiValue<Boolean>(false) {@Override public void onChange(Boolean checked) {if (checked) localization.current().set("English");}};
	final BiValue<Boolean> ru = new BiValue<Boolean>(true) {@Override public void onChange(Boolean checked) {if (checked) localization.current().set("Russian");}};
	new Calculation<Boolean>(ru, en) {
	    @Override public Boolean calculateFirst() { return !en.get();}
	    @Override public Boolean calculateSecond() { return !ru.get();} };
	window
	    .title(localization.get("applicationTitle"))
	    .footer(new Center()
		.body(new StandardButton(){
                        @Override public void onClick() {
                            if(theme.confirm( "Show dialog"))
                                theme.warn( "<html>This is <b>test</b>!</html>");
                            }
                        }
		    .title("Test button")
		    .icon("icon16.png")
		    )
		)
	    .body(new Center()
		.body(new StandardButton()
		    .title("Body Test button")
		    .icon("icon48.png")
		    )
		)
	    .icon("icon48.png")
	    .menu(new BiSet<MenuPad>()
		.add(new MenuPad()
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
		.add(new MenuPad()
		    .title(localization.get("menuHelp"))
		    .item(new MenuAction(){
			    @Override public void onSelect() {
				theme.inform( "This is test");
				}
			    }
			.title(localization.get("menuHelpAbout"))
			.icon("i16x16/messagebox_info.png")))
		)
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
	    /*.toolbar(new BiSet<ToolbarUnit>()
		.add(new ToolbarBigButton(){
			@Override public void onClick() {
			    localization.current().set("English");
			    }
			}
		    .icon("images/en.png")
		    .title(localization.get("menuFileLanguageEnglish")))
		.add(new ToolbarBigButton(){
			@Override public void onClick() {
			    localization.current().set("Russian");
			    }
			}
		    .icon("images/ru.png")
		    .title(localization.get("menuFileLanguageRussian")))
		)*/
	    ;
	if (localization.current().get().equals("Russian")) {
            ru.set(true);
            } 
	else {
            en.set(true);
            }
        theme.log(0, "start");
	theme.startup(window);
        /*final Ticker tt=new Ticker(){
            @Override public void onFinish() {
                    System.out.println("x: "+java.util.Calendar.getInstance().getTimeInMillis());
                    //restart(tt);
                    start();
                    }
                }
                .count(5)
                .delay(1000);
        new BiValue<Integer>(tt.current()){
            @Override
            public void onChange(Integer v){
                System.out.println(v+": "+java.util.Calendar.getInstance().getTimeInMillis());
                //if(v.intValue()==3)tt.stop();
            }
        };
        System.out.println("!: "+java.util.Calendar.getInstance().getTimeInMillis());
        tt.start();*/
        //tt.stop();
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
	    .add("English", "menuHelpAbout", "About");
    }
/*
    public static void _main(String[] args) {
	//BaseTheme theme = new crudfx2theme.Theme();
	BaseTheme theme = new crudfx2substance.SuTheme();
	final BaseWindow window = new BaseWindow("CrudfxExplorer.xml" //, new BiValue<String>("i16x16/package.png")
		, theme);
	//setupLocalization(window.localization());
	window.title().
		bind(window.localization().
		get("applicationTitle"));
	BiValue<String> status = new BiValue<String>(" 467674");
	window.localization().
		current().
		bind(window.configuration().
		find("properies").
		find("language").
		find("").
		asString("English"));
	//addMenu(window);
	//addToolbar(window);
	//addBody(window);
	//window.footer().set(new TextLabel(status));
	window.footer().
		set(new TextLabel().title("333"));
	theme.startup(window);
    }*/
/*
    public static void addBody(BaseWindow window) {
	Wood cfg = window.configuration().
		find("properies");
	window.body().
		set(new ColorFill(new BiValue<Color>(new Color(255, 0, 255, 125)), new BiValue<Widget>(
		new SplitLeftRight(cfg.find("split").
		find("").
		asInteger(100), composeTree(), new Tabs(new BiSet<TabPage>(new TabPage[]{
		    new TabPage(new BiValue<String>("Test1"), new BiValue<String>(), new BiValue<Widget>()), new TabPage(new BiValue<String>("Test2"), null, null), new TabPage(new BiValue<String>("Test3"), null, null)
		}))))));
    }
*/
    /*
    public static Widget composeTree() {
	Widget tree = new StandardTree(new BiSet<TreeItem>(new TreeItem[]{
		    new TreeLeaf(new BiValue<String>("Test1")) {

			@Override
			public void onClick() {
			    System.out.println("Test1");
			}
		    }, new TreeLeaf(new BiValue<String>("Test2")) {

		@Override
		public void onClick() {
		    System.out.println("Test2");
		}
	    }
		}));
	return tree;
    }
    */
/*
    public static void addToolbar(BaseWindow w) {
	final BaseWindow window = w;
	window.toolbar().
		add(
		new ToolbarUnit[]{
		    new ToolbarButton(new BiValue<String>("images/en.png"), window.
		    localization().
		    get("menuFileLanguageEnglish")) {

			@Override
			public void onClick() {
			    window.localization().
				    current().
				    set("English");
			}
		    }, new ToolbarButton(new BiValue<String>("images/ru.png"), window.
		    localization().
		    get("menuFileLanguageRussian")) {

		@Override
		public void onClick() {
		    window.localization().
			    current().
			    set("Russian");
		}
	    }, new ToolbarSeparator(), new ToolbarButton(new BiValue<String>("i16x16/messagebox_info.png"), new BiValue<String>("Help"))});
    }
*/
  /*  public static void addMenu(BaseWindow w) {
	final BaseWindow window = w;
	final BiValue<Boolean> en = new BiValue<Boolean>(false) {

	    @Override
	    public void onChange(Boolean checked) {
		if (checked) {
		    window.localization().
			    current().
			    set("English");
		}
	    }
	};
	final BiValue<Boolean> ru = new BiValue<Boolean>(true) {

	    @Override
	    public void onChange(Boolean checked) {
		if (checked) {
		    window.localization().
			    current().
			    set("Russian");
		}
	    }
	};
	new Calculation<Boolean>(ru, en) {

	    @Override
	    public Boolean calculateFirst() {
		return !en.get();
	    }

	    @Override
	    public Boolean calculateSecond() {
		return !ru.get();
	    }
	};
	if (window.localization().
		current().
		get().
		equals("Russian")) {
	    ru.set(true);
	} else {
	    en.set(true);
	}
	window.menu().
		add(
		new MenuPad[]{
		    new MenuPad(window.localization().
		    get("menuFile"), new MenuUnit[]{
			new Submenu(window.localization().
			get("menuFileLanguage"), new MenuUnit[]{
			    new MenuCheck(en, window.localization().
			    get("menuFileLanguageEnglish")), new MenuCheck(ru, window.
			    localization().
			    get("menuFileLanguageRussian"))}), new MenuSeparator(), new MenuAction(new BiValue<String>("i16x16/undo.png"), new BiValue<String>("Exit")) {

		    @Override
		    public void onSelect() {
			System.exit(0);
		    }
		}}),
		    new MenuPad(window.localization().
		    get("menuHelp"), new MenuUnit[]{
			new MenuAction(new BiValue<String>("i16x16/messagebox_info.png"), window.
			localization().
			get("menuHelpAbout")) {

			    @Override
			    public void onSelect() {
				//
			    }
			}})});
    }*/

  /*  public static void setupLocalization(GroupSet<String> localization) {
	localization.add("Russian", "applicationTitle", "Палитра компонентов");
	localization.add("English", "applicationTitle", "Component palette");
	localization.add("Russian", "menuFile", "Файл");
	localization.add("English", "menuFile", "File");
	localization.add("Russian", "menuHelp", "Справка");
	localization.add("English", "menuHelp", "Help");
	localization.add("Russian", "menuFileLanguage", "Язык");
	localization.add("English", "menuFileLanguage", "language");
	localization.add("Russian", "menuFileLanguageRussian", "Русский");
	localization.add("English", "menuFileLanguageRussian", "Russian");
	localization.add("Russian", "menuFileLanguageEnglish", "Английский");
	localization.add("English", "menuFileLanguageEnglish", "English");
	localization.add("Russian", "menuHelpAbout", "О программе");
	localization.add("English", "menuHelpAbout", "About");
    }*/
}
