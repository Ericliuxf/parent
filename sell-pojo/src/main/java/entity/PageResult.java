package entity;

import com.synjones.pojo.TbBrand;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: eric
 * @Description:
 * @Date: 2018/9/12 12:46
 */
@Data
public class PageResult implements Serializable {
    private long total;
    private List rows;

    public PageResult() {
    }

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
