/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.dispacher.impl;

import com.almundo.ejerciciocallcenter.app.dispacher.Dispacher;
import com.almundo.ejerciciocallcenter.app.model.Call;
import com.almundo.ejerciciocallcenter.app.task.CallTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DispacherImpl implements Dispacher {
    
    @Autowired
    private CallTask callTask;
    
    @Override
    public void dispatchCall(Call call) {
        
        callTask.addCall(call);
        
    }

   
    
}
