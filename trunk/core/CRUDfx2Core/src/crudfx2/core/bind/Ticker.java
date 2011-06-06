package crudfx2.core.bind;

import java.util.Calendar;

public class Ticker {

    private BiValue<Integer> _count = new BiValue<Integer>(0);
    private BiValue<Integer> _delay = new BiValue<Integer>(0);
    private BiValue<Integer> _current = new BiValue<Integer>(0);
    private boolean _stopFlag = false;
    private boolean _workFlag = false;

    public BiValue<Integer> count() {
        return _count;
    }

    public Ticker count(int n) {
        count().set(n);
        return this;
    }

    public Ticker count(BiValue<Integer> n) {
        count().bind(n);
        return this;
    }

    public BiValue<Integer> delay() {
        return _delay;
    }

    public Ticker delay(int n) {
        delay().set(n);
        return this;
    }

    public Ticker delay(BiValue<Integer> n) {
        delay().bind(n);
        return this;
    }

    public BiValue<Integer> current() {
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
                current().set(0);
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
