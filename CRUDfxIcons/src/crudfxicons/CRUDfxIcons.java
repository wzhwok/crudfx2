package crudfxicons;

import javax.swing.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class CRUDfxIcons {

    public static String i128Actions_edit_undo_icon = "i128Actions-edit-undo-icon.png";/*
    128Categories-applications-internet-icon.png
    128Categories-applications-system-icon.png
    128Devices-phone-icon.png
    128Places-folder-documents-icon.png
    128Places-folder-icon.png
    128Places-mail-message-icon.png
    128Status-user-busy-icon.png
    16Actions-edit-undo-icon.png
    16Categories-applications-internet-icon.png
    16Categories-applications-system-icon.png
    16Devices-phone-icon.png
    16Places-folder-documents-icon.png
    16Places-folder-icon.png
    16Places-mail-message-icon.png
    16Status-user-busy-icon.png
    32Actions-edit-undo-icon.png
    32Categories-applications-internet-icon.png
    32Categories-applications-system-icon.png
    32Devices-phone-icon.png
    32Places-folder-documents-icon.png
    32Places-folder-icon.png
    32Places-mail-message-icon.png
    32Status-user-busy-icon.png*/

    private static CRUDfxIcons me = null;
    private static CRUDfxIcons it() {
	if (me == null) {
	    me = new CRUDfxIcons();
	}
	return me;
    }
    public static ImageIcon icon(String path) {
	ImageIcon icon = null;
	try {
	    //File f = new File(path);
	    //System.out.println("load "+f.getAbsolutePath());
	    //if (f.exists()) {
	    //System.out.println("not found "+f.getAbsolutePath());
	    //icon = new ImageIcon(path);
	    //} else {
	    icon = new ImageIcon(it().getClass().getResource(path));
	    //}
	    //icon = new ImageIcon(it().getClass().getResource(path));
	} catch (Throwable t) {
	    //t.printStackTrace();
	    //System.out.println("load default");
	    icon = new ImageIcon(it().getClass().getResource("icons/16Status-user-busy-icon.png"));
	}
	return icon;
    }
}
