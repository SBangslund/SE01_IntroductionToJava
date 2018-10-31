/*
 * Created by Samuel Bangslund, Odense SDU Software Engineering 1. semester.
 */
package chapter_11_exercises._02;

/**
 *
 * @author Samuel Bangslund
 */
public class Person {

    private String name, address, phoneNumber, emailAddress;
    
    public Person() {
        
    }
    
    public Person(String name, String address, String phoneNumber, String emailAddress) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Person: name = " + this.name + 
                ", address = " + this.address + 
                ", phoneNumber = " + this.phoneNumber + 
                ", emailAddress = " + this.emailAddress;
    }
    
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    
}
