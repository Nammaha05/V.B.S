import javax.swing.*;
import java.awt.*;
import java.sql.*;

class Home extends JFrame {
    Home(String username) {
        double balance = 0.0;
        Font f = new Font("Futura", Font.BOLD, 40);
        Font f2 = new Font("Calibri", Font.PLAIN, 22);

        JLabel title = new JLabel("Welcome " + username, JLabel.CENTER);
        JLabel balanceLabel = new JLabel("Balance: ₹0.00", JLabel.CENTER);
        JButton b1 = new JButton("Deposit");
        JButton b2 = new JButton("Withdraw");
        JButton b3 = new JButton("Profile Settings");
        JButton b4 = new JButton("Transfer");
        JButton b5 = new JButton("Passbook");
        JButton b6 = new JButton("Logout");

        title.setFont(f);
        balanceLabel.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);
        b3.setFont(f2);
        b4.setFont(f2);
        b5.setFont(f2);
        b6.setFont(f2);

        Container c = getContentPane();
        c.setLayout(null);

        title.setBounds(100, 30, 600, 50);
        balanceLabel.setBounds(100, 100, 600, 30);

        b1.setBounds(100, 150, 200, 40);
        b2.setBounds(400, 150, 200, 40);

        b3.setBounds(100, 220, 200, 40);
        b4.setBounds(400, 220, 200, 40);

        b5.setBounds(100, 290, 200, 40);
        b6.setBounds(400, 290, 200, 40);

        c.add(title);
        c.add(balanceLabel);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);
        c.add(b5);
        c.add(b6);

        b1.addActionListener(
                a -> {
                    new Deposit(username);
                    dispose();
                }
        );
        b6.addActionListener(
                a->
                {
                    new Landing();
                    dispose();
                }
        );
        b2.addActionListener(
                a->
                {
                    new Withdraw(username);
                    dispose();
                }
        );
        b3.addActionListener(
                a->
                {
                    new Profile(username);
                    dispose();
                }
        );
        b4.addActionListener(
                a->
                {
                    new Transfer(username);
                    dispose();
                }
        );
        b5.addActionListener(
                a->
                {
                    new Passbook(username);
                    dispose();
                }
        );

        String url = "jdbc:mysql://localhost:3306/nam";
        try (Connection con = DriverManager.getConnection(url, "root", "PHW#84#jeor")) {
            String sql = "select balance from users where username=?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, username);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    balance = rs.getDouble("balance");
                }
                balanceLabel.setText("Balance: ₹" + balance);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        b2.addActionListener(
                a->
                {
                    new Withdraw(username);
                    dispose();
                }
        );

        setVisible(true);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Home");
    }

    public static void main(String[] args) {
        new Home("sara");
    }
}
