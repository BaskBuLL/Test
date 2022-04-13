package top.baskbull.monitortest.dependency.db;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/10 4:05 下午
 */
public class 单个SQL查询严重慢查 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd rt = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("单个SQL查询严重慢查");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("dependency", "db"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("youzanyun");
        metricTemplate.setTriggerLevel("critical");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(2);

        qpm.setName("SQL查询QPM");
        qpm.setQueryMql("sql.qpm_by_sqlId{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"sqlId\"], sum>");
        qpm.setTargetTagName("appReporter");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(180));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        rt.setName("SQL查询P75-RT");
        rt.setQueryMql("sql.centroid_by_sqlId{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, centroid<20>> | tag_aggr<[\"sqlId\"], quantile<[75]>>");
        rt.setTargetTagName("appReporter");
        rt.setDetectionMethod("THRESHOLD");
        rt.setComparisonOperator("GTE");
        rt.setRightVal(1500.0);
        rt.setQueryValFormat(0);
        rt.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, rt));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
