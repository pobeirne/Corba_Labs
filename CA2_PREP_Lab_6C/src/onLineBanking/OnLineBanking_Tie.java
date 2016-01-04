package onLineBanking;


/**
* onLineBanking/OnLineBanking_Tie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OnLineBanking.idl
* 11 March 2015 20:55:17 o'clock GMT
*/

public class OnLineBanking_Tie extends _OnLineBankingImplBase
{

  // Constructors
  public OnLineBanking_Tie ()
  {
  }

  public OnLineBanking_Tie (onLineBanking.OnLineBankingOperations impl)
  {
    super ();
    _impl = impl;
  }

  public void registerOnLineBanking (org.omg.CORBA.Any anyOnLineDetails, org.omg.CORBA.StringHolder password)
  {
    _impl.registerOnLineBanking(anyOnLineDetails, password);
  } // registerOnLineBanking

  public void performOnLineTransaction (String UniqueID, int amount, org.omg.CORBA.AnyHolder anyOnLineDetails)
  {
    _impl.performOnLineTransaction(UniqueID, amount, anyOnLineDetails);
  } // performOnLineTransaction

  public onLineBanking.onLineDetails getAccountInfo (String UniqueID)
  {
    return _impl.getAccountInfo(UniqueID);
  } // getAccountInfo

  private onLineBanking.OnLineBankingOperations _impl;

} // class OnLineBanking_Tie