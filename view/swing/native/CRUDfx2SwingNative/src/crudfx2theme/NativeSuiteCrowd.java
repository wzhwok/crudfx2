package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class NativeSuiteCrowd extends JScrollPane {

    private Vector<Widget> items = new Vector<Widget>();
    Vector<JComponent> comps = new Vector<JComponent>();
    JPanel panel = new JPanel();

    public NativeSuiteCrowd(SuiteCrowd unit, Theme ntheme) {
        final NativeSuiteCrowd me = this;
        final Theme theme = ntheme;
        //final 
        this.getViewport().add(panel);
        new BiSet<Widget>(unit.suite()) {

            public void onAdd(Widget item) {
                panel.add(theme.createJComponent(item));
            }

            public void onDrop(Widget item) {
                System.out.println("ops!");
            }
        };
        this.setOpaque(false);
        this.getViewport().setOpaque(false);
        this.setBorder(null);
        this.getViewport().setBorder(null);
        panel.setLayout(null);//new CrowdLayout());
        this.setOpaque(false);
        this.addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent e) {
                //System.out.println(e);
                me.relayout();
                /*System.out.println(panel.getSize());
                System.out.println(me.getSize());
                panel.setPreferredSize(panel.getSize());*/
                /*doLayout();
                sub.doLayout();
                subsub.doLayout();*/
            }
        });
        relayout();
    }

    void relayout() {
        int currentX = 0;
        int currentY = 0;
        int maxY = 0;
        int w = this.getSize().width;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Component c = panel.getComponent(i);
            c.setSize(c.getPreferredSize());
            //System.out.println(c);

            if ((currentX + c.getSize().width > w) && (currentX > 0)) {
                currentX = 0;
                currentY = maxY;
            }
            c.setLocation(currentX, currentY);
            //if (currentX + currentComponent.getSize().width > minWidth) {
            //minWidth = currentX + currentComponent.getSize().width;
            //}
            currentX = currentX + c.getSize().width;
            if (currentY + c.getSize().height > maxY) {
                maxY = currentY + c.getSize().height;
            }
        }
        w = 0;
        int h = 0;
        for (int i = 0; i < panel.getComponentCount(); i++) {
            Component c = panel.getComponent(i);
            if (c.getLocation().x + c.getSize().width > w) {
                w = c.getLocation().x + c.getSize().width;
            }
            if (c.getLocation().y + c.getSize().height > h) {
                h = c.getLocation().y + c.getSize().height;
            }
        }
        Dimension d = new Dimension(w, h);
        panel.setPreferredSize(d);
        panel.setMinimumSize(d);
        panel.setSize(d);
    }
}
