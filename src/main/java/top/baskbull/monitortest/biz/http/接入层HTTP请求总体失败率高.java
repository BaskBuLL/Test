package top.baskbull.monitortest.biz.http;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/9 9:02 下午
 */
public class 接入层HTTP请求总体失败率高 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failRate = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("接入层HTTP请求总体失败率高");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("biz", "http"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("main");
        metricTemplate.setTriggerLevel("critical");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(2);

        qpm.setName("每分钟调用次数");
        qpm.setQueryMql("watchtower-gateway.app.qpm_by_app_status{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        qpm.setTargetTagName("appName");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(60));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        failCount.setName("每分钟失败次数");
        failCount.setQueryMql("watchtower-gateway.app.qpm_by_app_status{statusCode!=\"200\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failCount.setTargetTagName("appName");
        failCount.setDetectionMethod("THRESHOLD");
        failCount.setComparisonOperator("GTE");
        failCount.setRightVal(Double.valueOf(60));
        failCount.setQueryValFormat(0);
        failCount.setQueryValCompareStrategy(0);

        failRate.setName("每分钟调用失败率");
        failRate.setQueryMql("watchtower-gateway.app.fail_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failRate.setTargetTagName("appName");
        failRate.setDetectionMethod("THRESHOLD");
        failRate.setComparisonOperator("GTE");
        failRate.setRightVal(0.40);
        failRate.setQueryValFormat(1);
        failRate.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, failCount, failRate));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
