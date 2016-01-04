package AddressBookAny;


/**
* AddressBookAny/_distAddrBkStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from AB.idl
* 11 March 2015 14:48:56 o'clock GMT
*/

public class _distAddrBkStub extends org.omg.CORBA.portable.ObjectImpl implements AddressBookAny.distAddrBk
{

  public void storePhoneBookDetails (AddressBookAny.AddressBook myAddressBook)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("storePhoneBookDetails", true);
                AddressBookAny.AddressBookHelper.write ($out, myAddressBook);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                storePhoneBookDetails (myAddressBook        );
            } finally {
                _releaseReply ($in);
            }
  } // storePhoneBookDetails

  public void getPhoneBookDetails (String name, org.omg.CORBA.AnyHolder myAddressBook)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getPhoneBookDetails", true);
                $out.write_string (name);
                $in = _invoke ($out);
                myAddressBook.value = $in.read_any ();
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                getPhoneBookDetails (name, myAddressBook        );
            } finally {
                _releaseReply ($in);
            }
  } // getPhoneBookDetails

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:AddressBookAny/distAddrBk:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _distAddrBkStub