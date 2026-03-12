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
import java.util.*; // import for Calendar

public class MyClock extends JLabel implements Runnable {

    public void run() {
        while (true) {
            Calendar d = Calendar.getInstance();
            int sec = d.get(Calendar.SECOND);
            int min = d.get(Calendar.MINUTE);
            int hour = d.get(Calendar.HOUR_OF_DAY);
            
            Font font = new Font("Monospaced",Font.BOLD,50);
            this.setFont(font);
            this.setText(String.format("%02d:%02d:%02d",hour,min,sec));
            this.setHorizontalAlignment(CENTER);
            
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
