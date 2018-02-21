/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.services.impl;

import com.almundo.ejerciciocallcenter.app.model.Employee;
import com.almundo.ejerciciocallcenter.app.services.EmpleoyeService;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class EmpleoyeServiceImpl implements EmpleoyeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmpleoyeServiceImpl.class);

    private final Queue<Employee> operators;
    private final Queue<Employee> supervisors;
    private final Queue<Employee> directors;

    public EmpleoyeServiceImpl() {
        this.operators = new ConcurrentLinkedQueue<>();
        this.supervisors = new ConcurrentLinkedQueue<>();
        this.directors = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void addEmpleoye(Employee employee) {
        LOGGER.info("Agregamos un empleado");
        switch (employee.getRol()) {
            case OPERATOR:
                operators.add(employee);
                break;
            case SUPERVISOR:
                supervisors.add(employee);
                break;
            case DIRECTOR:
                directors.add(employee);
                break;
            default:
                throw new AssertionError(employee.getRol().DIRECTOR.name());

        }

    }

    @Override
    public Employee getEmployeAvailabilable() {
        LOGGER.info("Obtenemos el empleado disponible actualmente");
        Employee employee=null;
        employee=operators.poll();
        if(employee==null){
            employee=supervisors.poll();
            return employee;
        }
        
        if(employee==null){
            employee=directors.poll();
        }
        
        LOGGER.info("Empleado resultado " + employee);
        
        return employee;
    }

}
