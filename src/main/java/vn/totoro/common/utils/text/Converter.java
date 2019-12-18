package vn.totoro.common.utils.text;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * @author linhnguyen
 * @version 1.0
 * @classname Converter
 * @description Type converter
 * @date 15/12/2019
 */
public class Converter {
    /**
     *
     * @param obj Object
     * @return String
     */
    public static String utf8Str(Object obj){
        return str(obj, CharsetKit.CHARSET_UTF_8);
    }

    /**
     * Convert Object to String<br>
     * Byte Array and ByteBuffer will be converted into array of corresponding strings 2, the object array will call the Arrays.toString method
     *
     *
     * @param obj Object
     * @param charset Character set
     * @return String
     */
    private static String str(Object obj, Charset charset) {
        if (null == obj){
            return null;
        }

        if (obj instanceof String){
            return (String) obj;
        } else if (obj instanceof byte[] || obj instanceof Byte[]){
            return str(obj, charset);
        } else if (obj instanceof ByteBuffer){
            return str(obj, charset);
        }

        return obj.toString();
    }
}
