/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core.functions;

import java.util.Map;
import org.zerucus.automats.core.AutomatException;
import org.zerucus.automats.core.Function;
import org.zerucus.automats.core.State;

/**
 *
 * @author krzeminskiz
 * w zasadzie klasa automat powiina być odpowiedzialna za przechodzenia do kolejnego stanu,
 * a klasa funkcji wogóle nie jest potrzeba, ale mam przeczucie, że może się przydać.
 */
public class TabFunction implements Function {
    Map<State, Map<Object, State>> map;
    public State nextState(State currentState, Object symbol) throws AutomatException {
        State st = null;
            for (State s : map.keySet())
                if (s.getStateName().equals(currentState.getStateName())) {
                    st = map.get(s).get(symbol);
                }
           if (st == null)
                throw new AutomatException("Value for ("+currentState+","+symbol+" not found");

            return st;
    }

    public void setTab(Map<State, Map<Object, State>> m) {
        map = m;
    }
}

