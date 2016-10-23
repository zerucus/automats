/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core;

import java.io.OutputStream;

/**
 *
 * @author krzeminskiz
 */
public interface Symbol {
    /**
     * Metoda konwertuje dane wejściowe (przycisk klawiatury, dźwięk, obraz) na symbol zrozumiały dla automatu
     * @param o
     */
    void convertSymbol(OutputStream o);
}
