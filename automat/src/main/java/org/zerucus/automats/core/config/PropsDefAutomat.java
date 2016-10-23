/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerucus.automats.core.config;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.zerucus.automats.core.Automat;

/**
 *
 * @author Administrator
 */
public class PropsDefAutomat implements AutomatDef {

    public Automat process(URL url) {
            Properties props = new Properties();
        try {
            props.load(url.openStream());
            // TODO create Automat from props
        } catch (IOException ex) {
            Logger.getLogger(PropsDefAutomat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
