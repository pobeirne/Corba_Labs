import AddressBookAny.*;
import java.io.*;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

/**
 *
 * @author paul
 */
public class disABClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            org.omg.CORBA.ORB orb = ORB.init(args, null);

            //Retrieve Distributed Address Book Object reference from the NameService
            org.omg.CORBA.Object nameObj = orb.resolve_initial_references("NameService");
            NamingContext rootCtx = NamingContextHelper.narrow(nameObj);
            NameComponent[] name = new NameComponent[1];
            name[0] = new NameComponent("AddressBook", "Object");
            org.omg.CORBA.Object obj = rootCtx.resolve(name);
            distAddrBk distABref = distAddrBkHelper.narrow(obj);

            AddressBook myAddressBook = new AddressBook();
            AnyHolder anyHolderAB = new AnyHolder();
            String tempName;
            int menuChoice;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            do {
                System.out.println("Please enter desired menu option");
                System.out.println("1 Store phonebook details");
                System.out.println("2 Retrieve phonebook details");
                System.out.println("3 Quit");
                menuChoice = Integer.parseInt(reader.readLine());

                switch (menuChoice) {
                    case 1: {
                        System.out.println("Please enter a name : ");
                        myAddressBook.name = reader.readLine();
                        System.out.println("Please enter an address : ");
                        myAddressBook.address = reader.readLine();
                        System.out.println("Please enter a phone number : ");
                        myAddressBook.phone = reader.readLine();
                        System.out.println("Please enter an email address : ");
                        myAddressBook.email = reader.readLine();
                        distABref.storePhoneBookDetails(myAddressBook);
                        continue;
                    }// End case 1
                    case 2: {
                        System.out.println("Please enter the name of a person that you wish to retrieve the details on : ");
                        tempName = reader.readLine();
                        distABref.getPhoneBookDetails(tempName, anyHolderAB);
                        AddressBook tempAddrBook = new AddressBook();
                        tempAddrBook = AddressBookHelper.extract(anyHolderAB.value);

                        //Check TypeCode
                        TypeCode tcAddressBook = anyHolderAB.value.type();
                        if (AddressBookHelper.type().equal(tcAddressBook)) {
                            System.out.println("Name : " + tempAddrBook.name);
                            System.out.println("Addr : " + tempAddrBook.address);
                            System.out.println("Phone : " + tempAddrBook.phone);
                            System.out.println("email : " + tempAddrBook.email);
                        } else {
                            System.out.println("Wrong Type returned");
                        }
                    }//End case 2//End case 2

                }// End switch

            } while (menuChoice != 3);

        } catch (InvalidName 
                | NotFound 
                | CannotProceed 
                | org.omg.CosNaming.NamingContextPackage.InvalidName 
                | IOException 
                | NumberFormatException e) {
            System.err.println("Error E: " + e);
            e.printStackTrace(System.out);
        }
    }
}
