package HelloWorldTieApp;


/**
* HelloWorldTieApp/HelloWorldInterfaceHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HelloWorldTie.idl
* 09 February 2015 13:37:29 o'clock GMT
*/

abstract public class HelloWorldInterfaceHelper
{
  private static String  _id = "IDL:HelloWorldTieApp/HelloWorldInterface:1.0";

  public static void insert (org.omg.CORBA.Any a, HelloWorldTieApp.HelloWorldInterface that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HelloWorldTieApp.HelloWorldInterface extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (HelloWorldTieApp.HelloWorldInterfaceHelper.id (), "HelloWorldInterface");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HelloWorldTieApp.HelloWorldInterface read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloWorldInterfaceStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HelloWorldTieApp.HelloWorldInterface value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static HelloWorldTieApp.HelloWorldInterface narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloWorldTieApp.HelloWorldInterface)
      return (HelloWorldTieApp.HelloWorldInterface)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HelloWorldTieApp._HelloWorldInterfaceStub stub = new HelloWorldTieApp._HelloWorldInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static HelloWorldTieApp.HelloWorldInterface unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloWorldTieApp.HelloWorldInterface)
      return (HelloWorldTieApp.HelloWorldInterface)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HelloWorldTieApp._HelloWorldInterfaceStub stub = new HelloWorldTieApp._HelloWorldInterfaceStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
