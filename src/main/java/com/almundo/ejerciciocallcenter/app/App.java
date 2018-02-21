package com.almundo.ejerciciocallcenter.app;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;
/**
 *
 * @author rcarrascal
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context=SpringApplication.run(App.class, args);
    }
}