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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;

public class ChatDemo implements ActionListener{

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
        fr.add(new JScrollPane(textArea), BorderLayout.CENTER);

        panel.setLayout(new GridLayout(2 , 1));
        panel.add(textField);
        panel.add(btnpanel);

        btnpanel.setLayout(new FlowLayout());
        btnpanel.add(sub);
        btnpanel.add(re);

        fr.add(panel, BorderLayout.SOUTH);

        sub.addActionListener(this);
        re.addActionListener(this);

        try{
            File f = new File("ChatDemo.dat");

            if(f.exists()){
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;

                while((line = br.readLine()) != null){
                    textArea.append(line + "\n");
                }

                br.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        fr.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){

                try{
                    BufferedWriter bw = new BufferedWriter(new FileWriter("ChatDemo.dat"));

                    bw.write(textArea.getText());

                    bw.close();
                }catch(Exception ex){
                    ex.printStackTrace();
                }

                System.exit(0);
            }
        });

        fr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        fr.pack();
        fr.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        if(e.getSource() == sub){

            String msg = textField.getText();

            textArea.append(dtf.format(LocalDateTime.now()) + " : " + msg + "\n");

            textField.setText("");
        }

        if(e.getSource() == re){

            textArea.setText("");
        }
    }

    public static void main(String[] args) {
        new ChatDemo();
    }
}