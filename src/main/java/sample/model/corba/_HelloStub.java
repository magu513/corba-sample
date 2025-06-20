package sample.model.corba;


/**
 * corba/_HelloStub.java .
 * IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
 * C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
 * 2025�N6��10�� 2��28��05�b JST
 */


// package6x?
public class _HelloStub extends org.omg.CORBA.portable.ObjectImpl implements Hello {

    public String sayHello(sample.model.corba.HelloPackage.Argument arg) {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("sayHello", true);
            sample.model.corba.HelloPackage.ArgumentHelper.write($out, arg);
            $in = _invoke($out);
            String $result = $in.read_string();
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return sayHello(arg);
        } finally {
            _releaseReply($in);
        }
    } // sayHello


    // ]ag}]?]???
    public String transmitSayHello(sample.model.corba.HelloPackage.Argument arg) {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("transmitSayHello", true);
            sample.model.corba.HelloPackage.ArgumentHelper.write($out, arg);
            $in = _invoke($out);
            String $result = $in.read_string();
            return $result;
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            return transmitSayHello(arg);
        } finally {
            _releaseReply($in);
        }
    } // transmitSayHello

    public void shutdown() {
        org.omg.CORBA.portable.InputStream $in = null;
        try {
            org.omg.CORBA.portable.OutputStream $out = _request("shutdown", false);
            $in = _invoke($out);
        } catch (org.omg.CORBA.portable.ApplicationException $ex) {
            $in = $ex.getInputStream();
            String _id = $ex.getId();
            throw new org.omg.CORBA.MARSHAL(_id);
        } catch (org.omg.CORBA.portable.RemarshalException $rm) {
            shutdown();
        } finally {
            _releaseReply($in);
        }
    } // shutdown

    // Type-specific CORBA::Object operations
    private static final String[] __ids = {
            "IDL:corba/Hello:1.0"};

    public String[] _ids() {
        return __ids.clone();
    }

    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException {
        String str = s.readUTF();
        com.sun.corba.se.impl.orbutil.IORCheckImpl.check(str, "sample.model.corba._HelloStub");
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try {
            org.omg.CORBA.Object obj = orb.string_to_object(str);
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _set_delegate(delegate);
        } finally {
            orb.destroy();
        }
    }

    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        String[] args = null;
        java.util.Properties props = null;
        org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, props);
        try {
            String str = orb.object_to_string(this);
            s.writeUTF(str);
        } finally {
            orb.destroy();
        }
    }
} // class _HelloStub
