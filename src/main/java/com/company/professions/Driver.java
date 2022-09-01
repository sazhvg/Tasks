package com.company.professions;

import Phone.Phone;
import com.company.entities.Person;

public class Driver extends Person {
    private int experience;


    public void setExperience(int experience){
        this.experience = experience;
    }
    public int getExperience() {
        return experience;
    }


    public String toString() {
        return "ПІБ водія: " + getName() + ", номер тел.: " + getNumber() + ", вік: " + getAge() + ", стать: " +
                getGender() + "стаж водіння: " + experience +".";
    }
}
