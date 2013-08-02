import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ChooseOption extends Form implements CommandListener
{
	
	Display disp;
	Command select,cmdback;
	ChoiceGroup choice;
	EnterRegNo reg;
	PollAnswer poll; 
	String URL;
	
	Form frm;
    
	public ChooseOption(String title, Display d,String u)
	{
		super(title);
		this.disp =d;
		this.URL=u;
		select = new Command("Select", Command.SCREEN,1);
		cmdback = new Command("Back", Command.BACK,0);
		choice = new ChoiceGroup("Select option to proceed ",Choice.EXCLUSIVE);
		choice.append("Internal Marks", null);
		choice.append("Attendance Details", null);
		choice.append("Answer to Poll", null);
		this.append(choice);
		this.addCommand(select);
		this.addCommand(cmdback); 
		this.setCommandListener(this);
		disp.setCurrent(this);
		
	}
	
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==select)
		{
			int i= choice.getSelectedIndex();
			String message =new String(choice.getString(i));
			// message = choice.getString(i);
			System.out.println("bxc "+i+message );
			if(i==0)
			{
			  reg = new EnterRegNo("Enter Reg",disp,message,URL);
			  disp.setCurrent(reg);
			}
			else if(i==1)
			{
			  reg = new EnterRegNo("Enter Reg",disp,message,URL);
			  disp.setCurrent(reg);	
			}
			else if(i==2)
			{
				poll= new PollAnswer("Answer  to Polling", disp,URL);
				disp.setCurrent(poll);
			}
		}
		if(cmd==cmdback){			
			Login l = new Login("Login",disp,URL);
	   		disp.setCurrent(l);			
		}
	}
}
