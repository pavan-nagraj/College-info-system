import javax.microedition.lcdui.*;
public class PollAnswer extends Form implements CommandListener
{
	Display disp;
	Command send,back;
	TextField tfAns;
	TextField tfqtn;
	ChooseOption choose;
	String ans;
	SocketConnection socket;
	String URL;
	public PollAnswer(String title,Display d,String u)
	{
		super(title);
		this.disp=d;
		this.URL=u;
		send=new Command("Send",Command.OK,0);
		back=new Command("Back",Command.BACK,1);
		tfAns=new TextField("Enter your answer","",40,TextField.ANY);
		tfqtn=new TextField("Enter question number","",40,TextField.ANY);
		choose=new ChooseOption("Select",disp,URL);
		this.append(tfqtn);
		this.append(tfAns);
		
		this.addCommand(send);
		this.addCommand(back);
		this.setCommandListener(this);
		disp.setCurrent(this);
		
	}
	public void commandAction(Command c,Displayable d)
	{
		if(c==back)
		{
			disp.setCurrent(choose);
			
		}
		else if(c==send)
		{
			ans="Opinion*parent*"+tfqtn.getString()+"*"+tfAns.getString()+"@";
			
		System.out.println("ANs "+ans);
		socket=new SocketConnection(ans,disp,URL);	
		}
	}
	
	
}