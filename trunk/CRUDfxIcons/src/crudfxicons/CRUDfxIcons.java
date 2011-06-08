package crudfxicons;

import javax.swing.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class CRUDfxIcons {

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
