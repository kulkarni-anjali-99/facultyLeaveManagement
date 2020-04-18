import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Properties;
import javax.mail.*;
public class leave_list {
    JFrame frame3;
    JPanel panel3;
    JButton no,yes,back;
    JLabel l1,l2;
    int el1, cl1;
    String eid;
    int index=0, earned_left, casual_left;
    public leave_list()
    {

        frame3= new JFrame();
        panel3= new JPanel();
        frame3.setSize(700, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (dim.width / 2) - (frame3.getWidth() / 2);
        int y = (dim.height / 2) -(frame3.getHeight() / 2);
        frame3.setLocationRelativeTo(null);
        panel3 = new JPanel();
        panel3.setBackground(Color.black);
        panel3.setLayout(null);
        frame3.setLocation(x, y);

        int x_coord=150, y_coord=100, x_yes_button= 400, x_no_button=500;
        int i,k=0;
        new leave_table();
        for(i=0;i<leave_table.leave_status.length;i++) {
            try {
                if (leave_table.leave_status[i].equals("applied")) {
                    String staff_name = staff.first_names[i];
                    String stid = leave_table.staff_id[i];
                    int index1 = 0;
                    int index2 = 0;
                    for (int j = 0; j < leave_table.staff_id.length; j++) {
                        if (stid.equals(leave_table.staff_id[j])) {
                            index1 = j;
                            break;
                        }
                    }

                    new leave_report_table();
                    for (int j = 0; j < leave_report_table.staff_id.length; j++) {
                        if (stid.equals(leave_report_table.staff_id[j])) {
                            index2 = j;
                            break;
                        }
                    }
                    int cl = leave_table.casual_leave[index1];
                    int el = leave_table.earned_leave[index1];
                    int nd = leave_report_table.no_of_days[index2];
                    String re=leave_report_table.reason[index2];

                    if(el>=15&&cl<10)
                    {
                        cl=cl+nd;
                    }
                    else if((15-el)>=nd&&cl<=10)
                    {
                        el=el+nd;
                    }
                    else
                    {
                        el1= 15-el;
                        cl1= nd-el1;
                        el=el+cl1;
                        cl= cl+(nd-cl1);
                    }
                    earned_left = 15 - el;
                    casual_left = 10 - cl;

                    String fd = leave_report_table.from_date[index2];
                    String td = leave_report_table.to_date[index2];
                    if(re.equals("Maternity")||re.equals("Paternity"))
                    {

                        l1= new JLabel(staff_name+"    is requesting for "+re+"  leave"+"from:"+fd+"  to:"+td +" due to "+re);
                        l1.setForeground(Color.WHITE);
                        l1.setBounds(x_coord, y_coord, 700, 30);
                        panel3.add(l1);
                        yes = new JButton("YES");
                        yes.setBounds(x_yes_button, y_coord + 30, 80, 30);
                        yes.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JDialog d = new JDialog(frame3, "Thanks for your response");
                                JLabel Blahblah = new JLabel("Your response has been recorded.");
                                d.add(Blahblah);
                                d.setSize(500, 500);
                                d.setLocationRelativeTo(null);
                                d.setVisible(true);
                                Connection myConnection1=null;
                                try {
                                    myConnection1 = JavaMysqlPreparedStatementInsertExample.getConnection();
                                    PreparedStatement myPreStatement = myConnection1.prepareStatement("select email_id from staff where staff_id= ?");
                                    myPreStatement.setString(1, stid);
                                    ResultSet rs = myPreStatement.executeQuery();
                                    while (rs.next()) {
                                        eid = rs.getString(1);
                                    }
                                    new Mailer2("javadbmsproject@gmail.com", "java&dbms", eid, "Status of Leave", "Greetings! " + "\n" + staff_name + "," + "leave has been granted." + "\n\n" + "Thank you");
                                } catch (SQLException exc) {
                                    exc.printStackTrace();
                                } catch (ClassNotFoundException exc) {
                                    exc.printStackTrace();
                                }
                                try {
                                    Connection myConnection = null;
                                    myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                                    String query = "update leave_ set leave_status = ? where staff_id = ?";
                                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                                    preparedStmt.setString(1, "approved");
                                    preparedStmt.setString(2, stid);
                                    preparedStmt.executeUpdate();
                                } catch (SQLException | ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                }
                                if(re.equals("Maternity"))
                                {
                                    Connection myConnection = null;
                                    try {
                                        myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                                        String query = "update leave_ set maternity_leave = ? where staff_id = ?";
                                        PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                                        preparedStmt.setString(1, "1");
                                        preparedStmt.setString(2, stid);
                                        preparedStmt.executeUpdate();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }
                                }
                                if(re.equals("Paternity"))
                                {
                                    Connection myConnection = null;
                                    try {
                                        myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                                        String query = "update leave_ set paternity_leave = ? where staff_id = ?";
                                        PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                                        preparedStmt.setString(1, "1");
                                        preparedStmt.setString(2, stid);
                                        preparedStmt.executeUpdate();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }
                                }

                            }
                        });
                        panel3.add(yes);

                        no = new JButton("NO");
                        no.setBounds(x_no_button, y_coord + 30, 80, 30);
                        no.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JDialog d = new JDialog(frame3, "Thanks for your response");
                                JLabel Blahblah = new JLabel("Your response has been recorded. PLease wait till the faculty has been informed");
                                d.add(Blahblah);
                                d.setSize(500, 500);
                                d.setLocationRelativeTo(null);
                                d.setVisible(true);
                                Connection myConnection1 = null;
                                PreparedStatement myPreStatement = null;
                                try {
                                    myPreStatement = myConnection1.prepareStatement("select email_id from staff where staff_id= ?");
                                    myPreStatement.setString(1, eid);
                                    ResultSet rs = myPreStatement.executeQuery();
                                    while (rs.next()) {
                                        eid = rs.getString(1);
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                new Mailer2("javadbmsproject@gmail.com", "java&dbms", eid, "Status of leave", "Greetings! " + "\n" + staff_name + "," + "leave has not been granted." + "\n\n" + "Thank you");
                                // Mailer.send("javadbmsproject@gmail.com","java&dbms",eid,"Status of leave","Greetings! "+"\n" + staff_name +","+ "leave has been granted." +"\n\n"+ "Thanking you,"+"\n"+"HOD of ISE Department.");
                                System.out.println("Leave disproved");

                            }
                        });
                        panel3.add(no);
                    }

                    else
                    {
                    l1 = new JLabel(staff_name + "\t is requesting for leave" + " from:" + fd + " to:" + td +" due to "+re);
                    l1.setForeground(Color.WHITE);
                    l1.setBounds(x_coord, y_coord, 700, 30);
                    panel3.add(l1);
                    l2 = new JLabel("Earned Leave:" + (15 - el - 1) + "Casual Leave:" + (10 - cl - 1));
                    l2.setForeground(Color.WHITE);
                    l2.setBounds(x_coord, y_coord + 30, 700, 30);
                    panel3.add(l2);
                    yes = new JButton("YES");
                    yes.setBounds(x_yes_button, y_coord + 30, 80, 30);
                    panel3.add(yes);
                    yes.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            try {
                                JDialog d = new JDialog(frame3, "Thanks for your response");
                                JLabel Blahblah = new JLabel("Your response has been recorded. Please wait till the other teachers have been informed");
                                d.add(Blahblah);
                                d.setSize(500, 500);
                                d.setLocationRelativeTo(null);
                                d.setVisible(true);
                                Connection myConnection1 = null;
                                myConnection1 = JavaMysqlPreparedStatementInsertExample.getConnection();
                                PreparedStatement myPreStatement = myConnection1.prepareStatement("select email_id from staff where staff_id= ?");
                                myPreStatement.setString(1, stid);
                                ResultSet rs = myPreStatement.executeQuery();
                                while (rs.next()) {
                                    eid = rs.getString(1);
                                }
                            } catch (SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            new Mailer2("javadbmsproject@gmail.com", "java&dbms", eid, "Status of Leave", "Greetings! " + "\n" + staff_name + "," + "leave has been granted." + "\n\n" + "Thank you");
                            // Mailer2.send("javadbmsproject@gmail.com","java&dbms",eid,"Approval of leave","Greetings! "+"\n" + staff_name +","+ "leave has been granted." +"\n\n"+ "Thanking you,"+"\n"+"HOD of ISE Department.");

                            try {
                                Connection myConnection = null;
                                myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                                String query = "update leave_ set leave_status = ? where staff_id = ?";
                                PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                                preparedStmt.setString(1, "approved");
                                preparedStmt.setString(2, stid);
                                preparedStmt.executeUpdate();
                            } catch (SQLException | ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            try {
                                if (earned_left > 0) {

                                    Connection myConnection = null;
                                    myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                                    String query = "update leave_ set earned_leave = ? where staff_id = ?";
                                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                                    preparedStmt.setInt(1, 15-earned_left);
                                    preparedStmt.setString(2, stid);
                                    preparedStmt.executeUpdate();
                                    leave_table.remainingteachers(stid);

                                } else if (casual_left > 0) {
                                    Connection myConnection = null;
                                    myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                                    String query = "update leave_ set casual_leave = ? where staff_id = ?";
                                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                                    preparedStmt.setInt(1, 10-casual_left);
                                    preparedStmt.setString(2, stid);
                                    preparedStmt.executeUpdate();
                                    leave_table.remainingteachers(stid);

                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }

                            JDialog d1 = new JDialog(frame3, "Emails are sent");
                            JLabel Blahblah1 = new JLabel("All the emails have been sent. You can now perform further actions");
                            d1.add(Blahblah1);
                            d1.setSize(300, 300);
                            d1.setLocationRelativeTo(null);
                            d1.setVisible(true);
                            panel3.remove(l1);
                            panel3.remove(l2);
                            panel3.remove(yes);
                        }
                    });

                    no = new JButton("NO");
                    no.setBounds(x_no_button, y_coord + 30, 80, 30);
                    panel3.add(no);
                    no.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JDialog d = new JDialog(frame3, "Thanks for your response");
                            JLabel Blahblah = new JLabel("Your response has been recorded. PLease wait till the faculty has been informed");
                            d.add(Blahblah);
                            d.setSize(500, 500);
                            d.setLocationRelativeTo(null);
                            d.setVisible(true);
                            Connection myConnection1 = null;
                            PreparedStatement myPreStatement = null;
                            try {
                                myPreStatement = myConnection1.prepareStatement("select email_id from staff where staff_id= ?");
                                myPreStatement.setString(1, eid);
                                ResultSet rs = myPreStatement.executeQuery();
                                while (rs.next()) {
                                    eid = rs.getString(1);
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                            new Mailer2("javadbmsproject@gmail.com", "java&dbms", eid, "Status of leave", "Greetings! " + "\n" + staff_name + "," + "leave has not been granted." + "\n\n" + "Thank you");
                            // Mailer.send("javadbmsproject@gmail.com","java&dbms",eid,"Status of leave","Greetings! "+"\n" + staff_name +","+ "leave has been granted." +"\n\n"+ "Thanking you,"+"\n"+"HOD of ISE Department.");
                            System.out.println("Leave disproved");
                            panel3.remove(l1);
                            panel3.remove(l2);
                            panel3.remove(no);
                        }
                    });
                    y_coord = y_coord + 70;
                    }

                }
            }catch(NullPointerException e)
            {
                continue;
            }
        }
        back= new JButton("BACK");
        back.setBounds(400,600,80,30);
        panel3.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame3.setVisible(false);
                try {
                    new hod_ui_window();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
    frame3.add(panel3);
        frame3.setVisible(true);
    }
}
