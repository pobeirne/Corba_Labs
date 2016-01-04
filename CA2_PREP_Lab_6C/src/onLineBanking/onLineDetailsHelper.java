package onLineBanking;


/**
* onLineBanking/onLineDetailsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OnLineBanking.idl
* 11 March 2015 20:55:17 o'clock GMT
*/

abstract public class onLineDetailsHelper
{
  private static String  _id = "IDL:onLineBanking/onLineDetails:1.0";

  public static void insert (org.omg.CORBA.Any a, onLineBanking.onLineDetails that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static onLineBanking.onLineDetails extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [5];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "CustomerName",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "CustomerAddress",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[2] = new org.omg.CORBA.StructMember (
            "UniqueID",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[3] = new org.omg.CORBA.StructMember (
            "BankACNumber",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[4] = new org.omg.CORBA.StructMember (
            "Balance",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (onLineBanking.onLineDetailsHelper.id (), "onLineDetails", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static onLineBanking.onLineDetails read (org.omg.CORBA.portable.InputStream istream)
  {
    onLineBanking.onLineDetails value = new onLineBanking.onLineDetails ();
    value.CustomerName = istream.read_string ();
    value.CustomerAddress = istream.read_string ();
    value.UniqueID = istream.read_string ();
    value.BankACNumber = istream.read_long ();
    value.Balance = istream.read_long ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, onLineBanking.onLineDetails value)
  {
    ostream.write_string (value.CustomerName);
    ostream.write_string (value.CustomerAddress);
    ostream.write_string (value.UniqueID);
    ostream.write_long (value.BankACNumber);
    ostream.write_long (value.Balance);
  }

}
