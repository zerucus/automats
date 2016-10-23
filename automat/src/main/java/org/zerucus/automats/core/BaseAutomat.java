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
public class BaseAutomat implements Automat {
    private final Set<State> finalStates;
    private final State beginningState;
    private final Set<State> availableStates;
    private final Set<Object> alphabet;
    private final Function function;
    private State currentState;

    public BaseAutomat( Set<State> availableStates,  Set<Object> alphabet,  Function function, State beginningState, Set<State> finalStates) {
        this.finalStates = finalStates;
        this.beginningState = beginningState;
        this.availableStates = availableStates;
        this.alphabet = alphabet;
        this.function = function;
    }

    @Override
    public Set<State> getFinalStates() {
        return finalStates;
    }

    @Override
    public State getBeginningState() {
        return beginningState;
    }

    @Override
    public Set<State> getStates() {
        return availableStates;
    }

    @Override
    public Set<Object> getAlphabet() {
        return alphabet;
    }

    @Override
    public Function getFunction() {
        return function;
    }
    


    @Override
    public synchronized State nextState(Object symbol) throws AutomatException {
        if (currentState == null)
            currentState = getBeginningState();
        currentState = function.nextState(currentState, symbol);
        return currentState;
    }

    @Override
    public State getCurrentState() {
        return currentState;
    }

    @Override
    public boolean isFinalState() {
        return finalStates.contains(currentState);
    }

    @Override
    public void reset() {
        currentState = beginningState;
    }

}
