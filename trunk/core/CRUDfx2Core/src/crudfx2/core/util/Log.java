package crudfx2.core.util;

public class Log {
    public static void log(String msg) {
        System.out.print(new java.util.Date());
        System.out.print(": ");
        System.out.println(msg);
    }

    public static void log(Throwable t) {
        log(t.getMessage());
        t.printStackTrace(System.out);
    }
}
