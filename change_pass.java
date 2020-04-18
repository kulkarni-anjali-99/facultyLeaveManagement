import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class change_pass extends JFrame {
    JLabel l1, l2, l3, l4, l5;
    JTextField tf2;
    JPasswordField old_pass, new_pass1, new_pass2;
    JButton btn1, btn2, btn3;
    JFrame change_pass;
    int index;

    public change_pass() {

        change_pass = new JFrame();
        change_pass.setSize(700, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (dim.width / 2) - (change_pass.getWidth() / 2);
        int y = (dim.height / 2) - (change_pass.getHeight() / 2);
        change_pass.setLocation(x, y);
        change_pass.setTitle("Change Password");
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        l1 = new JLabel("Change Password");
        l1.setForeground(Color.white);
        l1.setFont(new Font("Century", Font.BOLD, 30));
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l2 = new JLabel("User Name:");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Century", Font.ITALIC, 15));
        l3 = new JLabel("Old Password:");
        l3.setForeground(Color.white);
        l3.setFont(new Font("Century", Font.ITALIC, 15));
        l4 = new JLabel("New Password:");
        l4.setForeground(Color.white);
        l4.setFont(new Font("Century", Font.ITALIC, 15));
        l5 = new JLabel("Confirm Password:");
        l5.setForeground(Color.white);
        l5.setFont(new Font("Century", Font.ITALIC, 15));
        btn1 = new JButton("Submit");
        btn2 = new JButton("Cancel");
        btn3 = new JButton("Back");
        tf2 = new JTextField();
        old_pass = new JPasswordField();
        new_pass1 = new JPasswordField();
        new_pass2= new JPasswordField();
        l1.setBounds(180, 30, 400, 30);
        l2.setBounds(80, 90, 200, 30);
        l3.setBounds(80, 130, 200, 30);
        l4.setBounds(80, 170, 200, 30);
        l5.setBounds(80, 210, 200, 30);
        tf2.setBounds(300, 90, 200, 30);
        old_pass.setBounds(300, 130, 200, 30);
        new_pass1.setBounds(300, 170, 200, 30);
        new_pass2.setBounds(300, 210, 200, 30);
        btn1.setBounds(220, 310, 100, 30);
        btn2.setBounds(350, 310, 100, 30);
        btn3.setBounds(285, 380, 100, 30);
        p.setLayout(null);
        p.setVisible(true);
        p.add(l1);
        p.add(l2);
        p.add(tf2);
        p.add(l3);
        p.add(old_pass);
        p.add(l4);
        p.add(new_pass1);
        p.add(l5);
        p.add(new_pass2);
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
        change_pass.add(p);
        change_pass.setVisible(true);
        change_pass.ListenForButton3 lforbutton3 = new change_pass.ListenForButton3();
        btn1.addActionListener(lforbutton3);
        btn2.addActionListener(lforbutton3);
        btn3.addActionListener(lforbutton3);
    }

    public class ListenForButton3 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btn3) {
                change_pass.setVisible(false);
                try {
                    new UIWindow();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getSource()==btn1)
            {
                   new staff();
                    String user= tf2.getText();
                    String old= old_pass.getText();
                    String new1= new_pass1.getText();
                    String new2= new_pass2.getText();
                try {
                    boolean ans= staff.updatestaff(user,old,new1,new2);
                    if(ans) {
                        JDialog d = new JDialog(change_pass, "WARNING!");
                        JLabel Blahblah = new JLabel("Password change succesful");
                        d.add(Blahblah);
                        d.setSize(300, 300);
                        d.setLocationRelativeTo(null);
                        d.setVisible(true);
                    }
                    else {
                        JDialog d = new JDialog(change_pass, "WARNING!");
                        JLabel Blahblah = new JLabel("Enter correct username/ old password/ new password");
                        d.add(Blahblah);
                        d.setSize(300, 300);
                        d.setLocationRelativeTo(null);
                        d.setVisible(true);

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            }
            }
        }


