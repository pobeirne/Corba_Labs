package onLineBanking;


/**
* onLineBanking/onLineDetails.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OnLineBanking.idl
* 11 March 2015 20:55:17 o'clock GMT
*/

public final class onLineDetails implements org.omg.CORBA.portable.IDLEntity
{
  public String CustomerName = null;
  public String CustomerAddress = null;
  public String UniqueID = null;
  public int BankACNumber = (int)0;
  public int Balance = (int)0;

  public onLineDetails ()
  {
  } // ctor

  public onLineDetails (String _CustomerName, String _CustomerAddress, String _UniqueID, int _BankACNumber, int _Balance)
  {
    CustomerName = _CustomerName;
    CustomerAddress = _CustomerAddress;
    UniqueID = _UniqueID;
    BankACNumber = _BankACNumber;
    Balance = _Balance;
  } // ctor

} // class onLineDetails
