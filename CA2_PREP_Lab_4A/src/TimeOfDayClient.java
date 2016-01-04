
import AnyExample.*;
import org.omg.CORBA.Any;
import org.omg.CORBA.AnyHolder;
import org.omg.CORBA.BAD_OPERATION;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.TypeCodePackage.BadKind;
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
public class TimeOfDayClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            ORB orb = ORB.init(args, null);
            //Obtaining the object reference to the Name Service  
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            //Narrowing the object reference of the Name Service to the correct Type  
            NamingContext rootCtx = NamingContextHelper.narrow(objRef);
            //Creating a name of the desired object that we want to get the object reference of, from the name server  
            NameComponent nc = new NameComponent("Time", "Object");
            NameComponent[] path = {nc};
            org.omg.CORBA.Object objRefTime = rootCtx.resolve(path);
            //Converting the retireved object reference from the Name Service to the correct type  
            TimeOfDay todRef = TimeOfDayHelper.narrow(objRefTime);

            //Creating an any holder that will hold the out parameter from the hello operation call   
            AnyHolder anyTimeHolder = new AnyHolder();
            //Creating an any that will hold the return information from the hello operation call  
            Any anyLocation;

            anyLocation = todRef.hello(anyTimeHolder);
            //Demonstrating some typecode operations  
            TypeCode tc;
            tc = anyTimeHolder.value.type();

           //Comparing the types of the returned Any from the operation call hello 
            //with the expected type as described in the HelloHelper class  
            tc = anyLocation.type();

            if (tc.kind() == TCKind.tk_string) {
                System.out.println("Length of anyLocation is " + tc.length());
            } else {
                System.out.println("Not of type string");
            }

            String location = anyLocation.extract_string();
            System.out.println("Location is " + location);

            Time t = TimeHelper.extract(anyTimeHolder.value);
            System.out.println("Time is " + t.hour + ":" + t.minute);
        } catch (InvalidName 
                | NotFound 
                | CannotProceed
                | org.omg.CosNaming.NamingContextPackage.InvalidName 
                | BadKind | BAD_OPERATION e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }

}
