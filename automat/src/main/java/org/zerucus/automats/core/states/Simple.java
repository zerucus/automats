/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core.states;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.zerucus.automats.core.BaseState;

/**
 *
 * @author krzeminskiz
 */
public class Simple extends BaseState {

    public Simple(String name) {
       super(name);
    }
             
    @Override
    public InputStream visualization() {
        return new ByteArrayInputStream(getStateName().getBytes());
    }

    public void behaviour() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
