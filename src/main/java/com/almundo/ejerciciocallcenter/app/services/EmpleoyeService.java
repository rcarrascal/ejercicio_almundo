/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.services;

import com.almundo.ejerciciocallcenter.app.model.Employee;
import java.util.Optional;

/**
 *
 * @author rcarrascal
 */
public interface EmpleoyeService {
    
    /**
     * Agregamos un empleado a la memoria
     * @param employee
     */
    void addEmpleoye(Employee employee);
    
    /**
     * Obtenemos el empleado disponible actualmente
     * @return
     */
    Employee getEmployeAvailabilable();
    
    
    
}
