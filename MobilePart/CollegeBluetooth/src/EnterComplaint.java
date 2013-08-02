import javax.microedition.lcdui.*;

public class EnterComplaint extends Form implements CommandListener
{
   
     Display disp;
     Command submit,back;
     String value;
     TextField txtTo, txtComp, txtMobile;
   	 SocketConnection sc;
   	 String Value;
   	 Complaints comp;
   	 Alert alert;
   	 String to,complaints,mobNo;
   	 String URL;
   public EnterComplaint(String title, String value, Display d,String u)
   {
		super(title);
		this.disp = d;
		this.Value = value;
		this.URL=u;
		submit = new Command("Submit", Command.SCREEN,1);
		back=new Command("Back",Command.BACK,0);
		
		txtTo = new TextField("To","",30,TextField.ANY);
		txtComp = new TextField("Complaints/Suggestions","",30,TextField.ANY);
		txtMobile = new TextField("MobileNo/Email","",30,TextField.ANY);
		
		this.addCommand(submit);
		this.addCommand(back);
		this.append(txtTo);
		this.append(txtComp);
		this.append(txtMobile);
		
		this.setCommandListener(this);
		comp = new Complaints("Complaints/Suggestions",disp,URL);
		disp.setCurrent(this);
   }
 
 public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==submit)
		{	
		  to =txtTo.getString();
		  complaints=txtComp.getString();
		  complaints = complaints.replace(' ','$');
		  mobNo = txtMobile.getString();
		  String sendData="CS*"+Value+"*"+to+"*"+complaints+"*"+mobNo+"@";
		  System.out.println("before sending "+sendData);
		  sc= new SocketConnection(sendData,disp,URL);
		  System.out.println("after sending ");
		  alert=new Alert("Message ", "Complaints or Suggestions sent",null, AlertType.INFO);
		  alert.setTimeout(4000);
		  disp.setCurrent(alert);
		  
		}		
	  else if(cmd==back)
	 {
	 	 disp.setCurrent(comp);
	  }	 
	}
}			