package vn.totoro.framework.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import vn.totoro.common.utils.DateUtils;
import vn.totoro.common.utils.StringUtils;
import vn.totoro.common.utils.sql.SqlUtil;
import vn.totoro.framework.web.domain.AjaxResult;
import vn.totoro.framework.web.page.PageDomain;
import vn.totoro.framework.web.page.TableDataInfo;
import vn.totoro.framework.web.page.TableSupport;

import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.List;

/**
 * @author linhnguyen
 * @version 1.0
 * @classname BaseController
 * @description Web layer general data processing
 * @date 13/12/2019
 */
public class BaseController {
    /**
     * The format string passed from the foreground is automatically
     * converted to the Date type .
     *
     * @param binder date
     */
    @InitBinder
    public void initBinder(WebDataBinder binder){
        /*Date time conversion*/
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport(){
            @Override
            public void setAsText(String s) throws IllegalArgumentException {
                setValue(DateUtils.parseDate(s));
            }
        });
    }

    /**
     * Set request paging data
     */
    protected void startPage(){
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();

        if (StringUtils.isNotNull(pageNum) || StringUtils.isNotNull(pageSize)){
            String orderBy = SqlUtil.escapeOrderBySql(pageDomain.getOrderBy());
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * Paging data in response to a request
     *
     * @param list data
     * @return TableDataInfo
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected TableDataInfo getDataTable(List<?> list){
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(0);
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    /**
     *  Response returns results
     *
     * @param rows
     * @return
     */
    protected AjaxResult toAjax(int rows){
        return rows > 0 ? success() : error();
    }

    /**
     *
     * @return default error
     */
    private AjaxResult error() {
        return AjaxResult.error();
    }

    /**
     *
     * @return default success
     */
    private AjaxResult success() {
        return AjaxResult.success();
    }

    /**
     * Custom message success
     *
     * @param msg message
     * @return String
     */
    private AjaxResult success(String msg){
        return AjaxResult.success(msg);
    }

    /**
     * Custom message error
     *
     * @param msg message
     * @return AjaxResult
     */
    private AjaxResult error(String msg){
        return AjaxResult.error(msg);
    }

    /**
     * Page jump
     *
     * @param url redirect
     * @return String
     */
    private String redirect(String url){
        return StringUtils.format("redirect{}", url);
    }
}
