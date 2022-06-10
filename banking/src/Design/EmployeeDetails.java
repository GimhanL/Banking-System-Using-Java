
package Design;

import java.sql.*;

public class EmployeeDetails {
Connection con;
ResultSet rs;
PreparedStatement pst;
    private String Username;
    private String Usertype;
      private String pass; 
    
    Banking obj=new Banking();
    
   public String getUsername(){
        return Username;
    }
    
    public void setUsername(String Username) {
        this.Username= Username;
    }
    
    public String getUsertype(){
        return Usertype;
    }
     public void setpass(String pass) {
        this.pass= pass;
    }
    
    public String getpass(){
        return pass;
    }
       
    
    public void setUsertype(String Usertype) {
        this.Usertype= Usertype;
    }
    

     
       public int addemployee()
    {
        int noRows=0;
        String SQL="insert into login values('"+getUsername()+ "','"+ getpass()+"','"+ getUsertype()+"','"+ "Deactivate"+"')";
        
        try{
            noRows=obj.insertValues(SQL);
        }
        catch(Exception ex)
        {
            System.out.println(" "+ex.toString());
        }
       return noRows;
    }
   
     
     public boolean validateemployee()
    {
   boolean valid=true;
        if( getUsername().isEmpty() ||getpass().isEmpty() )
        {
        valid=false;
        }
        return valid;
    }
     
      public String AutoId()//auto id
    {
          String  IDS=null;
        try
        {
         String    SQL="select  Username  from login";
        ResultSet rs=obj.SelectValues(SQL);  	
        String CID=null;       
        while (rs.next())
           {
            CID= rs.getString( "Username") ;
             System.out.println(CID);	
            }
     
       String x =CID.substring(1); 
      int  ID  =Integer.parseInt(x); 
      	
        if(ID>0 && ID<9)
        {
       ID=ID+1;
       IDS ="U00"+ID;     
        }
      else   if(ID>=9 && ID<99)
        {
       ID=ID+1;
        IDS ="U0"+ID;
        }
       else   if(ID>=99)
        {
       ID=ID+1;
        IDS ="U"+ID;
        }     
      }         
        catch (Exception ex)
         {
         System.out.println(" "+ex.toString());
         
        }
 return IDS;
    }
}

