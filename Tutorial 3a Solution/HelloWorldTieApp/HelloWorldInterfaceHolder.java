package HelloWorldTieApp;

/**
* HelloWorldTieApp/HelloWorldInterfaceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HelloWorldTie.idl
* 09 February 2015 13:37:29 o'clock GMT
*/

public final class HelloWorldInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public HelloWorldTieApp.HelloWorldInterface value = null;

  public HelloWorldInterfaceHolder ()
  {
  }

  public HelloWorldInterfaceHolder (HelloWorldTieApp.HelloWorldInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HelloWorldTieApp.HelloWorldInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HelloWorldTieApp.HelloWorldInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HelloWorldTieApp.HelloWorldInterfaceHelper.type ();
  }

}
