/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core.alphabets;

import java.io.OutputStream;
import org.zerucus.automats.core.Symbol;

/**
 *
 * @author krzeminskiz
 */
public class Letter implements Symbol {
    private char letter;

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }
    
    public  Letter(char l) {
        letter = l;
    }
    
    @Override
    public String toString() {
        return "Letter: "+letter;
    }

    public void convertSymbol(OutputStream o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
