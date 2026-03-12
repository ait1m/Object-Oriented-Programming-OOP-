/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.awt.*;
import javax.swing.*;

public class MyFrame {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        MyClock clock = new MyClock();
        Thread t = new Thread(clock);
        
        t.start();
        
        fr.add(clock ,BorderLayout.CENTER);
        fr.setSize(300,150);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
