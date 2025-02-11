import javax.swing.*;
import java.awt.*;
import java.sql.*;

class Nlogin extends JFrame {
    Nlogin() {
        Font f = new Font("Futura", Font.BOLD, 30);
        Font f2 = new Font("Calibri", Font.PLAIN, 18);

        JLabel l1 = new JLabel("Set Username");
        JTextField t1 = new JTextField(10);

        JLabel l2 = new JLabel("Set Password");
        JTextField t2 = new JTextField(10);

        JLabel l3 = new JLabel("Confirm Password");
        JTextField t3 = new JTextField(10);

        JLabel l4 = new JLabel("Phone");
        JTextField t4 = new JTextField(15);

        JLabel l5 = new JLabel("Email");
        JTextField t5 = new JTextField(20);

        JLabel l6 = new JLabel("Gender");
        JComboBox<String> genderBox = new JComboBox<>(new String[]{"male", "female", "other"});

        JButton b1 = new JButton("Submit");
        JButton b2 = new JButton("Back");

        JLabel title = new JLabel("Signup", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 28));

        l1.setFont(f2);
        t1.setFont(f2);
        l2.setFont(f2);
        t2.setFont(f2);
        l3.setFont(f2);
        t3.setFont(f2);
        l4.setFont(f2);
        t4.setFont(f2);
        l5.setFont(f2);
        t5.setFont(f2);
        l6.setFont(f2);
        genderBox.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);

        Container c = getContentPane();
        c.setLayout(null);

        int labelX = 200, fieldX = 400, yStart = 80, width = 150, height = 30, gap = 40;

        title.setBounds(300, 10, 200, 40);

        l1.setBounds(labelX, yStart, width, height);
        t1.setBounds(fieldX, yStart, width, height);

        l2.setBounds(labelX, yStart + gap, width, height);
        t2.setBounds(fieldX, yStart + gap, width, height);

        l3.setBounds(labelX, yStart + 2 * gap, width, height);
        t3.setBounds(fieldX, yStart + 2 * gap, width, height);

        l4.setBounds(labelX, yStart + 3 * gap, width, height);
        t4.setBounds(fieldX, yStart + 3 * gap, width, height);

        l5.setBounds(labelX, yStart + 4 * gap, width, height);
        t5.setBounds(fieldX, yStart + 4 * gap, width, height);

        l6.setBounds(labelX, yStart + 5 * gap, width, height);
        genderBox.setBounds(fieldX, yStart + 5 * gap, width, height);

        b1.setBounds(250, yStart + 6 * gap, 120, 40);
        b2.setBounds(400, yStart + 6 * gap, 120, 40);

        c.add(title);
        c.add(l1);
        c.add(t1);
        c.add(l2);
        c.add(t2);
        c.add(l3);
        c.add(t3);
        c.add(l4);
        c.add(t4);
        c.add(l5);
        c.add(t5);
        c.add(l6);
        c.add(genderBox);
        c.add(b1);
        c.add(b2);

        b1.addActionListener(
                a -> {
                    if (t2.getText().equals(t3.getText())) {
                        String url = "jdbc:mysql://localhost:3306/nam";
                        try (Connection con = DriverManager.getConnection(url, "root", "PHW#84#jeor")) {
                            String sql = "INSERT INTO users(username,password,phone,email,gender) VALUES(?, ? , ?, ?, ?)";
                            try (PreparedStatement pst = con.prepareStatement(sql)) {
                                pst.setString(1,t1.getText());
                                pst.setString(2,t2.getText());
                                pst.setString(3,t4.getText());
                                pst.setString(4,t5.getText());
                                pst.setString(5,genderBox.getSelectedItem().toString());

                                pst.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Signup Successful");
                                new Home(t1.getText());
                                dispose();
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Passwords do not match");
                    }
                }
        );

        b2.addActionListener(
                a->
                {
                    new Landing();
                    dispose();
                }
        );

        setVisible(true);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Signup");
    }

    public static void main(String[] args) {
        new Nlogin();
    }
}
