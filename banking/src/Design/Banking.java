package Design;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.JOptionPane;
import java.sql.*;
public class Banking {//database connection
    Connection GetConnection;


    public Connection GetConnection()
    {
        Connection con=null;
        
         try{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");       
            con=DriverManager.getConnection("jdbc:odbc:Bank_DB");
        }
        
        catch(Exception exception){
            JOptionPane.showMessageDialog(null,"Error encountered while entering Connectin: "+exception);
        }
         return con;
    }
     public int insertValues (String SQL) throws Exception
    {
         Connection conn=GetConnection();
         Statement st=conn.createStatement();
         System.out.println(" "+SQL);
         int noRows= st.executeUpdate(SQL);
         conn.close();
         return noRows;
    }
    
     public ResultSet SelectValues(String SQL) throws Exception
    {
        Connection conn=GetConnection();
        PreparedStatement stmt=conn.prepareStatement(SQL);
        ResultSet rs=stmt.executeQuery();
        System.out.println(""+SQL);
        return rs;
    }

    int insertValues() {
        throw new UnsupportedOperationException("Not supported ."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    

