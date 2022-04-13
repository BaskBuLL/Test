package top.baskbull.monitortest.biz.api;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/9 8:23 下午
 */
public class 有赞云单个开放接口调用成功率跌0 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failRate = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("有赞云单个开放接口调用成功率跌0");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("biz", "api"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("main");
        metricTemplate.setTriggerLevel("critical");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        qpm.setName("每分钟调用次数");
        qpm.setQueryMql("bifrost-gateway.api.qpm_gwcode{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        qpm.setTargetTagName("clientId");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(20));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        failRate.setName("每分钟调用失败率");
        failRate.setQueryMql("bifrost-gateway.api.fail_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        failRate.setTargetTagName("clientId");
        failRate.setDetectionMethod("THRESHOLD");
        failRate.setComparisonOperator("GTE");
        failRate.setRightVal(0.99);
        failRate.setQueryValFormat(1);
        failRate.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, failRate));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
