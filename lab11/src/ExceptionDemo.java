/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class ExceptionDemo {

    public static void main(String[] args) {

        try {
            String a = args[0];
            String b = args[1];
            String c = args[2];
            
            double a2 = Double.parseDouble(a);
            double b2 = Double.parseDouble(b);
            double c2 = Double.parseDouble(c);

            double x1 = (-b2 + Math.sqrt((b2 * b2) - 4 * (a2 * c2))) / (2 * a2);
            double x2 = (-b2 - Math.sqrt((b2 * b2) - 4 * (a2 * c2))) / (2 * a2);

            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please enter 3 numbers as a, b, and c respectively.");
        } catch (NumberFormatException e) {
            System.out.println("Please input data in number format only.");
        }
    }

}
