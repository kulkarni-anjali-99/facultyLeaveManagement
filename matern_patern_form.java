import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class matern_patern_form {
    JFrame maternform;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf2, tf4, tf5, tf9, tf10;
    JTextArea ta8;
    JComboBox list1;
    JButton btn1, btn2, btn3;
    JDatePickerImpl datePicker1, datePicker2;
    String sid, day, reason, from_date, to_date;
    int no_day;
    JPanel p;

    public matern_patern_form() {

        maternform = new JFrame();
        maternform.setSize(700, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (dim.width / 2) - (maternform.getWidth() / 2);
        int y = (dim.height / 2) - (maternform.getHeight() / 2);
        maternform.setLocation(x, y);

        maternform.setTitle("Maternity/Paternity Form");
        p = new JPanel();
        p.setBackground(Color.BLACK);
        //  el1= new JLabel("Encashment Application");
        l1 = new JLabel("Maternity/Paternity Form");
        l1.setForeground(Color.decode("#89CFF0") );
        l1.setFont(new Font("Serif", Font.BOLD, 25));
        l2 = new JLabel("Name:");
        l2.setForeground(Color.white);
        l3 = new JLabel("Designation:");
        l3.setForeground(Color.white);
        l4 = new JLabel("Staff id:");
        l4.setForeground(Color.white);
        l5 = new JLabel("From Date:");
        l5.setForeground(Color.white);
        l6 = new JLabel("To Date:");
        l6.setForeground(Color.white);
        l7 = new JLabel("Reason");
        l7.setForeground(Color.white);

        tf2 = new JTextField();
        String designations[] = {"Assistant Professor", "Associate Professor", "Professor", "Head Of Department", "Lab Attendant"};
        list1 = new JComboBox(designations);
        list1.setSelectedIndex(0);
        list1.setEnabled(true);
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
        tf4 = new JTextField();
        ta8 = new JTextArea();
        // tf5 = new JTextField();
        // tf9 = new JTextField();
        // tf10 = new JTextField();
        btn1 = new JButton("Submit");
        btn1.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sid = tf4.getText();//staff_id
                //day = tf10.getText();
                //no_day = Integer.parseInt(tf5.getText());
                reason = ta8.getText();
                from_date = datePicker1.getJFormattedTextField().getText(); //from
                to_date = datePicker2.getJFormattedTextField().getText(); //to
                Dialog d = new JDialog(maternform, "THANKYOU!");
                JLabel Blahbla = new JLabel("Please wait until your leave is being recorded.");
                d.add(Blahbla);
                Blahbla.setBounds(150, 150, 300, 30);
                d.setSize(500, 500);
                d.setLocationRelativeTo(null);
                d.setVisible(true);
                try {
                    Connection myConnection = null;
                    myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                    String query4 = "insert into leave_report values(?,?,?,?,?,?)";
                    PreparedStatement preparedStmt4 = myConnection.prepareStatement(query4);
                    preparedStmt4.setString(1, sid);
                    preparedStmt4.setString(2, from_date);
                    preparedStmt4.setString(3, to_date);
                    preparedStmt4.setString(4, "0");
                    preparedStmt4.setString(5, "NA");
                    preparedStmt4.setString(6, reason);
                    preparedStmt4.executeUpdate();
                    String query = "update leave_ set leave_status = ? where staff_id = ?";
                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                    preparedStmt.setString(1, "applied");
                    preparedStmt.setString(2, sid);
                    preparedStmt.executeUpdate();
                    JLabel Blahblah = new JLabel("Your leave application has succesfully been recorded");
                    d.add(Blahblah);
                    Blahblah.setBounds(150, 150, 300, 30);
                    d.setSize(500, 500);
                    d.setLocationRelativeTo(null);
                    d.setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }));
        btn2 = new JButton("Reset");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tf2.setText("");
                tf4.setText("");
                //tf5.setText("");
                // tf9.setText("");
                ta8.setText("");
            }
        });
        btn3 = new JButton("Back");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                maternform.setVisible(false);
                try {
                    maternform.setVisible(false);
                    new UIWindow();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
       // ListenForButton2 lforbutton2 = new ListenForButton2();
       // btn1.addActionListener(lforbutton2);
       // btn2.addActionListener(lforbutton2);
        //btn3.addActionListener(lforbutton2);
        l1.setBounds(300, 30, 400, 30);
        l2.setBounds(80, 70, 200, 30);
        l3.setBounds(80, 110, 200, 30);
        l4.setBounds(80, 150, 200, 30);
        l5.setBounds(80, 190, 200, 30);
        l6.setBounds(80, 230,200,30 );
        l7.setBounds(80, 270, 200, 30 );
        tf2.setBounds(300, 70, 200, 30);
        list1.setBounds(300, 110, 200, 30);
        tf4.setBounds(300, 150, 200, 30);
        datePicker1.setBounds(300, 190, 200, 30);
        datePicker2.setBounds(300, 230, 200, 30);
        ta8.setBounds(300, 270, 200, 30);

//.setBounds(300, 190, 200, 30);
        //      tf9.setBounds(300, 370, 200, 30);
        //tf10.setBounds(300, 410, 200, 30);
        btn1.setBounds(220, 450, 100, 30);
        btn2.setBounds(350, 450, 100, 30);
        btn3.setBounds(285, 490, 100, 30);
        p.setLayout(null);
        p.setVisible(true);
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(l7);
        p.add(tf2);
        p.add(list1);
        p.add(tf4);
        p.add(datePicker1);
        p.add(datePicker2);
        p.add(ta8);

//        p.add(tf5);
        //      p.add(tf9);
        // p.add(tf10);
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
        maternform.add(p);
        maternform.setVisible(true);
    }


    }


