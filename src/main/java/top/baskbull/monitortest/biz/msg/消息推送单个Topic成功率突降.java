package top.baskbull.monitortest.biz.msg;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/10 9:17 上午
 */
public class 消息推送单个Topic成功率突降 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failRate = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("消息推送单个Topic成功率突降");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("biz", "msg"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("main");
        metricTemplate.setTriggerLevel("warning");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        qpm.setName("每分钟推送次数");
        qpm.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"bizType\"], sum>");
        qpm.setTargetTagName("clientId");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(60));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        failRate.setName("每分钟推送失败率同比昨天突升");
        failRate.setQueryMql("bifrost-push-admin.msg-push.fail_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"bizType\"], sum>");
        failRate.setTargetTagName("clientId");
        failRate.setDetectionMethod("CHANGE");
        failRate.setComparisonStrategy("DAY_ON_DAY");
        failRate.setComparisonOperator("INCREASE_GT");
        failRate.setRightVal(Double.valueOf(20));
        failRate.setQueryValFormat(1);
        failRate.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, failRate));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
