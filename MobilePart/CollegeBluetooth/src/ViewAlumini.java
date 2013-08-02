import javax.microedition.lcdui.*;

public class ViewAlumini extends List implements CommandListener
{
	Display disp;
	String output;
	String inmsg;
	Command back;
	Command viewmore;
	AluminiInfo alumini;
	SocketConnection sc;
	String URL;
	
	String Msg;
		
	public ViewAlumini(String title, String msg, Display d,String u)
	{
		super(title,Choice.IMPLICIT);
		this.disp =d;
		this.Msg = msg;
		this.URL=u;
		System.out.println(" in alumini "+Msg);
		
		back = new Command("Back",Command.BACK, 0);
		viewmore = new Command("ViewMore",Command.OK,1);
		this.addCommand(viewmore);
		this.addCommand(back);
			
		int j=0;
		this.append("Liist of Alumini's", null);
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
		alumini = new AluminiInfo("Enter", disp,URL);
		disp.setCurrent(this);
	

	}
	public void commandAction(Command c, Displayable d1)
	{
		if(c==back)
		{
			disp.setCurrent(alumini);
		}
		else if(c==viewmore)
		{
			int index = this.getSelectedIndex();
			String item ="DT*"+this.getString(index)+"@";
			System.out.println("selected one is"+item+""+index);
			
			sc=new SocketConnection(item,disp,URL);
			//disp.setCurrent();
		}
		
	}
}