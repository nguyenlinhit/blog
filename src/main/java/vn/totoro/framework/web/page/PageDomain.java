package vn.totoro.framework.web.page;

import lombok.Data;

/**
 * @author linh.nguyen
 * @version 1.0
 * @classname PageDomain
 * @description Paginated data
 * @date 12/10/2019
 */
@Data
public class PageDomain {
    /*Start index of current record*/
    private Integer pageNum;
    /*record per page*/
    private Integer pageSize;
    /*sorting*/
    private String orderByColumn;
    /*Sort direct "desc" or "asc"*/
    private String isAsc;

    public String getOrderBy(){
        //TODO implement code here
        return null;
    }
}
