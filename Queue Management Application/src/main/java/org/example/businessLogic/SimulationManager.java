package org.example.businessLogic;

import org.example.model.Server;
import org.example.model.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimulationManager implements Runnable{

    private int nrClients;
    private int nrQueues;
    private int simulationInterval;
    private int minArrival;
    private int maxArrival;
    private int minService;
    private int maxService;
    private Scheduler scheduler;
    private List<Task> generatedTasks=new ArrayList<>();



    public SimulationManager(int nrClients, int nrQueues, int simulationInterval, int minArrival, int maxArrival, int minService, int maxService) {
        this.nrClients=nrClients;
        this.nrQueues=nrQueues;
        this.simulationInterval=simulationInterval;
        this.minArrival=minArrival;
        this.maxArrival=maxArrival;
        this.minService=minService;
        this.maxService=maxService;
        scheduler = new Scheduler(nrQueues, nrClients, simulationInterval);
        scheduler.changeStrategy();
        for(int i=0; i<nrQueues;i++){
            Thread thread = new Thread(scheduler.getServers().get(i));
            thread.start();
        }
        generateNRandomTasks(nrClients);

    }

    public void generateNRandomTasks(int n){
        for(int i=0; i<n; i++){
            int arrivalTime = (int) (Math.random() * (maxArrival - minArrival)) + minArrival;
            int processingTime = (int) (Math.random() * (maxService - minService)) + minService;
            Task task = new Task(i,arrivalTime, processingTime);
            generatedTasks.add(task);
        }
    }
    public void run() {
        int currentTime = 1;
        while(currentTime<=simulationInterval){
            Iterator<Task> iterator = generatedTasks.iterator();
            while (iterator.hasNext()) {
                Task t = iterator.next();
                if (t.getArrivalTime() == currentTime) {
                    scheduler.dispatchTask(t);
                    iterator.remove();
                }
            }
            System.out.println("Time: " + currentTime);
            for(Task t: generatedTasks){
                System.out.println("Task " + t.getID() + " arrival time: " + t.getArrivalTime() + " serving time: " + t.getServiceTime());
                }
            for(Server s: scheduler.getServers()){
                if(s.getTasks().size()!=0)
                {
                    System.out.println("Queue " + ": ");
                    for(Task t: s.getTasks()){
                        System.out.println("Task " + t.getID() + " " + t.getArrivalTime() + " " + t.getServiceTime());
                    }
                }

                else
                    System.out.println("Queue " + ": closed");

            }
            System.out.println("\n");
            currentTime++;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
