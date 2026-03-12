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
import java.io.*;

public class StudentView implements ActionListener {
    private JFrame fr;
    private JTextField txtID , txtName, txtMoney;
    private JLabel IDlabel ,Namelabel , Moneylabel;
    private JButton deposit , withdraw;
    private JPanel btn ,IDpanel ,Namepanel ,Moneypanel;

    public StudentView(){
        fr = new JFrame();
        txtID = new JTextField();
        txtName = new JTextField();
        txtMoney = new JTextField("0");
        txtMoney.setEditable(false);

        IDlabel = new JLabel("   ID :");
        Namelabel = new JLabel("   Name :");
        Moneylabel = new JLabel(" Money :");

        deposit = new JButton("Deposit");
        withdraw = new JButton("Withdraw");

        IDpanel = new JPanel();
        Namepanel = new JPanel();
        Moneypanel = new JPanel();
        btn = new JPanel();

        IDpanel.setLayout(new GridLayout(1,2));
        IDpanel.add(IDlabel);
        IDpanel.add(txtID);

        Namepanel.setLayout(new GridLayout(1,2));
        Namepanel.add(Namelabel);
        Namepanel.add(txtName);

        Moneypanel.setLayout(new GridLayout(1,2));
        Moneypanel.add(Moneylabel);
        Moneypanel.add(txtMoney);

        btn.add(deposit);
        btn.add(withdraw);

        fr.setLayout(new GridLayout(4,1));
        fr.add(IDpanel);
        fr.add(Namepanel);
        fr.add(Moneypanel);
        fr.add(btn);

        deposit.addActionListener(this);
        withdraw.addActionListener(this);

        try{
            File f = new File("StudentM.dat");

            if(f.exists()){
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);

                Student s = (Student) oi.readObject();

                txtID.setText(String.valueOf(s.getID()));
                txtName.setText(s.getName());
                txtMoney.setText(String.valueOf(s.getMoney()));

                oi.close();
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        fr.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                try{

                    Student s = new Student(
                            txtName.getText(),
                            Integer.parseInt(txtID.getText()),
                            Integer.parseInt(txtMoney.getText())
                    );

                    FileOutputStream fo = new FileOutputStream("StudentM.dat");
                    ObjectOutputStream oo = new ObjectOutputStream(fo);

                    oo.writeObject(s);

                    oo.close();

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

        int money = Integer.parseInt(txtMoney.getText());

        if(e.getSource() == deposit){
            money = money + 100;
            txtMoney.setText(String.valueOf(money));
        }

        if(e.getSource() == withdraw){
            money = money - 100;
            txtMoney.setText(String.valueOf(money));
        }
    }

    public static void main(String[] args) {
        new StudentView();
    }
}