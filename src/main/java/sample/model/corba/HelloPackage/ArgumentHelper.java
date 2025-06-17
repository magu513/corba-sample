package sample.model.corba.HelloPackage;


/**
 * corba/HelloPackage/ArgumentHelper.java .
 * IDL-to-Java�R���p�C��(�|�[�^�u��)�A�o�[�W����"3.2"�ɂ���Đ�������܂���
 * C:/Users/ryuda/IdeaProjects/corba-sample/idl/corba_sample.idl����
 * 2025�N6��9�� 16��55��06�b JST
 */

abstract public class ArgumentHelper {
    private static final String _id = "IDL:corba/Hello/Argument:1.0";

    public static void insert(org.omg.CORBA.Any a, sample.model.corba.HelloPackage.Argument that) {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream();
        a.type(type());
        write(out, that);
        a.read_value(out.create_input_stream(), type());
    }

    public static sample.model.corba.HelloPackage.Argument extract(org.omg.CORBA.Any a) {
        return read(a.create_input_stream());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;
    private static boolean __active = false;

    synchronized public static org.omg.CORBA.TypeCode type() {
        if (__typeCode == null) {
            synchronized (org.omg.CORBA.TypeCode.class) {
                if (__typeCode == null) {
                    if (__active) {
                        return org.omg.CORBA.ORB.init().create_recursive_tc(_id);
                    }
                    __active = true;
                    org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember[1];
                    org.omg.CORBA.TypeCode _tcOf_members0 = null;
                    _tcOf_members0 = org.omg.CORBA.ORB.init().create_string_tc(0);
                    _members0[0] = new org.omg.CORBA.StructMember(
                            "name",
                            _tcOf_members0,
                            null);
                    __typeCode = org.omg.CORBA.ORB.init().create_struct_tc(sample.model.corba.HelloPackage.ArgumentHelper.id(), "Argument", _members0);
                    __active = false;
                }
            }
        }
        return __typeCode;
    }

    public static String id() {
        return _id;
    }

    public static sample.model.corba.HelloPackage.Argument read(org.omg.CORBA.portable.InputStream istream) {
        sample.model.corba.HelloPackage.Argument value = new sample.model.corba.HelloPackage.Argument();
        value.name = istream.read_string();
        return value;
    }

    public static void write(org.omg.CORBA.portable.OutputStream ostream, sample.model.corba.HelloPackage.Argument value) {
        ostream.write_string(value.name);
    }

}
