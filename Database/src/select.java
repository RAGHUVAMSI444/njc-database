

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sqlitetutorial.net
 */
public class select {

    /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:/sqlite/cinema.db";
        Connection conn = null;
        try {
        	Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    
    /**
     * select all rows in the warehouses table
     */
    public void selectAll(){
    	String sql = "SELECT id, name, year "
                + "FROM movies";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
            	 System.out.println(rs.getInt("id") +  "\t" + 
                         rs.getString("name") + "\t" +
                         rs.getInt("year"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void selectSpecific(String hero){
        String sql = "SELECT *"
                   + "FROM movies WHERE hero = ?";
 
 try (Connection conn = this.connect();
      PreparedStatement pstmt  = conn.prepareStatement(sql)){
     
     // set the value
     pstmt.setString(1,hero);
     //
     ResultSet rs  = pstmt.executeQuery();
     
     // loop through the result set
     while (rs.next()) {
         System.out.println(rs.getInt("id") +  "\t" + 
                            rs.getString("name") + "\t" +
                            rs.getDouble("year"));
     }
 } catch (SQLException e) {
     System.out.println(e.getMessage());
 }
}
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        select app = new select();
        //app.selectAll();
        app.selectSpecific("bale");
    }

}