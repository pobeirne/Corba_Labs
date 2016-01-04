

import HelloWorldTieApp.*;
import org.omg.CORBA.*;
import java.util.Date;
import java.io.*;
import java.net.*;

public class HelloServer   {
	static String stringifiedObjectReference;

  public static void main(String args[]){
    try{
      //Create and initialize the ORB
      ORB orb = ORB.init(args, null);

      //Create servant and register it with the ORB

      HelloWorldInterface objref = new HelloWorldInterface_Tie(new HelloInterfaceServant());



      orb.connect(objref);

      //Convert the object reference to a string and store
      // it in a common file for access by the client.
      orb.object_to_string(objref);


     	ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("IOR")) ;

	  	out.writeObject(orb.object_to_string(objref)) ;
	  	out.close() ;
 	    System.out.println("Server is running...");
 	  	orb.run();
    }catch (Exception e) {
       System.err.println("ERROR: " + e);
       e.printStackTrace(System.out);
    }//end catch block
  }//end main()
}
