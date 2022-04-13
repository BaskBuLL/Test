package top.baskbull.monitortest.biz.http;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/3/9 9:02 下午
 */
public class 接入层HTTP请求总体响应较慢 {

    public static void main(String[] args) {
        MetricTemplateSaveCmd metricTemplate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd qpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd rt = new MetricQueryTemplateSaveCmd();

        metricTemplate.setName("接入层HTTP请求总体响应较慢");
        metricTemplate.setSupportTypes(Arrays.asList(0, 1));
        metricTemplate.setTags(Arrays.asList("biz", "http"));
        metricTemplate.setCombinatorialLogic("AND");
        metricTemplate.setBu("main");
        metricTemplate.setTriggerLevel("warning");
        metricTemplate.setPeriod(1);
        metricTemplate.setTimeUnit("m");
        metricTemplate.setContinuousCount(2);

        qpm.setName("每分钟调用次数");
        qpm.setQueryMql("watchtower-gateway.app.qpm_by_app_status{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        qpm.setTargetTagName("appName");
        qpm.setDetectionMethod("THRESHOLD");
        qpm.setComparisonOperator("GTE");
        qpm.setRightVal(Double.valueOf(180));
        qpm.setQueryValFormat(0);
        qpm.setQueryValCompareStrategy(0);

        rt.setName("调用P75-RT");
        rt.setQueryMql("watchtower-gateway.app.rt_centroid{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, centroid<20>> | tag_aggr<[], quantile<[75]>>");
        rt.setTargetTagName("appName");
        rt.setDetectionMethod("THRESHOLD");
        rt.setComparisonOperator("GTE");
        rt.setRightVal(Double.valueOf(2000));
        rt.setQueryValFormat(0);
        rt.setQueryValCompareStrategy(0);

        metricTemplate.setQueryTemplateList(Arrays.asList(qpm, rt));
        System.out.println(JSON.toJSONString(metricTemplate, true));
        System.out.println(JSON.toJSONString(metricTemplate));
    }
}
