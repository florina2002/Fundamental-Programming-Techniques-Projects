package org.example.businessLogic;

import org.example.model.Server;
import org.example.model.Task;

import java.util.List;

public class TimeStrategy implements Strategy{

    private Server s=null;
    @Override
    public void addTask(List<Server> servers, Task task) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < servers.size(); i++) {
            if (servers.get(i).getWaitingPeriod() < min) {
                min = servers.get(i).getWaitingPeriod();
                s=servers.get(i);
            }
        }
        s.addTask(task);

    }


}
