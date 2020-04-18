import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class leave_table {
    public static String staff_id[] = new String[35];
    public static int earned_leave[] = new int[35];
    public static int casual_leave[] = new int[35];
    public static int maternity_leave[] = new int[35];
    public static int paternity_leave[] = new int[35];
    public static int restricted_holidays[] = new int[35];
    public static String encashment_status[] = new String[35];
    public static int total_leaves[] = new int[35];
    public static String leave_status[]= new String[35];

    int index;
    public leave_table() {
        Connection myConnection = null;
        //leave_table l = new leave_table();
        try {
            myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
            PreparedStatement myPreStatement = myConnection.prepareStatement("SELECT * FROM LEAVE_");
            ResultSet rs = myPreStatement.executeQuery();
            System.out.println(rs);
            int i = 0;
            while (rs.next()) {
                staff_id[i] = rs.getString(1);
                earned_leave[i] = rs.getInt(2);
                casual_leave[i] = rs.getInt(3);
                maternity_leave[i] = rs.getInt(4);
                paternity_leave[i] = rs.getInt(5);
                restricted_holidays[i] = rs.getInt(6);
                encashment_status[i] = rs.getString(7);
                total_leaves[i] = rs.getInt(8);
                leave_status[i]= rs.getString(9);
                i++;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static void remainingteachers(String staffid) throws SQLException, ClassNotFoundException {
     int index = 0, index1=0;
     String eid1;
     String staff1;
     Connection myConnection=null;
        myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
        PreparedStatement myPreStatement = myConnection.prepareStatement("select distinct(s1.staff_id) from staff s1,timetable t1, timetable t2 where s1.staff_id=t2.staff_id and t1.semester= t2.semester and t1.section= t2.section and t1.staff_id=? and t2.staff_id<>t1.staff_id and t1.subject_ not like \"%LAB\" and t2.subject_ not like \"%LAB\" and t1.semester=3 ");
        myPreStatement.setString(1, staffid);

        ResultSet rs = myPreStatement.executeQuery();
        while(rs.next())
        {
            String t1= rs.getString(1);
            String query = "insert into substitution values(?,?,?)";
            PreparedStatement preparedStmt = myConnection.prepareStatement(query);
            preparedStmt.setString(1, staffid);
            preparedStmt.setString(2,t1 );
            preparedStmt.setString(3, "3");
            preparedStmt.executeUpdate();
            for(int jk =0; jk<staff.staff_ids.length; jk++){
                if(t1.equals(staff.staff_ids[jk])){
                    index = jk;
                    break;
                }

            }
            for(int jk =0; jk<staff.staff_ids.length; jk++){
                if(staffid.equals(staff.staff_ids[jk])){
                    index1 = jk;
                    break;
                }

            }
            eid1 = staff.email_ids[index];
            staff1 = staff.first_names[index1];
            new Mailer2("javadbmsproject@gmail.com","java&dbms",eid1, "Substitute classes", "Greetings! "+"\n" + staff1 +","+ "is on leave." +"\n\n"+ "Please go to the leave portal for more details." + "\n\n"+" Thank you.");
            // Mailer.send("javadbmsproject@gmail.com","java&dbms",eid,"Status of leave","Greetings! "+"\n" + staff_name +","+ "leave has been granted." +"\n\n"+ "Thanking you,"+"\n"+"HOD of ISE Department.");

        }


        PreparedStatement myPreStatement1 = myConnection.prepareStatement("select distinct(s1.staff_id) from staff s1,timetable t1, timetable t2 where s1.staff_id=t2.staff_id and t1.semester= t2.semester and t1.section= t2.section and t1.staff_id=? and t2.staff_id<>t1.staff_id and t1.subject_ not like \"%LAB\" and t2.subject_ not like \"%LAB\" and t1.semester=5 ");
        myPreStatement1.setString(1, staffid);
        ResultSet rs1 = myPreStatement1.executeQuery();
        while(rs1.next())
        {
            String t1= rs1.getString(1);
            String query = "insert into substitution values(?,?,?)";
            PreparedStatement preparedStmt = myConnection.prepareStatement(query);
            preparedStmt.setString(1, staffid);
            preparedStmt.setString(2,t1 );
            preparedStmt.setString(3, "5");
            preparedStmt.executeUpdate();
            for(int jk =0; jk<staff.staff_ids.length; jk++){
                if(t1.equals(staff.staff_ids[jk])){
                    index = jk;
                    break;
                }
            }
            for(int jk =0; jk<staff.staff_ids.length; jk++){
                if(staffid.equals(staff.staff_ids[jk])){
                    index1= jk;
                    break;
                }
            }
            eid1 = staff.email_ids[index];
            staff1 = staff.first_names[index1];
            new Mailer2("javadbmsproject@gmail.com","java&dbms",eid1, "Substitute class", "Greetings! "+"\n" + staff1 +","+ " is taking leave." +"\n\n"+ "Check you leave management portal for further details." + "\n" + "Thank you.");
            //new Mailer2("javadbmsproject@gmail.com","java&dbms",eid1, "Substitute class", "Greetings! "+"\n" + staff1 +","+ " is taking leave." +"\n\n"+ "Check you leave management portal for further details." + "\n" + "Thanking you,"+"\n"+"HOD , ISE Department.");
            //new Mailer2("javadbmsproject@gmail.com","java&dbms",eid1, "Substitute class", "Greetings! "+"\n" + staff1 +","+ " is taking leave." +"\n\n"+ "Check you leave management portal for further details." + "\n" + "Thanking you,"+"\n"+"HOD of ISE Department.");
            // Mailer.send("javadbmsproject@gmail.com","java&dbms",eid,"Status of leave","Greetings! "+"\n" + staff_name +","+ "leave has been granted." +"\n\n"+ "Thanking you,"+"\n"+"HOD of ISE Department.");


        }
        PreparedStatement myPreStatement2 = myConnection.prepareStatement("select distinct(s1.staff_id) from staff s1,timetable t1, timetable t2 where s1.staff_id=t2.staff_id and t1.semester= t2.semester and t1.section= t2.section and t1.staff_id=? and t2.staff_id<>t1.staff_id and t1.subject_ not like \"%LAB\" and t2.subject_ not like \"%LAB\" and t1.semester=7");
        myPreStatement2.setString(1, staffid);
        //myPreStatement2.setString(2, staffid);
        //myPreStatement.setString(3, staffid);
        //myPreStatement.setString(4, staffid);
        ResultSet rs2 = myPreStatement2.executeQuery();
        while(rs2.next())
        {
            String t1= rs2.getString(1);
            String query = "insert into substitution values(?,?,?)";
            PreparedStatement preparedStmt = myConnection.prepareStatement(query);
            preparedStmt.setString(1, staffid);
            preparedStmt.setString(2,t1 );
            preparedStmt.setString(3, "7");
            preparedStmt.executeUpdate();
            for(int jk =0; jk<staff.staff_ids.length; jk++){
                if(t1.equals(staff.staff_ids[jk])){
                    index = jk;
                    break;
                }
            }
            for(int jk =0; jk<staff.staff_ids.length; jk++){
                if(staffid.equals(staff.staff_ids[jk])){
                    index1= jk;
                    break;
                }
            }
            eid1 = staff.email_ids[index];
            staff1 = staff.first_names[index1];
            new Mailer2("javadbmsproject@gmail.com","java&dbms",eid1, "Substitute class", "Greetings! "+"\n" + staff1 +","+ " is taking leave." +"\n\n"+ "Check you leave management portal for further details." + "\n" + "Thank you");
            // new Mailer2("javadbmsproject@gmail.com","java&dbms",eid1, "Status of leave", "Greetings! "+"\n" + staff1 +","+ "leave has been granted." +"\n\n"+ "Thanking you,"+"\n"+"HOD of ISE Department.");
            // Mailer.send("javadbmsproject@gmail.com","java&dbms",eid,"Status of leave","Greetings! "+"\n" + staff_name +","+ "leave has been granted." +"\n\n"+ "Thanking you,"+"\n"+"HOD of ISE Department.");

        }
    }

}

