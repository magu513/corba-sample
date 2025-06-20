package sample.model.corba;


/**
 * corba/HelloHelper.java .
 * IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
 * C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
 * 2025�N6��10�� 2��28��05�b JST
 */


// package6x?
abstract public class HelloHelper {
    private static final String _id = "IDL:corba/Hello:1.0";

    public static void insert(org.omg.CORBA.Any a, Hello that) {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static Hello extract(org.omg.CORBA.Any a) {
        return read(a.create_input_stream());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;

    synchronized public static org.omg.CORBA.TypeCode type() {
        if (__typeCode == null) {
            __typeCode = org.omg.CORBA.ORB.init().create_interface_tc(HelloHelper.id(), "Hello");
        }
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static Hello read(org.omg.CORBA.portable.InputStream istream) {
        return narrow(istream.read_Object(_HelloStub.class));
    }

    public static void write(org.omg.CORBA.portable.OutputStream ostream, Hello value) {
        ostream.write_Object(value);
    }

    public static Hello narrow(org.omg.CORBA.Object obj) {
        if (obj == null)
            return null;
        else if (obj instanceof Hello)
            return (Hello) obj;
        else if (!obj._is_a(id()))
            throw new org.omg.CORBA.BAD_PARAM();
        else {
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _HelloStub stub = new _HelloStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

    public static Hello unchecked_narrow(org.omg.CORBA.Object obj) {
        if (obj == null)
            return null;
        else if (obj instanceof Hello)
            return (Hello) obj;
        else {
            org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate();
            _HelloStub stub = new _HelloStub();
            stub._set_delegate(delegate);
            return stub;
        }
    }

}
