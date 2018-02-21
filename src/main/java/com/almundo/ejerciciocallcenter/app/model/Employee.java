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
public class Employee {
    
    public enum Rol{
        
        OPERATOR, SUPERVISOR, DIRECTOR
        
    }
    
    private int id;
    private String name;
    private Rol rol;

    public Employee(String name, Rol rol) {
        this.name = name;
        this.rol = rol;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", name=" + name + ", rol=" + rol + '}';
    }

    
}
