package sample.corba.HelloPackage;


/**
* corba/HelloPackage/Argument.java .
* IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
* 2025�N6��9�� 16��55��06�b JST
*/

public final class Argument implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;

  public Argument ()
  {
  } // ctor

  public Argument (String _name)
  {
    name = _name;
  } // ctor

} // class Argument
