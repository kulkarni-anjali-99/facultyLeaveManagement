
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

public class appli_encashment extends JFrame implements ActionListener
{
    JLabel l1, l2, l3, l4, l5, l6, l7, l8,l9,l10;
    JTextField tf2, tf3, tf4, tf5,tf9, tf10;
    JButton btn1, btn2,btn3;
    JTextArea ta8;
    JComboBox list1;
    JDatePickerImpl datePicker1, datePicker2;


    JScrollPane s1;
    // JPasswordField p1, p2;

    appli_encashment()
    {
        this.setSize(700, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (dim.width/2)-(this.getWidth()/2);
        int y = (dim.height/2)-(this.getHeight()/2);
        this.setLocation(x,y);
        this.setTitle("Encashment of Leave");
        JPanel p = new JPanel();
        p.setBackground(Color.BLACK);
        l1 = new JLabel("Encashment of leave");
        l1.setForeground(Color.decode("#89CFF0") );
        l1.setFont(new Font("Century", Font.BOLD, 30));
        l2 = new JLabel("Name:");
        l2.setForeground(Color.white);
        l2.setFont(new Font("Century", Font.ITALIC, 15));
        l3 = new JLabel("Designation:");
        l3.setForeground(Color.white);
        l3.setFont(new Font("Century", Font.ITALIC, 15));
        l4 = new JLabel("Staff id");
        l4.setForeground(Color.white);
        l4.setFont(new Font("Century", Font.ITALIC, 15));
        l5 = new JLabel("No. of Days:");
        l5.setForeground(Color.white);
        l5.setFont(new Font("Century", Font.ITALIC, 15));
        l6 = new JLabel("From:");
        l6.setForeground(Color.white);
        l6.setFont(new Font("Century", Font.ITALIC, 15));
        l7 = new JLabel("To:");
        l7.setForeground(Color.white);
        l7.setFont(new Font("Century", Font.ITALIC, 15));
        l8 = new JLabel("Reason");
        l8.setForeground(Color.white);
        l8.setFont(new Font("Century", Font.ITALIC, 15));
        l9= new JLabel("Monthly Salary");
        l9.setForeground(Color.white);
        l9.setFont(new Font("Century", Font.ITALIC, 15));
        l10= new JLabel("Other allowances");
        l10.setForeground(Color.white);
        l10.setFont(new Font("Century", Font.ITALIC, 15));
        tf2 = new JTextField();
        String designations[]={"Assistant Professor","Associate Professor","Professor","Head Of Department","Lab Attendant"};
        list1= new JComboBox(designations);
        list1.setSelectedIndex(0);
        list1.setEnabled(true);

        tf4= new JTextField();
        tf5 = new JTextField();
        UtilDateModel model1 = new UtilDateModel();
        Properties prop1= new Properties();
        prop1.put("text.today", "Today");
        prop1.put("text.month", "Month");
        prop1.put("text.year", "Year");
        JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, prop1);
        JDatePickerImpl datePicker1 = new JDatePickerImpl(datePanel1,new DateLabelFormatter());
        UtilDateModel model2 = new UtilDateModel();
        Properties prop2= new Properties();
        prop2.put("text.today", "Today");
        prop2.put("text.month", "Month");
        prop2.put("text.year", "Year");
        JDatePanelImpl datePanel2 = new JDatePanelImpl(model2, prop2);
        JDatePickerImpl datePicker2 = new JDatePickerImpl(datePanel2,new DateLabelFormatter());

        ta8 = new JTextArea(30,30);
        ta8.setLineWrap(true);
        ta8.setWrapStyleWord(true);
        //JScrollPane s1= new JScrollPane(ta8, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        tf9= new JTextField();
        tf10= new JTextField();
        btn1 = new JButton("Submit");
        btn2 = new JButton("Reset");
        btn3 = new JButton("Back");
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);

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
        btn3.setBounds(435, 650, 100, 30);//btn1.addActionListener(this);
        //btn2.addActionListener(this);
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
        p.add(l6);
        p.add(datePicker1);
        p.add(l7);
        p.add(datePicker2);
        p.add(l8);
        p.add(ta8);
        //p.add(s1);
        p.add(l9);
        p.add(tf9);
        p.add(l10);
        p.add(tf10);
        p.add(btn1);
        p.add(btn2);
        p.add(btn3);
        this.add(p);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btn1)
        {
            int x = 0;
            String s2 = tf2.getText();
            String s3 = tf3.getText();
            String s4 = tf4.getText();
            String s5 = tf5.getText();

            String s8 = ta8.getText();
            String s9= tf9.getText();
            String s10= tf10.getText();


        }
        if (e.getSource() == btn3){

            try {
                new UIWindow();
                this.setVisible(false);

            } catch (SQLException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==btn1)
        {
            String stid=tf4.getText();
            try {
                Connection
                        myConnection = null;
                myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                String query = "update leave_ set encashment_status = ? where staff_id = ?";
                PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                preparedStmt.setString(1, "applied");
                preparedStmt.setString(2, stid);
                preparedStmt.executeUpdate();
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==btn2) {
            tf2.setText("");
            tf4.setText("");
            tf5.setText("");
            tf9.setText("");
            tf10.setText("");
        }

    }

}

