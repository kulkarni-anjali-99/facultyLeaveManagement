import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class substitute_class {//1
    JFrame frame4;
    JPanel panel4;
    JLabel l, l1, sub3;
    JButton yes, no;
    JComboBox sub5, sub6;
    public static String third_sem_from[]= new String[10];
    public static String third_sem_to[]= new String[10];
    public static String fifth_sem_from[]= new String[10];
    public static String fifth_sem_to[]= new String[10];
    public static String seventh_sem_from[]= new String[10];
    public static String seventh_sem_to[]= new String[10];


    public substitute_class(String stid) throws SQLException, ClassNotFoundException {//2
        new leave_report_table();
        new substitution();
        System.out.println("Hello");
        frame4 = new JFrame();
        panel4 = new JPanel();
        frame4.setSize(700, 700);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        int x = (dim.width / 2) - (frame4.getWidth() / 2);
        int y = (dim.height / 2) - (frame4.getHeight() / 2);
        frame4.setLocation(x, y);

        frame4.setTitle("Substitute List");
        panel4.setBackground(Color.BLACK);
        panel4.setLayout(null);
        //finding out the leave_staf_id when the substitute staff_id is givenfor(int j=0;j<substitution.sub_staff_id.length;j++)
        int index3=0;
        String []days= {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
        int x_coord = 150, y_coord = 100, x_yes_button = 400, x_no_button = 500, drop3_x = 150, drop3_y = 200;
        int index2 = 0;
        for (int ji = 0; ji < substitution.sub_staff_id.length; ji++) {//3
            try {//4
                if (substitution.sub_staff_id.length == 0) {//5
                    break;
                }//5
                if (!substitution.sub_staff_id[ji].equals(stid)) {//5
                    continue;
                }//5
                String tol= substitution.sub_staff_id[ji];
                String leave_stid = substitution.leave_staff_id[ji];
                for (int m = 0; m < leave_report_table.staff_id.length; m++) {//5
                    if (leave_stid.equals(leave_report_table.staff_id[m])) {//6
                        index2 = m;
                        break;
                    }//6
                }//5
                System.out.println("Hello 2");
                String fdate = leave_report_table.from_date[index2];
                String tdate = leave_report_table.to_date[index2];
                String day = leave_report_table.day_of_start[index2];
                int no_day = leave_report_table.no_of_days[index2];
                System.out.println(fdate);
                System.out.println(tdate);
                System.out.println(day);
                System.out.println(no_day);
                Connection myConnection = null;
                myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                int k1 = 0, k2 = 0, k3 = 0, count;
                if (substitution.sub_staff_id[ji].equals(stid) && substitution.sem[ji] == 3) {//5
                    String sname = "";
                    for (int k = 0; k < staff.first_names.length; k++) {//6
                        if (leave_stid.equals(staff.staff_ids[k])) {//7
                            sname = staff.first_names[k];
                            break;
                        }//7
                    }//6
                    count = 0;
                    for (int m = 0; m < 6; m++) {//6
                        try {//7
                            if (day.equals(days[m])) {//8
                                index3 = m;
                                break;
                            }//8
                        }//7
                        catch (NullPointerException e) {//8
                            continue;
                        }//8
                    }//6
                    for (int j = index3; count < no_day; j = (j + 1) % 6) {//6
                        System.out.println("Hello 3");
                        System.out.println( leave_report_table.staff_id[index2]);
                        PreparedStatement myPreStatement = myConnection.prepareStatement("select start_time,end_time from timetable where staff_id=? and day_of_week=? and semester=3;");
                        myPreStatement.setString(1, leave_report_table.staff_id[index2]);
                        myPreStatement.setString(2, days[j]);
                        ResultSet rs = myPreStatement.executeQuery();
                        while (rs.next()) {//7
                            third_sem_from[k1] = rs.getString(1);
                            third_sem_to[k1] = rs.getString(2);
                            System.out.println(fdate);
                            System.out.println(tdate);
                            System.out.println(day);
                            System.out.println(no_day);
                            l = new JLabel(sname + " is taking leave from " + fdate + " to " + tdate + " . ");
                            l1 = new JLabel("Do you want to take a 3rd semester class from :" + third_sem_from[k1] + " to" + third_sem_to[k1] + "?");
                            l.setForeground(Color.WHITE);
                            l1.setForeground(Color.WHITE);
                            l.setBounds(x_coord, y_coord, 700, 30);
                            l1.setBounds(x_coord, y_coord, 700, 60);
                            yes = new JButton("YES");
                            yes.addActionListener(new ActionListener() {//8[-
                                @Override
                                public void actionPerformed(ActionEvent e) {//9
                                    Connection myconnect = null;
                                    try{
                                        myconnect = JavaMysqlPreparedStatementInsertExample.getConnection();
                                        PreparedStatement mystatement = myconnect.prepareStatement("Delete from substitution where leave_staff_id = ? and sem = 3 ");
                                        PreparedStatement myst1= myconnect.prepareStatement("Delete from leave_report where staff_id=?");
                                        myst1.setString(1,tol);
                                        mystatement.setString(1, tol );
                                        myst1.executeUpdate();
                                        mystatement.executeUpdate();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                    JDialog d = new JDialog(frame4, "THANKYOU!");
                                    JLabel Blahbla = new JLabel("This slot is booked for you.");
                                    d.add(Blahbla);
                                    Blahbla.setBounds(150, 150, 300, 30);
                                    d.setSize(300, 300);
                                    d.setLocationRelativeTo(null);
                                    d.setVisible(true);
                                    System.out.println("Okay you can take one");
                                }//9
                            });//8
                            no = new JButton("NO");
                            no.addActionListener(new ActionListener() {//8
                                @Override
                                public void actionPerformed(ActionEvent e) {//9
                                    JDialog d = new JDialog(frame4, "THANKYOU!");
                                    JLabel Blahbla = new JLabel("Thanks for your time.");
                                    d.add(Blahbla);
                                    Blahbla.setBounds(150, 150, 300, 30);
                                    d.setSize(300, 300);
                                    d.setLocationRelativeTo(null);
                                    d.setVisible(true);
                                    System.out.println("Okay thanks for your time");
                                    // panel4.setVisible(false);
                                }//9
                            });//8
                            yes.setBounds(250, y_coord + 70, 80, 30);
                            no.setBounds(330, y_coord + 70, 80, 30);
                            panel4.add(l);
                            panel4.add(l1);
                            panel4.add(yes);
                            panel4.add(no);
                            y_coord = y_coord + 40;
                            k1++;
                        }//7
                        count++;
                    }//6
                    /*for (int k = 0; k < third_sem_from.length; k++) {

                    }*/
                }//5
                if (substitution.sub_staff_id[ji].equals(stid) && substitution.sem[ji] == 5) {//5
                    String sname = "";
                    for (int k = 0; k < staff.first_names.length; k++) {//6
                        if (leave_stid.equals(staff.staff_ids[k])) {//7
                            sname = staff.first_names[k];
                            break;
                        }//7
                    }//6

                    for (int m = 0; m < 6; m++) {//6
                        try {//7
                            if (day.equals(days[m])) {//8
                                index3 = m;
                                break;
                            }//8
                        }//7
                        catch (NullPointerException e) {//7
                            continue;
                        }//7
                    }//6
                    k1 = 0;
                    count=0;
                    for (int j = index3; count < no_day; j = (j + 1) % 6) {//6
                        System.out.println( leave_report_table.staff_id[index2]);
                        PreparedStatement myPreStatement = myConnection.prepareStatement("select start_time,end_time from timetable where staff_id=? and day_of_week=? and semester=5;");
                        myPreStatement.setString(1, leave_report_table.staff_id[index2]);
                        myPreStatement.setString(2, days[j]);
                        ResultSet rs = myPreStatement.executeQuery();
                        while (rs.next()) {//7
                            fifth_sem_from[k1] = rs.getString(1);
                            fifth_sem_to[k1] = rs.getString(2);
                            System.out.println(fdate);
                            System.out.println(tdate);
                            System.out.println(day);
                            System.out.println(no_day);
                            l = new JLabel(sname + " is taking leave from " + fdate + " to " + tdate + " . ");
                            l1 = new JLabel("Do you want to take a 5th semester class from :" + fifth_sem_from[k1] + " to" + fifth_sem_to[k1] + "?");
                            l.setForeground(Color.WHITE);
                            l1.setForeground(Color.WHITE);
                            l.setBounds(x_coord, y_coord, 700, 30);
                            l1.setBounds(x_coord, y_coord, 700, 60);
                            yes = new JButton("YES");
                            yes.addActionListener(new ActionListener() {//8
                                @Override
                                public void actionPerformed(ActionEvent e) {//9
                                    Connection myconnect = null;
                                    try{
                                        myconnect = JavaMysqlPreparedStatementInsertExample.getConnection();
                                        PreparedStatement mystatement = myconnect.prepareStatement("Delete from substitution where leave_staff_id = ? and sem = 5 ");
                                        PreparedStatement myst1= myconnect.prepareStatement("Delete from leave_report where staff_id=?");
                                        myst1.setString(1,tol);
                                        mystatement.setString(1, tol );
                                        mystatement.executeUpdate();
                                        myst1.executeUpdate();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }

                                    JDialog d = new JDialog(frame4, "THANKYOU!");
                                    JLabel Blahbla = new JLabel("This slot is booked for you.");
                                    d.add(Blahbla);
                                    Blahbla.setBounds(150, 150, 300, 30);
                                    d.setSize(300, 300);
                                    d.setLocationRelativeTo(null);
                                    d.setVisible(true);

                                }//9
                            });//8
                            no = new JButton("NO");
                            no.addActionListener(new ActionListener() {//8
                                @Override
                                public void actionPerformed(ActionEvent e) {//9
                                    JDialog d = new JDialog(frame4, "THANKYOU!");
                                    JLabel Blahbla = new JLabel("Thanks for your time.");
                                    d.add(Blahbla);
                                    Blahbla.setBounds(150, 150, 300, 30);
                                    d.setSize(300, 300);
                                    d.setLocationRelativeTo(null);
                                    d.setVisible(true);


                                }//9
                            });//8
                            yes.setBounds(250, y_coord + 70, 80, 30);
                            no.setBounds(330, y_coord + 70, 80, 30);
                            panel4.add(l);
                            panel4.add(l1);
                            panel4.add(yes);
                            panel4.add(no);
                            y_coord = y_coord + 40;
                            k1++;
                        }//7
                        count++;
                    }//6


                }//5

                if (substitution.sub_staff_id[ji].equals(stid) && substitution.sem[ji] == 7) {//5
                    String sname = "";
                    for (int k = 0; k < staff.first_names.length; k++) {//6
                        if (leave_stid.equals(staff.staff_ids[k])) {//7
                            sname = staff.first_names[k];
                            break;
                        }//7
                    }//6
                    count = 0;
                    for (int m = 0; m < 6; m++) {//6
                        try {//7
                            if (day.equals(days[m])) {//8
                                index3 = m;
                                break;
                            }//8
                        }//7
                        catch (NullPointerException e) {//7
                            continue;
                        }//7
                    }//6
                    for (int j = index3; count < no_day; j = (j + 1) % 6) {//6
                        System.out.println(fdate);
                        System.out.println(tdate);
                        System.out.println(day);
                        System.out.println(no_day);
                        System.out.println( leave_report_table.staff_id[index2]);
                        PreparedStatement myPreStatement = myConnection.prepareStatement("select start_time,end_time from timetable where staff_id=? and day_of_week=? and semester=7;");
                        myPreStatement.setString(1, leave_report_table.staff_id[index2]);
                        myPreStatement.setString(2, days[j]);
                        ResultSet rs = myPreStatement.executeQuery();
                        while (rs.next()) {//7

                            seventh_sem_from[k1] = rs.getString(1);
                            seventh_sem_to[k1] = rs.getString(2);
                            l = new JLabel(sname + " is taking leave from " + fdate + " to " + tdate + " . ");
                            l1 = new JLabel("Do you want to take a 7th semester class from :" + seventh_sem_from[k1] + " to" + seventh_sem_to[k1] + "?");
                            l.setForeground(Color.WHITE);
                            l1.setForeground(Color.WHITE);
                            l.setBounds(x_coord, y_coord, 700, 30);
                            l1.setBounds(x_coord, y_coord, 700, 50);
                            yes = new JButton("YES");
                            yes.addActionListener(new ActionListener() {//8
                                @Override
                                public void actionPerformed(ActionEvent e) {//9
                                    Connection myconnect = null;
                                    try{
                                        myconnect = JavaMysqlPreparedStatementInsertExample.getConnection();
                                        PreparedStatement mystatement = myconnect.prepareStatement("Delete from substitution where leave_staff_id = ? and sem = 7 ");
                                        PreparedStatement myst1= myconnect.prepareStatement("Delete from leave_report where staff_id=?");

                                        mystatement.setString(1, tol );
                                        myst1.setString(1,tol);
                                        myst1.executeUpdate();
                                        mystatement.executeUpdate();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    }
                                    JDialog d = new JDialog(frame4, "THANKYOU!");
                                    JLabel Blahbla = new JLabel("This slot is booked for you.");
                                    d.add(Blahbla);
                                    Blahbla.setBounds(150, 150, 300, 30);
                                    d.setSize(300, 300);
                                    d.setLocationRelativeTo(null);
                                    d.setVisible(true);
                                    System.out.println("Okay you can take one");

                                }//9
                            });//8
                            no = new JButton("NO");
                            no.addActionListener(new ActionListener() {//8
                                @Override
                                public void actionPerformed(ActionEvent e) {//9
                                    JDialog d = new JDialog(frame4, "THANKYOU!");
                                    JLabel Blahbla = new JLabel("Thanks for your time.");
                                    d.add(Blahbla);
                                    Blahbla.setBounds(150, 150, 300, 30);
                                    d.setSize(300, 300);
                                    d.setLocationRelativeTo(null);
                                    d.setVisible(true);
                                    System.out.println("Okay thanks for your time");
                                }//9
                            });//8
                            yes.setBounds(x_yes_button, y_coord + 50, 80, 30);
                            no.setBounds(x_no_button, y_coord + 50, 80, 30);
                            panel4.add(l);
                            panel4.add(l1);
                            panel4.add(yes);
                            panel4.add(no);
                            y_coord = y_coord + 140;
                            k1++;
                        }
                        count++;//7
                    }//6

                }//5

            }//4
            catch (Exception e) {//4
                continue;
            }//4

        }//3
        frame4.add(panel4);
        frame4.setVisible(true);
    }//2
}//1