import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import javax.microedition.io.*;
import java.io.*;
import java.util.Vector;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.*;

public class discover extends List implements CommandListener
 {
  Display display;
  Command cmdQuit,login,refresh;
  Login log;
  
  Thread processorThread1,processorThread2;
  LocalDevice localDevice;
  DiscoveryAgent agent;
  Welcome parent;
  int count1 = 0;
  int count2 = 0;
  int Sflag=0;
  int Dflag=0;
  int CommandFlag=0;         
  StreamConnection con = null;
  StreamConnectionNotifier service= null;
  InputStream ip  = null;
  OutputStream op=null;
   RemoteDevice[] device = null;
  String serviceURL=null ;
   ServiceRecord[][] records = null;
  String[] connectionURL = null;
  int[] transactionid=null;
  TextBox serching;
  int index;
  String DName;
  String URL;
  String[] RemoteDeviceAddres=new String[10];
  public static Vector RemoteDevices = new Vector();
  public discover()
  {
  	 super("Discovered..", List.IMPLICIT); 
  }
     
  public discover(Display d,Welcome ff) throws Exception
   {    
    
    
    super("Discovered..", List.IMPLICIT);
    
    device = new RemoteDevice[10];
    connectionURL=new  String[10];
    transactionid=new int[10];
   
    display=d; 
    parent=ff;
    serching=new TextBox("wait","i am serching..",15,1);
    
    cmdQuit=new Command("Quit",Command.EXIT,1);
    login=new Command("Login",Command.OK,1); 
    refresh=new Command("Refresh",Command.OK,1);     
    this.addCommand(cmdQuit);
    
    this.addCommand(refresh);
      
    this.setCommandListener(this);
           
     doDiscover();
   }
   
   	
   	
   	
   	public void commandAction(Command com,Displayable d1)
   {
     if(com==cmdQuit)
     {
      parent.destroyApp(false);
      parent.notifyDestroyed();        
     }     
    if(com==login)
     {
     	 index=this.getSelectedIndex();
     	 DName=this.getString(index);
     	 URL=  connectionURL[index];
     	System.out.println("within main url is "+this.URL);
     	
     	log=new Login("LOGIN",display,URL);
     	display.setCurrent(log);
        
     }
     if(com==refresh)
     {
       startINQUIRY();	
     } 
     
    
   }
  
 
  
    
    public void doDiscover()
    {
    	
        try
        {
        	
        localDevice = LocalDevice.getLocalDevice();
        localDevice.setDiscoverable( DiscoveryAgent.GIAC ); 
        String address=(localDevice.getBluetoothAddress()).trim();
        address=address.substring(1,5);
        UUID RFCOMM_UUID= new UUID("102030405060708090A0B0C0D0E0F010", false);
        this.serviceURL="btspp://localhost:"+RFCOMM_UUID+";name=MessageServer";
        System.out.println("URL IS:"+this.serviceURL);
        Thread.sleep(1000);
        ReadSocket tempObj=new ReadSocket(this.serviceURL,this.display);
        processorThread2=new Thread(tempObj);
        processorThread2.start();
        Thread.sleep(5000);
		System.out.println("Address: "+address);
		System.out.println("Name: "+localDevice.getFriendlyName());
		
		//find devices
		agent = localDevice.getDiscoveryAgent();
		
        
	
		System.out.println("Starting device inquiry...");
	
    	display.setCurrent(serching);
		
		agent.startInquiry(DiscoveryAgent.GIAC, new listener(this));
	
		
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
			Alert al= new 	Alert("sucess","142"+e,null,null); 
    		int time= al.getDefaultTimeout();
    		al.setTimeout(time);
    		Displayable db=display.getCurrent();
    		display.setCurrent(al,db);
		}
    }
  public void startINQUIRY() 
  {
  	    try
  	    {
  	    
  		System.out.println("Starting device inquiry...");
  		this.display.setCurrent(serching);		
		agent.startInquiry(DiscoveryAgent.GIAC,  new listener(this));
		
			}
		catch(Exception e)
		{
			System.out.println("Exception>>>>1"+e);
			Alert al= new 	Alert("sucess","162"+e,null,null); 
    		int time= al.getDefaultTimeout();
    		al.setTimeout(time);
    		Displayable db=display.getCurrent();
    		display.setCurrent(al,db);
		}
  } 
 }
 class listener  implements DiscoveryListener,Runnable
    {
    	discover obj;
    	listener(discover obj)
    	{
    		this.obj=obj;
    		
    		
    	}
    
  public  void serviceSearchCompleted(int transID, int respCode)   
  {
   
    
   if(respCode==SERVICE_SEARCH_ERROR)
   System.out.println("\nSERVICE_SEARCH_ERROR\n");
   if(respCode==SERVICE_SEARCH_COMPLETED)
   System.out.println("\nSERVICE_SEARCH_COMPLETED\n");
   if(respCode==SERVICE_SEARCH_TERMINATED)
   System.out.println("\n SERVICE_SEARCH_TERMINATED\n");
   if(respCode == SERVICE_SEARCH_NO_RECORDS){
   
   System.out.println("\n SERVICE_SEARCH_NO_RECORDS\n");
   }
   if(respCode == SERVICE_SEARCH_DEVICE_NOT_REACHABLE)
   System.out.println("\n SERVICE_SEARCH_DEVICE_NOT_REACHABLE\n");
   }
	public void inquiryCompleted(int discType)
	 {
	 	try
	 	{
	 	
	 	
	  	Thread.sleep(2000);
	    obj.display.setCurrent(obj);
		switch (discType) {
			case DiscoveryListener.INQUIRY_COMPLETED :
				System.out.println("INQUIRY_COMPLETED");
			    	    	    
       			break;
			case DiscoveryListener.INQUIRY_TERMINATED :
				System.out.println("INQUIRY_TERMINATED");
				break;
			case DiscoveryListener.INQUIRY_ERROR :
				System.out.println("INQUIRY_ERROR");
				break;
			default :
				System.out.println("Unknown Response Code");
				break;
		}
		
		if(discType==DiscoveryListener.INQUIRY_COMPLETED)
		{
		Thread td =new Thread(this);
		td.start();
		}
		}catch(Exception e)
		{
			System.out.println("Exception"+e);
			Alert a2= new 	Alert("error","239"+e,null,null); 
    		int time1 = a2.getDefaultTimeout();
    		a2.setTimeout(time1);
    		obj.display.setCurrent(a2,obj);
		}
	
	}
	public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) 
	{
		
	   	    
		discover.RemoteDevices.addElement( btDevice );
		
		
	}
	
	public void run()
	{
		
	
    	
	    int flag=0;
	    	
		 try
        {
              
        
        for (int m = 0; m < discover.RemoteDevices.size(); m++) 
        	{
        		 RemoteDevice btDevice = (RemoteDevice)	discover.RemoteDevices.elementAt(m);
        		flag=0;
        		
     
        		if(obj.CommandFlag==0)
	           {
	        	obj.addCommand(obj.login);
	    	    obj.CommandFlag=1;
	           }
        		
            
        	for(int i=0;i<obj.count1;i++)
        	{
        	  if(obj.device[i] == btDevice)
        	  {
        	  	flag=1;
        	  	break;
        	  }	
        	}
        	if(flag==0)
        	{
        	
	         String str =btDevice.getFriendlyName(true);
	           obj.device[obj.count1] = btDevice;
	        
	       obj.append(str, null);
	       obj.RemoteDeviceAddres[obj.count1]=btDevice.getBluetoothAddress();
	    
     	 	 UUID[] uuids = new UUID[1];
              uuids[0] = new UUID("102030405060708090A0B0C0D0E0F010", false);
              
     			 obj.transactionid[obj.count1] = obj.agent.searchServices(null,uuids,btDevice,this);
     			 Thread.sleep(30000);
     			 System.out.println("Transaction id  for device :"+obj.count1+"id is::"+obj.transactionid[obj.count1++]);
 		 	
        	}
        	        	
        	}
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
			Alert a2= new 	Alert("sucess","320"+e,null,null); 
    		int time1 = a2.getDefaultTimeout();
    		a2.setTimeout(time1);
    		Displayable db1=obj.display.getCurrent();
    		obj.display.setCurrent(a2,db1);
		} 
	}
	public  void servicesDiscovered(int transID,ServiceRecord[] servRecords)
    {
    	
    	
         System.out.println("Service discoverd...");
  		 System.out.println("Service discoverd& transID:"+transID);
  		 int j=0;
  		 while(j!=10)
  		 {
  		 	System.out.println("transID>>"+obj.transactionid[j]);
  		 	if(transID==obj.transactionid[j])
  		 	{
  		 		break;
  		 	}
  		 	j++;
  		 	System.out.println("value of j :"+j);
  		 }
  		 
   	
   		 for(int i=0;i<servRecords.length;i++) 
   		 {
           
           
           obj.connectionURL[j] = servRecords[i].getConnectionURL(0,false);
           System.out.println("Connection url :" + obj.connectionURL[j]);
          
         }
         System.out.println("Connection url :" + obj.connectionURL[j]);
        Alert a2= new 	Alert("RemoteUrl","RUrl"+obj.connectionURL[j],null,null); 
    	 int time1 = a2.getDefaultTimeout();
    	a2.setTimeout(time1);
    	Displayable db1=obj.display.getCurrent();
    		obj.display.setCurrent(a2,db1);
   }
   
}


