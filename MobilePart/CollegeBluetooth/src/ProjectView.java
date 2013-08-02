import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class ProjectView extends Form implements CommandListener
{

    Display disp;
	Command ok, back;
	TextField txtName;
	String message;
	String topicName;
	String st;	
	SocketConnection sc;
	ProjectInfo pi;
	String URL;
	public ProjectView(String title, Display d,String message,String u)
   {
		super(title);
		this.disp = d;
		this.URL=u;
		this.message=message;
		ok = new Command("OK", Command.OK,1);
		back = new Command("Back", Command.BACK,0);
		txtName = new TextField("Enter Topic","",50,TextField.ANY);
		this.addCommand(ok);
		this.addCommand(back);
		this.append(txtName);
		this.setCommandListener(this);
		
		pi= new ProjectInfo("Select",disp,message,URL);
		disp.setCurrent(this);
		
   }
   public void commandAction(Command cmd, Displayable d1)
   {
		if(cmd==ok)
		{
		   topicName = txtName.getString();
                   System.out.println("topic "+topicName);
		   topicName=topicName.replace(' ','$');
		   if(message.startsWith("Topic"))
		      st="PS"+"*"+topicName+"@";
		   else if(message.startsWith("Platform"))
		      st="PS"+"*"+topicName+"@";
		   sc = new SocketConnection(st,disp,URL);
		}
		if(cmd==back)
		{
			disp.setCurrent(pi);
		}
	} 
}	
	