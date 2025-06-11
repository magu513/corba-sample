package corba;


/**
* corba/HelloPOA.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idlから
* 2025年6月10日 2時35分28秒 JST
*/


// package6x?
public abstract class HelloPOA extends org.omg.PortableServer.Servant
 implements corba.HelloOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sayHello", new java.lang.Integer (0));
    _methods.put ("transmitSayHello", new java.lang.Integer (1));
    _methods.put ("shutdown", new java.lang.Integer (2));
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
       case 0:  // corba/Hello/sayHello
       {
         corba.HelloPackage.Argument arg = corba.HelloPackage.ArgumentHelper.read (in);
         String $result = null;
         $result = this.sayHello (arg);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }


  // ]ag}]?]???
       case 1:  // corba/Hello/transmitSayHello
       {
         corba.HelloPackage.Argument arg = corba.HelloPackage.ArgumentHelper.read (in);
         String $result = null;
         $result = this.transmitSayHello (arg);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // corba/Hello/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:corba/Hello:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Hello _this() 
  {
    return HelloHelper.narrow(
    super._this_object());
  }

  public Hello _this(org.omg.CORBA.ORB orb) 
  {
    return HelloHelper.narrow(
    super._this_object(orb));
  }


} // class HelloPOA
