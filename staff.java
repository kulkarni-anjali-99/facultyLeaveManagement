import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class staff {
    public static String email_ids[] = new String[35];
    public static String passwords[] = new String[35];
    public static String staff_ids[] = new String[35];
    public static String first_names[] = new String[35];
    public static String last_names[] = new String[35];
    public static String mid_names[] = new String[35];
    public static String designations[] = new String[35];

    public static String sid, sname;

    public staff() {
        Connection myConnection = null;
        try {
            myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
            PreparedStatement myPreStatement = myConnection.prepareStatement("SELECT * FROM STAFF");
            ResultSet rs = myPreStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                staff_ids[i] = rs.getString(1);
                first_names[i] = rs.getString(2);
                last_names[i] = rs.getString(3);
                mid_names[i] = rs.getString(4);
                email_ids[i] = rs.getString(5);
                passwords[i] = rs.getString(6);
                designations[i] = rs.getString(7);
                i++;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    public static boolean validatepassword(String user, String pass) {
        int index = 0,j;
        for (j = 0; j < email_ids.length; j++) {
            if (user.equals(email_ids[j])) {
                index = j;
                break;
            }
        }
        if (j > email_ids.length) {
            return(false);
        }
        if (((pass.equals(passwords[index])))) {
            sid=staff_ids[index];
            sname= first_names[index];
            return (true);
        }
        return(false);

        }
        public static boolean updatestaff(String user, String old, String new1, String new2) throws SQLException, ClassNotFoundException {
            int index = 0, j = 0;
            for (j = 0; j < email_ids.length; j++) {
                if (email_ids[j].equals(user)) {
                    index = j;
                    break;
                }
            }
            if (index > email_ids.length) {
                return (false);
            }
            if (!staff.passwords[index].equals(old)) {
                return (false);
            }
            if (!new1.equals(new2)) {
                return (false);
            } else {
                try {
                    Connection
                            myConnection = null;
                    myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
                    String query = "update staff set passwrd = ? where email_id = ?";
                    PreparedStatement preparedStmt = myConnection.prepareStatement(query);
                    preparedStmt.setString(1, new1);
                    preparedStmt.setString(2, user);
                    preparedStmt.executeUpdate();
                } catch (SQLException | ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return(false);

                }
            }
            return(true);
        }
    }




