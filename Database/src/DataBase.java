import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
   
public class DataBase {  
     /** 
     * Connect to a sample database 
     */  
    public static void connect() {  
        Connection conn = null;  
        try {  
            // db parameters  
        	 Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:MoviesDB.db";  
            // create a connection to the database  
            conn = DriverManager.getConnection(url);  
              
            System.out.println("Connection to SQLite has been established.");  
              
        } catch (SQLException | ClassNotFoundException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            try {  
                if (conn != null) {  
                    conn.close();  
                }  
            } catch (SQLException ex) {  
                System.out.println(ex.getMessage());  
            }  
        }  
    }  
    /** 
     * @param args the command line arguments 
     */  
}  