package wordProcessor;import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author priya
 */
public class Dictionary {

    public static void main(String[] args)
    {

        Connection con = null;
    Statement st=null,st1=null,st2=null;
ArrayList <String> al = new ArrayList();
    String url = "jdbc:mysql://localhost:3306/vakyaYantra_2?characterSetResults=UTF-8&characterEncoding=UTF-8&useUnicode=yes";
    //String db = "vakyaYantra_2";
    String driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String pass = "nagashree";
    String drop="DROP TABLE Dict";

  //  primary key(EntityID)
    String no="CREATE TABLE Dict (word varchar(100) character set utf8,translation varchar(100),meaning varchar(100),pos varchar(100) )";
     try{

     Class.forName(driver).newInstance();
       System.out.println("connection established");

      con = DriverManager.getConnection(url, user, pass);
      try
      {
         st = con.createStatement();


     st.execute(drop);
        st.execute(no);

        con.close();
       }
      catch (SQLException s){
         // s.printStackTrace();
       System.out.println("Table already exists!");
        }
    }
    catch (Exception e)
    {
         e.printStackTrace();
      //  System.out.println("Class for name some problem");
    }
  // Updating freq counts case 1- for table 1 :)

String l=null,r=null;//line




       
        int c=0;
         String del="\\|";
        String[] temp=new String[10];
        try{
            Connection connection=DriverManager.getConnection(url, user, pass);
   FileInputStream fin=new FileInputStream("/home/administrator/java/Dictionary.txt");
   DataInputStream dis=new DataInputStream(fin);
  BufferedReader br=new BufferedReader(new InputStreamReader(dis,"UTF-8"));
    int i=1,nfc=0,r1;

       int num=1;
ResultSet S=null;
    while ((l = br.readLine())!=null)
    {
         temp = l.split(del);

        //System.out.println(temp[0]+" "+temp[1]+" "+temp[2]+" "+temp[3]);
         PreparedStatement stat1= connection.prepareStatement("INSERT INTO Dict(word,translation,meaning,pos) VALUES(?,?,?,?)");
             stat1.setString(1, temp[0]);//for the first ?
             stat1.setString(2,temp[1] );//for the second ?
             stat1.setString(3, temp[2]);//for the first ?
             stat1.setString(4,temp[3]);

             stat1.executeUpdate();
        c++;

   }

//
//       PreparedStatement stat=connection.prepareStatement("SELECT meaning FROM Dict where word like 'अंगैः'");
//       S=stat.executeQuery();
//
//       while(S.next()){
//           String wd=S.getString(1);
//          al.add(wd);
//           System.out.println("wd"+wd);
//
//      }

        }catch(Exception e){}
        System.out.print(c);

     

    }

}
