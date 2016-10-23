/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core.config;

import java.net.URL;
import org.zerucus.automats.core.Automat;

/**
 *
 * @author krzeminskiz
 */
public class AutomatFactory {
    org.zerucus.automats.core.Automat automat;
    
    public Automat getInstance(URL url) {
        // na razie z propertiesów
        if (automat == null)
            automat =  new PropsDefAutomat().process(url);
        return automat;
    }
    
    
}
