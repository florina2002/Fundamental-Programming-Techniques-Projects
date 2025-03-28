package org.example.businessLogic;

import org.example.model.Server;
import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    public List<Server> servers;
    public int maxNoServers;
    public int maxTasksPerServer;
    public Strategy strategy;

    public int maxSimulationTime;




    public Scheduler(int maxNoServers, int maxTasksPerServer, int maxSimulationTime) {
        //create thread with the object of the class Server
        this.maxNoServers = maxNoServers;
        this.maxTasksPerServer = maxTasksPerServer;
        this.maxSimulationTime = maxSimulationTime;
            servers=new ArrayList<>();
        for (int i = 0; i < maxNoServers; i++) {
            Server server = new Server();
            Thread thread = new Thread(server);
            thread.start();
            servers.add(server);
        }
    }




    public void changeStrategy(){
        SelectionPolicy policy= SelectionPolicy.SHORTEST_TIME;
        if(policy == SelectionPolicy.SHORTEST_QUEUE) {
          //  strategy = new ShortestQueueStrategy();
        }
        else if(policy == SelectionPolicy.SHORTEST_TIME) {
            strategy = new TimeStrategy();
        }

    }



    public void dispatchTask(Task t) {
        strategy.addTask(servers, t);
    }

    public List<Server> getServers() {
        return servers;
    }

}
