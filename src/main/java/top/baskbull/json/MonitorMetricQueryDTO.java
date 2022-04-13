package top.baskbull.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuzhuo
 * @date 2022/1/11 3:48 下午
 */
@Data
public class MonitorMetricQueryDTO implements Serializable {

    private static final long serialVersionUID = -6714501096333150547L;

    private String name;

    private String rawQuery;

    /**
     * @see com.youzan.alert.adapter.api.model.enums.monitor.DetectionMethodEnum
     */
    private String detectionMethod;

    /**
     * @see com.youzan.alert.adapter.api.model.enums.monitor.ComparisonStrategyEnum
     */
    private String strategy;
}
