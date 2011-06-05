package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.menu.*;
import crudfx2theme.nuvola.IconLoader;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class LinkedMenuPad extends JMenu {

    public MenuPad link;

    public LinkedMenuPad(MenuPad pad) {
        super(pad.title().get());
        link = pad;
        new BiValue<String>(link.title()) {

            @Override
            public void onChange(String to) {
                setText(to);
            }
        };
    }
}

class LinkedSubMenu extends JMenu {

    public Submenu link;

    public LinkedSubMenu(Submenu m) {
        super(m.title().get());
        link = m;
        new BiValue<String>(link.title()) {

            @Override
            public void onChange(String to) {
                setText(to);
            }
        };
    }
}

public class NativeMainWindow extends JFrame {

    private Wood _configuration;
    private BaseWindow _mainWindow;
    private JToolBar _toolbar = new JToolBar();
    private JComponent _unit = null;
    private JComponent _footer = null;
    private JMenuBar _menuBar = new JMenuBar();
    private Theme theme;

    public NativeMainWindow(BaseWindow inMmainWindow, Theme ntheme) {
        //final Theme 
        theme = ntheme;
        final JFrame me = this;
        this.setLayout(new BorderLayout());
        _toolbar.setFloatable(false);
//System.out.println(	_toolbar.getUI());
        _configuration = inMmainWindow.configuration().find("MainWindow");
        _mainWindow = inMmainWindow;
        addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                _configuration.find("width").find("").asInteger(800).set(getSize().width);
                _configuration.find("height").find("").asInteger(600).set(getSize().height);
            }

            public void componentMoved(ComponentEvent e) {
                _configuration.find("x").find("").asInteger(100).set(getLocation().x);
                _configuration.find("y").find("").asInteger(50).set(getLocation().y);
            }

            public void componentShown(ComponentEvent e) {
                //
            }

