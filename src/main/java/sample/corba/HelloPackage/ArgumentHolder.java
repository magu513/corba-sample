package sample.corba.HelloPackage;

/**
* corba/HelloPackage/ArgumentHolder.java .
* IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
* 2025�N6��9�� 16��55��06�b JST
*/

public final class ArgumentHolder implements org.omg.CORBA.portable.Streamable
{
  public sample.corba.HelloPackage.Argument value = null;

  public ArgumentHolder ()
  {
  }

  public ArgumentHolder (sample.corba.HelloPackage.Argument initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = sample.corba.HelloPackage.ArgumentHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    sample.corba.HelloPackage.ArgumentHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return sample.corba.HelloPackage.ArgumentHelper.type ();
  }

}
