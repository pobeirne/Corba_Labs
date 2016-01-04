
import java.io.*;
import org.omg.CORBA.*;
import HelloDynamicInvocation.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paul
 */
public class HelloDynamicServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {

            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            //Delegation model for creating a servant
            Hello helloRef = new Hello_Tie(new HelloServant());

            //connecting the servant to the orb
            orb.connect(helloRef);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext rootCtx = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Hello", "");
            NameComponent path[] = {nc};
            rootCtx.rebind(path, helloRef);

            System.out.println("Servant loaded.");
            
            // wait for invocations from clients
            orb.run();

        } catch (org.omg.CORBA.ORBPackage.InvalidName 
                | NotFound 
                | CannotProceed 
                | InvalidName e) {
            System.err.println("Error: " + e);
            e.printStackTrace(System.out);
        }

    }
}
