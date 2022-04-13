package top.baskbull.monitortest.dependency.db;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/10 4:05 下午
 */
public class 数据库总体查询较慢 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd rt = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("数据库总体查询较慢");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("dependency", "db"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("youzanyun");
        metricTemplate.setTriggerLevel("warning");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        qpm.setName("每分钟数据库查询平均QPM");
        qpm.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        qpm.setTargetTagName("appReporter");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(3000));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        rt.setName("每分钟数据库执行P50-RT");
        rt.setQueryMql("sql.rt_centroid_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, centroid<20>> | tag_aggr<[], quantile<[50]>>");
        rt.setTargetTagName("appReporter");
        rt.setDetectionMethod("THRESHOLD");
        rt.setComparisonOperator("GTE");
        rt.setRightVal(300.0);
        rt.setQueryValFormat(0);
        rt.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, rt));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
