package input2;
import java.sql.*;

public class demo_sql {
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:B:\\java\\DataBase\\stu_answers.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("not found");
        }
            System.out.println("connection made");
        
        return conn;
    }

    /**
     * Insert a new row into the warehouses table
     *
     * @param name
     * @param capacity
     */
	public void insert() {
		String a="a",b="b",c="c";
        String sql = "INSERT INTO students(subCode, roll, answer) VALUES(?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, a);
            pstmt.setString(2, b);
            pstmt.setString(3, c);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        demo_sql app = new demo_sql();
        // insert three new rows
        app.insert();
       
    }

}


public void getCapacityGreaterThan(double capacity){
    String sql = "SELECT id, name, capacity "
               + "FROM warehouses WHERE capacity > ?";

try (Connection conn = this.connect();
  PreparedStatement pstmt  = conn.prepareStatement(sql)){
 
 // set the value
 pstmt.setDouble(1,capacity);
 //
 ResultSet rs  = pstmt.executeQuery();
 
 // loop through the result set
 while (rs.next()) {
     System.out.println(rs.getInt("id") +  "\t" + 
                        rs.getString("name") + "\t" +
                        rs.getDouble("capacity"));
 }
} catch (SQLException e) {
 System.out.println(e.getMessage());
}
}