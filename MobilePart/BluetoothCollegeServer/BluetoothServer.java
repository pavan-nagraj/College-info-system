import java.io.IOException;
import java.util.Vector;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.*;
import java.io.*;
import javax.microedition.io.*;
//import java.util.*;

class BluetoothServer 
{
	
	
	public static void main(String a[])
	{
	
		StreamConnection con = null;
        StreamConnectionNotifier service= null;
        InputStream ip  = null;
        OutputStream op=null;
       
			try{
		//Creating the Object of the LocalDevice class & calling the setDiscoverable() method on that Object		
		LocalDevice localDevice = LocalDevice.getLocalDevice();
		System.out.println("Address: "+localDevice.getBluetoothAddress());
		System.out.println("Name: "+localDevice.getFriendlyName());
        localDevice.setDiscoverable( DiscoveryAgent.GIAC ); 
        
        //Creating the Object of UUID class & appending the address of that Object to a String 
        UUID RFCOMM_UUID = new UUID("102030405060708090A0B0C0D0E0F010", false);
        String serviceURL="btspp://localhost:"+RFCOMM_UUID+";name=MessageServer";
        System.out.println("URL IS:"+serviceURL);
        
		
	  //Creating the Object of the StreamConnectionNotifier class by calling the static method i.e., open() of the Connector class 
	  service = (StreamConnectionNotifier)Connector.open(serviceURL);
	  System.out.println("connection is opend to reading.........");
      while(true)
      {
      //Waiting for the client to be connect
      //Creating the Object of the StreamConnection class
      //by invoking the acceptAndOpen() of  StreamConnectionNotifier class on the StreamConnectionNotifier Object
      con = service.acceptAndOpen();

       //Creating the Object of InputStream Class
       //by invoking the openInputStream() of StreamConnection Class on the StreamConnection Object.
      ip = con.openInputStream();	
				
			
       //Creating the Object of the Read Class & passing that Object to the Constructor of the Thread Class
       Read read =new Read(ip,con);
       Thread td =new Thread(read);
       
       //Thread is started
       td.start();
       }
       	}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	}
	
}

class Read extends BluetoothServer  implements Runnable
{
	InputStream subip=null;
	OutputStream subop=null;
	StreamConnection Subcon = null;
	String msg;
	StoreOpinion storeOpinion;
	 
	  RegNoCheck reg;
	  QueryResponse resp; 
	  
	  String m;
	  
	  ComplaintsTo comp;
	  
	  StudentQuery stud;
	  PlacementQuery placement;
	
	
				
	Read()
	{
	}
	
Read(InputStream sip,StreamConnection c)
	{
		this.subop=null;
		this.subip=sip;
		this.Subcon=c;
		reg = new RegNoCheck();
		resp=new QueryResponse();
		comp = new ComplaintsTo();
		stud = new StudentQuery();
		placement = new PlacementQuery();
		System.out.println("thread copy created...");
	

	}	
		
