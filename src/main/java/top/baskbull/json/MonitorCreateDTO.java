package top.baskbull.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhuo
 * @date 2022/1/11 12:10 下午
 */
@Data
public class MonitorCreateDTO implements Serializable {

    private static final long serialVersionUID = 7929446449834008433L;

    /**
     * 监控项触发器
     */
    private MonitorNoticeTriggerDTO noticeTrigger;

    /**
     * 监控名称
     */
    private String name;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 所属应用
     */
    private String owningApp;

    /**
     * 监控项详细描述 非必选
     */
    private String description;

    /**
     * metric
     */
    private List<MonitorMetricQueryDTO> metricQueries;

    /**
     * 检测窗口
     */
    private MonitorEvaluationWindowDTO evaluationWindow;

    private String combinatorialLogic;

    private MonitorNotifySettingsRequestDTO notifyingSettings;
}
