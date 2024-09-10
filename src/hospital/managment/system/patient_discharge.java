package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import static java.awt.Choice.*;

public class patient_discharge extends JFrame {

    patient_discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel label1 = new JLabel("CHECK- OUT");
        label1.setBounds(100,20,150,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("CUSTOMER-ID");
        label2.setBounds(30,80,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c =new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from  Patient_Info");
            while(resultSet.next()){
                choice.add(resultSet.getString("number"));

            }
        }catch(Exception e){
            e.printStackTrace();
        }


        JLabel label3 = new JLabel("ROOM NUMBER");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel Rno = new JLabel();
        Rno.setBounds(200,130,150,20);
        Rno.setFont(new Font("Tahoma",Font.BOLD,14));
        Rno.setForeground(Color.white);
        panel.add(Rno);


        JLabel label4 = new JLabel("IN TIME");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.white);
        panel.add(label4);


        JLabel INTIME = new JLabel();
        INTIME.setBounds(200,180,250,20);
        INTIME.setFont(new Font("Tahoma",Font.BOLD,14));
        INTIME.setForeground(Color.white);
        panel.add(INTIME);


        JLabel label5 = new JLabel("OUT TIME");
        label5.setBounds(30,230,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.white);
        panel.add(label5);


        Date date = new Date();


        JLabel OUTIME  = new JLabel(""+date);
        OUTIME.setBounds(200,230,250,20);
        OUTIME.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTIME.setForeground(Color.white);
        panel.add(OUTIME);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conn c = new conn();
                try {

                    c.statement.executeUpdate("delete from Patient_Info where number = '" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("update room set Status = 'Available' where Room_Number ='"+ Rno.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton check  = new JButton("Check ");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from Patient_Info where number  = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next()){
                        Rno.setText(resultSet.getString("Room_Number"));
                        INTIME.setText(resultSet.getString("Time"));
                    }

                }catch(Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton Back  = new JButton("BACK ");
        Back.setBounds(300,300,120,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.white);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });













        setUndecorated(true);
        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);


    }

    public static void main(String[] args) {
        new patient_discharge();

    }
}
