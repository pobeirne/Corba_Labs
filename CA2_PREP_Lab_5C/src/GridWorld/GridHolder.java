package GridWorld;

/**
* GridWorld/GridHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from grid.idl
* 11 March 2015 21:23:05 o'clock GMT
*/

public final class GridHolder implements org.omg.CORBA.portable.Streamable
{
  public GridWorld.Grid value = null;

  public GridHolder ()
  {
  }

  public GridHolder (GridWorld.Grid initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = GridWorld.GridHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    GridWorld.GridHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return GridWorld.GridHelper.type ();
  }

}