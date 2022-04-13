package top.baskbull;

import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liuzhuo
 * @date 2022/1/18 3:28 下午
 */

@Getter
public enum MetricTriggerLevelEnum implements Comparator<MetricTriggerLevelEnum> {


    notice("notice", "提醒", 0),
    warning("warning", "警告", 5),
    critical("critical", "危险", 10);

    private MetricTriggerLevelEnum(String name, String desc, Integer order){
        this.name = name;
        this.description = desc;
        this.order = order;
    }

    private String name;
    private String description;
    private Integer order;

    public static MetricTriggerLevelEnum ofType(String nm) {
        return Arrays.stream(values()).filter(x -> x.name.equals(nm)).findAny().orElse(null);
    }


    @Override
    public int compare(MetricTriggerLevelEnum o1, MetricTriggerLevelEnum o2) {
        return o1.order - o2.order;
    }
}
