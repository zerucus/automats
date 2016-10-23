/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core;

/**
 *
 * @author krzeminskiz
 */
public class AutomatException extends Exception {

    /**
     * Creates a new instance of <code>AutomatException</code> without detail message.
     */
    public AutomatException() {
    }


    /**
     * Constructs an instance of <code>AutomatException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public AutomatException(String msg) {
        super(msg);
    }
}
