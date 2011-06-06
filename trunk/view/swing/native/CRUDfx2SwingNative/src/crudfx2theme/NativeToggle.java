package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
//import crudfx2.core.gui.toolbar.*;
import crudfx2.core.gui.control.*;
import crudfx2.core.view.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class NativeToggle extends JToggleButton {
   
    StandardToggle _unit;

    public NativeToggle(StandardToggle unit) {
        super(unit.toString());
        _unit = unit;
        addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //_unit.onClick();
                //System.out.println("aergesr");
                boolean selected = getModel().isSelected();
                //System.out.println("action "+selected);
                _unit.toggled().set(selected);
            }
        });
        //this.setSelected(true);
        new BiValue<String>(_unit.title()){
            @Override
            public void onChange(String newValue){
                setText(_unit.title().get());
            }
        };
        new BiValue<Boolean>(_unit.toggled()){
            @Override
            public void onChange(Boolean newValue){
                setSelected(_unit.toggled().get());
                boolean selected = getModel().isSelected();
                //System.out.println("trigger "+selected);
            }
        };
    } 
}
