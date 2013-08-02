import javax.microedition.lcdui.*;

public class PlacementResult extends TextBox implements CommandListener
{
	Display disp;
	String output;
	Command Return;
	Placement placement;
	String URL;
	public PlacementResult(String title, String data, Display d,String u)
	{
		super(title,"",40,0);
		this.disp = d;
		
		this.output = data;
		this.URL=u;
		System.out.println("result "+output);
		int first=output.indexOf("*");
		String msg=output.substring(first+1);
		this.setString(msg);
		Return = new Command("Return", Command.BACK,0);
		this.addCommand(Return);
		this.setCommandListener(this);
		
		placement = new Placement("Enter Ur USN", disp,URL);
		disp.setCurrent(this);
		
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd ==Return)
		{
			disp.setCurrent(placement);
		}
	}
	
}