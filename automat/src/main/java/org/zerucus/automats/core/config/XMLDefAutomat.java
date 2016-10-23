/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerucus.automats.core.config;

import com.thoughtworks.xstream.XStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zerucus.automats.core.Automat;

/**
 *
 * @author Administrator
 */
public class XMLDefAutomat implements AutomatDef {

    @Override
    public Automat process(URL url) {
        XStream x = new XStream();
        x.alias("states", Set.class);
        x.alias("symbols", Set.class);
        x.alias("entries", Set.class);
        x.alias("finalStates", Set.class);
                Automat a = null;
        try {
            a = (Automat) x.fromXML(new FileInputStream(url.getFile()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XMLDefAutomat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return a;
    }
    
}
