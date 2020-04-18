import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.Properties;


public class appli_leave extends JFrame {//1
    public static String sid;
    JLabel el1, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11 ,l12;
    JTextField tf2, tf5, tf4, tf9, tf10;
    JTextArea ta8;
    JButton btn1, btn2, btn3;
    JComboBox list1, list2;
    JPanel p;
    JDatePickerImpl datePicker1, datePicker2;
    static String day,from_date, to_date,reason;

    static int no_day;


    // JPasswordField p1, p2;
    JFrame leave_application;

    public appli_leave() {//2
        leave_application = new JFrame();
        leave_application.setSize(1000, 800);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (dim.width / 2) - (leave_application.getWidth() / 2);
        int y = (dim.height / 2) - (leave_application.getHeight() / 2);
        leave_application.setLocation(x, y);

        leave_application.setTitle("Application Form");
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        //  el1= new JLabel("Encashment Application");
        l1 = new JLabel("Leave Application");
        l1.setForeground(Color.decode("#89CFF0") );

        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l2 = new JLabel("Name:");
        l2.setForeground(Color.white);
        l3 = new JLabel("Designation:");
        l3.setForeground(Color.white);
        l4 = new JLabel("Staff id:");
        l4.setForeground(Color.white);
        l5 = new JLabel("No. of Days:");
        l5.setForeground(Color.white);
        l6 = new JLabel("From Date:");
        l6.setForeground(Color.white);
        l7 = new JLabel("To Date:");
        l7.setForeground(Color.white);
        l8 = new JLabel("Reason:");
        l8.setForeground(Color.white);
        l9 = new JLabel("Monthly Salary:");
        l9.setForeground(Color.white);
        l10 = new JLabel("Day of Start:");
        l10.setForeground(Color.white);

        tf2 = new JTextField();
        String designations[] = {"Assistant Professor", "Associate Professor", "Professor", "Head Of Department", "Lab Attendant"};
        list1 = new JComboBox(designations);
        list1.setSelectedIndex(0);
        list1.setEnabled(true);
        tf4 = new JTextField();
        tf5 = new JTextField();
        UtilDateModel model1 = new UtilDateModel();
        Properties prop1 = new Properties();
        prop1.put("text.today", "Today");
        prop1.put("text.month", "Month");
        prop1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, prop1);
        datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
        UtilDateModel model2 = new UtilDateModel();
        Properties prop2 = new Properties();
        prop2.put("text.today", "Today");
        prop2.put("text.month", "Month");
        prop2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, prop2);
        datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());
        ta8 = new JTextArea(20, 30);
        tf9 = new JTextField();
        tf10 = new JTextField();
        btn1 = new JButton("Submit");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog d = new JDialog(leave_application, "THANKYOU!");
                JLabel Blahbla = new JLabel("Please wait until your leave is being recorded.");
                d.add(Blahbla);
                Blahbla.setBounds(150, 150, 300, 30);
                d.setSize(300, 300);
                d.setLocationRelativeTo(null);
                d.setVisible(true);
                System.out.println("Okay you can take one");
                int index = 0;
                String staff1;
                sid = tf4.getText();//staff_id
                day= tf10.getText();
                no_day= Integer.parseInt(tf5.getText());
                from_date= datePicker1.getJFormattedTextField().getText(); //from
                to_date= datePicker2.getJFormattedTextField().getText(); //to
                reason = ta8.getText();
                for(int jk =0; jk<staff.staff_ids.length; jk++){
                    if(sid.equals(staff.staff_ids[jk])){
                        index = jk;
                        break;
                    }
                }
                //eid1 = staff.email_ids[index];
                staff1 = staff.first_names[index];
                new Mailer2("javadbmsproject@gmail.com","java&dbms","anjaliv.is17@bmsce.ac.in", "Application for leave", "Greetings! "+"\n" + staff1 + " has requested for leave." +"\n\n"+ " Please go to the portal for further actions. " + "\n\n"+ "Thank you.");
                try {
                    Connection myConnection = null;
                    myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                    String query4= "insert into leave_report values(?,?,?,?,?,?)";
                    PreparedStatement preparedStmt4 = myConnection.prepareStatement(query4);
                    preparedStmt4.setString(1,sid);
                    preparedStmt4.setString(2, from_date);
                    preparedStmt4.setString(3, to_date);
                    preparedStmt4.setInt(4, no_day);
                    preparedStmt4.setString(5, day);
                    preparedStmt4.setString(6, reason);
                    preparedStmt4.executeUpdate();
                    String query = "update leave_ set leave_status = ? where staff_id = ?";
                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                    preparedStmt.setString(1, "applied");
                    preparedStmt.setString(2, sid);
                    preparedStmt.executeUpdate();

                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                try {
                    new leave_report_table();
                }catch (NullPointerException e1) {
                    JDialog d1 = new JDialog(leave_application, "WARNING!");
                    JLabel Blahblah = new JLabel("Please enter the from date and to date correctly");
                    d1.add(Blahblah);
                    Blahbla.setBounds(150, 150, 300, 30);
                    d1.setSize(300, 300);
                    d1.setLocationRelativeTo(null);
                    d1.setVisible(true);
                    System.out.println("INVALID ENTRY");
                    leave_application.setVisible(false);
                    try {
                        new UIWindow();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
                    JDialog d2 = new JDialog(leave_application, "THANKYOU!");
                    JLabel Blahblah1 = new JLabel("Your leave has been recorded successfully.");
                    d2.add(Blahblah1);
                    Blahbla.setBounds(150, 150, 300, 30);
                    d2.setSize(300, 300);
                    d2.setLocationRelativeTo(null);
                    d2.setVisible(true);
                    System.out.println("SUCCESFUL ENTRY");
                    leave_application.setVisible(false);
                    try {
                        new UIWindow();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (ClassNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }


        });
        btn2 = new JButton("Reset");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf2.setText("");
                tf4.setText("");
                tf5.setText("");
                tf9.setText("");
                tf10.setText("");
            }
        });
        btn3 = new JButton("Back");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leave_application.setVisible(false);
                try {
                    new UIWindow();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        l1.setBounds(400, 40, 400, 30);
        l2.setBounds(300, 120, 200, 30);
        l3.setBounds(300, 170, 200, 30);
        l4.setBounds(300, 220, 200, 30);
        l5.setBounds(300, 270, 200, 30);
        l6.setBounds(300, 320, 200, 30);
        l7.setBounds(300, 370, 200, 30);
        l8.setBounds(300, 420, 200, 30);
       // l9.setBounds(200, 480, 200, 30);
        l10.setBounds(300, 480, 200, 30);
        tf2.setBounds(500, 120, 200, 30);
        list1.setBounds(500, 170, 200, 30);
        tf4.setBounds(500, 220, 200, 30);
        tf5.setBounds(500, 270, 200, 30);
        datePicker1.setBounds(500, 320, 200, 30);
        datePicker2.setBounds(500, 370, 200, 30);
        ta8.setBounds(500, 420, 200, 50);
       // tf9.setBounds(400, 480, 200, 30);
        tf10.setBounds(500, 480, 200, 30);
        btn1.setBounds(370, 600, 100, 30);
        btn2.setBounds(500, 600, 100, 30);
        btn3.setBounds(435, 650, 100, 30);
        p.setLayout(null);
        p.setVisible(true);
        p.add(l1);
        p.add(l2);
        p.add(tf2);
        p.add(l3);
        p.add(list1);
        p.add(l4);
        p.add(tf4);
        p.add(l5);
        p.add(tf5);
        p.add(tf10);
        p.add(l6);
        p.add(datePicker1);
        p.add(l7);
        p.add(l10);
        p.add(datePicker2);
        p.add(l8);
        p.add(ta8);
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
        leave_application.add(p);
        leave_application.setVisible(true);

    }

    }



