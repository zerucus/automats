/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.imivic.automats.core;

import org.zerucus.automats.core.State;
import org.zerucus.automats.core.BaseAutomat;
import org.zerucus.automats.core.Symbol;
import org.zerucus.automats.core.AutomatException;
import org.zerucus.automats.core.Automat;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.zerucus.automats.core.alphabets.Letter;
import org.zerucus.automats.core.functions.TabFunction;
import org.zerucus.automats.core.functions.TabFunctionNoDefSymbolStartState;
import org.zerucus.automats.core.states.Simple;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author zbigniewk
 */
public class BaseAutomatTest {
    

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testFinalStateEqualsExpectedFinalSate() throws AutomatException, IOException {
        Map<Object,State> rm;
        Map<State, Map<Object, State>> am = new HashMap<>();
        Symbol[] lettersTab = { new Letter('0'), new Letter('1')};
        State[] statesTab = {new Simple("start"), new Simple("s2"),  new Simple("s3")};
        Set<State> states  = new HashSet<>(Arrays.asList(statesTab));
        Set<Object> alphabet = new HashSet<>(Arrays.asList(lettersTab));
        Set<State> finalStates = new HashSet<>(Collections.singletonList(statesTab[2]));
        rm  = new HashMap<>();
        rm.put(lettersTab[0], statesTab[1]);
        rm.put(lettersTab[1], statesTab[0]);
        am.put(statesTab[0], rm);
        rm  = new HashMap<>();
        rm.put(lettersTab[0], statesTab[1]);
        rm.put(lettersTab[1], statesTab[2]);
        am.put(statesTab[1], rm);
        rm  = new HashMap<>();
        rm.put(lettersTab[0], statesTab[2]);
        rm.put(lettersTab[1], statesTab[2]);
        am.put(statesTab[2], rm);

        TabFunction f = new TabFunction();
        f.setTab(am);
        Automat a = new BaseAutomat(states, alphabet, f, statesTab[0], finalStates);
        byte[] b = new byte[4];
        Symbol[] word = {lettersTab[1],lettersTab[0],lettersTab[1],lettersTab[0],lettersTab[1],lettersTab[0],lettersTab[1]};
        State rs;
        for (Symbol s : word) {
            rs = a.nextState(s);
            rs.visualization().read(b);
            System.out.println(new String(b));
        }
        Assert.assertTrue(a.isFinalState());
    }
    
    @Test
    public void shouldWordContainsStringula() throws AutomatException, IOException {
        Automat a = containsulaAutomat("xulyulax");
        Assert.assertTrue(a.isFinalState());
    }
    
    @Test
    public void shouldWordDontContainsStringula() throws AutomatException, IOException {
        Automat a = containsulaAutomat("xullax");
        Assert.assertFalse(a.isFinalState());

    }

    private Automat containsulaAutomat(String word) throws IOException, AutomatException {
        Map<Object,State> rm;
        Map<State, Map<Object, State>> am = new HashMap<>();
        State[] statesTab = {new Simple("start"), new Simple("u"),  new Simple("l"), new Simple("OK")};
        Set<State> states  = new HashSet<>(Arrays.asList(statesTab));
        Set<Object> alphabet = new HashSet<>(Arrays.asList(new Character[] {'u','l','a','x','y'}));
        Set<State> finalStates = new HashSet<>(Collections.singletonList(statesTab[3]));
        rm  = new HashMap<>();
        rm.put('u', statesTab[1]);
        am.put(statesTab[0], rm);
        rm  = new HashMap<>();
        rm.put('l', statesTab[2]);
        am.put(statesTab[1], rm);
        rm  = new HashMap<>();
        rm.put('a', statesTab[3]);
        am.put(statesTab[2], rm);
        rm  = new HashMap<>();
        rm.put('u', statesTab[3]);
        rm.put('l', statesTab[3]);
        rm.put('a', statesTab[3]);
        rm.put('x', statesTab[3]);
        rm.put('y', statesTab[3]);
        am.put(statesTab[3], rm);
        TabFunction f = new TabFunctionNoDefSymbolStartState(statesTab[0]);
        f.setTab(am);
        Automat a = new BaseAutomat(states, alphabet, f, statesTab[0], finalStates);
       State rs;
        for (Object s : word.toCharArray()) {
            byte[] b = new byte[4];
            rs = a.nextState(s);
            rs.visualization().read(b);
            System.out.println(s+": "+new String(b));
        }
        return a;
    }
   
}
