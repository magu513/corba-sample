package corba;


/**
* corba/HelloOperations.java .
* IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
* 2025�N6��10�� 2��35��28�b JST
*/


// package6x?
public interface HelloOperations 
{
  String sayHello (corba.HelloPackage.Argument arg);

  // ]ag}]?]???
  String transmitSayHello (corba.HelloPackage.Argument arg);
  void shutdown ();
} // interface HelloOperations
