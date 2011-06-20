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
import java.io.*;
import java.util.*;

public class Main {
    //static TabPage infoPage=null;
    /*static TabPage icons16=null;
    static TabPage icons32=null;
    static TabPage icons128=null;
    static TabPage iconsAll=null;*/
    public static void main(String[] args) {
	final BaseTheme theme = new crudfx2theme.Theme(){
	//final BaseTheme theme = new crudfx2substance.SuTheme(){
            @Override public ImageIcon icon(String path) {
                ImageIcon ii= super.icon(path);                
		if(ii.getIconWidth()<0){
                    ii=CRUDfxIcons.icon(path);
                    }
		if(ii==null){
		    try{
			ii = new ImageIcon(Main.class.getResource(path));
			}
		    catch(Throwable t){
			ii=CRUDfxIcons.icon("icons/16Status-dialog-warning-icon.png");
			}
                    }
                return ii;
                }
	    @Override public String text(String path, String encoding) {
		//System.out.println("path: "+path);
		String txt=super.text(path, encoding);
		//System.out.println("txt: "+txt);
		if(txt==null){
		    InputStream f=Main.class.getResourceAsStream(path);
		    ByteArrayOutputStream b = new ByteArrayOutputStream();
		    int n;
		    try{
			while ((n = f.read()) != -1) {
			    b.write(n);
			    }
			f.close();
			txt = new String(b.toByteArray(), encoding);
			//System.out.println("txt2: "+txt);
			}
		    catch(Throwable t){
			log(0,t);
			}
		    }
		return txt;
		}
	    };
	//String ss=theme.text("pages/info.html", "UTF-8");
	//System.out.println(ss);
	final Localization localization=new Localization();
	Strings.setupLocalization(localization);
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
	    .icon(CRUDfxIcons.i32_system)
	    .menuPad(createMenuFile(localization,theme))
	    .menuPad(createMenuHelp(localization,theme))
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
		.title("System")
		.treeItem(new TreeLeaf(){
			@Override public void onClick(){
			    ftabs.current(ToTray.get(ftheme));
			    }
			}
		    .title("System tray")
		    .icon(CRUDfxIcons.i16_system)
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
			ftabs.current(Info.get(ftheme));
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
                .page(Info.get(ftheme));
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
    static MenuPad createMenuHelp(Localization localization,BaseTheme theme){
	final BaseTheme ftheme=theme;
	return new MenuPad()
	    .title(localization.get("menuHelp"))
	    .item(new MenuAction(){
		    @Override public void onSelect() {
			ftheme.inform( "<html><h1>Hello</h1><p>This is <strong>just</strong> a test.</p></html>");
			}
		    }
		.title(localization.get("menuHelpAbout"))
		.icon(CRUDfxIcons.i16_information));
	}
    static MenuPad createMenuFile(Localization localization,BaseTheme theme){
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
		.icon(CRUDfxIcons.i16_undo));	
    }
}
