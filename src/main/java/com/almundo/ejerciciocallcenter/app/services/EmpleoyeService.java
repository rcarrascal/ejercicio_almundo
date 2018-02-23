/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.services;

import com.almundo.ejerciciocallcenter.app.model.Employee;
import java.util.Queue;

/**
 *
 * @author rcarrascal
 */
public interface EmpleoyeService {
    
    /**
     * Agregamos un empleado disponible a la memoria
     * @param employee
     */
    void addEmpleoye(Employee employee);
    
    /**
     * Obtenemos el empleado disponible actualmente
     * @return
     */
    Employee getEmployeAvailabilable();
    
    /**
     * Obtenemos un empleado operador especifico
     * @return
     */
    Queue<Employee> getOperators();
    
    /**
     * Obtenemos un empleado Supervisor especifico
     * @return
     */
    Queue<Employee> getSupervisors();
    
    /**
     * Obtenemos un empleado Director especifico
     * @return
     */
    Queue<Employee> getDirectors();
    
    
    
}
