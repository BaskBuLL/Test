package top.baskbull.monitortest.dependency;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/9 8:05 下午
 */
public class 三方接口请求量暴涨 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failRate = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("三方接口请求量暴涨");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("dependency", "httpclient"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("youzanyun");
        metricTemplate.setTriggerLevel("notice");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        failCount.setName("每分钟三方接口请求报错数量");
        failCount.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failCount.setTargetTagName("appReporter");
        failCount.setDetectionMethod("THRESHOLD");
        failCount.setComparisonOperator("GTE");
        failCount.setRightVal(Double.valueOf(18000));
        failCount.setQueryValFormat(0);
        failCount.setQueryValCompareStrategy(0);

        failRate.setName("三方接口请求量同比昨天突增");
        failRate.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failRate.setTargetTagName("appReporter");
        failRate.setDetectionMethod("CHANGE");
        failRate.setComparisonStrategy("DAY_ON_DAY");
        failRate.setComparisonOperator("INCREASE_GT");
        failRate.setRightVal(300.0);
        failRate.setQueryValFormat(1);
        failRate.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(failCount, failRate));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