class ReadSocket extends discover implements Runnable
{
	String URL=null;
	Display SubDisplay=null;
	ReadSocket(String url,Display dpl)
	{
		
	super();
	this.URL=url;
	SubDisplay=dpl;
	System.out.println("reading.........");

	}
	public void run() 
	{
		try{
		
	   System.out.println("url is:"+this.URL);
	  service = (StreamConnectionNotifier)Connector.open(this.URL);
	  System.out.println("connection is opend to reading.........");
      while(true)
      {
      
      super.con = service.acceptAndOpen();

       super.ip = super.con.openInputStream();
       Read read =new Read(super.ip,SubDisplay,super.con);
       Thread td =new Thread(read);
      
       td.start();
       }
       	}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
			Alert al= new 	Alert("Eroor","410"+e,null,null); 
    		int time= al.getDefaultTimeout();
    		al.setTimeout(time);
    		Displayable db=SubDisplay.getCurrent();
    		SubDisplay.setCurrent(al,db);
		}
      
   
	}

	
}
class Read extends discover implements Runnable
{
	InputStream subip=null;
	Display SubSubDisplay=null;
	StreamConnection Subcon = null;
	Read(InputStream subip,Display dpl,StreamConnection c)
	{
		super();
		this.subip=subip;
		SubSubDisplay=dpl;
	    Subcon=c;
	System.out.println("i am in read thred...");
	

	}	
		
		public  void run()
	{
		try{
		
   		
   		
   	 StringBuffer str =new StringBuffer();
   	 char data;
   	
   	 while((data=(char) this.subip.read())!='*')
   	 {
   	 	str.append(data);
   	 	
   	 }  
             
          if (this.subip != null) {
        
          this.subip.close();
          this.Subcon.close();
          }
          
          String message =new String(str);
          System.out.println("message recived is"+message);
      
   		 	}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
			Alert al= new 	Alert("Error","479"+e,null,null); 
    		int time= al.getDefaultTimeout();
    		al.setTimeout(time);
    		Displayable db=SubSubDisplay.getCurrent();
    		SubSubDisplay.setCurrent(al,db);
		}
	}
}