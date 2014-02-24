package wordProcessor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author priya
 */
public class connect {

    public Object connection() {

        
        String url = "jdbc:mysql://localhost:3306/ies?characterSetResults=UTF-8&characterEncoding=UTF-8&useUnicode=yes";
       
        
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "sant23";
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
         //   e.printStackTrace();
        }

        return con;

    }
 ResultSet result ;Connection con;
    public ResultSet getResult(String query) throws SQLException {
       con =null;
         result = null;
        Statement stmt = null;
         
         connect c = new connect();
        try {
        
        con = (Connection) c.connection();

            stmt = (Statement) con.createStatement();
            result = (ResultSet) stmt.executeQuery(query);
            
                
        } catch (Exception e) {
          //  e.printStackTrace();
        }
        //if(con!=null) con.close();
       
        return result;
    }
    public boolean insert(String query) throws SQLException
    {
        boolean flag=false;
        con = null;
        Statement stmt = null;
        connect c = new connect();
        int f=0;
        try {
            con = (Connection) c.connection();
            stmt = (Statement) con.createStatement();
            f=stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
      //  con.close();
        if(f==1)
            flag=true;
        return flag;
    }

    public void closeConnection() throws SQLException
    {
        if(con!=null) con.close();
    }
    
}
