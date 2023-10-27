/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author HP
 */
public class TeamMember {
    private String name;
    private int skillLevel;
    private int currentWorkLoad; //Added property to track workload
    
    public TeamMember(String name, int skillLevel){
        this.name = name;
        this.skillLevel = skillLevel;
        this.currentWorkLoad = 0; //start workload from 0
    }
    
    //Getters
    public String getName(){
        return name;
    }
    public int getSkillLevel(){
        return currentWorkload;
    }
    
    //Setters
    public void setName(String name){
        this.name = name;
    }
    public void setSkillLevel(int skillLevel){
        this.skillLevel = skillLevel;
    }
    public void setCurrentWorkload(int currentWorkLoad){
        this.currentWorkLoad = currentWorkload;
    }
    
    //Additional method to add work
    public void addWork(int workAmount){
        currentWorklaod += workAmount;
    }
    
    //Additional method to check if the team member is overloaded
    public boolean is Overloaded(int workloadLimit){
        return currentWorkload > workloadLimit;
    }
    
    @Override
    public String toString(){
        return "TeamMember{" +
                "name='" + name + '\'' +
                ", skillLevel=" + skillLevel +
                ", currentWorkload=" + currentWorkload +
                '}';
    }
}
