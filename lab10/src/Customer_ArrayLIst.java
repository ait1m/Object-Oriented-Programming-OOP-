/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.ArrayList;
public class Customer_ArrayLIst {
    private String firstName;
    private String lastName;
    private ArrayList acct;
    private int numOfAccount;

    public Customer_ArrayLIst() {
        this.firstName = "";
        this.lastName = "";
        this.acct = null;
    }

    public Customer_ArrayLIst(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.acct = new ArrayList();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount(int index){
        return (Account) acct.get(index);
    }
    
    public void addAccount(Account acct){
        this.acct.add(acct);
        numOfAccount++;
    }
    
    public int getNumOfAccount(){
        return acct.size();
    }

    @Override
    public String toString() {
        if (this.acct == null) {
            return (firstName + " " + lastName + " doesn’t have account.");
        } else {
            return (firstName + " " + lastName + " have " + this.numOfAccount + " account(s).");
        }
    }

    public boolean equals(Customer c) {
        return (this.firstName.equals(c.getFirstName())) && (this.lastName.equals(c.getLastName()));
    }
}