            public void componentHidden(ComponentEvent e) {
                //
            }
        });
        int x = _configuration.find("x").find("").asInteger(100).get();
        int y = _configuration.find("y").find("").asInteger(50).get();
        int width = _configuration.find("width").find("").asInteger(800).get();
        int height = _configuration.find("height").find("").asInteger(600).get();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (width + x > screenSize.width) {
            x = screenSize.width - width;
            if (x < 0) {
                x = 0;
                width = screenSize.width;
            }
        }
        if (height + y > screenSize.height) {
            y = screenSize.height - height;
            if (y < 0) {
                y = 0;
                height = screenSize.height;
            }
        }
        _configuration.find("x").find("").asInteger(100).set(x);
        _configuration.find("y").find("").asInteger(50).set(y);
        _configuration.find("width").find("").asInteger(800).set(width);
        _configuration.find("height").find("").asInteger(600).set(height);
        setLocation(_configuration.find("x").find("").asInteger(100).get(),
                _configuration.find("y").find("").asInteger(100).get());
        setSize(_configuration.find("width").find("").asInteger(800).get(),
                _configuration.find("height").find("").asInteger(600).get());

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (_mainWindow.approveClosing()) {
                    System.exit(0);
                }
            }
        });
        new BiValue<Widget>(_mainWindow.body()) {

            @Override
            public void onChange(Widget newValue) {
                if (_unit != null) {
                    getContentPane().remove(_unit);
                }
                if (_mainWindow.body().get() != null) {
                    _unit = theme.createJComponent(_mainWindow.body().get());
                    getContentPane().add(_unit, BorderLayout.CENTER);
                    validate();
                }
            }
        };
        new BiValue<Widget>(_mainWindow.footer()) {

            @Override
            public void onChange(Widget newValue) {
                if (_footer != null) {
                    getContentPane().remove(_footer);
                }
                if (_mainWindow.footer().get() != null) {
                    _footer = theme.createJComponent(_mainWindow.footer().get());
                    getContentPane().add(_footer, BorderLayout.SOUTH);
                    validate();
                }
            }
        };
        new BiValue<String>(_mainWindow.title()) {

            @Override
            public void onChange(String newValue) {
                me.setTitle("");
                if (_mainWindow.title().get() != null) {
                    me.setTitle(_mainWindow.title().get());
                }
            }
        };
        new BiValue<String>(_mainWindow.icon()) {

            @Override
            public void onChange(String newValue) {
                me.setIconImage(theme.icon(_mainWindow.icon().get()).getImage());
            }
        };
        this.getContentPane().add(_toolbar, BorderLayout.NORTH);
        new BiValue<Widget>(_mainWindow.toolbar()) {

            @Override
            public void onChange(Widget newValue) {
                _toolbar.removeAll();
                if (newValue != null) {
                    _toolbar.add(theme.createJComponent(newValue));
                }
                //JButton k=new JButton("fthm dthm sdfb");
                //_toolbar.add(k);
                //System.out.println(k.getUI());
                adjustToolbar();
            }
        };
        this.setJMenuBar(_menuBar);
        new BiSet<MenuPad>(_mainWindow.menu()) {

            @Override
            public void onAdd(MenuPad pad) {

                LinkedMenuPad jMenu = new LinkedMenuPad(pad);
                _menuBar.add(jMenu);
                addSubMenus(jMenu, pad.items());
                adjustMenu();
            }

            @Override
            public void onDrop(MenuPad pad) {
                for (int i = 0; i < _menuBar.getMenuCount(); i++) {
                    JMenu m = _menuBar.getMenu(i);
                    if (m instanceof LinkedMenuPad) {
                        LinkedMenuPad l = (LinkedMenuPad) m;
                        if (l.link == pad) {
                            _menuBar.remove(l);
                        }
                    }
                }
                adjustMenu();
            }
        };
        Runtime.getRuntime().addShutdownHook(new Thread() {

            public void run() {
                shutdown();
            }
        });
        adjustToolbar();
        adjustMenu();
    }

    private void shutdown() {
        theme.saveConfiguration(_mainWindow.key, _mainWindow.configuration());
        _mainWindow.onClose();
    }

    private void adjustToolbar() {
        if (_toolbar.getComponentCount() > 0) {
            _toolbar.setVisible(true);
        } else {
            _toolbar.setVisible(false);
        }
    }

    private void adjustMenu() {
        _menuBar.setVisible(this._mainWindow.menu().count() > 0);
    }

    private void addMenuItem(JMenu jMenu, MenuUnit itm) {
        if (itm instanceof MenuSeparator) {
            jMenu.addSeparator();
        } else {
            if (itm instanceof MenuAction) {
                final MenuAction mai = (MenuAction) itm;
                final JMenuItem it = new javax.swing.JMenuItem(mai.title().get());
                it.addActionListener(new java.awt.event.ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        mai.onSelect();
                    }
                });
                new BiValue<String>(mai.icon()) {

                    @Override
                    public void onChange(String newValue) {
                        if (mai.icon().get().length() > 0) {
                            it.setIcon(IconLoader.icon(mai.icon().get()));
                        } else {
                            it.setIcon(null);
                        }
                    }
                };
                new BiValue<String>(mai.title()) {

                    @Override
                    public void onChange(String newValue) {
                        it.setText(newValue);
                    }
                };
                jMenu.add(it);
            } else {
                if (itm instanceof Submenu) {
                    Submenu sm = (Submenu) itm;
                    LinkedSubMenu nm = new LinkedSubMenu(sm);
                    jMenu.add(nm);
                    addSubMenus(nm, sm.items());
                } else {
                    if (itm instanceof MenuCheck) {
                        final MenuCheck ch = (MenuCheck) itm;
                        final JCheckBoxMenuItem it = new javax.swing.JCheckBoxMenuItem(ch.title().get());
                        new BiValue<String>(ch.title()) {

                            @Override
                            public void onChange(String newValue) {
                                it.setText(newValue);
                            }
                        };
                        new BiValue<Boolean>(ch.checked()) {

                            @Override
                            public void onChange(Boolean newValue) {
                                it.setState(newValue);
                            }
                        };
                        it.addActionListener(new java.awt.event.ActionListener() {

                            public void actionPerformed(ActionEvent evt) {
                                ch.checked().set(it.getState());
                            }
                        });
                        jMenu.add(it);
                    } else {
                        jMenu.add(new javax.swing.JMenuItem("?" + itm.getClass().getName()));
                    }
                }
            }
        }
    }

    private void addSubMenus(JMenu jMenu, BiSet<MenuUnit> all) {
        final JMenu m = jMenu;
        final BiSet<MenuUnit> a = all;
        new BiSet<MenuUnit>(all) {

            @Override
            public void onAdd(MenuUnit it) {
                addMenuItem(m, it);
            }

            @Override
            public void onDrop(MenuUnit it) {
                m.removeAll();
                for (int i = 0; i < a.count(); i++) {
                    addMenuItem(m, a.get(i));
                }
            }
        };
    }
}
