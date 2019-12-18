package vn.totoro.common.utils.sql;

import vn.totoro.common.utils.StringUtils;

/**
 * @author linhnguyen
 * @version 1.0
 * @classname SqlUtil
 * @description Sql operation tool
 * @date 14/12/2019
 */
public class SqlUtil {
    /*Only letters, numbers, underscores, spaces, commas are supported (multi-field sorting is supported)*/
    public static String SQL_PATTERN = "[a-zA-Z0-9_\\\\ \\\\,]+";

    /**
     * Check characters to prevent injection bypass
     *
     * @param value
     * @return
     */
    public static String escapeOrderBySql(String value){
        if (StringUtils.isNotEmpty(value) && !isValidOrderBySql(value)){
            return StringUtils.EMPTY;
        }
        return value;
    }

    /**
     *
     *
     * @param value
     * @return
     */
    private static boolean isValidOrderBySql(String value) {
        return value.matches(SQL_PATTERN);
    }
}
