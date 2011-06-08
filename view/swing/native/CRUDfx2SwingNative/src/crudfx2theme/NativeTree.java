package crudfx2theme;

import crudfx2.core.gui.*;
import crudfx2.core.bind.*;
import crudfx2.core.gui.layout.*;
import crudfx2.core.gui.control.tree.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.tree.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import crudfx2theme.nuvola.*;

class BranchNode extends DefaultMutableTreeNode {

    public TreeBranch it;

    public BranchNode(TreeBranch item) {
        super();
        it = item;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}

class LeafNode extends DefaultMutableTreeNode {

    public TreeLeaf it;

    public LeafNode(TreeLeaf item) {
        super();
        it = item;

    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}

public class NativeTree extends JScrollPane {

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("");
    DefaultTreeModel model = new DefaultTreeModel(root);
    JTree tree = new JTree();
Theme theme;
    public void dropNode(TreeItem item) {
        model.removeNodeFromParent(findNode(item, root));
    }

    public DefaultMutableTreeNode findNode(TreeItem item, DefaultMutableTreeNode parent) {
        for (int i = 0; i < model.getChildCount(parent); i++) {
            Object o = model.getChild(parent, i);
            if (o instanceof LeafNode) {
                LeafNode n = (LeafNode) o;
                if (n.it == item) {
                    return n;
                }
            }
            if (o instanceof BranchNode) {
                BranchNode n = (BranchNode) o;
                if (n.it == item) {
                    return n;
                }
                DefaultMutableTreeNode other = findNode(item, n);
                if (other != null) {
                    return other;
                }
            }
        }
        return null;
    }

    public void addNode(TreeItem item, DefaultMutableTreeNode parent) {
        if (item instanceof TreeBranch) {
            TreeBranch b = (TreeBranch) item;
            final DefaultMutableTreeNode branch = new BranchNode(b);
            branch.setUserObject(item.title().get());
            int insPoint = model.getChildCount(parent);
            for (int i = 0; i < model.getChildCount(parent); i++) {
                Object o = model.getChild(parent, i);
                if (o instanceof LeafNode) {
                    insPoint = i;
                    break;
                }
            }
            model.insertNodeInto(branch, parent, insPoint);
            new BiSet<TreeItem>(b.children()) {

                @Override
                public void onAdd(TreeItem item) {
                    addNode(item, branch);
                }

                @Override
                public void onDrop(TreeItem item) {
                    dropNode(item);
                }
            };
        } else {
            DefaultMutableTreeNode leaf;
            leaf = new LeafNode((TreeLeaf) item);
            leaf.setUserObject(item.title().get());
            int insPoint = model.getChildCount(parent);
            model.insertNodeInto(leaf, parent, insPoint);
        }
        tree.expandPath(new TreePath(root));
    }

    void doMouseClicked(MouseEvent me) {
        TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
        if (tp != null) {
            Object o = tp.getLastPathComponent();
            if (o instanceof LeafNode) {
                LeafNode n = (LeafNode) o;
                n.it.onClick();
            }
        }
    }

    public NativeTree(StandardTree unit,Theme ntheme) {
        theme=ntheme;
        final StandardTree link = unit;
        this.getViewport().setOpaque(false);
        this.setOpaque(false);
        this.getViewport().add(tree);
        this.setBorder(null);
        tree.setModel(model);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(false);
        tree.setToggleClickCount(1);
        tree.setOpaque(false);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer() {
/*
            @Override
            public Dimension getPreferredSize() {
                Dimension retDimension = super.getPreferredSize();

                if (retDimension != null) {
                    retDimension = new Dimension(retDimension.width + 3, retDimension.height + 12);
                }
                System.out.println(retDimension);
                return retDimension;
            }
*/
            @Override
            public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
                Component c = super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

                //System.out.println(value.getClass());
                //setIcon(IconLoader.icon("_unit.icon().get()"));
                if (value instanceof LeafNode) {
                    //System.out.println("\tleaf");
                    LeafNode lf = (LeafNode) value;
                    if (lf.it.icon().get() != null) {
                        //System.out.println("\tno");
                        if (lf.it.icon().get().length() > 0) {
                            //System.out.println("\t" + lf.it.icon().get());
                            setIcon(theme.icon(lf.it.icon().get()));
                        }
                    }
                } else {
                    if (value instanceof BranchNode) {
                        BranchNode br = (BranchNode) value;
                        if (!expanded) {
                            if (br.it.icon().get() != null) {
                                //System.out.println("\tno");
                                if (br.it.icon().get().length() > 0) {
                                    //System.out.println("\t" + lf.it.icon().get());
                                    setIcon(theme.icon(br.it.icon().get()));
                                }
                            }
                        } else {
                            if (br.it.openedIcon().get() != null) {
                                //System.out.println("\tno");
                                if (br.it.openedIcon().get().length() > 0) {
                                    //System.out.println("\t" + lf.it.icon().get());
                                    setIcon(theme.icon(br.it.openedIcon().get()));
                                }
                            }
                        }
                    }
                }
//setSize(getPreferredSize());
                return c;
            }
        };
        renderer.setOpaque(false);
        renderer.setBackgroundNonSelectionColor(new Color(0, 0, 0, 0));
        tree.setRowHeight(19);

        tree.setCellRenderer(renderer);
        tree.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent me) {
                doMouseClicked(me);
            }
        });
        new BiSet<TreeItem>(link.children()) {

            @Override
            public void onAdd(TreeItem item) {
                addNode(item, root);
            }

            @Override
            public void onDrop(TreeItem item) {
                dropNode(item);
            }
        };
        //tree.setCellRenderer(renderer);
    }
}
