import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class substitution {
    public static String leave_staff_id[] = new String[35];
    public static String[] sub_staff_id = new String[35];
    public static int sem[] = new int[35];
    public substitution() {
        Connection myConnection = null;
        try {

            myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
            PreparedStatement myPreStatement = myConnection.prepareStatement("select * from substitution");
            ResultSet rs = myPreStatement.executeQuery();
            int i = 0;
            while (rs.next()) {
                leave_staff_id[i] = rs.getString(1);
                sub_staff_id[i] = rs.getString(2);
                sem[i] = rs.getInt(3);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
