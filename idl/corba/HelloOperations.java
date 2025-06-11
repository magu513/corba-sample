package corba;


/**
* corba/HelloOperations.java .
* IDL-to-Javaコンパイラ(ポータブル)、バージョン"3.2"によって生成されました
* C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idlから
* 2025年6月10日 2時35分28秒 JST
*/


// package6x?
public interface HelloOperations 
{
  String sayHello (corba.HelloPackage.Argument arg);

  // ]ag}]?]???
  String transmitSayHello (corba.HelloPackage.Argument arg);
  void shutdown ();
} // interface HelloOperations
