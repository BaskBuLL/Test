package top.baskbull;

import lombok.Data;

/**
 * @author liuzhuo
 * @date 2022/2/16 10:05 上午
 */
@Data
public class MetricQueryTemplateSaveCmd {

    private String name;

    private String queryMql;

    private String targetTagName;

    private String detectionMethod;

    private String comparisonStrategy;

    private String comparisonOperator;

    /**
     * INT_NUMBER(0, "整数值"),
     * PERCENT(1, "百分比"),
     * FLOAT_NUMBER(2, "浮点数");
     */
    private Integer queryValFormat;

    /**
     * BIGGER(0, "取相对大值"),
     * SMALLER(1, "取相对小值"),
     * ABSOLUTE_BIGGER(2, "取绝对值相对大值"),
     * ABSOLUTE_SMALLER(3, "取绝对值相对小值");
     */
    private Integer queryValCompareStrategy;

    private Double leftVal;

    private Double rightVal;
}
