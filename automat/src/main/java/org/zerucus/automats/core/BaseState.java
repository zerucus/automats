/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.zerucus.automats.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 *
 * @author krzeminskiz
 */
public abstract class BaseState implements State {
    
        String stateName;


    public String getStateName() {
        return stateName;
    }
    
    
     public BaseState(String name) {
        stateName = name;

    }

   abstract public InputStream visualization();

   abstract public void behaviour();

    @Override
   public String toString() {
       return "StateName: "+stateName;
   }
}
