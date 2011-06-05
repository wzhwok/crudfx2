package crudfx2theme;
import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class NativeSuiteVertical extends JPanel {

    private Vector<Widget> items = new Vector<Widget>();
    private Vector<JamTop> containers = new Vector<JamTop>();
    private JamTop root = new JamTop();
    private JamTop last = root;

    public NativeSuiteVertical(SuiteVertical unit, Theme ntheme) {
        final NativeSuiteVertical me = this;
        new BiSet<Widget>(unit.suite()) {
            public void onAdd(Widget item) {
                JamTop newContainer = new JamTop();
                newContainer.top().set(item);
                me.last.body().set(newContainer);
                me.last = newContainer;
                items.add(item);
                containers.add(newContainer);
            }

            public void onDrop(Widget item) {
                for (int i = 0; i < items.size(); i++) {
                    if (items.get(i) == item) {
                        JamTop pre;
                        if (i > 0) {
                            pre = containers.get(i - 1);
                        } else {
                            pre = me.root;
                        }
                        pre.body().set(null);
                        containers.get(i).body().set(null);
                        containers.get(i).top().set(null);
                        if (i < items.size() - 1) {
                            pre.body().set(containers.get(i + 1));
                        }
                        items.remove(items.get(i));
                        containers.remove(containers.get(i));
                        break;
                    }
                }
            }
        };
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        add(ntheme.createJComponent(me.root), BorderLayout.CENTER);
    }
}
