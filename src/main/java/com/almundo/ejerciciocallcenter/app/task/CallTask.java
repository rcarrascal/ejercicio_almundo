/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.ejerciciocallcenter.app.task;

import com.almundo.ejerciciocallcenter.app.model.Call;
import com.almundo.ejerciciocallcenter.app.model.Employee;
import com.almundo.ejerciciocallcenter.app.services.EmpleoyeService;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author rcarrascal
 */
@Component
public class CallTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallTask.class);

    //Ejecutor que se encargara de administrar los hilos de las llamadas
    private ExecutorService executor;

    @Autowired
    private EmpleoyeService empleoyeService;

    //Cola concurrente donde estaran todas las llamadas entrantes
    private final Queue<Call> calls;

    private boolean isAlive = true;

    public CallTask() {
        executor = Executors.newFixedThreadPool(11);
        this.calls = new ConcurrentLinkedQueue<>();
    }

    @PostConstruct
    public void init() {
        executor.submit(() -> {
            this.execute();
        });

    }

    public void addCall(Call call) {
        LOGGER.info("Agregamos una nueva llamada a la cola");
        calls.add(call);
    }

    /*
     * Procesador que se ejecutara y encontrara las llamadas encoladas
     */
    public void execute() {
        LOGGER.info("Iniciamos procesador de llamadas");
        while (isAlive) {
            //Obtenemos el empleado disponible para ejecutar la llamada
            Optional.ofNullable(empleoyeService.getEmployeAvailabilable())
                    .ifPresent(employee -> {
                        //Si enconramos un empleado dispoible le asignamos llamada
                        Call currentCall = calls.poll();
                        currentCall.setEmployee(employee);
                        executor.submit(() -> {
                            call(currentCall);
                        });
                    });

        }
    }

    //Utilidad para simular una llamada real
    private void call(Call call) {
        LOGGER.info("Llamada iniciada " + call);
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Volvemos agregar el empleado a la cola de disponibles
        empleoyeService.addEmpleoye(call.getEmployee());
    }

}
