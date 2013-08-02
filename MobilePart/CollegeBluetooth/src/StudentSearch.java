import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

public class StudentSearch extends Form implements CommandListener
{

    Display disp;
	Command select,cancel;
	ChoiceGroup choice;
	AluminiInfo alumini;
	ProjectInfo pi; 
	Complaints comp;
	StudentInfo stud;
	SendOpinion sendOpinion;
	Placement placement;
	ChooseOption cp;
	String URL;
	
	Form frm;
	
	public StudentSearch(String title, Display d,String u)
	{
		super(title);
		this.disp = d;
		this.URL=u;
		
		select = new Command("Select", Command.SCREEN,1);
		cancel = new Command("Back",Command.CANCEL,0);
		choice = new ChoiceGroup("Select option to proceed ",Choice.EXCLUSIVE);
		
		choice.append("Project/Seminar", null);
		choice.append("Alumini Information", null);
		choice.append("Complaints/Suggestions", null);
		choice.append("Student Details", null);
		choice.append("Send Answer for polling",null);
		choice.append("Placement Details", null);
		choice.append("Attendace", null);
		
		this.append(choice);
		this.addCommand(select);
		this.addCommand(cancel);
		this.setCommandListener(this);
		
		
		disp.setCurrent(this);
		
	}
	public void commandAction(Command cmd, Displayable d1)
	{
		if(cmd==select)
		{
			int i= choice.getSelectedIndex();
			String message =new String(choice.getString(i));
			
			System.out.println("selected item "+i+message );
			if(i==0)
			{
			  pi = new ProjectInfo("Options to Search ",disp,message,URL);
			  disp.setCurrent(pi);
			}
			else if(i==1)
			{
			  alumini = new AluminiInfo("Enter ",disp,URL);
			  disp.setCurrent(alumini);	
			} 
			else if(i==2)
			{
			  comp = new Complaints("Complaints/Suggestions",disp,URL);
			  disp.setCurrent(comp);
			}
			else if(i==3)
			{
			  stud = new StudentInfo("Enter search Category",disp,URL);
			  disp.setCurrent(stud);	
			}
			else if(i==4)
			{
				sendOpinion=new SendOpinion("Send Opinion",disp,URL);
				disp.setCurrent(sendOpinion);
				
			}
			else if(i==5)
			{
				placement=new Placement("Enter ur USN to view result",disp,URL);
				disp.setCurrent(placement);
				
			}
		else if(i==6)
			{
				cp=new ChooseOption("Attendance",disp,URL);
				disp.setCurrent(cp);
				
			}




		}
		
	   else if(cmd==cancel)
	   {
	   		Login l = new Login("Login",disp,URL);
	   		disp.setCurrent(l);
	   }
	}
	
}