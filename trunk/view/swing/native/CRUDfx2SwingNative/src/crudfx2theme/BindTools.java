package crudfx2theme;

import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.helpers.*;
import org.xml.sax.*;
import crudfx2.core.util.*;
import crudfx2.core.bind.*;

public class BindTools {

    public static void saveToHome(String name, Wood branch) {
        try {
            // Create file
            FileWriter fstream = new FileWriter(homeFile(name));
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + composeXML(branch));
            //Close the output stream
            out.close();
        } catch (Exception e) {//Catch exception if any
            //System.err.println("Error: " + e.getMessage());
            Log.log(e);
        }
    }

    public static String homeFile(String name) {
        String home = java.lang.System.getProperty("user.home", "?");
        String separator = java.lang.System.getProperty("file.separator", "?");
        return home + separator + name;
    }

    public static Wood loadFromXMLFile(String path) {
        final Vector<Wood> out = new Vector<Wood>();
        //Branch root = null;//new Branch("");
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            DefaultHandler handler = new DefaultHandler() {

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    //System.out.println("start " + qName);
                    //root = null;//new Branch("")
                    Wood current;
                    if (out.size() < 1) {
                        current = new Wood(qName);
                        out.add(current);
                    } else {
                        current = new Wood(qName);
                        current.saxparent = out.get(0);
                        out.get(0).children().add(current);
                        out.removeAllElements();
                        out.add(current);
                        //System.out.println(crudfxii.bind.Branch.composeXML(current));
                    }
                    for (int i = 0; i < attributes.getLength(); i++) {
                        Wood a = new Wood(attributes.getQName(i));
                        a.raw = attributes.getValue(i);
                        a.isAttribute = true;
                        current.children().add(a);
                    }
                }

                public void endElement(String uri, String localName, String qName) {
                    //System.out.println("end " + qName);
                    if (out.get(0).saxparent != null) {
                        Wood current = out.get(0).saxparent;
                        out.removeAllElements();
                        out.add(current);
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    /*if (name) {
                    System.out.println("Name: "
                    + new String(ch, start, length));
                    name = false;
                    }*/
                    String s = new String(ch, start, length);
                    if (s.trim().length() > 0) {
                        //System.out.println("ch " + s);
                        if (out.size() > 0) {
                            //System.out.println("ch " + s);
                            Wood current = new Wood("");
                            current.raw = s;
                            out.get(0).children().add(current);
                        }
                    }
                }
            };
            saxParser.parse(new File(path), handler);
        } catch (Throwable t) {
            //t.printStackTrace();
            Log.log(t);
        }
        //return root;
        if (out.size() < 1) {
            return new Wood("");
        } else {
            return out.get(0);
        }
    }

    private static String safe(String text) {
        if (text == null) {
            return "";
        }
        text = text.replace("\"", "&quot;");
        text = text.replace("<", "&lt;");
        text = text.replace(">", "&gt;");
        return text;
    }

    private static String composeXML(Wood branch, String pad) {
        String data = "";
        if (branch.name.equals("")) {
            branch.gather();
            if (branch.isCDATA) {
                data = data + "<![CDATA[" + branch.raw + "]]>";
            } else {
                data = data + safe(branch.raw);
            }
        } else {
            if (!pad.equals("")) {
                data = data + "\n";
            }
            data = data + pad + "<" + safe(branch.name);
            for (int i = 0; i < branch.children().count(); i++) {
                if (branch.children().get(i).isAttribute) {
                    branch.children().get(i).gather();
                    data = data + " " + branch.children().get(i).name + "=\"" + safe(branch.children().get(i).raw) + "\"";
                }
            }
            data = data + ">";
            /*branch.gather();
            if (branch.isCDATA) {
            data = data + "<![CDATA[" + branch.raw + "]]>";
            } else {
            data = data + safe(branch.raw);
            }*/
            for (int i = 0; i < branch.children().count(); i++) {
                if (!branch.children().get(i).isAttribute) {
                    data = data + composeXML(branch.children().get(i), pad + "  ");
                }
            }
            data = data + "</" + safe(branch.name) + ">";
        }
        return data;
    }

    public static String composeXML(Wood branch) {
        return composeXML(branch, "");
    }
}
