package common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validate {
    private static final String ID_KHACHHANG = "KH-[0-9]{4}";
    private static final String ID_NV = "NV-[0-9]{4}";
    private static final String ID_DICHVU = "DV-[0-9]{4}";
    private static final String SCMND = "[0-9]{12}|[0-9]{9}";
    private static final String SDT = "090[0-9]{7}|091[0-9]{7}|[(]84[)][+]90[0-9]{7}|[(]84[)][+]91[0-9]{7}";
    private static final String EMAIL = "[A-Za-z0-9]*[@]{1}[A-Za-z0-9]*[.]com";
    private static final String SOLUONG_SOTANG = "[1-9]*";
    private static final String TAM = "([1-9]{1}[0-9]*[.][0-9]*)|([1-9]{1}[0-9]*)";
    private static final String TEN = "^[A_Z][A-Za-z0-9]*";


    public static String validate_Socmnd(String value)
    {
        String message= null;
        if(!Pattern.matches( SCMND , value))
        {
            message ="vui lòng nhập đúng định dạng 9 hoặc 12 số";
        }
        else {
            message = null;
        }
        return message;
    }
    public static String validate_sdt(String value)
    {
        String message= null;
        if(!Pattern.matches( SDT , value))
        {
            message ="vui lòng nhập đúng định dạng só đt";
        }
        else {
            message = null;
        }
        return message;
    }
    public static String validate_email(String value)
    {
        String message= null;
        if(!Pattern.matches( EMAIL , value))
        {
            message ="vui lòng nhập đúng định dạng email";
        }
        else {
            message = null;
        }
        return message;
    }
    public static String validate_soluong(String value)
    {
        String message= null;
        if(!Pattern.matches( SOLUONG_SOTANG , value))
        {
            message ="vui lòng nhập đúng định dạng so tang";
        }
        else {
            message = null;
        }
        return message;
    }
    public static String ID_KHACHHANG(String value) {
        String message = null;
        if (!Pattern.matches(ID_NV, value)) {
            message = "vui lòng nhập đúng định dạng NV-XXXX";
        } else {
            message = null;
        }
        return message;
    }

    public static String validateID_NV(String value) {
        String message = null;
        if (!Pattern.matches(ID_NV, value)) {
            message = "vui lòng nhập đúng định dạng NV-XXXX";
        } else {
            message = null;
        }
        return message;
    }

}