package corba;

/**
* corba/HelloHolder.java .
* IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
* 2025�N6��10�� 2��35��28�b JST
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
