/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core;

import java.io.InputStream;

/**
 *
 * @author krzeminskiz
 */
public interface State {

    InputStream visualization();
    void behaviour();
    String getStateName();
}
