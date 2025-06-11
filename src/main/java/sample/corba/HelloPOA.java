package sample.corba;


/**
* corba/HelloPOA.java .
* IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
* 2025�N6��10�� 2��28��05�b JST
*/


// package6x?
public abstract class HelloPOA extends org.omg.PortableServer.Servant
 implements sample.corba.HelloOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static final java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("sayHello", new Integer (0));
    _methods.put ("transmitSayHello", new Integer (1));
    _methods.put ("shutdown", new Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    Integer __method = (Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // corba/Hello/sayHello
       {
         sample.corba.HelloPackage.Argument arg = sample.corba.HelloPackage.ArgumentHelper.read (in);
         String $result = null;
         $result = this.sayHello (arg);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }


  // ]ag}]?]???
       case 1:  // corba/Hello/transmitSayHello
       {
         sample.corba.HelloPackage.Argument arg = sample.corba.HelloPackage.ArgumentHelper.read (in);
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
  private static final String[] __ids = {
    "IDL:corba/Hello:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return __ids.clone ();
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
