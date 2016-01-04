import AddressBookAny.*;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author paul
 */
public class disABServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            org.omg.CORBA.ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object nameObj = orb.resolve_initial_references("NameService");

            NamingContext rootCtx = NamingContextHelper.narrow(nameObj);
            NameComponent[] name = new NameComponent[1];
            name[0] = new NameComponent("AddressBook", "Object");

            distAddrBk servant = new distAddrBk_Tie(new AddressServant(orb));
            rootCtx.rebind(name, servant);

            orb.run();

        } catch (InvalidName 
                | NotFound 
                | CannotProceed 
                | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            System.err.println("Error E: " + e);
            e.printStackTrace(System.out);
        }
    }
}
