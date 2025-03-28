package org.example;

import org.example.GUI.SimulationFrame;
import org.example.businessLogic.SimulationManager;

public class Main {
    public static void main(String[] args) {

        //SimulationFrame frame = new SimulationFrame(null);
        SimulationManager gen = new SimulationManager(5, 2, 20, 2, 5, 2, 5);
        Thread t = new Thread(gen);
        t.start();
    }
}

