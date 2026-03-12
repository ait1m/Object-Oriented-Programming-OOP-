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
import java.awt.event.*;

public class Poring implements Runnable {

    private JFrame fr;
    private JLabel picture;
    private JLabel count;
    private Thread t;
    private boolean running = true;

    public Poring(int num){

        fr = new JFrame();

        picture = new JLabel(new ImageIcon("src/poring.png"));
        count = new JLabel(String.valueOf(num));

        fr.setLayout(new FlowLayout());

        fr.add(picture);
        fr.add(count);

        picture.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                fr.dispose();
            }
        });

        t = new Thread(this);
        t.start();

        fr.pack();
        fr.setVisible(true);
        fr.setResizable(false);
        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public void run(){
        while(running){
            try{
                Thread.sleep(1000);
            }catch(Exception e){}
        }
        fr.dispose();
    }

    public void stopPoring(){
        running = false;
    }
}