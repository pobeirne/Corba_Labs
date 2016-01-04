import java.io.*;
import org.omg.CORBA.*;
import HelloNaming.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;
import java.util.Properties;


public class HelloNamingServer{

	public static void main (String args[]) {
		try{
			NameComponent nc[] = new NameComponent[1];
	    	
			ORB orb = ORB.init(args, null);

			Hello helloRef = new Hello_Tie(new HelloServant()) ;

			
			orb.connect(helloRef);
	   		System.out.println("Orb connected.");

			
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
	   		System.out.println("Found NameService.");
			
			NamingContext rootCtx = NamingContextHelper.narrow(objRef);
			
			nc[0] = new NameComponent("Hello", "Context");
			NamingContext HelloCtx = rootCtx.bind_new_context(nc);
			
			nc[0] = new NameComponent("World", "Object");			
			HelloCtx.rebind(nc, helloRef);	   
			orb.run();

		} catch (Exception e) {
			System.err.println("Error: "+e);
			e.printStackTrace(System.out);
		}

	}
}