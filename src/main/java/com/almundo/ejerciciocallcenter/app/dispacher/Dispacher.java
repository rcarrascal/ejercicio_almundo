/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.dispacher;

import com.almundo.ejerciciocallcenter.app.model.Call;

/**
 *
 * @author rcarrascal
 */
public interface Dispacher {
    
    /**
     * Interface encargada de lanzar la llamada
     */
    void dispatchCall(Call call);
    
}
