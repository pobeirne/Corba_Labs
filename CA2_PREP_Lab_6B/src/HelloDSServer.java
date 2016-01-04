
import org.omg.CORBA.*;
import HelloDeferredSynchronous.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class HelloDSServer {

    public static void main(String args[]) {
        try {

            // create and initialize the ORB
            ORB orb = ORB.init(args, null);
            //Delegation model for creating a servant
            Hello helloRef = new Hello_Tie(new HelloDSServant());
            //connecting the servant to the orb
            orb.connect(helloRef);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext rootCtx = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Hello", "");
            NameComponent path[] = {nc};
            rootCtx.rebind(path, helloRef);

            System.out.println("Defferred Synchronous Server running ...");
            // wait for invocations from clients
            orb.run();

        } catch (InvalidName 
                | NotFound 
                | CannotProceed 
                | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        }

    }
}
