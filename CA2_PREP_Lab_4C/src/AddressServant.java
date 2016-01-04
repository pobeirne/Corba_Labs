
import java.util.*;
import AddressBookAny.*;
import org.omg.CORBA.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author paul
 */
public class AddressServant implements distAddrBkOperations {

    public static Hashtable hashtable;
    public static ORB orb;

    public AddressServant(org.omg.CORBA.ORB orb) {
        this.hashtable = new Hashtable();
        this.orb = orb;
    }

    @Override
    public void storePhoneBookDetails(AddressBookAny.AddressBook myAddressBook) {
        hashtable.put(myAddressBook.name, myAddressBook);
    }

    @Override
    public void getPhoneBookDetails(String name, org.omg.CORBA.AnyHolder myAddressBook) {

        Any anyAB = orb.create_any();
        try {
            AddressBook tempAddrBook = (AddressBook) hashtable.get(name);
            AddressBookHelper.insert(anyAB, tempAddrBook);
            myAddressBook.value = anyAB;
        } catch (Exception e) {
            System.err.println("Error E: " + e);
            e.printStackTrace(System.out);
        }
    }

}
