import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
public class timetable {

        public static String staff_id[] = new String[35];
        public static String subject[] = new String[35];
        public static String start_time[] = new String[35];
        public static String end_time[] = new String[35];
        public static String day_of_week[] = new String[35];
        public static int semester[] = new int[35];
        public static String section[] = new String[35];


        public timetable() {
            Connection myConnection = null;
            try {
                myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                PreparedStatement myPreStatement = myConnection.prepareStatement("SELECT * FROM timetable");
                ResultSet rs = myPreStatement.executeQuery();
                int i = 0;
                while (rs.next()) {
                    staff_id[i] = rs.getString(1);
                    subject[i] = rs.getString(2);
                    start_time[i] = rs.getString(3);
                    end_time[i] = rs.getString(4);
                    day_of_week[i] = rs.getString(5);
                    semester[i] = rs.getInt(6);
                    section[i] = rs.getString(7);
                    i++;
                }
            } catch (SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }



