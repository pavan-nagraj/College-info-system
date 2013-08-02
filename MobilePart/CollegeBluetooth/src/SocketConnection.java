import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
import java.io.*;
import java.util.*;
import java.lang.*;

class SocketConnection extends Thread 
{
	
	Display disp;
	
	String str;
	
	StreamConnection con;
	//IPAddress ipadd;
	String recMesg;
	String url;
	EnterRegNo reg;
	Login login;
	String msg, info;
	ChooseOption opt;
	DisplayMarks dm;
	
	StudentSearch ss;
	ViewProjSem ps;
	ViewAlumini alumini;
	ViewAluminiDetails detail;
	ListNames lst;
	StudentDetails stud;
	PlacementResult placeResult;
	String URL;
	
	InputStream in;
	OutputStream op;
	
	
	public SocketConnection(String userpass, Display d1,String u)
	{
	
	  this.str= userpass;
	  System.out.println("sss " +str);
	  this.disp = d1;
	  this.URL=u;
	  //ipadd = new IPAddress();
	 
	  this.start(); 	
	}
	
    public void run()
	 {
	 
		System.out.println("before");
		try{
	    
		con = (StreamConnection)Connector.open(URL,Connector.READ_WRITE);
		System.out.println("\nValue from Server : " + con);
		
		System.out.println("after");
             op = con.openOutputStream();
            System.out.println("@@@");
            
   				
			System.out.println("New String: "+str.trim());
   		    System.out.println("i am sending...");
   	
   		
   				this.op.write(str.getBytes());
   				System.out.println ("aftr converting to bytes");
   				this.op.close();
   				System.out.println("message sent...");
   				
		
		
		
		
			try
			{
				System.out.println("1");
				in = con.openInputStream();	
				System.out.println("2");
				
			}
			catch(IOException e) 
			{
	    		System.out.println("Exception : " + e);
	    		Alert al= new 	Alert("failure","142"+e,null,null); 
    			int time= al.getDefaultTimeout();
    			al.setTimeout(time);
    			Displayable db=disp.getCurrent();
    			disp.setCurrent(al,db);
	    	}
	    
	   		 System.out.println("@@@"+in);
	    	System.out.println("GGG ");
	    
			
   			StringBuffer str1 =new StringBuffer();
   	 		char data;
   	 		int ch;
   	 		while(( ch= this.in.read())!=-1)
   	 		{
   	 		data=(char)ch;
   	 		if(data=='%')
   	 		{
   	 			break ;
   	 		}
   	 	  	 			
   	 		 		System.out.println("i am in reading..."+data);
   	 				str1.append(data);
   	 				
   	 		} 
   	 		this.con.close(); 
          	this.in.close(); 
             
    	  
          System.out.println("after reading...");
          recMesg=new String(str1);
          recMesg=recMesg.trim();
         /* Alert al= new 	Alert("Data Recieved After Reading",recMesg,null,null); 
    				int time= al.getDefaultTimeout();
    				al.setTimeout(time);
    				Displayable db=disp.getCurrent();
    				disp.setCurrent(al,db);*/
          
          
          System.out.println("message recived at mobile is"+recMesg);
          /*int a=recMesg1.indexOf("*");
          String recMesg=recMesg1.substring(0,a);
          recMesg=recMesg.trim();
          Alert al= new 	Alert("After Modifying",recMesg,null,null); 
    				int time= al.getDefaultTimeout();
    				al.setTimeout(time);
    				Displayable db=disp.getCurrent();
    				disp.setCurrent(al,db);*/
            				
   				
				
	
	     /* if(recMesg.startsWith("Parent")) 
	      {   	
	       	opt = new ChooseOption("Select ",disp,URL);
	      	disp.setCurrent(opt);
	      }	*/
	    	if(recMesg.startsWith("Invalid"))
	      {
	      	 Alert a1=new Alert("info","you are not valid user",null,AlertType.INFO);
             disp.setCurrent(a1);
             a1.setTimeout(4000);
	      }
	    	else if(recMesg.startsWith("AVG"))
	      {
	      	System.out.println("in avg");
	      	dm = new DisplayMarks("Internal Marks",recMesg,disp,URL);
	      	
	      	disp.setCurrent(dm);
	      }
	      else if(recMesg.startsWith("Percentage"))
	      {
	      	System.out.println("percentage");
	      	dm = new DisplayMarks("Attendandance Percentage",recMesg,disp,URL);
	      	
	      	disp.setCurrent(dm);
	      }
	      else if(recMesg.startsWith("Student"))
	      {
	      	/*Alert al= new 	Alert("Enter","OK",null,null); 
    				int time= al.getDefaultTimeout();
    				al.setTimeout(time);
    				Displayable db=disp.getCurrent();
    				disp.setCurrent(al,db);*/
	      	ss=new StudentSearch("Select Ur Choice",disp,URL);
	      	disp.setCurrent(ss);
	      	
	      }
	      else if(recMesg.startsWith("PS"))
	      {
	      	ps= new ViewProjSem("Project Details",recMesg,disp,URL);
	      }
	      else if(recMesg.startsWith("Alumini"))
	      {
	      	
	      	alumini = new ViewAlumini("Alumini Details",recMesg,disp,URL);
	      }
	      else if(recMesg.startsWith("DT"))
	      {
	      	
	      	detail = new ViewAluminiDetails("Alumini Details",recMesg,disp,URL);
	      }
	      else if(recMesg.startsWith("ST"))
	      {
	      	lst = new ListNames("List of Names",recMesg, disp,URL);
	      }
	      
	      /*else if(recMesg.startsWith("NAME"))
	      {
	      	stud = new StudentDetails("Student Information",info,disp);
	      }*/
	      
	      else if(recMesg.startsWith("PL"))
	      {
	      	
	      	placeResult = new PlacementResult("Placement Result ",recMesg, disp,URL);
	      	disp.setCurrent(placeResult);
	      }
	      
	      else if(recMesg.startsWith("POLL"))
	      {
	      	 Alert a1=new Alert("info","Ur Answers Sent Sucessfully",null,AlertType.INFO);
             disp.setCurrent(a1);
             a1.setTimeout(4000);
	      }
	      
	      else if(recMesg.startsWith("IN")) {
	      	
	      	 System.out.println("\n**********Called.\n");
	      	 stud = new StudentDetails("Student Information",recMesg, disp,URL);
	      	 disp.setCurrent(stud);	      	
	      }
	      
	     
	    }
	    catch(Exception e11)
	    {
	    	
	    	 System.out.println(e11);
	    	 
	    }	
	}
	

	
}