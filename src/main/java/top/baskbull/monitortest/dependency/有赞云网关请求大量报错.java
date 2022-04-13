package top.baskbull.monitortest.dependency;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/22 11:41 上午
 */
public class 有赞云网关请求大量报错 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failRate = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("有赞云网关请求大量报错");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("dependency", "opensdk"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("youzanyun");
        metricTemplate.setTriggerLevel("critical");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        failRate.setName("每分钟网关请求QPM");
        failRate.setQueryMql("cloud-open-sdk.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failRate.setTargetTagName("appReporter");
        failRate.setDetectionMethod("THRESHOLD");
        failRate.setComparisonOperator("GTE");
        failRate.setRightVal(10.0);
        failRate.setQueryValFormat(0);
        failRate.setQueryValCompareStrategy(0);

        failCount.setName("每分钟网关处理错误错误数");
        failCount.setQueryMql("cloud-open-sdk.request_fail_bizcode_qpm{bizCode=~\"4...\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failCount.setTargetTagName("appReporter");
        failCount.setDetectionMethod("THRESHOLD");
        failCount.setComparisonOperator("GTE");
        failCount.setRightVal(Double.valueOf(10));
        failCount.setQueryValFormat(0);
        failCount.setQueryValCompareStrategy(0);


        metricTemplate.setQueryTemplateList(Arrays.asList(failRate,failCount));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
