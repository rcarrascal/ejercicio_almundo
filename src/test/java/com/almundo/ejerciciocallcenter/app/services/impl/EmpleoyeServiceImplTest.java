/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.services.impl;

import com.almundo.ejerciciocallcenter.app.model.Employee;
import com.almundo.ejerciciocallcenter.app.services.EmpleoyeService;
import java.util.Queue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Prueba unitaria para comprobar la disponibilidad de los empleados
 *
 * @author rcarrascal
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpleoyeServiceImplTest {

    @Autowired
    private EmpleoyeService empleoyeService;

    /**
     * Test para validar el agregar empleados a su rol especifico.
     */
    @Test
    public void testAddEmpleoye() {
        System.out.println("addEmpleoye");
        empleoyeService.addEmpleoye(new Employee("Ronald", Employee.Rol.OPERATOR));
        Queue<Employee> employees = empleoyeService.getOperators();

        assertEquals(employees.peek().getName(), "Ronald");

        empleoyeService.addEmpleoye(new Employee("Supervisor", Employee.Rol.SUPERVISOR));
        Queue<Employee> supervisor = empleoyeService.getSupervisors();

        assertEquals(supervisor.peek().getName(), "Supervisor");

        empleoyeService.addEmpleoye(new Employee("Director", Employee.Rol.DIRECTOR));
        Queue<Employee> directores = empleoyeService.getDirectors();

        assertEquals(directores.peek().getName(), "Director");

    }

    /**
     * Test para obtener empleado de acuerdo al orden por rol establecido
     * Operador - Supervisor - Director
     */
    @Test
    public void testGetEmployeAvailabilable() {
        System.out.println("getEmployeAvailable");
        empleoyeService.addEmpleoye(new Employee("SUPERVISOR", Employee.Rol.SUPERVISOR));
        empleoyeService.addEmpleoye(new Employee("OPERADOR", Employee.Rol.OPERATOR));
        empleoyeService.addEmpleoye(new Employee("OPERADOR", Employee.Rol.OPERATOR));
        empleoyeService.addEmpleoye(new Employee("DIRECTOR", Employee.Rol.DIRECTOR));

        Employee operador1 = empleoyeService.getEmployeAvailable();
        System.out.println("Empleado: " + operador1);
        assertEquals(operador1.getName(), "OPERADOR");

        Employee operador2 = empleoyeService.getEmployeAvailable();
        System.out.println("Empleado: " + operador2);
        assertEquals(operador2.getName(), "OPERADOR");

        Employee supervisor = empleoyeService.getEmployeAvailable();
        System.out.println("Empleado: " + supervisor);
        assertEquals(supervisor.getName(), "SUPERVISOR");

        Employee director = empleoyeService.getEmployeAvailable();
        System.out.println("Empleado: " + director);
        assertEquals(director.getName(), "DIRECTOR");

    }

}
