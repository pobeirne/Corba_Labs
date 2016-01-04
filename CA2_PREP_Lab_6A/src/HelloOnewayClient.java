
import java.io.*;
import org.omg.CORBA.*;
import HelloOneway.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class HelloOnewayClient {

    public static void main(String args[]) {
        try {
            // create and initialize the ORB
            ORB orb = ORB.init(args, null);

            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContext rootCtx = NamingContextHelper.narrow(objRef);
            NameComponent nc = new NameComponent("Hello", "");
            NameComponent path[] = {nc};
            Hello helloRef = HelloHelper.narrow(rootCtx.resolve(path));

            BufferedReader b_in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter a number representing who you want to say hello to");
            System.out.println("(eg 1 . World; 2. Ireland; 3. Dublin");
            int audience = (Integer.valueOf(b_in.readLine())).shortValue();
            b_in.close();
            
            //create Request object
            Request request = helloRef._request("sayHello");
            Any arg = request.add_in_arg(); 
            //add an argument to the Request object
            arg.insert_long(audience);
            //Invoking a one way request
            request.send_oneway();

            for (int x = 1; x <= 10000; x++) {
                System.out.println("Control returned to client");
            }

        } catch (InvalidName 
                | NotFound 
                | CannotProceed 
                | org.omg.CosNaming.NamingContextPackage.InvalidName 
                | IOException 
                | NumberFormatException e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }

    }
}
