import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
   
public class insert {  
   
    private Connection connect() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:D:/sqlite/cinema.db";  
        Connection conn = null;  
        try {  
            conn = DriverManager.getConnection(url);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }  
        return conn;  
    }  
   
  
    public void insertRecords(String hero,String heroine,String director,String name, int year) {  
        String sql = "INSERT INTO movies(hero,heroine,director,name,year) VALUES(?,?,?,?,?)";  
   
        try{  
        	Class.forName("org.sqlite.JDBC");
            Connection conn = this.connect();  
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,hero);
            pstmt.setString(2,heroine);
            pstmt.setString(3,director);
            pstmt.setString(4,name);  
            pstmt.setInt(5,year);  
            pstmt.executeUpdate();  
        } catch (SQLException | ClassNotFoundException e) {  
            System.out.println(e.getMessage());  
        }  
    }  
   
    public static void main(String[] args) {  
   
        insert app = new insert();  
        // insert three new rows  
        app.insertRecords("bale","maggie","Nolan","Dark knight",2002);  
        app.insertRecords("jack sparrow","elizabeth","espen","Pirates",2001);  
        app.insertRecords("mcfly","lorraine","robert","Back to future",1995);  
    }  
   
}  