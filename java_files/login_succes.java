import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login_succes extends JFrame {
    JLabel username, password,l1, l2, l3, l4, l5;
    JTextField user_text;
    JPasswordField pass_text;
    JButton button1;
    public static JFrame frame1;
    public login_succes() throws IOException {
        frame1 = new JFrame();
        frame1.setSize(1500, 900);
        Toolkit tkp = Toolkit.getDefaultToolkit();
        Dimension dim1 = tkp.getScreenSize();

        frame1.setLocationRelativeTo(null);

        frame1.setTitle("Login Page");
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.getHSBColor(0,0,0));
        l1 = new JLabel("BMS COLLEGE OF ENGINEERING");
        l1.setForeground(Color.decode("#89CFF0") );
        l1.setFont(new Font("Times New Roman", Font.BOLD,35));

        l3 = new JLabel("INFORMATION SCIENCE AND ENGINEERING");
        l3.setForeground(Color.white);
        l3.setFont(new Font("Times New Roman", Font.BOLD,25));

        l2 = new JLabel("Department of");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Times New Roman", Font.BOLD,25));

        l4 = new JLabel("Welcomes you to Leave Management System");
        l4.setForeground(Color.white);
        l4.setFont(new Font("Times New Roman", Font.BOLD,20));

        l5 = new JLabel("HAVE A NICE DAY!");
        l5.setForeground(Color.white);
        l5.setFont(new Font("Times New Roman", Font.BOLD,20));

        username = new JLabel("USERNAME:");
        username.setForeground(Color.decode("#89CFF0") );
        username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        user_text = new JTextField(15);

        password = new JLabel("PASSWORD:");
        password.setForeground(Color.decode("#89CFF0" ));
        password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pass_text = new JPasswordField(15);

        l1.setBounds(485, 30, 800, 30);
        l2.setBounds(700, 110, 890, 30);
        l3.setBounds(500, 150, 900, 30 );
        l4.setBounds(580, 200, 900, 30 );
        username.setBounds(595, 280, 200, 30);
        user_text.setBounds(745, 280, 200, 30);
        password.setBounds(595, 330, 200, 30);
        pass_text.setBounds(745, 330, 200, 30);
        panel1.setLayout(null);
        panel1.setVisible(true);
        panel1.add(l1);
        panel1.add(l2);
        panel1.add(l3);
        panel1.add(l4);
        //username = new JLabel("USERNAME:");
        panel1.add(username);
        //user_text = new JTextField(15);
        panel1.add(user_text);
       // password = new JLabel("PASSWORD");
        panel1.add(password);
        //pass_text = new JPasswordField(15);
        panel1.add(pass_text);
        button1 = new JButton("Submit");
        button1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        ListenForButton lforbutton = new ListenForButton();
        button1.addActionListener(lforbutton);
        button1.setBounds(730, 450, 100, 30);
        l5.setBounds(690, 550, 300, 30);
        panel1.add(button1);
        panel1.add(l5);
        frame1.add(panel1);
        frame1.setVisible(true);
        //frame1.dispose();
    }

        public class ListenForButton implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == button1) {
                    new staff();
                    boolean validate = staff.validatepassword(user_text.getText(), pass_text.getText());
                    if (validate) {
                        try {
                            if (user_text.getText().equals("anjaliv.is17@bmsce.ac.in")) {
                                new hod_ui_window();
                            } else {
                                new UIWindow();
                            }
                            //frame1.setVisible(false);
                            frame1.dispose();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        JDialog d = new JDialog(frame1, "WARNING!");
                        JLabel Blahblah = new JLabel("Wrong Username or Password. Enter Again.");
                        d.add(Blahblah);
                        d.setSize(300, 300);
                        d.setLocationRelativeTo(null);
                        d.setVisible(true);
                        user_text.setText(" ");
                        pass_text.setText(" ");
                       // frame1.setVisible(false);
                    }

                }

            }
            //
        }
            }

















