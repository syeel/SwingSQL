import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class testsql {

    static final String DB_URL = "jdbc:mysql://localhost/companytest";
    static final String USER = "dbAdmin";
    static final String PASSWORD = "adminpass";

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        Statement stmt = connection.createStatement();
        
        String text = "user1";
        String sql = "select * from profiles";
        String sql2 = "SELECT * FROM profiles WHERE username = '" +text +"'";

        ResultSet rs = stmt.executeQuery(sql2);
        
        if (!rs.isBeforeFirst() ) { 
            // false if the cursor is not before the first record or if there are no rows in the ResultSet.
            System.out.println("No data"); 
            
        } else{
            while (rs.next()) {
                String username = rs.getString("username"); //getString(1), first column
                String password = rs.getString("password"); //getString(2), second column
                String fullName = rs.getString("fullName");
                String email = rs.getString("emailAddress");
                String dob = rs.getString("dob");
                String homeAddress = rs.getString("homeAddress");

                System.out.println(username + "\n" + password + "\n" + fullName
                                    + "\n" + email + "\n" + dob+ "\n" + homeAddress);
                System.out.println("");
                System.out.println("");
            }
        }

        rs.close();
        stmt.close();
        connection.close();
    }
}