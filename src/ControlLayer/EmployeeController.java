package ControlLayer;

import DBLayer.DBEmployee;

import ModelLayer.Employee;

public class EmployeeController {

	public EmployeeController()
	{
		
	}
	
	public void createEmployee(String name/*,.....*/) throws Exception 
    {    
         Employee employee = new Employee();
         employee.setName(name);
         //..

    try{
        	DBEmployee temp = new DBEmployee();
        	temp.create(employee);
       }
       catch(Exception e)
       {
    	   throw new Exception("Employee not inserted");
       }
    }
	
	 public void updateEmployee(int id/*,...*/)
     {
         DBEmployee temp = new DBEmployee();
         Employee employee = new Employee();
         
         employee.setId(id);
         //..........
         
         temp.update(employee);
     }
	 
	 public void deleteEmployee(String id)
	 {
		 DBEmployee temp = new DBEmployee();
		 
		 temp.delete(id);
	 }
	
	public Employee findByName(String name)
	{
		DBEmployee temp = new DBEmployee();
		return temp.searchEmployeeName(name);
	}
	 
	public Employee findById(String id)
	{
		DBEmployee temp = new DBEmployee();
		return temp.findEmployee(id);
	}
}
