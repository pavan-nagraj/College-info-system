import javax.microedition.lcdui.*;

public class StudentDetails extends List implements CommandListener
{	
   	Display disp;
   	Command Return;
   	String Msg, Msg1;
   	StudentInfo si;
   	Command back;
   	String URL;
   	
   	public StudentDetails(String title, String msg, Display d,String u)
	{
	   	super(title,Choice.IMPLICIT);
		this.disp = d;
		this.Msg = msg;
		this.URL=u;
		
		System.out.println("\n*********Message : " + Msg + "\n");
		
		
		int first=Msg.indexOf("*");
String m1=msg.substring(first+1);
//System.out.println(m1);

int second=m1.indexOf("*");
String name="Name:"+m1.substring(0,second);
//System.out.println(name);

String m2=m1.substring(second+1);
//System.out.println(m2);

int third=m2.indexOf("*");
String Phone="Mobile No:"+m2.substring(0,third);
//System.out.println(Phone);

String Email="Email Id:"+m2.substring(third+1);
//System.out.println(Email);
		
		/*int x = Msg.indexOf("*");
		System.out.println("\n1");
		String name="Name :"+ Msg.substring(0,x);		
		System.out.println("\nName : " + name);
	       	
		Msg1 = Msg.substring(x+1);
		System.out.println("\n2");
		int y= Msg1.indexOf("*");
		String Phone ="Ph No :"+ Msg1.substring(0,y);
		
			
		//Msg2 = Msg1.substring(y+1);
		//int z= Msg2.indexOf("*");
		String Email ="Email :"+ Msg1.substring(y+1);
		
		//String dept ="Dept:"+ Msg.substring(x+1);*/
		
		System.out.println(" Student Info. : " + name + " * " + Phone + " * " + Email + ".\n");
				
		this.append(name, null);
		this.append(Phone, null);
		this.append(Email, null);
		//this.append(dept, null);
		back = new Command("Back", Command.OK,0);
		
		this.setCommandListener(this);
		this.addCommand(back);
		
		disp.setCurrent(this);
		
		
    }
    	public void commandAction(Command c, Displayable d1)
	{     
	     if(c==back)
		{  
		    si= new StudentInfo("Enter either Dept or Sem", disp,URL);
			disp.setCurrent(si);
		
		}
	}
}     		