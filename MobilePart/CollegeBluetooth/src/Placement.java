import javax.microedition.lcdui.*;

public class Placement extends Form implements CommandListener
{
	Command ok, back;
	TextField txtusn;
	Display disp;
	StudentSearch studsearch;
	SocketConnection sc;
	String URL;
	Placement(String Title, Display d,String u)
	{
		super(Title);
		this.disp = d;
		this.URL=u;
		
		ok = new Command("OK", Command.OK, 1);
		back = new Command("Back", Command.BACK, 0);
		txtusn=new TextField("Enter USN: ", "",30,TextField.ANY);
		
		this.addCommand(ok);
		this.addCommand(back);
		this.append(txtusn);
		
		this.setCommandListener(this);
		studsearch = new StudentSearch("Select", disp,URL);
		disp.setCurrent(this);
		
	}
	public void commandAction(Command c, Displayable d1)
	{
		if(c==back)
		{
		  disp.setCurrent(studsearch);
		  	
		}
		else if(c==ok)
		{
			String data ="PL*"+ txtusn.getString()+"@";
			
			System.out.println("enetrd "+data);
			
			sc = new SocketConnection(data,disp,URL);
		}
	}
}
