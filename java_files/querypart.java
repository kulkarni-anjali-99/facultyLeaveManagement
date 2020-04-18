import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class querypart {
    void insertintotable() throws SQLException, ClassNotFoundException {
        try {
            Connection myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
            PreparedStatement myPreStatement = myConnection.prepareStatement("INSERT INTO users(Id, Nam, age) VALUES(?, ?, ?)");
            int id=101,age=20;
            String name="Harika";
            myPreStatement.setInt(1, id);
            myPreStatement.setString(2, name);
            myPreStatement.setInt(3, age);
            myPreStatement.execute();
            System.out.println("Succesful");

        } catch (SQLException e) {
            System.out.println("Not succesful");
        }
        }
        void retrievefromtable() throws SQLException, ClassNotFoundException {
            Connection myConnection = JavaMysqlPreparedStatementInsertExample.getConnection();
            PreparedStatement myPreStatement = myConnection.prepareStatement("SELECT * FROM users");
            ResultSet rs = myPreStatement.executeQuery();
            String ans1="",ans2="",ans3="";
            while(rs.next())
            {
                ans1= rs.getString(1);
                ans2= rs.getString(2);
                ans3= rs.getString(3);
            }
            System.out.println(ans1+" "+ans2+" "+ans3);
        }
        public static void main(String args[]) throws SQLException, ClassNotFoundException {
            querypart ob= new querypart();
            ob.insertintotable();
            ob.retrievefromtable();
        }
    }

