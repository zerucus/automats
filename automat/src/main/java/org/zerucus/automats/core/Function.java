/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core;

/**
 *
 * @author krzeminskiz
 */
public interface Function {
    State nextState(State currentState, Object symbol) throws AutomatException;
}
