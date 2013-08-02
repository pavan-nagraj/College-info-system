import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class DisplayMarks extends TextBox implements CommandListener
{
	
	Display disp;
	String Average;
	Command back;
	EnterRegNo reg;
	String URL;
	public DisplayMarks(String title, String mesg, Display d,String u)
	{
		super(title,"",50,0);
		this.Average=mesg;
		this.disp=d;
		this.URL=u;
		int first=Average.indexOf("*");
		String msg=Average.substring(first+1);
		this.setString(msg);
			    
	    back = new Command("Back", Command.BACK,0);
	    this.addCommand(back);
	    this.setCommandListener(this);
	    
	    reg = new EnterRegNo("Enter Reg",disp,Average,URL);   
	    disp.setCurrent(this);
		
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==back)
		{
			disp.setCurrent(reg);
		}
	}
}