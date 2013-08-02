import javax.microedition.lcdui.*;

public class Complaints extends Form implements CommandListener
{
   
    Display disp;
    Command back,choose;
    String value;
    ChoiceGroup choice;
    SocketConnection sc;
   	StudentSearch studsearch;
   	String URL;
   	
   	EnterComplaint comp;
   public Complaints(String title, Display d,String u)
   {
		super(title);
		this.disp = d;
		this.URL=u;
		
		choose = new Command("Choose", Command.SCREEN,1);
		back=new Command("Back",Command.BACK,0);
		
		choice = new ChoiceGroup("Complaints/Sugestions about",Choice.EXCLUSIVE);
		
		choice.append("Staff", null);
		choice.append("Library", null);
		choice.append("Canteen", null);
		choice.append("Campus", null);
		
		this.append(choice);
		this.addCommand(choose);
		this.addCommand(back);
		this.setCommandListener(this);
	    
	    studsearch = new StudentSearch("Select", disp,URL);
	    
		disp.setCurrent(this);
		
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==choose)
		{
			int index = choice.getSelectedIndex();
			value =choice.getString(index);
			System.out.println("selected item "+value);
			comp = new EnterComplaint("Enter ",value, disp,URL);
			
			   	
		}
		else if(cmd==back)
		{
			disp.setCurrent(studsearch);
		}
	}
}