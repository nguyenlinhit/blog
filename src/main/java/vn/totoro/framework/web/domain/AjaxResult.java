package vn.totoro.framework.web.domain;

import java.util.HashMap;

/**
 * @author linh.nguyen
 * @description Operation message reminder
 * @date 2019/12/10
 * @version 1.0
 */
public class AjaxResult extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    /*Initialize a newly create message object*/
    public AjaxResult(){}

    /**
     *  Return message error
     *
     * @return Wrong information
     */
    public static AjaxResult error(){
        return error(500, "Operation Failed");
    }

    /**
     * Internal error message
     *
     * @param msg
     * @return Wrong information
     */
    public static AjaxResult error(String msg){
        return error(500, msg);
    }

    /**
     *  Custom error message
     *
     * @param code
     * @param msg
     * @return Wrong information
     */
    public static AjaxResult error(int code, String msg) {
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", code);
        return json;
    }

    /**
     * Return success message
     *
     * @return Success information
     */
    public static AjaxResult success(){
        return AjaxResult.success("Operation Success");
    }

    /**
     * Custom success message
     *
     * @param msg
     * @return Success information
     */
    public static AjaxResult success(String msg){
        AjaxResult json = new AjaxResult();
        json.put("msg", msg);
        json.put("code", 200);
        return json;
    }

    /**
     * Override put function
     *
     * @param key
     * @param value
     * @return AjaxResult
     */
    @Override
    public AjaxResult put(String key, Object value){
        super.put(key, value);
        return this;
    }
}
