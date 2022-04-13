package top.baskbull.monitortest.dependency.db;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/10 4:05 下午
 */
public class 数据库SQL总体查询量突增 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd change = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("数据库SQL总体查询量突增");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("dependency", "db"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("youzanyun");
        metricTemplate.setTriggerLevel("notice");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        qpm.setName("每分钟数据库查询平均QPM");
        qpm.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        qpm.setTargetTagName("appReporter");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(24000));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        change.setName("每分钟调用量变化");
        change.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        change.setTargetTagName("appReporter");
        change.setDetectionMethod("CHANGE");
        change.setComparisonStrategy("DAY_ON_DAY");
        change.setComparisonOperator("INCREASE_GT");
        change.setRightVal(200.0);
        change.setQueryValFormat(1);
        change.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, change));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
