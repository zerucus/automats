/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerucus.automats.core.config;

import java.net.URL;
import org.zerucus.automats.core.Automat;

/**
 *
 * @author Administrator
 */
public interface AutomatDef {
    Automat process(URL url);
}
