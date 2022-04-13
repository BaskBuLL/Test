package top.baskbull.monitortest.biz.log;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/10 9:47 上午
 */
public class 云应用错误日志数突增 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failRate = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("云应用错误日志数突增");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("biz", "log"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("main");
        metricTemplate.setTriggerLevel("critical");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        qpm.setName("每分钟错误日志数");
        qpm.setQueryMql("lumberjack.log_montior{logAppReporter=\"{{ logAppReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        qpm.setTargetTagName("logAppReporter");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(50));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        failRate.setName("每分钟错误日志数同比昨天突增");
        failRate.setQueryMql("lumberjack.log_montior{logAppReporter=\"{{ logAppReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failRate.setTargetTagName("logAppReporter");
        failRate.setDetectionMethod("CHANGE");
        failRate.setComparisonStrategy("DAY_ON_DAY");
        failRate.setComparisonOperator("INCREASE_GT");
        failRate.setRightVal(Double.valueOf(100));
        failRate.setQueryValFormat(1);
        failRate.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, failRate));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
