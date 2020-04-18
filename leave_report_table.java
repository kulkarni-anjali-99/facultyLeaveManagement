import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class leave_report_table
{
    public static String[] staff_id= new String[35];
    public static String[] from_date= new String[35];
    public static String[] to_date= new String[35];
    public static int[] no_of_days= new int[35];
    public static String[]  day_of_start= new String[35];
    public static String[] reason= new String[35];
    public leave_report_table()
    {
        Connection myConnection = null;
        //leave_table l = new leave_table();
        try {
            myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
            PreparedStatement myPreStatement = myConnection.prepareStatement("SELECT * FROM leave_report");
            ResultSet rs = myPreStatement.executeQuery();
            System.out.println(rs);
            int i = 0;

            while (rs.next()) {
                staff_id[i] = rs.getString(1);
                from_date[i] = rs.getString(2);
                to_date[i] = rs.getString(3);
                no_of_days[i] = rs.getInt(4);
                day_of_start[i] = rs.getString(5);
                reason[i]= rs.getString(6);
                i++;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }

    }
    }

