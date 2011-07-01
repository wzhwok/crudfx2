package crudfx2.core.bind;

import java.util.Calendar;

public class Ticker {

    private BiNumber _count = new BiNumber(0.0);
    private BiNumber _delay = new BiNumber(0.0);
    private BiNumber _current = new BiNumber(0.0);
    private boolean _stopFlag = false;
    private boolean _workFlag = false;

    public BiNumber count() {
        return _count;
    }

    public Ticker count(double n) {
        count().set(n);
        return this;
    }

    public Ticker count(BiNumber n) {
        count().bind(n);
        return this;
    }

    public BiNumber delay() {
        return _delay;
    }

    public Ticker delay(double n) {
        delay().set(n);
        return this;
    }

    public Ticker delay(BiNumber n) {
        delay().bind(n);
        return this;
    }

    public BiNumber current() {
        return _current;
    }

    public Ticker() {
    }

    public void start() {
        Thread t = new Thread() {

            public void run() {
                long prev = Calendar.getInstance().getTimeInMillis();
                long step = (long) (delay().get().intValue());
                long current;
                _workFlag = true;
                _stopFlag = false;
                current().set(0.0);
                while (!_stopFlag) {
                    current = Calendar.getInstance().getTimeInMillis();
                    if (prev < current - step) {
                        if (current().get() >= count().get() - 1) {
                            break;
                        }
                        prev = prev + step;
                        current().set(current().get() + 1);
                    }
                    try {
                        sleep(40);
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
                _workFlag = false;
                onFinish();
            }
        };
        t.start();
    }

    public void onFinish() {
    }

    public void stop() {
        _stopFlag = true;
        while (!_workFlag) {
            try {
                Thread.sleep(10);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
