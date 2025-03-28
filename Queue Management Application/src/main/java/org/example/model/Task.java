package org.example.model;

public class Task {

    int ID; //ID of each person
    int arrivalTime; //arrival time of each person
    int serviceTime; //service time of each person


    //constructor
    public Task(int ID, int arrivalTime, int serviceTime) {
        this.ID = ID;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }

    //getters and setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public String toString() { //override the toString method to print the task in the format (ID, arrivalTime, serviceTime)
        return "(" + this.getID() + ", " + this.getArrivalTime() + ", " + this.serviceTime + ")";
    }


}
