package HelloNaming;

/**
* HelloNaming/HelloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from C:/Users/I306184/Desktop/DS lab 3b/0_HelloNaming_LectureExample/HelloNaming.idl
* 18 February 2015 21:44:59 o'clock GMT
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public HelloNaming.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (HelloNaming.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = HelloNaming.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    HelloNaming.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return HelloNaming.HelloHelper.type ();
  }

}
