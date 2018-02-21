/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.dispacher.impl;

import com.almundo.ejerciciocallcenter.app.dispacher.Dispacher;
import com.almundo.ejerciciocallcenter.app.model.Call;
import com.almundo.ejerciciocallcenter.app.model.Employee;
import com.almundo.ejerciciocallcenter.app.services.EmpleoyeService;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author rcarrascal
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DispacherImplTest {

    @Autowired
    private Dispacher dispacher;

    @Autowired
    private EmpleoyeService empleoyeService;

    public DispacherImplTest() {
    }

    /**
     * Prueba para verificar que se asignan las llamadas correctamente
     */
    @Test
    public void testDispatchCall() {
        System.out.println("dispatchCall");
        //Agregamos los empleados
        empleoyeService.addEmpleoye(new Employee("Ronald", Employee.Rol.OPERATOR));
        empleoyeService.addEmpleoye(new Employee("Juan", Employee.Rol.OPERATOR));
        empleoyeService.addEmpleoye(new Employee("Carlos", Employee.Rol.OPERATOR));
        empleoyeService.addEmpleoye(new Employee("Maria", Employee.Rol.SUPERVISOR));
        empleoyeService.addEmpleoye(new Employee("Daniela", Employee.Rol.SUPERVISOR));
        empleoyeService.addEmpleoye(new Employee("Mariana", Employee.Rol.DIRECTOR));

        dispacher.dispatchCall(new Call());
        dispacher.dispatchCall(new Call());
        dispacher.dispatchCall(new Call());
        dispacher.dispatchCall(new Call());
        dispacher.dispatchCall(new Call());
        dispacher.dispatchCall(new Call());
        dispacher.dispatchCall(new Call());
        dispacher.dispatchCall(new Call());
        

    }

}