		public  void run()
	{
		try{
		
   		
 	 		StringBuffer str1 =new StringBuffer();
   	 		char data;
   	 		int ch;
   	 		
   	 		while(( ch= this.subip.read())!=-1)
   	 		{
   	 		data=(char)ch;
   	 		if(data=='@')
   	 		{
   	 			break ;
   	 		}
   	 	  	 			
   	 		 		System.out.println("i am in reading..."+data);
   	 				str1.append(data);			
   	 			System.out.println("i am in reading..."+str1);
   	 		} 
   	 		
           this.subip.close();   
    	  
          System.out.println("after reading...");
          msg=new String(str1);
          msg=msg.trim();
          
          
          System.out.println("message recived at server is"+msg);
          
          
               
        subop =this.Subcon.openOutputStream();      
	 	if(msg.startsWith("u"))
	 	{
          LoginCheck login=new LoginCheck();
	 	  m = login.Check(msg);
	 	  m=m+"%";
	 	  System.out.println("after response"+m);	 	  
	 	  this.subop.write(m.getBytes());
	 	  System.out.println("value set at:"+m.trim());
	 	
	 	}
	 	
	 	if(msg.startsWith("Inter"))
	 	{
	 	   m= reg.NumberCheck(msg);
	 	   m=m+"%";
	 	   System.out.println("after response"+m);
	 	   this.subop.write(m.getBytes());
	 	 
	 	}
	 	
	 	if(msg.startsWith("Attend"))
	 	{
	 	   m= reg.NumberCheck(msg);
	 	   m=m+"%";
	 	   System.out.println("after response"+m);
	 	   this.subop.write(m.getBytes());
	 	  
	 	}
	 	
	 	if(msg.startsWith("PS"))
	 	{
	 	    System.out.println("in check");
	 	    m= resp.sendResponse(msg);
	  	    System.out.println("after response"+m);
	  	    m=m+"%";
	  	    System.out.println("after response"+m);
	  	   	this.subop.write(m.getBytes());
	 	    
	 	}
	 	
	    if(msg.startsWith("PT"))
	 	{
	 		System.out.println("in check");
	 	    m= resp.sendResponse(msg);
	 	    m=m+"%";
	 	    System.out.println("after response"+m);
	 	    this.subop.write(m.getBytes());
	 	   
	 	}
	 	
	 	if(msg.startsWith("Alumini"))
	 	{
	 	  	System.out.println("in check");
	 	  	m= resp.sendResponse(msg);
	 	  	m=m+"%";
	 	  	System.out.println("after response"+m);
	 	  	this.subop.write(m.getBytes());
	 	  
	 	}
	 	if(msg.startsWith("DT"))
	 	{
	 	  m = resp.sendResponse(msg);
	 	  m=m+"%";
	 	  System.out.println("after response"+m);
	 	  this.subop.write(m.getBytes());
	 	 
	 	}
	 	
	 	if(msg.startsWith("CS"))
	 	{
	 		
	 	  	comp.dataStore(msg);
	 	  	    
	 	}
	 	
	    if(msg.startsWith("ST"))
	    {
	       m =stud.queryData(msg);
	       m=m+"%";
	       System.out.println("after response"+m);
	       this.subop.write(m.getBytes());	
	       
	    }
	  	    
	    if(msg.startsWith("Opinion"))
	    {   
	      storeOpinion=new StoreOpinion();
	    	
	      m=storeOpinion.storeData(msg);
	      m=m+"%";
	      System.out.println("after response"+m);
	      this.subop.write(m.getBytes());
	     
	    }
	    
	    if(msg.startsWith("PL"))
	    {
	      m= placement.sendData(msg);
	      m=m+"%";
	      System.out.println("after response"+m);
	      this.subop.write(m.getBytes());
	     
	    }
	    
	    if(msg.startsWith("IN"))
	    {
	       m =stud.queryData(msg);
	       System.out.println("\n********Called.\n");
	       System.out.println("Value : " + m);
	       m=m+"%";
	       System.out.println("after response"+m);
	       this.subop.write(m.getBytes());
	      	
	       System.out.println("\n*********Send\n");
	    }
	    if(msg.startsWith("MR"))
	    {
	       m =stud.queryData(msg);
	       System.out.println("\n********Called.\n");
	       System.out.println("Value : " + m);
	       m=m+"%";
	       System.out.println("after response"+m);
	       this.subop.write(m.getBytes());
	      
	       System.out.println("\n*********Send\n");
	    }
	    if(msg.startsWith("EX"))
	    {
	       m =stud.queryData(msg);
	       System.out.println("\n********Called.\n");
	       System.out.println("Value : " + m);
	       m=m+"%";
	       System.out.println("after response"+m);
	       this.subop.write(m.getBytes());
	      
	       System.out.println("\n*********Send\n");
	    }
	    if(msg.startsWith("LB"))
	    {
	       m =stud.queryData(msg);
	       System.out.println("\n********Called.\n");
	       System.out.println("Value : " + m);
	       m=m+"%";
	       System.out.println("after response"+m);
	       this.subop.write(m.getBytes());
	      
	       System.out.println("\n*********Send\n");
	    }
	     if(msg.startsWith("AT"))
	    {
	       m =stud.queryData(msg);
	       System.out.println("\n********Called.\n");
	       System.out.println("Value : " + m);
	       m=m+"%";
	       System.out.println("after response"+m);
	       this.subop.write(m.getBytes());
	      
	       System.out.println("\n*********Send\n");
	    }   
         this.subop.close();
         this.Subcon.close();
        
       	
   		
   		 	}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	}
}

