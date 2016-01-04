// GridServer.java
import GridWorld.* ;
import java.io.* ;
import org.omg.PortableServer.*;
import org.omg.CORBA.* ;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

public class GridServer {
    public static void main(String[] args) {
	try{
		System.out.println("Please wait for Server ...");
 		ORB orb = ORB.init(args,null);
      	POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

		GridPOA g = new GridPOATie(new GridImplementation(50,50));
   		byte[] gridId = rootPOA.activate_object(g);
		org.omg.CORBA.Object gridObj = rootPOA.id_to_reference(gridId) ;

		org.omg.CORBA.Object nameObj=orb.resolve_initial_references("NameService");

		NamingContext rootCtx=NamingContextHelper.narrow(nameObj);
		NameComponent[] name = new NameComponent[1];
		name[0] = new NameComponent("POA", "Obj");
 		rootCtx.rebind(name, gridObj);

   		rootPOA.the_POAManager().activate();
   		System.out.println(gridObj + " with id " + gridId + " is ready.");
   		orb.run();
    	}
    	catch (Exception e) {
      		e.printStackTrace();
    	}
    }
}
