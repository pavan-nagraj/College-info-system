import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class Login extends Form implements CommandListener
{
	Display disp;
	Form frm;
	
	Command submit,back;
	TextField txtname, txtpass, txtip;
	String username="", password="",str="";
	//IPAddress ip;
	String URL;
	
	SocketConnection sc;
	public Login(String title,Display d,String u)
	{  
	    super(title);
	    System.out.println("dfhdfg"+title);
	    this.disp=d;
	    this.URL=u;
	    
	    System.out.println("dfhdfg");
		
	    //ip = new IPAddress();
	   //disp = Display.getDisplay(this);
	   //frm = new Form("Login");
	    submit = new Command("Submit", Command.SCREEN,1);
	    back=new Command("Back",Command.BACK,0);
	    txtname=new TextField("UserName","", 30,TextField.ANY);
	    txtpass=new TextField("Password","", 20,TextField.PASSWORD);
	    //txtip=new TextField("IP Address","", 20,TextField.ANY);
		
	    this.addCommand(submit);
		
		this.addCommand(back);
		this.append(txtname);
		this.append(txtpass);
		//this.append(txtip);
		
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
	 	if(cmd==back)
		{
			disp.setCurrent(frm);
			
		} 
		 if(cmd == submit)
		{   
            //ipaddress = txtip.getString();
			username = txtname.getString();
			password = txtpass.getString();
			str ="u"+"*"+username+"*"+password+"@";
			System.out.println("aaa "+str.trim());
			/*ip.setIPAdress(ipaddress);
			System.out.println("add  "+ipaddress);*/
			
			sc = new SocketConnection(str,disp,URL);
			
			
		}  
	      
   }	
}