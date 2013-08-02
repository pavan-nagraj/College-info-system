import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
public class Welcome extends MIDlet implements CommandListener
{
  Display disp;
  Form frm;
  Command cmd,exit;
  Ticker ticker;
  String  str;
  discover td;
  TextBox serching;
  
  public Welcome()
  {
  	disp = Display.getDisplay(this);
  	frm = new Form("Welcome");
  	cmd = new Command("Discover",Command.OK,1);
  	exit = new Command("Quit",Command.EXIT,0);
  	str = new String("College Campus");
  	ticker = new Ticker(str);
  	serching=new TextBox("wait","i am serching..",15,1);  
  	frm.addCommand(cmd);
  	frm.addCommand(exit);
  	frm.setTicker(ticker);
  	frm.setCommandListener(this);
  	  	 	
  	disp.setCurrent(frm);
  }	
	
	public void startApp()
	{
	}
	
	public void pauseApp()
	{
	}
	
	public void destroyApp(boolean u)
	{
	}
	
	public void commandAction(Command c, Displayable d)
	{
		 try
        {
		if(c==cmd)
		{
			disp.setCurrent(serching);
			td = new discover(disp,this);
		}
		if(c==exit)
		{
			destroyApp(false);
			notifyDestroyed();
		}
		}
		
			catch(Exception e)
		{
			System.out.println("Exception"+e);
		}
	}
}