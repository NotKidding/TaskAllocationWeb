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
    private int currentWorkload; //Added property to track workload
    
    public TeamMember(String name, int skillLevel){
        this.name = name;
        this.skillLevel = skillLevel;
        this.currentWorkload = 0; //start workload from 0
    }
    
    //Getters
    public String getName(){
        return name;
    }
    public int getSkillLevel(){
        return skillLevel;
    }
    public int getCurrentWorkload(){
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
        this.currentWorkload = currentWorkload;
    }
    
    //Additional method to add work
    public void addWork(int workAmount){
        currentWorkload += workAmount;
    }
    
    //Additional method to check if the team member is overloaded
    public boolean isOverloaded(int workloadLimit){
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
