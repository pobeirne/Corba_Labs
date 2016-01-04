
import AnyExample.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author paul
 */
public class TimeOfDayServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ORB orb = ORB.init(args, null);
            //Instantiating the Servant   
            TimeOfDay t = new TimeOfDay_Tie(new TimeOfDayImpl(orb, "Athlone"));
            orb.connect(t);
            //Getting the object reference to the Name Service held in the ORB 
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            //Narrowing the object reference to point to the root of the name service 
            NamingContext rootCtx = NamingContextHelper.narrow(obj);
            //Creating a new name component that contains the object reference to the instantiated servant 
            NameComponent nc = new NameComponent("Time", "Object");
            NameComponent path[] = {nc};
            //Binding the name to an object that is stored in the Name Service 
            rootCtx.rebind(path, t);
            // wait for invocations from clients  
            orb.run();
        } catch (InvalidName | 
                NotFound | 
                CannotProceed | 
                org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }
    }

}
