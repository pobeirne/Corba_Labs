package onLineBanking;


/**
* onLineBanking/_OnLineBankingImplBase.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from OnLineBanking.idl
* 11 March 2015 20:55:17 o'clock GMT
*/

public abstract class _OnLineBankingImplBase extends org.omg.CORBA.portable.ObjectImpl
                implements onLineBanking.OnLineBanking, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors
  public _OnLineBankingImplBase ()
  {
  }

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("registerOnLineBanking", new java.lang.Integer (0));
    _methods.put ("performOnLineTransaction", new java.lang.Integer (1));
    _methods.put ("getAccountInfo", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // onLineBanking/OnLineBanking/registerOnLineBanking
       {
         org.omg.CORBA.Any anyOnLineDetails = in.read_any ();
         org.omg.CORBA.StringHolder password = new org.omg.CORBA.StringHolder ();
         this.registerOnLineBanking (anyOnLineDetails, password);
         out = $rh.createReply();
         out.write_string (password.value);
         break;
       }

       case 1:  // onLineBanking/OnLineBanking/performOnLineTransaction
       {
         String UniqueID = in.read_string ();
         int amount = in.read_long ();
         org.omg.CORBA.AnyHolder anyOnLineDetails = new org.omg.CORBA.AnyHolder ();
         this.performOnLineTransaction (UniqueID, amount, anyOnLineDetails);
         out = $rh.createReply();
         out.write_any (anyOnLineDetails.value);
         break;
       }

       case 2:  // onLineBanking/OnLineBanking/getAccountInfo
       {
         String UniqueID = in.read_string ();
         onLineBanking.onLineDetails $result = null;
         $result = this.getAccountInfo (UniqueID);
         out = $rh.createReply();
         onLineBanking.onLineDetailsHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:onLineBanking/OnLineBanking:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }


} // class _OnLineBankingImplBase
