/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core;

import java.util.Set;

/**
 *
 * @author krzeminskiz
 */
public interface Automat {
    Set<State> getFinalStates();
    State getBeginningState();
//    void setFinalStates(State[] states);
//    void setBeginningState(State state);
    Set<Object> getAlphabet();
//    void setAlphabet(Symbol[] states);
    Set<State> getStates();
//    void setStates(State[] states);
    Function getFunction();
//    void setFunction(Function f);
    State nextState(Object symbol) throws AutomatException;
    State getCurrentState();
    void reset();
    boolean isFinalState();
    
}
