package vn.totoro.framework.web.page;

import java.io.Serializable;
import java.util.List;

/**
 * @author linh.nguyen
 * @description Table paging data object
 * @date 2019/12/10
 * @version 1.0
 */
public class TableDataInfo implements Serializable {
    /*Total*/
    private long total;
    /*List data*/
    private List<?> rows;
    /*Message status code*/
    private int code;

    public TableDataInfo() {}

    public TableDataInfo(List<?> list, int total){
        this.rows = list;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
