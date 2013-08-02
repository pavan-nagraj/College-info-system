import javax.microedition.lcdui.*;
import java.util.*;

public class ViewProjSem extends List implements CommandListener
{
	
	Display disp;
	String projDetails;
	Command back;
	ProjectView proj;
	int i, j, k;
	String title;
	String date;
	String platform;
	String time;
	String output;
	String URL;
	
	Vector vMsg;
	//String rec[];
	String msg1 = "",ps;	
	
	int j1=0;
	int start=0;
	
	public ViewProjSem(String title, String msg, Display d1,String u)
	{
		super(title,Choice.IMPLICIT);
		this.disp = d1;
		this.projDetails = msg;
		this.URL=u;
		System.out.println("\n ProjDetails : " + projDetails);
				
		back = new Command("Back", Command.BACK, 0);
		this.addCommand(back);
		this.setCommandListener(this);
		
		proj =new ProjectView("Select", disp, projDetails,URL);
	
	
		vMsg = new Vector();		
		
	
		while(j<projDetails.length())
		{ 
		    System.out.println("\n projDetails.length() " + projDetails.length());
			start=projDetails.indexOf("#");
			
			msg1 = projDetails.substring(0,start);
				
			vMsg.addElement(msg1);
			System.out.println("\n Added.");
			
			projDetails=projDetails.substring(start+1,projDetails.length());
		}
		
		System.out.println("\nSize of Vector :  " + vMsg.size()); 
	   
	    String rec[] = new String[vMsg.size()];
	    
	    vMsg.copyInto(rec);	   
	    System.out.println("\nCopied.");   
	   			
		for(int j1=0;j1<rec.length;j1++) {
			
			System.out.println("\n Inside.");
			
			String s = rec[j1];
			
			i = s.indexOf("*");			
			ps = s.substring(0,i);
			
			String first = s.substring(i+1);
			j = first.indexOf("*");
			
			title ="Title :"+ first.substring(0,j);
			
			String sec = first.substring(j+1);
			k = sec.indexOf("*");
						
			platform="Platform :"+ sec.substring(0,k);
			
			String last =sec.substring(k+1);
			int l = last.indexOf("*");
			
			time ="Time :"+ last.substring(0,l);
			date ="Date :"+ last.substring(l+1);			 
		
		   	String line = "-----------";
		
			output =title+" "+platform+" "+date+" "+time;
			
			System.out.println("\nvalues =="+output);
		
			this.append(title,null);
			this.append(platform, null);
			this.append(date, null);
			this.append(time,null);
			this.append(line,null);					
		}		
		
		disp.setCurrent(this); 
	}
	public void commandAction(Command c, Displayable d)
	{
		if(c==back)
		{
		 disp.setCurrent(proj);
		}
	}
}