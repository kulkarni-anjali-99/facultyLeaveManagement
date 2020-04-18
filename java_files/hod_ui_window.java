import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class hod_ui_window extends JFrame {

    JLabel name_message, el_message, cl_message, l1, l2;
    JButton leave_form, encashment_form, logout, change_password, yes, no, leave_appli, back, matern_paternity_form;
    JFrame frame2;
    static int index = 0;
    int earned_left, casual_left;
    JPanel panel2;


    public hod_ui_window() throws SQLException, ClassNotFoundException {
        frame2 = new JFrame();
        frame2.setSize(1000, 1000);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (dim.width / 2) - (frame2.getWidth() / 2);
        int y = (dim.height / 2) - (frame2.getHeight() / 2);
        frame2.setLocation(x, y);

        frame2.setLocationRelativeTo(null);
        panel2 = new JPanel();
        panel2.setBackground(Color.black);
        panel2.setLayout(null);
        //welcome_message = new JLabel("WELCOME TO YOUR ACCOUNT");
        name_message = new JLabel("Welcome " + staff.sname + "!");
        name_message.setForeground(Color.decode("#87CEEB"));
        name_message.setFont(new Font("Century", Font.BOLD, 30));
        new leave_table();

        for (int j = 0; j < leave_table.staff_id.length; j++) {
            if (leave_table.staff_id[j].equals(staff.sid)) {
                index = j;
                break;
            }
        }
        earned_left = 15 - leave_table.earned_leave[index];
        casual_left = 10 - leave_table.casual_leave[index];
        el_message = new JLabel("Number of Earned Leaves left: " + earned_left);
        el_message.setForeground(Color.WHITE);
        el_message.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        cl_message = new JLabel("Number of Casual Leaves left: " + casual_left);
        cl_message.setForeground(Color.WHITE);
        cl_message.setFont(new Font("Times New Roman", Font.ITALIC, 18));
        leave_form = new JButton("APPLY FOR LEAVE");
        leave_form.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                new appli_leave();
            }
        });
        encashment_form = new JButton("APPLY FOR ENCASHMENT");
        encashment_form.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                new appli_encashment();
            }
        });

        change_password = new JButton("CHANGE PASSWORD");
        change_password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                new change_pass();
            }
        });
        logout = new JButton("LOGOUT");
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame2.setVisible(false);
                try {
                    new login_succes();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        leave_appli = new JButton("LEAVE APPLICATIONS");
        leave_appli.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new leave_list();
            }
        });
        matern_paternity_form= new JButton("MATERNITY/PATERNITY FORM");
        matern_paternity_form.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new matern_patern_form();
                frame2.setVisible(false);
            }
        });
        name_message.setBounds(350, 100, 700, 30);
        el_message.setBounds(360, 280, 700, 30);
        cl_message.setBounds(360, 230, 700, 30);
        leave_form.setBounds(150, 400, 200, 40);
        encashment_form.setBounds(350, 400, 200, 40);
        change_password.setBounds(700, 1, 200, 35);
        logout.setBounds(900, 1, 100, 35);
        leave_appli.setBounds(360, 550, 200, 40);
        matern_paternity_form.setBounds(550, 400, 250, 40);
        panel2.add(name_message);
        panel2.add(el_message);
        panel2.add(cl_message);
        panel2.add(leave_form);
        panel2.add(change_password);
        panel2.add(encashment_form);
        panel2.add(matern_paternity_form);
        panel2.add(logout);
        panel2.add(leave_appli);
        frame2.add(panel2);
        frame2.setVisible(true);
    }

}






