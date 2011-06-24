package crudfx2substance;

import javax.swing.*;
import crudfx2.core.gui.*;
import org.pushingpixels.substance.api.*;
import org.pushingpixels.substance.api.skin.*;

public class SuTheme extends crudfx2theme.Theme {

    public SuTheme() {
	super();
    }
    void setSkin(SubstanceLookAndFeel laf, BaseWindow win) {
	String sk = win.configuration().find("skin").find("")
		.asString("org.pushingpixels.substance.api.skin.BusinessBlueSteelSkin").get();
		//.asString("org.pushingpixels.substance.api.skin.OfficeBlue2007Skin").get();
	try {
	    laf.setSkin(sk);
	} catch (Throwable t) {
	    this.log(0, t);
	}
    }
    public void beforeStartup(BaseWindow win) {
	//log(0,"test");
	//try {
	    //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
	    try {
		UIManager.setLookAndFeel(laf);
	    } catch (Throwable t) {
		//t.printStackTrace();
		log(0,t);
	    }

	    SubstanceLookAndFeel.registerSkinChangeListener(new SkinChangeListener() {

		@Override
		public void skinChanged() {
		    String nm = SubstanceLookAndFeel.getCurrentSkin().getClass().getCanonicalName();
		    mainwin.configuration().find("skin").find("").asString("").set(nm);
		    log(0,"skinChanged: "+nm);
		    if (nativeMainWindow != null) {
			SwingUtilities.updateComponentTreeUI(nativeMainWindow);
			//nativeMainWindow.update(null);
		    }
		}
	    });
	    setSkin(laf, mainwin);
	    UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JDialog.setDefaultLookAndFeelDecorated(true);
	//} catch (Throwable t) {
	   // t.printStackTrace();
	  //  log(0,t);
	//}
    }
    /*
    public void ___startup(BaseWindow _w) {
	mainwin = _w;
	final SuTheme me = this;
	SwingUtilities.invokeLater(new Runnable() {

	    public void run() {
		SubstanceLookAndFeel laf = new SubstanceGeminiLookAndFeel();
		try {
		    UIManager.setLookAndFeel(laf);
		} catch (Throwable t) {
		    t.printStackTrace();
		}

		SubstanceLookAndFeel.registerSkinChangeListener(new SkinChangeListener() {

		    @Override
		    public void skinChanged() {
			String nm = SubstanceLookAndFeel.getCurrentSkin().getClass().getCanonicalName();
			mainwin.configuration().find("skin").find("").asString("").set(nm);
			
		    }
		});
		setSkin(laf, mainwin);
		UIManager.put(SubstanceLookAndFeel.SHOW_EXTRA_WIDGETS, Boolean.TRUE);
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		nativeMainWindow = new crudfx2theme.NativeMainWindow(mainwin, me);
		nativeMainWindow.setVisible(true);
	    }
	});
    }*/
}
