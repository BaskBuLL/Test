package top.baskbull.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuzhuo
 * @date 2022/1/11 3:59 下午
 * 检测窗口
 */
@Data
public class MonitorEvaluationWindowDTO implements Serializable {

    private static final long serialVersionUID = -4569664632896874439L;

    private Integer len;

    private String unit;
}
