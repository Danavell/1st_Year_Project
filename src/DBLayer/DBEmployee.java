package DBLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ModelLayer.Employee;

public class DBEmployee {
	
	private  Connection con;
	
	public DBEmployee()
	{
		con = DBConnection.getInstance().getDBcon();
	}
	
	public int create(Employee emp) throws Exception
    {  
        int nextID = GetID.getId("Select max(id) from employee");
        nextID = nextID + 1;
  
       int x = -1;
       //AFTER RELATIONAL MODEL
	   String query="INSERT INTO employee(id,x,x,x,..)  VALUES('"+ nextID  + "')";

     try{ 
	          Statement stmt = con.createStatement();
	          stmt.setQueryTimeout(5);
	     	  x = stmt.executeUpdate(query);
	          stmt.close();
      	}
       catch(SQLException ex){
          System.out.println("Employee is not added");
          throw new Exception ("Employee is not added");
       }
       return(x);
    }
	
	public int update(Employee emp)
	{
		int x = -1;
// After we have relational model
		String query = "UPDATE employee SET "+ "name ='"+ emp.getName()+"'";
		
  	try{
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	x = stmt.executeUpdate(query);
	 	 	stmt.close();
		}
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in employee db: " + ex);
	  	}
		return(x);
	}
	
	public int delete(String id)
	{
		int x = -1;
	  //AFTER RELATIONAL MODEL
	  	String query = "DELETE FROM employee WHERE id = '" + id + "'";
	  	
	 try{
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	  	x = stmt.executeUpdate(query);
	 	  	stmt.close();
  		}
   	        catch(Exception ex)
	 		{
   	        	System.out.println("Delete exception in employee db: " + ex);
   	        }
		return(x);
	}
	
	private String selectEmployeeWhere(String where)
	{
		//AFTER RELATIONAL MODEL
	    String query = "SELECT name,x,x,x,..  FROM employee";
		
		if ( where.length() > 0 )
		{
			query = query + " WHERE " + where;
		}
			
		return query;
	}
	
	private Employee buildEmployee(ResultSet results)
    {  
		Employee employee = new Employee();
        try
        { //All attributes of employee table
	        employee.setName(results.getString("name"));
	        //........
	        
        }
        catch(Exception e)
        {
        	System.out.println("error in building the employee object");
        }
        return employee;
    }
	
	private Employee singleWhere(String where)
	{
		ResultSet results;
		Employee employee = new Employee();
                
	    String query = selectEmployeeWhere(where);

		try
		{ 	
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() )
	 		{
	            employee = buildEmployee(results);         
	            stmt.close();
			}
            else
            { 	
                employee = null;
            }
		}
		
	 	catch(Exception e)
		{
	 		System.out.println("Query exception: " + e);
	 	}
		
		return employee;
	}
	
	private ArrayList<Employee> moreWhere(String where)
	{
		ResultSet results;
	    ArrayList<Employee> list = new ArrayList<Employee>();	
		
	    String query =  selectEmployeeWhere(where);
  
        try{
				Statement stmt = con.createStatement();
			 	stmt.setQueryTimeout(5);
			 	results = stmt.executeQuery(query);
			 	
			
				while( results.next() )
				{
					Employee employee = new Employee();
					employee = buildEmployee(results);	
		            list.add(employee);	
				}
		        stmt.close();     
		}
        
	 	catch(Exception e){
	 		System.out.println("Query exception" + e);
			e.printStackTrace();
	 	}
        
		return list;
	}

	public ArrayList<Employee> getAllEmployees()
    {
        return moreWhere("");
    }
	
    //get one employee with id
    public Employee findEmployee(String id)
    {   String where = "  id = '" + id + "'";
        return singleWhere(where);
    }
    
    //find one employee having the name
    public Employee searchEmployeeName(String name)
    {
        String where = "name like '%" + name + "%'";
        System.out.println("Search Employee " + where);
        return singleWhere(where);
    }

}
