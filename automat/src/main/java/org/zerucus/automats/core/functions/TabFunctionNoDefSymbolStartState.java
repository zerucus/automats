/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.zerucus.automats.core.functions;

import org.zerucus.automats.core.AutomatException;
import org.zerucus.automats.core.State;

/**
 *
 * @author zbigniewk
 */
public class TabFunctionNoDefSymbolStartState extends TabFunction {
    private final State startState;

    public TabFunctionNoDefSymbolStartState(State startState) {
        this.startState = startState;
    }
    
    
    @Override
    public State nextState(State currentState, Object symbol) throws AutomatException {
        State st;
        try {
            st = super.nextState(currentState, symbol);
        }
        catch (AutomatException e) {
            st = startState;
        }
        return st;
    }
    
}
