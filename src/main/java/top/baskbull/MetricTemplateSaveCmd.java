package top.baskbull;

import lombok.Data;

import java.util.List;

@Data
public class MetricTemplateSaveCmd {

    private String name;

    private List<Integer> supportTypes;

    private List<String> tags;

    private String combinatorialLogic;

    private String bu;

    private String triggerLevel;

    private Integer period;

    private String timeUnit;

    private Integer continuousCount;

    private List<MetricQueryTemplateSaveCmd> queryTemplateList;
}
