package corba.HelloPackage;

/**
* corba/HelloPackage/ArgumentHolder.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idlから
* 2025年6月10日 2時35分28秒 JST
*/

public final class ArgumentHolder implements org.omg.CORBA.portable.Streamable
{
  public corba.HelloPackage.Argument value = null;

  public ArgumentHolder ()
  {
  }

  public ArgumentHolder (corba.HelloPackage.Argument initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corba.HelloPackage.ArgumentHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corba.HelloPackage.ArgumentHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corba.HelloPackage.ArgumentHelper.type ();
  }

}
