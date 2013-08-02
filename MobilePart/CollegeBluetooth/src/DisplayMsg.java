import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class DisplayMsg extends TextBox implements CommandListener
{
	
	Display disp;
	String Average;
	Command back;
	EnterRegNo reg;
	String URL;
	public DisplayMsg(String title, String mesg, Display d,String u)
	{
		super(title,"",50,0);
		this.Average=mesg;
		this.disp=d;
		this.URL=u;
		this.setString(Average);
	    
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