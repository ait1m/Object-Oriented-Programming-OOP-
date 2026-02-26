/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class CheckingAccount extends Account {

    private double credit;

    public CheckingAccount() {
        super(0, "");
        credit = 0;
    }

    public CheckingAccount(double balance, String name, double credit) {
        super(balance, name);
        this.credit = credit;
    }

    public void setCredit(double credit) {
        if (credit > 0) {
            this.credit = credit;
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

    public double getCredit() {
        return credit;
    }

    @Override
    public void withdraw(double a) {
        if (a > 0) {
            if ((balance - a) >= 0) {
                this.balance -= a;
                System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit + ".");
            } else if (((balance - a) <= 0) && (((balance - a) + credit) >= 0)) {
                this.credit -= (a - balance);
                this.balance = 0;
                System.out.println(a + " baht is withdrawn from " + name + " and your credit balance is " + credit + ".");
            } else if (((balance - a) < 0) && (((balance - a) + credit) < 0)) {
                System.out.println("Not enough money!");
            }
        } else {
            System.out.println("Input number must be a positive integer.");
        }
    }

     public void withdraw(String a) {
        this.withdraw(Double.valueOf(a));
    }

    @Override
    public String toString() {
        return "The " + name + " account has " + balance + " baht and " + credit + " credits.";
    }
}
