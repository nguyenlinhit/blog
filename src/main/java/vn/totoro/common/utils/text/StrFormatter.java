package vn.totoro.common.utils.text;

import vn.totoro.common.utils.StringUtils;

/**
 * @author linhnguyen
 * @version 1.0
 * @classname StrFormatter
 * @description String formatting
 * @date 15/12/2019
 */
public class StrFormatter {
    public static final String EMPTY_JSON = "{}";
    public static final char C_BACKSLASH = '\\';
    public static final char C_DELIM_START = '{';
    public static final char C_DELIM_END = '}';

    /**
     * Format string<br>
     * This method simply replaces the placeholders {} with parameters in order<br>
     * If you want to output {} use \\ escape {, if you want to output \ before {} use double escape \\\\ <br>
     * Example: <br>
     * Usually : format ("this is {} for {}", "a", "b") --> this is a for b<br>
     * Escape {}: format("this is ]]{} for {}", "a", "b") --> this is \{} for a<br>
     * Escape \: format ("this is \\\\{} for {}", "a", "b") --> this is \a for b<br>
     *
     * @param strPattern String template
     * @param argArray   Parameter list
     * @return String
     */
    public static String format(final String strPattern, final Object... argArray){
        if (StringUtils.isEmpty(strPattern) || StringUtils.isEmpty(argArray)){
            return strPattern;
        }
        final int strPatterLength = strPattern.length();
        /*Initialize the defined length for better best performance*/
        StringBuilder strBuffer = new StringBuilder(strPatterLength + 50);
        int handledPosition = 0;
        /*Placeholder*/
        int delimIndex;
        for (int argIndex = 0; argIndex < argArray.length; argIndex++){
            delimIndex = strPattern.indexOf(EMPTY_JSON, handledPosition);
            if (delimIndex == -1){
                if (handledPosition == 0){
                    return strPattern;
                } else {
                    /*The rest of the string template no longer contains placeholders, the result is returned after adding the rest*/
                    strBuffer.append(strPattern, handledPosition, strPatterLength);
                    return strBuffer.toString();
                }
            } else {
                if (delimIndex > 0 && strPattern.charAt(delimIndex - 1) == C_BACKSLASH){
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - 2) == C_BACKSLASH){
                        /*There is an escape character before the escape character, the placeholder is still valid*/
                        strBuffer.append(strPattern, handledPosition, delimIndex - 1);
                        strBuffer.append(Converter.utf8Str(argArray[argIndex]));
                        handledPosition = delimIndex + 2;
                    } else {
                        /*Placeholders are escaped  */
                        argIndex--;
                        strBuffer.append(strPattern, handledPosition, delimIndex - 1);
                        strBuffer.append(C_DELIM_START);
                        handledPosition = delimIndex + 1;
                    }
                } else {
                    /*Normal placeholder*/
                    strBuffer.append(strPattern, handledPosition, delimIndex);
                    strBuffer.append(Converter.utf8Str(argArray[argIndex]));
                    handledPosition = delimIndex + 2;
                }
            }
        }
        /*append the characters following the last {} pair.*/
        /*All characters after the last placeholder*/
        strBuffer.append(strPattern, handledPosition, strPattern.length());

        return strBuffer.toString();
    }
}
