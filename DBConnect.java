import java.sql.*;

public class DBConnect {
    public static void main(String[] args) {
        try {
            // create our mysql database connection
            String myUrl = "jdbc:mysql://localhost:3306/njc_labs";
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM user";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String address = rs.getString("address");

                // print the results
                System.out.format("%s, %s, %s, %s\n", id, firstName, lastName, address);
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Exception found! ");
            System.err.println(e.getMessage());
        }
    }
}