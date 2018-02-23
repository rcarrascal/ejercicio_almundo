/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.model;

/**
 *
 * @author rcarrascal
 */
public class Call {
    
    private String id;
    private Employee employee;
    private String status;

    public Call(String id) {
        this.id = id;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Call{" + "id=" + id + ", employee=" + employee + '}';
    }
    
    
    
}
