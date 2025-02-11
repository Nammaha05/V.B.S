import javax.swing.*;
import java.awt.*;

class Apage extends JFrame {
    Apage() {
        Font f = new Font("Futura", Font.BOLD, 40);
        Font f2 = new Font("Calibri", Font.PLAIN, 22);

        JLabel l1 = new JLabel("Welcome Admin", JLabel.CENTER);
        JLabel l2 = new JLabel();
        JButton b1 = new JButton("Logout");
        JButton b2 = new JButton("Show All Users");

        l1.setFont(f);
        b1.setFont(f2);
        b2.setFont(f2);

        Container c = getContentPane();
        c.setLayout(null);

        l1.setBounds(110, 30, 600, 50);
        b2.setBounds(250, 100, 300, 40);
        b1.setBounds(250, 160, 300, 40);
        l2.setBounds(250, 220, 300, 30);

        c.add(l1);
        c.add(b2);
        c.add(b1);
        c.add(l2);

        setVisible(true);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Admin Page");
    }

    public static void main(String[] args) {
        new Apage();
    }
}
