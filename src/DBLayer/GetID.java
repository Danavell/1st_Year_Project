package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetID {

	private static Connection con;
	
    public GetID()
    {
    	con = DBConnection.getInstance().getDBcon();
    }
		
    public static int getId(String query)
    {
    	
	ResultSet results;
	int x = -1;
	
	try{ 
		   Statement stmt = con.createStatement();
		   results = stmt.executeQuery(query);
		   if( results.next() )
		   {
			 x = results.getInt(1);
		   }
	   }
	catch(Exception e){
	    System.out.println("Error" + e);
	}
	return x;
}
}