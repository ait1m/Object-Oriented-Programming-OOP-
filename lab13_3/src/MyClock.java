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


public class MyClock extends JLabel implements Runnable {

    public void run() {
        int sec = 0;
        int min = 0;
        int hour = 0;

        Font font = new Font("Monospaced", Font.BOLD, 50);
        this.setFont(font);
        this.setHorizontalAlignment(CENTER);

        while (true) {

            this.setText(String.format("%02d:%02d:%02d", hour, min, sec));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            sec++;

            if (sec == 60) {
                sec = 0;
                min++;
            }

            if (min == 60) {
                min = 0;
                hour++;
            }
        }
    }
}