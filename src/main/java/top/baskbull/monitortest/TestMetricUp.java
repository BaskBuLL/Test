package top.baskbull.monitortest;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/2/23 9:24 上午
 */
public class TestMetricUp {

    public static void main(String[] args) {
//        MetricTemplateSaveCmd 网关api调用测试 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 网关api查询测试 = new MetricQueryTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 网关apirt查询测试 = new MetricQueryTemplateSaveCmd();
//
//        网关api调用测试.setName("网关api调用测试");
//        网关api调用测试.setSupportTypes(Arrays.asList(0, 1));
//        网关api调用测试.setTags(Arrays.asList("网关"));
//        网关api调用测试.setCombinatorialLogic("AND");
//        网关api调用测试.setBu("main");
//        网关api调用测试.setTriggerLevel("critical");
//        网关api调用测试.setPeriod(1);
//        网关api调用测试.setTimeUnit("m");
//        网关api调用测试.setContinuousCount(1);
//
//        网关api查询测试.setName("网关api查询测试");
//        网关api查询测试.setQueryMql("bifrost-gateway.api.qpm_by_apiname{}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
//        网关api查询测试.setTargetTagName("null");
//        网关api查询测试.setDetectionMethod("THRESHOLD");
//        网关api查询测试.setComparisonOperator("GTE");
//        网关api查询测试.setRightVal(Double.valueOf(1));
//
//        网关apirt查询测试.setName("网关apirt查询测试");
//        网关apirt查询测试.setQueryMql("bifrost-gateway.api.rt_by_apiname{}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
//        网关apirt查询测试.setTargetTagName("null");
//        网关apirt查询测试.setDetectionMethod("THRESHOLD");
//        网关apirt查询测试.setComparisonOperator("GTE");
//        网关apirt查询测试.setRightVal(Double.valueOf(1));
//
//        网关api调用测试.setQueryTemplateList(Arrays.asList(网关api查询测试, 网关apirt查询测试));
//
//        System.out.println(JSON.toJSONString(网关api调用测试, true));

        MetricTemplateSaveCmd 扩展点调用 = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd 扩展点调用失败次数查询 = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd 扩展点调用成功率查询 = new MetricQueryTemplateSaveCmd();

        //todo 截掉查询名
        扩展点调用.setName("业务扩展点总体调用失败率高");
        扩展点调用.setSupportTypes(Arrays.asList(0));
        扩展点调用.setTags(Arrays.asList("biz"));
        扩展点调用.setCombinatorialLogic("AND");
        扩展点调用.setBu("main");
        扩展点调用.setTriggerLevel("critical");
        扩展点调用.setPeriod(1);
        扩展点调用.setTimeUnit("m");
        扩展点调用.setContinuousCount(2);

        扩展点调用失败次数查询.setName("业务扩展点总体调用失败率高@每分钟失败次数");
        扩展点调用失败次数查询.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        扩展点调用失败次数查询.setTargetTagName("appName");
        扩展点调用失败次数查询.setDetectionMethod("THRESHOLD");
        扩展点调用失败次数查询.setComparisonOperator("GTE");
        扩展点调用失败次数查询.setRightVal(Double.valueOf(20));

        扩展点调用成功率查询.setName("扩展点调用成功率查询(总体)-critical");
        扩展点调用成功率查询.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        扩展点调用成功率查询.setTargetTagName("appName");
        扩展点调用成功率查询.setDetectionMethod("THRESHOLD");
        扩展点调用成功率查询.setComparisonOperator("LTE");
        扩展点调用成功率查询.setRightVal(0.6);

        扩展点调用.setQueryTemplateList(Arrays.asList(扩展点调用失败次数查询, 扩展点调用成功率查询));

        System.out.println(JSON.toJSONString(扩展点调用, true));
        System.out.println(Arrays.toString("wwwww查询1".split("@")));
        System.out.println("告警对象:dennis-chain-baihuo\n核心告警项:网关api调用测试-critical[3]次\n触发原因:网关apirt查询测试,触发值范围(1474.00-5021.00),网关api查询测试,触发值范围(1.00-99.00)\n\n业务告警项:网关api调用测试-critical[3]次\n触发原因:网关apirt查询测试,触发值范围(1474.00-5021.00),网关api查询测试,触发值范围(1.00-99.00)\n\n");
//        MetricTemplateSaveCmd 扩展点调用warning = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用失败次数查询warning = new MetricQueryTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用成功率查询warning = new MetricQueryTemplateSaveCmd();
//
//        扩展点调用warning.setName("扩展点调用(总体)-warning");
//        扩展点调用warning.setSupportTypes(Arrays.asList(0, 1));
//        扩展点调用warning.setTags(Arrays.asList("扩展点"));
//        扩展点调用warning.setCombinatorialLogic("AND");
//        扩展点调用warning.setBu("main");
//        扩展点调用warning.setTriggerLevel("warning");
//        扩展点调用warning.setPeriod(1);
//        扩展点调用warning.setTimeUnit("m");
//        扩展点调用warning.setContinuousCount(2);
//
//        扩展点调用失败次数查询warning.setName("扩展点请求失败次数查询(总体)-warning");
//        扩展点调用失败次数查询warning.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        扩展点调用失败次数查询warning.setTargetTagName("appName");
//        扩展点调用失败次数查询warning.setDetectionMethod("THRESHOLD");
//        扩展点调用失败次数查询warning.setComparisonOperator("GTE");
//        扩展点调用失败次数查询warning.setRightVal(Double.valueOf(10));
//
//        扩展点调用成功率查询warning.setName("扩展点调用成功率查询(总体)-warning");
//        扩展点调用成功率查询warning.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        扩展点调用成功率查询warning.setTargetTagName("appName");
//        扩展点调用成功率查询warning.setDetectionMethod("THRESHOLD");
//        扩展点调用成功率查询warning.setComparisonOperator("LTE");
//        扩展点调用成功率查询warning.setRightVal(0.75);
//
//        扩展点调用warning.setQueryTemplateList(Arrays.asList(扩展点调用失败次数查询warning, 扩展点调用成功率查询warning));
//
//        System.out.println(JSON.toJSONString(扩展点调用warning, true));


//        MetricTemplateSaveCmd 扩展点调用单个c = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用失败次数查询单c = new MetricQueryTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用成功率查询单c = new MetricQueryTemplateSaveCmd();
//
//        扩展点调用单个c.setName("扩展点调用(单个)-critical");
//        扩展点调用单个c.setSupportTypes(Arrays.asList(0, 1));
//        扩展点调用单个c.setTags(Arrays.asList("扩展点"));
//        扩展点调用单个c.setCombinatorialLogic("AND");
//        扩展点调用单个c.setBu("main");
//        扩展点调用单个c.setTriggerLevel("critical");
//        扩展点调用单个c.setPeriod(1);
//        扩展点调用单个c.setTimeUnit("m");
//        扩展点调用单个c.setContinuousCount(2);
//
//        扩展点调用失败次数查询单c.setName("扩展点请求失败次数查询(单个)-critical");
//        扩展点调用失败次数查询单c.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
//        扩展点调用失败次数查询单c.setTargetTagName("appName");
//        扩展点调用失败次数查询单c.setDetectionMethod("THRESHOLD");
//        扩展点调用失败次数查询单c.setComparisonOperator("GTE");
//        扩展点调用失败次数查询单c.setRightVal(Double.valueOf(10));
//
//        扩展点调用成功率查询单c.setName("扩展点调用成功率查询(单个)-critical");
//        扩展点调用成功率查询单c.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
//        扩展点调用成功率查询单c.setTargetTagName("appName");
//        扩展点调用成功率查询单c.setDetectionMethod("THRESHOLD");
//        扩展点调用成功率查询单c.setComparisonOperator("LTE");
//        扩展点调用成功率查询单c.setRightVal(0.60);
//
//        扩展点调用单个c.setQueryTemplateList(Arrays.asList(扩展点调用失败次数查询单c, 扩展点调用成功率查询单c));
//
//        System.out.println(JSON.toJSONString(扩展点调用单个c, true));

//        MetricTemplateSaveCmd 扩展点调用单个w = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用失败次数查询单w = new MetricQueryTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用成功率查询单w = new MetricQueryTemplateSaveCmd();
//
//        扩展点调用单个w.setName("扩展点调用(单个)-warning");
//        扩展点调用单个w.setSupportTypes(Arrays.asList(0, 1));
//        扩展点调用单个w.setTags(Arrays.asList("扩展点"));
//        扩展点调用单个w.setCombinatorialLogic("AND");
//        扩展点调用单个w.setBu("main");
//        扩展点调用单个w.setTriggerLevel("warning");
//        扩展点调用单个w.setPeriod(1);
//        扩展点调用单个w.setTimeUnit("m");
//        扩展点调用单个w.setContinuousCount(2);
//
//        扩展点调用失败次数查询单w.setName("扩展点请求失败次数查询(单个)-warning");
//        扩展点调用失败次数查询单w.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
//        扩展点调用失败次数查询单w.setTargetTagName("appName");
//        扩展点调用失败次数查询单w.setDetectionMethod("THRESHOLD");
//        扩展点调用失败次数查询单w.setComparisonOperator("GTE");
//        扩展点调用失败次数查询单w.setRightVal(Double.valueOf(5));
//
//        扩展点调用成功率查询单w.setName("扩展点调用成功率查询(单个)-warning");
//        扩展点调用成功率查询单w.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
//        扩展点调用成功率查询单w.setTargetTagName("appName");
//        扩展点调用成功率查询单w.setDetectionMethod("THRESHOLD");
//        扩展点调用成功率查询单w.setComparisonOperator("LTE");
//        扩展点调用成功率查询单w.setRightVal(0.75);
//
//        扩展点调用单个w.setQueryTemplateList(Arrays.asList(扩展点调用失败次数查询单w, 扩展点调用成功率查询单w));
//
//        System.out.println(JSON.toJSONString(扩展点调用单个w, true));

//        MetricTemplateSaveCmd 扩展点调用单个w = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用失败次数查询单w = new MetricQueryTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd 扩展点调用成功率查询单w = new MetricQueryTemplateSaveCmd();
//
//        扩展点调用单个w.setName("扩展点调用(单个)-warning");
//        扩展点调用单个w.setSupportTypes(Arrays.asList(0, 1));
//        扩展点调用单个w.setTags(Arrays.asList("扩展点"));
//        扩展点调用单个w.setCombinatorialLogic("AND");
//        扩展点调用单个w.setBu("main");
//        扩展点调用单个w.setTriggerLevel("warning");
//        扩展点调用单个w.setPeriod(1);
//        扩展点调用单个w.setTimeUnit("m");
//        扩展点调用单个w.setContinuousCount(2);
//
//        扩展点调用失败次数查询单w.setName("扩展点请求失败次数查询(单个)-warning");
//        扩展点调用失败次数查询单w.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
//        扩展点调用失败次数查询单w.setTargetTagName("appName");
//        扩展点调用失败次数查询单w.setDetectionMethod("THRESHOLD");
//        扩展点调用失败次数查询单w.setComparisonOperator("GTE");
//        扩展点调用失败次数查询单w.setRightVal(Double.valueOf(5));
//
//        扩展点调用成功率查询单w.setName("扩展点调用成功率查询(单个)-warning");
//        扩展点调用成功率查询单w.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
//        扩展点调用成功率查询单w.setTargetTagName("appName");
//        扩展点调用成功率查询单w.setDetectionMethod("THRESHOLD");
//        扩展点调用成功率查询单w.setComparisonOperator("LTE");
//        扩展点调用成功率查询单w.setRightVal(0.75);
//
//        扩展点调用单个w.setQueryTemplateList(Arrays.asList(扩展点调用失败次数查询单w, 扩展点调用成功率查询单w));
//
//        System.out.println(JSON.toJSONString(扩展点调用单个w, true));
    }
}
