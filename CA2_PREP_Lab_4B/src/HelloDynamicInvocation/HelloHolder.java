package HelloDynamicInvocation;

/**
* HelloDynamicInvocation/HelloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from HelloWorldDynamicInvocation.idl
* 11 March 2015 14:39:43 o'clock GMT
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public HelloDynamicInvocation.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (HelloDynamicInvocation.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HelloDynamicInvocation.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HelloDynamicInvocation.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HelloDynamicInvocation.HelloHelper.type ();
  }

}
