package crudfx2theme.nuvola;

import javax.swing.*;
import java.io.*;
import java.io.*;
import java.awt.*;
import javax.imageio.*;

public class IconLoader {

    private static IconLoader me = null;

    private static IconLoader it() {
        if (me == null) {
            me = new IconLoader();
        }
        return me;
    }

    public static Image stream(String s) {
        InputStream is = null;
        Image image = null;
        try {
            is = IconLoader.class.getResourceAsStream(s);
            image = ImageIO.read(is);

        } catch (Throwable t) {
            t.printStackTrace();
        }
        return image;
    }

    public static ImageIcon icon2(String path) {
        ImageIcon icon = null;
        try {
            File f = new File(path);
            //System.out.println("load "+f.getAbsolutePath());
            if (f.exists()) {
                //System.out.println("not found "+f.getAbsolutePath());
                icon = new ImageIcon(path);
            } else {
                icon = new ImageIcon(it().getClass().getResource(path));
            }
            //icon = new ImageIcon(it().getClass().getResource(path));
        } catch (Throwable t) {
            //t.printStackTrace();
            //System.out.println("load default");
            icon = new ImageIcon(it().getClass().getResource("i16x16/player_stop.png"));
        }
        return icon;
    }
}
