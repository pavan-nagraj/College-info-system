import javax.microedition.lcdui.*;

public class StudentInfo extends Form implements CommandListener
{
   
    Display disp;
    Command search,back;
    String value;
    TextField txtcategory;
   	SocketConnection sc;
   	StudentSearch studsearch;
   	String URL;
   public StudentInfo(String title, Display d,String u)
   {
		super(title);
		this.disp = d;
		this.URL=u;
		
		search = new Command("Search", Command.SCREEN,1);
		back=new Command("Back",Command.BACK,0);
		
		txtcategory = new TextField("Enter either dept or semester ","",30,TextField.ANY);
		
		this.addCommand(search);
		this.addCommand(back);
		this.append(txtcategory);
		this.setCommandListener(this);
	    
	    studsearch = new StudentSearch("Select", disp,URL);
		disp.setCurrent(this);
		
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==search)
		{
			value ="ST"+"*"+txtcategory.getString()+"@";
			
			System.out.println("selected item "+value );
			
			sc = new SocketConnection(value,disp,URL);
		
		}
		else if(cmd==back)
		{
			disp.setCurrent(studsearch);
		}
	}
}