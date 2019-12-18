package vn.totoro.framework.web.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @author linh.nguyen
 * @description Entity base class
 * @date 2019/12/10
 * @version 1.0
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /*Search value*/
    private String searchValue;
    /*Created by*/
    private String createBy;
    /*Created time */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /*Updated by*/
    private String updateBy;
    /*Update time*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /*Remark*/
    private String remark;
    /*Requested params*/
    private Map<String, Object> params;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Map<String, Object> getParams() {
        if (params == null){
            params = Maps.newHashMap();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }
}
