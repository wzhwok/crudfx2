package crudfx2.core.view;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;

public abstract class BaseTheme {

    public abstract void startup(BaseWindow win);
    public abstract void exit();
    public abstract BiTree loadConfiguration(String key);
    public abstract void saveConfiguration(String key, BiTree cfg);
    public abstract boolean confirm(String message);
    public abstract void warn(String message);
    public abstract void inform(String message);
    public abstract void log(int key, String message);
    public abstract void hide();
    public abstract String text(String path, String encoding);
}
