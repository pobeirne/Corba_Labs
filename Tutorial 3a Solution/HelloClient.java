import HelloWorldTieApp.*;
import org.omg.CORBA.*;
import java.io.*;
import java.net.*;

public class HelloClient{
	static String stringifiedObjectReference;

  public static void main(String args[]){
    try{
      // create and initialize the ORB
      ORB orb = ORB.init(args, null);

	  ObjectInputStream in = new ObjectInputStream(new FileInputStream("IOR")) ;

		String ior = (String) in.readObject() ;

			in.close() ;


		org.omg.CORBA.Object genericObjRef = orb.string_to_object(ior) ;
		System.out.println(genericObjRef);

      HelloWorldInterface remoteObjRef = HelloWorldInterfaceHelper.narrow(genericObjRef);

      String msg = remoteObjRef.sayHelloMethod();
      System.out.println(msg);


         }catch (Exception e) {
      System.out.println("ERROR : " + e) ;
      e.printStackTrace(System.out);
    }//end catch block
  }//end main() method

}//end DateClient class
