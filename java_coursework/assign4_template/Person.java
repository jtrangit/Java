//CIS 2168 Data Structures
//Section 005
//Johnny Tran, tun45633@temple.edu
//Assign 4, HiringApp

package assign4_template;

import java.util.ArrayList;

public class Person { 
    //data fields
    private String name;
    private String degree;
    private ArrayList<String> skills;

    
    //constructors
    public Person(String name, String degree, ArrayList<String> skills) {
        this.name = name;
        this.degree = degree;
        this.skills = skills;
    }

    public Person() {

    }

    //getters
    public getName() {
        return name;
    }
    public getDegree() {
        return degree;
    }
    public getSkills() {
        return skills;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }
    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }
    
    //toString
    @Override
    public String toString() {
        return name; //toString of just the person's name to make it look cleaner

        //actual toString with all info below
        //return "Name: " + name + "\n" + "Degree: " + degree + "\n" + "Skills: " + skills;
    }
}

