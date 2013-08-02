import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class EnterRegNo extends Form  implements CommandListener
{
	Display disp;
	Form frm;
	Command ok,back;
	TextField  txtReg, txtSubj;
	String regNo, subName;
	String str;	
	String selectedType;
	SocketConnection sc;
	String URL;

     ChooseOption ch;

	public EnterRegNo(String title,Display d, String mesg,String u)
	{  
	    super(title);
	    System.out.println("dfhdfg"+title);
	    this.disp=d;
	    this.URL=u;
	    selectedType=mesg;		
		ok = new Command("OK", Command.SCREEN,1);
		back=new Command("Back",Command.BACK,0);
		txtReg=new TextField("Registration No","", 30,TextField.ANY);
		txtSubj=new TextField("Subject name","", 30,TextField.ANY);
		this.addCommand(ok);
		
		this.addCommand(back);
	 
	    this.append(txtReg);
		this.append(txtSubj);
		this.setCommandListener(this);
		
		disp.setCurrent(this);
		
	}  
	public void startApp()
	{
	}
	public void pauseApp()
	{
	}
	public void destroyApp(boolean unconditional)
	{
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		  if(cmd==ok)
		  {
		  	regNo=txtReg.getString();
		  	subName=txtSubj.getString();
		  	if(selectedType.startsWith("Internal"))
		  	{
		  	
		  	str="Inter"+"*"+regNo+"*"+subName+"@";
		  	}
		  	else if(selectedType.startsWith("Attendance"))
		  	{
		  	str="Attend"+"*"+regNo+"*"+subName+"@";	
		  	}
		  	sc = new SocketConnection(str,disp,URL);
		  }
		  else if(cmd==back)
		  {
		  	ch = new ChooseOption("Select", disp,URL);
		  }
    }
 }   		  
		  