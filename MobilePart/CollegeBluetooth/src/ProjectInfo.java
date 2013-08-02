import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ProjectInfo extends Form implements CommandListener
{

    Display disp;
	Command select,back;
	ChoiceGroup choice;
	
	String message; 
	ProjectView pv;
	StudentSearch ss;
	String URL;
	public ProjectInfo(String title, Display d,String message,String u)
	{
		super(title);
		this.disp = d;
		this.URL=u;
		
		select = new Command("Select", Command.SCREEN,1);
		back=new Command("Back",Command.BACK,0);
		choice = new ChoiceGroup("Search by  ",Choice.EXCLUSIVE);
		choice.append("Topic Name", null);
		choice.append("Platform", null);
		this.append(choice);
		this.addCommand(select);
		this.addCommand(back);
		this.setCommandListener(this);
		ss = new StudentSearch("Select ",disp,URL);
		disp.setCurrent(this);
		
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==select)
		{
			int i= choice.getSelectedIndex();
			String selected =new String(choice.getString(i));
			
			System.out.println("selected item "+i+selected );
			if(i==0)
			{
			  pv = new ProjectView("Enter Topic Name ",disp,selected,URL);
			  disp.setCurrent(pv);
			}
	   		else if(i==1)
			{
			  pv = new ProjectView("Enter Platform",disp,selected,URL);
			  disp.setCurrent(pv);	
			} 
		}
		else if(cmd==back)
		{
			disp.setCurrent(ss);
		}
	}
}