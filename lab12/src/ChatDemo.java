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
public class ChatDemo {
    private JFrame fr;
    private JTextArea textArea;
    private JTextField textField;
    private JPanel panel , btnpanel;
    private JButton sub , re;
    
    public ChatDemo(){
        fr = new JFrame();
        textArea = new JTextArea(20 , 45);
        textField = new JTextField(45);
        panel = new JPanel();
        btnpanel = new JPanel();
        sub = new JButton("Submit");
        re = new JButton("Reset");
        
        textArea.setEditable(false);
        
        fr.setLayout(new BorderLayout());
        fr.add(textArea, BorderLayout.CENTER);
        
        panel.setLayout(new GridLayout(2 , 1));
        panel.add(textField);
        panel.add(btnpanel);
        
        btnpanel.setLayout(new FlowLayout());
        btnpanel.add(sub);
        btnpanel.add(re);
        
        fr.add(panel,BorderLayout k);
        
        
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }
}
