package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Employee;
import ModelLayer.Protocol;

public class DBProtocol
{
	private Connection con;
	
	public DBProtocol()
	{
		con = DBConnection.getInstance().getDBcon();
	}
	
	public void create(Protocol protocol)
	{
		int nextID = GetID.getId("select max(id) from protocol");
		nextID = nextID + 1;
		
		int x = -1;
		
		String query = "INSERT INTO protocol(id,x,x,x,x,...) VALUES (    )";
		
		try 
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			x = stmt.executeUpdate(query);
			stmt.close();
		} 
		catch (SQLException e)
		{
			
			e.printStackTrace();
		}	
	}
	
	public void update(Protocol protocol)
	{
		int x = -1;
		
		String query = "UPDATE protocol SET "+ "name =' " ;
		
		try 
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			x = stmt.executeUpdate(query);
			stmt.close();
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	
	public void delete(String id)
	{
		int x = -1;
		
		String query = "DELETE FROM protocol WHERE id = '" +  "";
		
		try 
		{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			x = stmt.executeUpdate(query);
			stmt.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	private String selectProtocolWhere(String where)
	{
		String query = "SELECT x,x,x,xx,x,.. FROM protocol";
		
		if(where.length() > 0 )
		{
			query = query + "WHERE " + where;
		}
		return query;
	}
	
	private Protocol buildProtocol(ResultSet results)
    {  
		Protocol protocol = new Protocol();
        try
        { 
	       // protocol.setName(results.getString("name"));
	        //........
	        
        }
        catch(Exception e)
        {
        	System.out.println("");
        }
        return protocol;
    }
	
	private Protocol singleWhere(String where)
	{
		ResultSet results;
		Protocol protocol = new Protocol();
                
	    String query = selectProtocolWhere(where);

		try
		{ 	
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	            protocol = buildProtocol(results);         
	            stmt.close();
			}
            else
            { 	
                protocol = null;
            }
		}
		
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: " + e);
	 	}
		
		return protocol;
	}
	
	private ArrayList<Protocol> moreWhere(String where)
	{
		ResultSet results;
	    ArrayList<Protocol> list = new ArrayList<Protocol>();	
		
	    String query =  selectProtocolWhere(where);
  
        try{
				Statement stmt = con.createStatement();
			 	stmt.setQueryTimeout(5);
			 	results = stmt.executeQuery(query);
			 	
			
				while( results.next() )
				{
					Protocol protocol = new Protocol();
					protocol = buildProtocol(results);	
		            list.add(protocol);	
				}
		        stmt.close();     
		}
        
	 	catch(Exception e){
	 		System.out.println("Query exception" + e);
			e.printStackTrace();
	 	}
        
		return list;
	}
	
	public ArrayList<Protocol> getAllProtocol()
    {
        return moreWhere("");
    }
	
    //get one employee with id
    public Protocol findProtocol(String id)
    {   String where = "  id = '" + id + "'";
        return singleWhere(where);
    }
    
    //find one employee having the name
    public Protocol searchProtocolName(String name)
    {
        String where = "name like '%" + name + "%'";
        System.out.println("Search Protocol " + where);
        return singleWhere(where);
    }
}
