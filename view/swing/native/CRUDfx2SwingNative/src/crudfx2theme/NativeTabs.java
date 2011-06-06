package crudfx2theme;

import crudfx2.core.bind.*;
import crudfx2.core.gui.container.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TabPanel extends JPanel {

    public TabPage link;

    public TabPanel(TabPage page) {
        link = page;
    }
}

class TabHeader extends JPanel {

    public JButton button = new JButton("");
    public JLabel label = new JLabel("label");

    public TabHeader() {
        label.setOpaque(false);
        button.setPreferredSize(new Dimension(12, 8));
        button.setToolTipText("close this tab");
        button.setIcon(crudfx2theme.nuvola.IconLoader.icon("i16x16/small_cancel.png"));
        button.setContentAreaFilled(false);
        button.setFocusable(false);
        button.setBorder(BorderFactory.createEtchedBorder());
        button.setBorderPainted(false);
        button.setCursor(Theme.handCursor);
        this.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(button, BorderLayout.EAST);
        this.add(label, BorderLayout.CENTER);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                closeClicked();
            }
        });

    }

    public void closeClicked() {
    }
}

public class NativeTabs extends JTabbedPane {

    Tabs link;

    public NativeTabs(Tabs unit, Theme ntheme) {
        link = unit;
        this.setOpaque(false);
        new BiSet<TabPage>(link.pages()) {

            @Override
            public void onAdd(TabPage item) {
                final TabPage cur = item;
                final TabHeader head = new TabHeader() {

                    @Override
                    public void closeClicked() {
                        //System.out.println("drop "+cur);
                        link.pages().drop(cur);
                    }
                };
                addTab(cur.title().get(), new TabPanel(cur));
                setTabComponentAt(count() - 1, head);
                new BiValue<String>(cur.title()) {

                    @Override
                    public void onChange(String newValue) {
                        head.label.setText(cur.title().get());
                    }
                };
                new BiValue<String>(cur.icon()) {

                    @Override
                    public void onChange(String newValue) {
                        //System.out.println()
                        head.label.setIcon(crudfx2theme.nuvola.IconLoader.icon(cur.icon().get()));
                    }
                };
            }

            @Override
            public void onDrop(TabPage item) {
                //System.out.println("onDrop "+item);
                for (int i = 0; i < getTabCount(); i++) {
                    Component c = getComponentAt(i);
                    //System.out.println("test "+c);
                    if (c instanceof TabPanel) {
                        TabPanel tp = (TabPanel) c;
                        if (tp.link == item) {
                            removeTabAt(i);
                            break;
                        }
                    }
                }
            }
        };
    }
}