package corba.HelloPackage;

/**
* corba/HelloPackage/ArgumentHolder.java .
* IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
* 2025�N6��10�� 2��35��28�b JST
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
