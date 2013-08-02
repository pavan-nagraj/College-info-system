import javax.microedition.lcdui.*;
public class SendOpinion extends Form implements CommandListener
{
	Display disp;
	Command send,back;
	TextField tfAns;
	TextField qNum;
	StudentSearch studSearch;
	String ans;
	SocketConnection socket;
	String URL;
	public SendOpinion(String title,Display d,String u)
	{
		super(title);
		this.disp=d;
		this.URL=u;
		send=new Command("Send",Command.OK,0);
		back=new Command("Back",Command.BACK,1);
		tfAns=new TextField("Enter your answer","",40,TextField.ANY);
		qNum=new TextField("Enter question number","",40,TextField.ANY);
		studSearch=new StudentSearch("Select",disp,URL);
		this.append(qNum);
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
			disp.setCurrent(studSearch);
			
		}
		else if(c==send)
		{
			String getdata=tfAns.getString();
			getdata=getdata.replace(' ','$');
			ans="Opinion*student*"+qNum.getString()+"*"+getdata+"@";
			
		System.out.println("ANs "+ans);
		socket=new SocketConnection(ans,disp,URL);	
		}
	}
	
	
}