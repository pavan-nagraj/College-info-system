import javax.microedition.lcdui.*;

public class ViewAluminiDetails extends List implements CommandListener
{	
   	Display disp;
   	
   	Command Return;
    String Msg;
	String yearOfPass;
	String compName;
	String emailId;
	String phNo;
	String alName; 
	ViewAlumini view;
	int i=0;
	AluminiInfo alumini;
	String URL;
	public ViewAluminiDetails(String title, String msg, Display d,String u)
	{
		super(title,Choice.IMPLICIT);
		this.disp =d;
		this.Msg = msg;
		this.URL=u;
		System.out.println(" in view "+Msg);
		
		int first=Msg.indexOf("*");
String m1=Msg.substring(first+1);

int second=m1.indexOf("*");
String alName="Name:"+m1.substring(0,second);
System.out.println(alName);
String m2=m1.substring(second+1);

int third=m2.indexOf("*");
String yearOfPass="PassedOut: "+m2.substring(0,third);
System.out.println(yearOfPass);
String m3=m2.substring(third+1);

int fourth=m3.indexOf("*");
String phNo= "Phone No:"+m3.substring(0,fourth);
System.out.println(phNo);
String emailId = "EmailId: "+m3.substring(fourth+1);
System.out.println(emailId);

/*int fifth=m4.indexOf("*");
String emailId = "EmailId: "+m4.substring(0,fifth);
System.out.println(emailId);
String compName = "Company: "+m4.substring(fifth+1);
System.out.println(compName);*/
			     
	    /* i =Msg.indexOf("*");
	     
	     
	     alName = "Name: "+Msg.substring(0,i);
	     Msg = Msg.substring(i+1);
	     System.out.println(alName);
	     i = Msg.indexOf("*");
	     yearOfPass = "PassedOut: "+Msg.substring(0,i);
	        System.out.println(yearOfPass);
	     Msg = Msg.substring(i+1);
	     i = Msg.indexOf("*");
	     
	     phNo= "Phone No:"+Msg.substring(0,i);
	       System.out.println(phNo);
	     Msg = Msg.substring(i+1);
	     
	     i = Msg.indexOf("*");
	     emailId = "EmailId: "+Msg.substring(0,i);
	       System.out.println(emailId);
	     Msg = Msg.substring(i+1);
	     compName = "Company: "+Msg.substring(0);
	        System.out.println(compName);
	        
	        */
	        this.append(alName, null);
	        this.append(yearOfPass, null);
	        this.append(phNo, null);
	        this.append(emailId, null);
	        //this.append(compName, null);
	        
	        
	        Return = new Command("Return",Command.OK, 0);
	        this.setCommandListener(this);
	        this.addCommand(Return); 
	        disp.setCurrent(this);
	        
	 }       
	   	public void commandAction(Command c, Displayable d1)
	{     
	     if(c==Return)
		{  
		    alumini = new AluminiInfo("Enter ",disp,URL);
			//disp.setCurrent(view);
			disp.setCurrent(alumini);
		}
	}
}	
	
	
	