import DateApp.*;
import org.omg.CORBA.*;
import java.io.*;
import java.net.*;

public class DateClient{
	static String stringifiedObjectReference;

  public static void main(String args[]){
    try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);



      //Get and convert the stringified object reference
      // to a generic CORBA object reference
		  ObjectInputStream in = new ObjectInputStream(new FileInputStream("IOR")) ;

			String ior = (String) in.readObject() ;

			in.close() ;


			org.omg.CORBA.Object genericObjRef = orb.string_to_object(ior) ;


      //Cast, or narrow the generic object reference to a
      // true object reference.
      DateInterface remoteObjRef = DateInterfaceHelper.narrow(genericObjRef);

      
      //Call the TheDateInterface server object and
      // print results
      String username = remoteObjRef.getMasterDateMethod("Oisin Cawley - ID:123456789");
      System.out.println(username);

      //Delay program termination so that the console
      // won't disappear from the screen when running
      // under control of a batch file.
         }catch (Exception e) {
      System.out.println("ERROR : " + e) ;
      e.printStackTrace(System.out);
    }//end catch block
  }//end main() method

}//end DateClient class
