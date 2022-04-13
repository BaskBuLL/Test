package top.baskbull.monitortest.biz.http;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/9 9:02 下午
 */
public class 接入层HTTP总体请求流量突增 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd rt = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("接入层HTTP总体请求流量突增");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("biz", "http"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("main");
        metricTemplate.setTriggerLevel("notice");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(3);

        qpm.setName("每分钟调用次数");
        qpm.setQueryMql("watchtower-gateway.app.qpm_by_app_status{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        qpm.setTargetTagName("appName");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(3000));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        rt.setName("每分钟调用量同比昨天突增");
        rt.setQueryMql("watchtower-gateway.app.qpm_by_app_status{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        rt.setTargetTagName("appName");
        rt.setDetectionMethod("CHANGE");
        rt.setComparisonStrategy("DAY_ON_DAY");
        rt.setComparisonOperator("INCREASE_GT");
        rt.setRightVal(200.0);
        rt.setQueryValFormat(1);
        rt.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, rt));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
