package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {

    JTextField textField;// it should be declared globally
    JPasswordField jPasswordField;
    JButton b1, b2;

    login() {

        JLabel nameLabel = new JLabel("UserName");
        nameLabel.setBounds(40, 20, 100, 30); // where to settle the label
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));  //the name and font style of the username
        nameLabel.setForeground(Color.BLACK); //to change the color of font
        add(nameLabel);

        JLabel password = new JLabel(("Password"));
        password.setBounds(40, 70, 100, 30);
        password.setFont(new Font("Tahoma", Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 179, 0));
        add(textField);    // to add the textField to the web page

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 179, 0));
        add(jPasswordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));   // to get an image icon on the interface
        Image i1 = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);  // this is ued to scale and alter the image according to the interface
        ImageIcon imageIcon1 = new ImageIcon(i1);   // this the scaled image which we have used
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, -30, 400, 300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);  // to change the color of the button
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(109, 164, 170));  // these are custom colors
        setSize(750, 300);
        setLocation(400, 270);  //to move the frame in the centre
        setLayout(null);           // we can design our frame on our needs
        setVisible(true);          //because by default the visiblity of JFrame will be hidden


    }


    public static void main(String[] args) {
        new login();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1) {   // action listener uses the button b1 or b2 and it uses this by using e.getSource
            try {
                conn c = new conn();
                String user = textField.getText(); // when we enter a text in the interface then it will remove it and pass it to the database and it is stored in user
                String Pass = jPasswordField.getText();

                String q = "select * from login where ID ='" + user + "' and  PW= '" + Pass + "'";   // this is creation of a query
                ResultSet resultSet = c.statement.executeQuery(q);  // it checks if the query matches

                if (resultSet.next()) {
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }

        } else {
            System.exit(10);
        }
    }
}

