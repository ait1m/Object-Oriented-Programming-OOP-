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
import java.util.ArrayList;

public class PoringConstructor implements ActionListener {

    private JFrame fr;
    private JButton btn;
    private int num = 0;

    private ArrayList<Poring> porings = new ArrayList<>();

    public PoringConstructor(){

        fr = new JFrame();

        btn = new JButton("Add");

        fr.setLayout(new FlowLayout());
        fr.add(btn);

        btn.addActionListener(this);

        fr.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){

                for(Poring p : porings){
                    p.stopPoring();
                }

                System.exit(0);
            }
        });

        fr.setSize(200,150);
        fr.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        num++;

        Poring p = new Poring(num);

        porings.add(p);

    }
}