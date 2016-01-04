package HelloNaming;


/**
* HelloNaming/HelloHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HelloWorldName.idl
* 26 February 2015 09:14:27 o'clock GMT
*/

abstract public class HelloHelper
{
  private static String  _id = "IDL:HelloNaming/Hello:1.0";

  public static void insert (org.omg.CORBA.Any a, HelloNaming.Hello that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static HelloNaming.Hello extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (HelloNaming.HelloHelper.id (), "Hello");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static HelloNaming.Hello read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_HelloStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, HelloNaming.Hello value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static HelloNaming.Hello narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloNaming.Hello)
      return (HelloNaming.Hello)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HelloNaming._HelloStub stub = new HelloNaming._HelloStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static HelloNaming.Hello unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof HelloNaming.Hello)
      return (HelloNaming.Hello)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      HelloNaming._HelloStub stub = new HelloNaming._HelloStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
