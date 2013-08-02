import javax.microedition.lcdui.*;

public class AluminiInfo extends Form implements CommandListener
{
   
   Display disp;
   Command search,back;
   String value;
   TextField txtYear;
   	SocketConnection sc;
   	StudentSearch studsearch;
   String URL;
   public AluminiInfo(String title, Display d,String u)
   {
		super(title);
		this.disp = d;
		this.URL=u;
		
		search = new Command("Search", Command.SCREEN,1);
		back=new Command("Back",Command.BACK,0);
		
		txtYear = new TextField("Enter either comp or passout year","",30,TextField.ANY);
		
		this.addCommand(search);
		this.addCommand(back);
		this.append(txtYear);
		this.setCommandListener(this);
	    
	    studsearch = new StudentSearch("Select", disp,URL);
		disp.setCurrent(this);
		
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==search)
		{
			value ="Alumini"+"*"+txtYear.getString()+"@";
			
			System.out.println("selected item "+value );
			
			sc = new SocketConnection(value,disp,URL);
		
		}
		else if(cmd==back)
		{
			disp.setCurrent(studsearch);
		}
	}
}