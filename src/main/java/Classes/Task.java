/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author HP
 */
public class Task {
    private String name;
    private int priority;
    private int requiredSkill;
    private String assignedTo;
    
    public Task(String name, int priority, int requiredSkill){
        this.name = name;
        this.priority = priority;
        this.requiredSkill = requiredSkill;
    }
    //Getters
    public String getName(){
        return name;
    }
    public int getPriority(){
        return priority;
    }
    public int getRequiredSkill(){
        return requiredSkill;
    }
    public String getAssignedTo(){
        return assignedTo;
    }
    
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setPriority(int priority){
        this.priority = priority;
    }
    public void setRequiredSkill(int requiredSkill){
        this.requiredSkill = requiredSkill;
    }
    public void setAssignedTo(String assignedTo){
        this.assignedTo = assignedTo;
    }
    
    @Override
    public String toString(){
        return "Task{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                "requiredSkill=" + requiredSkill +
                '}';
    }
}
