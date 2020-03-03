package CSCI4448project3;

import CSCI4448project3.Customer;

public class BusinessCustomer extends Customer{
    
    public BusinessCustomer(String name){
        super(name);        
    }

    public void setName(String name){
        this.name = name;
    }
}