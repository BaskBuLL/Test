package top.baskbull.monitortest.dependency;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/10 4:29 下午
 */
public class 三方接口请求平均RT突升 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd rt = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("三方接口请求平均RT突升");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("dependency", "httpclient"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("youzanyun");
        metricTemplate.setTriggerLevel("warning");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        failCount.setName("每分钟三方接口请求单个地址数量");
        failCount.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"destHost\"], sum>");
        failCount.setTargetTagName("appReporter");
        failCount.setDetectionMethod("THRESHOLD");
        failCount.setComparisonOperator("GTE");
        failCount.setRightVal(Double.valueOf(300));
        failCount.setQueryValFormat(0);
        failCount.setQueryValCompareStrategy(0);

        rt.setName("每分钟三方接口请求P75-RT突升");
        rt.setQueryMql("cloud-http-client.httpclient_rt_centroid{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, centroid<20>> | tag_aggr<[\"destHost\"], quantile<[75]>>");
        rt.setTargetTagName("appReporter");
        rt.setComparisonStrategy("DAY_ON_DAY");
        rt.setDetectionMethod("CHANGE");
        rt.setComparisonOperator("INCREASE_GT");
        rt.setRightVal(100.0);
        rt.setQueryValFormat(1);
        rt.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(failCount, rt));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
