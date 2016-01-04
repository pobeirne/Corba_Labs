import DateApp.*;
import org.omg.CORBA.*;
import java.util.Date;
import java.io.*;
import java.net.*;

class DateInterfaceServant extends _DateInterfaceImplBase{
	public String getMasterDateMethod(String student){
		System.out.println("Received a call from " + student + ".");
		return new Date().toString();
  }//end getDateMethod()
}//end DateInterfaceservant class