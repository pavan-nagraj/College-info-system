import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;

public class exe 

{
	Display disp;
	//Form frm;
	Command submit;
	String str;
	Thread t;
	StreamConnection con;
	String URL;
	
	public exe(String userpass, Display d1,String u)
	{
		this.disp=d1;
		this.str=userpass;	
		this.URL=u;
			t.start();
		
	}
	
	 public void startApp(){}
     public void pauseApp(){}
     public void destroyApp(boolean b){}
     
     public void run()
     {
     }
}