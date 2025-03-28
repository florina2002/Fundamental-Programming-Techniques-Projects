package org.example.model;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {

    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private int finalTime;
    private int aux;
    public Server() {
        this.aux = 1;
        tasks = new ArrayBlockingQueue<Task>(20);
        waitingPeriod = new AtomicInteger(0);
    }


    public void addTask(Task newtask) {

        //add task to queue
        //update waiting period
        tasks.add(newtask);
        waitingPeriod.addAndGet(newtask.getServiceTime());
    }

    @Override
    public void run() {

        while (aux==1) {
            //take new task from queue
            //stop the thread for a time equal with the task's processing time
            //decrease waiting period
                try {
                    if(tasks.isEmpty()) {
                        Thread.sleep(100);
                        continue;
                    }
                    Task task = tasks.take();
                    Thread.sleep(task.getServiceTime());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
        }
    }

    public void setTasks(BlockingQueue<Task> tasks) {
        this.tasks = tasks;
    }

    public int getWaitingPeriod() {
        return waitingPeriod.get();
    }

    public void setWaitingPeriod(int waitingPeriod) {
        this.waitingPeriod.set(waitingPeriod);
    }

    public BlockingQueue<Task> getTasks() {
        return tasks;
    }


}
