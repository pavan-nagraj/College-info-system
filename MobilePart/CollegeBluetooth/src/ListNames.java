import javax.microedition.lcdui.*;

public class ListNames extends List implements CommandListener
{
	Display disp;
	String output;
	String inmsg;
	Command back;
	Command viewmore;
	
	SocketConnection sc;
	
	String Msg;
	StudentInfo stud;
	String URL;	

	public ListNames(String title, String msg, Display d,String u)
	{
		super(title,Choice.IMPLICIT);
		this.disp =d;
		this.Msg = msg;
		this.URL=u;
		System.out.println(" list "+Msg);
		
		back = new Command("Back",Command.BACK, 0);
		viewmore = new Command("ViewMore",Command.OK,1);
		this.addCommand(viewmore);
		this.addCommand(back);
			
		int j=0;
		this.append("List of Students", null);
		while(j<Msg.length())
		{ 
		    
		    int start=Msg.indexOf("*");
		    if(start<0)
		    {
		       System.out.println(Msg);
		       this.append(Msg,null);
		       break;
		    }
		    output=Msg.substring(0,start);
		    System.out.println(output);
		    this.append(output, null);
		    Msg=Msg.substring(start+1,Msg.length());
		    	
		}
		
		
		this.setCommandListener(this);
		stud = new StudentInfo("Enter", disp,URL);
		disp.setCurrent(this);
	

	}
	public void commandAction(Command c, Displayable d1)
	{
		if(c==back)
		{
			disp.setCurrent(stud);
		}
		else if(c==viewmore)
		{
			int index = this.getSelectedIndex();
			String select=this.getString(index);
			  
			//String item ="NAME*"+this.getString(index);
			System.out.println("selected one is"+select+""+index);
 		    String item ="IN*"+select+"@";	
 		    
 		    System.out.println("\nCommand : " + item + "\n");
 		     		    
			sc=new SocketConnection(item,disp,URL);			
		}
		
	}
}