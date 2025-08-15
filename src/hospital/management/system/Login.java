package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField  textField;
    JPasswordField passField;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try{
                conn c = new conn();
                String user = textField.getText();
                String pass = new String(passField.getPassword());

                String q = "select * from login where ID = '"+user+"' and  PW = '"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            System.exit(10);
        }

    }

    JButton b1, b2;

    Login() {

        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(40, 20, 100, 30);
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        nameLabel.setForeground(Color.black);
        add(nameLabel);


        JLabel password = new JLabel("Password ");
        password .setBounds(40, 70, 100, 30);
        password .setFont(new Font("Tahoma", Font.BOLD, 16));
        password .setForeground(Color.black);
        add(password );

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textField.setBackground(new Color(255,179,0));
        add(textField);


        passField = new JPasswordField();
        passField.setBounds(150, 70, 150, 30);
        passField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passField.setBackground(new Color(255,179,0));
        add(passField);

        // Load image from resources folder (inside src)
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));

        // Resize image
        Image i1 = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_SMOOTH);

         // Convert back to ImageIcon
        ImageIcon scaledIcon = new ImageIcon(i1);

        // Create JLabel with image
        JLabel imageLabel = new JLabel(scaledIcon);

         // Position the image
        imageLabel.setBounds(320, 30, 400, 300);

// Add to frame
        add(imageLabel);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("serif", Font.BOLD, 15));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("serif", Font.BOLD, 15));
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(109,164,170));
        setSize(750, 300);
        setLocation(400,270);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Hospital Management System - Login");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}
