package sample.corba;

/**
* corba/HelloHolder.java .
* IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
* 2025�N6��10�� 2��28��05�b JST
*/


// package6x?
public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public sample.corba.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (sample.corba.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sample.corba.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sample.corba.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sample.corba.HelloHelper.type ();
  }

}
