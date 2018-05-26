package ControlLayer;


import DBLayer.DBProtocol;

import ModelLayer.Protocol;

public class DeviceController 
{
	public DeviceController()
	{
		
	}
	
	public void createProtocol(String name/*,.....*/) throws Exception 
    {    
         Protocol protocol = new Protocol();
         //protocol.setDate(date);
         //..

    try{
        	DBProtocol temp = new DBProtocol();
        	temp.create(protocol);
       }
       catch(Exception e)
       {
    	   throw new Exception("");
       }
    }
	
	 public void updateProtocol(int id/*,...*/)
     {
         DBProtocol temp = new DBProtocol();
         Protocol protocol = new Protocol();
         
         //protocol.setId(id);
         //..........
         
         temp.update(protocol);
     }
	 
	 public void deleteProtocol(String id)
	 {
		 DBProtocol temp = new DBProtocol();
		 
		 temp.delete(id);
	 }
	
	public Protocol findByName(String name)
	{
		DBProtocol temp = new DBProtocol();
		return temp.searchProtocolName(name);
	}
	 
	public Protocol findById(String id)
	{
		DBProtocol temp = new DBProtocol();
		return temp.findProtocol(id);
	}
	
	
	
	
	
	
}
