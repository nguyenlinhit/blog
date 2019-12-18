package vn.totoro.common.utils;

import vn.totoro.common.utils.text.StrFormatter;

import java.util.Collection;

/**
 * @author linhnguyen
 * @version 1.0
 * @classname StringUtils
 * @description String utility
 * @date 14/12/2019
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils {
    /*Empty string*/
    private static final String NULLSTR = "";
    /*Underline*/
    private static final char SEPARATOR = '_';

    /**
     * NVL function
     *
     * @param value
     * @param defaultValue
     * @param <T>
     * @return T
     */
    public static <T> T nvl(T value, T defaultValue){
        return value != null ? value : defaultValue;
    }

    /**
     * isEmpty function for collections
     *
     * @param collections
     * @return
     */
    public static boolean isEmpty(Collection<?> collections){
        return isNull(collections) || collections.isEmpty();
    }

    /**
     * check object is null
     *
     * @param obj
     * @return boolean
     */
    public static boolean isNull(Object obj){
        return obj == null;
    }

    /**
     * isNotNull function
     *
     * @param obj
     * @return boolean
     */
    public static boolean isNotNull(Object obj){
        return !isNull(obj);
    }

    /**
     * isNotEmpty function
     *
     * @param collections
     * @return boolean
     */
    public static boolean isNotEmpty(Collection<?> collections){
        return !isEmpty(collections);
    }

    /**
     * Formatted text, {} stands for placeholder <br>
     * The method simply replaces the placeholder {} with parameters in order <br>
     * If you want to output {}, use \\ escaped {, if you want to output \ before {}, use double escape character \\\\. <br>
     * Example: <br>
     * Usually : format ("this is {} for {}", "a", "b") --> this is a for b<br>
     * Escape {}: format("this is ]]{} for {}", "a", "b") --> this is \{} for a<br>
     * Escape \: format ("this is \\\\{} for {}", "a", "b") --> this is \a for b<br>
     *
     * @param template Text template, replaced parts are represented by {}
     * @param params   Parameter value
     * @return String
     */
    public static String format(String template, Object... params){
        if (isEmpty(params) || isEmpty(template)){
            return template;
        }
        return StrFormatter.format(template, params);
    }

    /**
     * isEmpty function (Object)
     *
     * @param obj
     * @return boolean
     */
    public static boolean isEmpty(Object[] obj) {
        return isNull(obj) || obj.length == 0;
    }
}
