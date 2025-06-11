package corba;

/**
* corba/HelloHolder.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idlから
* 2025年6月10日 2時35分28秒 JST
*/


// package6x?
public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public corba.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (corba.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = corba.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    corba.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return corba.HelloHelper.type ();
  }

}
