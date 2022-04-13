package top.baskbull.monitortest;

import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/2/25 10:08 下午
 */
public class BizMetric {

    public static void main(String[] args) {
        MetricTemplateSaveCmd columbusFailRate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd successRate = new MetricQueryTemplateSaveCmd();

        columbusFailRate.setName("业务扩展点调用总体失败率较高");
        columbusFailRate.setSupportTypes(Arrays.asList(0));
        columbusFailRate.setTags(Arrays.asList("biz"));
        columbusFailRate.setCombinatorialLogic("AND");
        columbusFailRate.setBu("main");
        columbusFailRate.setTriggerLevel("warning");
        columbusFailRate.setPeriod(1);
        columbusFailRate.setTimeUnit("m");
        columbusFailRate.setContinuousCount(2);

        failCount.setName("业务扩展点调用总体失败率较高@每分钟失败次数");
        failCount.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failCount.setTargetTagName("appName");
        failCount.setDetectionMethod("THRESHOLD");
        failCount.setComparisonOperator("GTE");
        failCount.setRightVal(Double.valueOf(10));

        successRate.setName("业务扩展点调用总体失败率较高@每分钟调用成功率");
        successRate.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        successRate.setTargetTagName("appName");
        successRate.setDetectionMethod("THRESHOLD");
        successRate.setComparisonOperator("LTE");
        successRate.setRightVal(0.75);

        columbusFailRate.setQueryTemplateList(Arrays.asList(failCount, successRate));

//        System.out.println(JSON.toJSONString(columbusFailRate, true));

        MetricTemplateSaveCmd columbusFailRateLess = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd failCountLess = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd successRateLess = new MetricQueryTemplateSaveCmd();

        columbusFailRateLess.setName("业务扩展点调用量突增");
        columbusFailRateLess.setSupportTypes(Arrays.asList(0));
        columbusFailRateLess.setTags(Arrays.asList("biz"));
        columbusFailRateLess.setCombinatorialLogic("AND");
        columbusFailRateLess.setBu("main");
        columbusFailRateLess.setTriggerLevel("warning");
        columbusFailRateLess.setPeriod(1);
        columbusFailRateLess.setTimeUnit("m");
        columbusFailRateLess.setContinuousCount(3);

        failCountLess.setName("业务扩展点调用量突增@每分钟调用次数");
        failCountLess.setQueryMql("columbus.biz_ext_qpm{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        failCountLess.setTargetTagName("appName");
        failCountLess.setDetectionMethod("THRESHOLD");
        failCountLess.setComparisonOperator("GTE");
        failCountLess.setRightVal(Double.valueOf(1200));

        successRateLess.setName("业务扩展点调用量突增@每分钟调用量");
        successRateLess.setQueryMql("columbus.biz_ext_qpm{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        successRateLess.setTargetTagName("appName");
        successRateLess.setDetectionMethod("CHANGE");
        successRateLess.setComparisonStrategy("DAY_ON_DAY");
        successRateLess.setComparisonOperator("INCREASE_GT");
        successRateLess.setRightVal(3.0);

        columbusFailRateLess.setQueryTemplateList(Arrays.asList(failCountLess, successRateLess));

//        System.out.println(JSON.toJSONString(columbusFailRateLess, false));


        MetricTemplateSaveCmd singleColumbusFailRateLess = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd singleFailCountLess = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd singleSuccessRateLess = new MetricQueryTemplateSaveCmd();

        singleColumbusFailRateLess.setName("单个业务扩展点调用失败率较高");
        singleColumbusFailRateLess.setSupportTypes(Arrays.asList(0));
        singleColumbusFailRateLess.setTags(Arrays.asList("biz"));
        singleColumbusFailRateLess.setCombinatorialLogic("AND");
        singleColumbusFailRateLess.setBu("main");
        singleColumbusFailRateLess.setTriggerLevel("critical");
        singleColumbusFailRateLess.setPeriod(1);
        singleColumbusFailRateLess.setTimeUnit("m");
        singleColumbusFailRateLess.setContinuousCount(2);

        singleFailCountLess.setName("单个业务扩展点调用失败率较高@每分钟失败次数");
        singleFailCountLess.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
        singleFailCountLess.setTargetTagName("appName");
        singleFailCountLess.setDetectionMethod("THRESHOLD");
        singleFailCountLess.setComparisonOperator("GTE");
        singleFailCountLess.setRightVal(Double.valueOf(5));

        singleSuccessRateLess.setName("单个业务扩展点调用失败率较高@每分钟调用成功率");
        singleSuccessRateLess.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
        singleSuccessRateLess.setTargetTagName("appName");
        singleSuccessRateLess.setDetectionMethod("THRESHOLD");
        singleSuccessRateLess.setComparisonOperator("LTE");
        singleSuccessRateLess.setRightVal(0.75);

        singleColumbusFailRateLess.setQueryTemplateList(Arrays.asList(singleFailCountLess, singleSuccessRateLess));

//        System.out.println(JSON.toJSONString(singleColumbusFailRateLess, true));

        MetricTemplateSaveCmd 成功率迭0 = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd 失败次数 = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd 失败率 = new MetricQueryTemplateSaveCmd();

        成功率迭0.setName("单个业务扩展点调用成功率跌0");
        成功率迭0.setSupportTypes(Arrays.asList(0, 1));
        成功率迭0.setTags(Arrays.asList("biz"));
        成功率迭0.setCombinatorialLogic("AND");
        成功率迭0.setBu("main");
        成功率迭0.setTriggerLevel("critical");
        成功率迭0.setPeriod(1);
        成功率迭0.setTimeUnit("m");
        成功率迭0.setContinuousCount(2);

        失败次数.setName("单个业务扩展点调用成功率跌0@每分钟失败次数");
        失败次数.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
        失败次数.setTargetTagName("appName");
        失败次数.setDetectionMethod("THRESHOLD");
        失败次数.setComparisonOperator("GTE");
        失败次数.setRightVal(Double.valueOf(5));

        失败率.setName("单个业务扩展点调用成功率跌0@每分钟调用成功率");
        失败率.setQueryMql("columbus.request_success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"interfaceName\"], sum>");
        失败率.setTargetTagName("appName");
        失败率.setDetectionMethod("THRESHOLD");
        失败率.setComparisonOperator("LTE");
        失败率.setRightVal(0.01);

        成功率迭0.setQueryTemplateList(Arrays.asList(失败次数, 失败率));
//        System.out.println(JSON.toJSONString(成功率迭0, false));


        MetricTemplateSaveCmd httpFailRate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpFailCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpSuccessRate = new MetricQueryTemplateSaveCmd();

        httpFailRate.setName("接入层HTTP请求总体失败率高");
        httpFailRate.setSupportTypes(Arrays.asList(0));
        httpFailRate.setTags(Arrays.asList("biz"));
        httpFailRate.setCombinatorialLogic("AND");
        httpFailRate.setBu("main");
        httpFailRate.setTriggerLevel("critical");
        httpFailRate.setPeriod(1);
        httpFailRate.setTimeUnit("m");
        httpFailRate.setContinuousCount(2);

        httpFailCount.setName("接入层HTTP请求总体失败率高@每分钟失败次数");
        httpFailCount.setQueryMql("watchtower-gateway.app.qpm_by_app_status{statusCode!=\"200\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpFailCount.setTargetTagName("appName");
        httpFailCount.setDetectionMethod("THRESHOLD");
        httpFailCount.setComparisonOperator("GTE");
        httpFailCount.setRightVal(Double.valueOf(60));

        httpSuccessRate.setName("接入层HTTP请求总体失败率高@每分钟调用成功率");
        httpSuccessRate.setQueryMql("watchtower-gateway.app.success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpSuccessRate.setTargetTagName("appName");
        httpSuccessRate.setDetectionMethod("THRESHOLD");
        httpSuccessRate.setComparisonOperator("LTE");
        httpSuccessRate.setRightVal(0.60);

        httpFailRate.setQueryTemplateList(Arrays.asList(httpFailCount, httpSuccessRate));
//        System.out.println(JSON.toJSONString(httpFailRate, false));


        MetricTemplateSaveCmd httpResponseSlow = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientRt = new MetricQueryTemplateSaveCmd();

        httpResponseSlow.setName("接入层HTTP请求总体响应较慢");
        httpResponseSlow.setSupportTypes(Arrays.asList(0));
        httpResponseSlow.setTags(Arrays.asList("biz"));
        httpResponseSlow.setCombinatorialLogic("AND");
        httpResponseSlow.setBu("main");
        httpResponseSlow.setTriggerLevel("warning");
        httpResponseSlow.setPeriod(1);
        httpResponseSlow.setTimeUnit("m");
        httpResponseSlow.setContinuousCount(2);

        httpClientCount.setName("接入层HTTP请求总体响应较慢@每分钟调用次数");
        httpClientCount.setQueryMql("watchtower-gateway.app.qpm_by_app_status{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientCount.setTargetTagName("appName");
        httpClientCount.setDetectionMethod("THRESHOLD");
        httpClientCount.setComparisonOperator("GTE");
        httpClientCount.setRightVal(Double.valueOf(180));

        httpClientRt.setName("接入层HTTP请求总体响应较慢@调用RT");
        httpClientRt.setQueryMql("watchtower-gateway.app.rt_centroid{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, centroid<20>> | tag_aggr<[], quantile<[75]>>");
        httpClientRt.setTargetTagName("appName");
        httpClientRt.setDetectionMethod("THRESHOLD");
        httpClientRt.setComparisonOperator("GTE");
        httpClientRt.setRightVal(Double.valueOf(2000));

        httpResponseSlow.setQueryTemplateList(Arrays.asList(httpClientCount, httpClientRt));
//        System.out.println(JSON.toJSONString(httpResponseSlow, false));


        MetricTemplateSaveCmd httpFailRateS = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpFailCountS = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpSuccessRateS = new MetricQueryTemplateSaveCmd();

        httpFailRateS.setName("请求层HTTP请求总体响应慢");
        httpFailRateS.setSupportTypes(Arrays.asList(0));
        httpFailRateS.setTags(Arrays.asList("biz"));
        httpFailRateS.setCombinatorialLogic("AND");
        httpFailRateS.setBu("main");
        httpFailRateS.setTriggerLevel("critical");
        httpFailRateS.setPeriod(1);
        httpFailRateS.setTimeUnit("m");
        httpFailRateS.setContinuousCount(2);

        httpFailCountS.setName("请求层HTTP请求总体响应慢@每分钟调用次数");
        httpFailCountS.setQueryMql("watchtower-gateway.app.qpm_by_app_status{statusCode!=\"200\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpFailCountS.setTargetTagName("appName");
        httpFailCountS.setDetectionMethod("THRESHOLD");
        httpFailCountS.setComparisonOperator("GTE");
        httpFailCountS.setRightVal(Double.valueOf(600));

        httpSuccessRateS.setName("请求层HTTP请求总体响应慢@调用RT");
        httpSuccessRateS.setQueryMql("watchtower-gateway.app.success_rate{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpSuccessRateS.setTargetTagName("appName");
        httpSuccessRateS.setDetectionMethod("THRESHOLD");
        httpSuccessRateS.setComparisonOperator("LTE");
        httpSuccessRateS.setRightVal(0.75);

        httpFailRateS.setQueryTemplateList(Arrays.asList(httpFailCountS, httpSuccessRateS));
//        System.out.println(JSON.toJSONString(httpFailRateS, false));

        MetricTemplateSaveCmd httpRequestAddQuick = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpQpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpAddChange = new MetricQueryTemplateSaveCmd();

        httpRequestAddQuick.setName("接入层HTTP总体请求流量突增");
        httpRequestAddQuick.setSupportTypes(Arrays.asList(0));
        httpRequestAddQuick.setTags(Arrays.asList("biz"));
        httpRequestAddQuick.setCombinatorialLogic("AND");
        httpRequestAddQuick.setBu("main");
        httpRequestAddQuick.setTriggerLevel("notice");
        httpRequestAddQuick.setPeriod(1);
        httpRequestAddQuick.setTimeUnit("m");
        httpRequestAddQuick.setContinuousCount(3);

        httpQpm.setName("接入层HTTP总体请求流量突增@每分钟调用次数");
        httpQpm.setQueryMql("watchtower-gateway.app.qpm_by_app_status{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpQpm.setTargetTagName("appName");
        httpQpm.setDetectionMethod("THRESHOLD");
        httpQpm.setComparisonOperator("GTE");
        httpQpm.setRightVal(Double.valueOf(3000));

        httpAddChange.setName("接入层HTTP总体请求流量突增@每分钟调用量变化");
        httpAddChange.setQueryMql("watchtower-gateway.app.qpm_by_app_status{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpAddChange.setTargetTagName("appName");
        httpAddChange.setDetectionMethod("CHANGE");
        httpAddChange.setComparisonStrategy("DAY_ON_DAY");
        httpAddChange.setComparisonOperator("INCREASE_GT");
        httpAddChange.setRightVal(200.0);

//        httpRequestAddQuick.setQueryTemplateList(Arrays.asList(httpQpm, httpAddChange));
//        System.out.println(JSON.toJSONString(httpRequestAddQuick, true));

        MetricTemplateSaveCmd messagePushFailRateHigh = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushSuccessRate = new MetricQueryTemplateSaveCmd();

        messagePushFailRateHigh.setName("消息推送总体失败率高");
        messagePushFailRateHigh.setSupportTypes(Arrays.asList(0));
        messagePushFailRateHigh.setTags(Arrays.asList("biz"));
        messagePushFailRateHigh.setCombinatorialLogic("AND");
        messagePushFailRateHigh.setBu("main");
        messagePushFailRateHigh.setTriggerLevel("critical");
        messagePushFailRateHigh.setPeriod(1);
        messagePushFailRateHigh.setTimeUnit("m");
        messagePushFailRateHigh.setContinuousCount(5);

        messagePushCount.setName("消息推送总体失败率高@每分钟推送次数");
        messagePushCount.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        messagePushCount.setTargetTagName("clientId");
        messagePushCount.setDetectionMethod("THRESHOLD");
        messagePushCount.setComparisonOperator("GTE");
        messagePushCount.setRightVal(Double.valueOf(300));

        messagePushSuccessRate.setName("消息推送总体失败率高@每分钟推送成功率");
        messagePushSuccessRate.setQueryMql("bifrost-push-admin.msg-push.success_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        messagePushSuccessRate.setTargetTagName("clientId");
        messagePushSuccessRate.setDetectionMethod("THRESHOLD");
        messagePushSuccessRate.setComparisonOperator("LTE");
        messagePushSuccessRate.setRightVal(0.5);

        messagePushFailRateHigh.setQueryTemplateList(Arrays.asList(messagePushCount, messagePushSuccessRate));
//        System.out.println(JSON.toJSONString(messagePushFailRateHigh, false));

        MetricTemplateSaveCmd messagePushFailRateHigher = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushCountRise = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushSuccessRateLow = new MetricQueryTemplateSaveCmd();

        messagePushFailRateHigher.setName("消息推送总体失败率较高");
        messagePushFailRateHigher.setSupportTypes(Arrays.asList(0));
        messagePushFailRateHigher.setTags(Arrays.asList("biz"));
        messagePushFailRateHigher.setCombinatorialLogic("AND");
        messagePushFailRateHigher.setBu("main");
        messagePushFailRateHigher.setTriggerLevel("warning");
        messagePushFailRateHigher.setPeriod(1);
        messagePushFailRateHigher.setTimeUnit("m");
        messagePushFailRateHigher.setContinuousCount(5);

        messagePushCountRise.setName("消息推送总体失败率较高@每分钟推送次数");
        messagePushCountRise.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        messagePushCountRise.setTargetTagName("clientId");
        messagePushCountRise.setDetectionMethod("THRESHOLD");
        messagePushCountRise.setComparisonOperator("GTE");
        messagePushCountRise.setRightVal(Double.valueOf(180));

        messagePushSuccessRateLow.setName("消息推送总体失败率较高@每分钟推送成功率");
        messagePushSuccessRateLow.setQueryMql("bifrost-push-admin.msg-push.success_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        messagePushSuccessRateLow.setTargetTagName("clientId");
        messagePushSuccessRateLow.setDetectionMethod("THRESHOLD");
        messagePushSuccessRateLow.setComparisonOperator("LTE");
        messagePushSuccessRateLow.setRightVal(0.75);

        messagePushFailRateHigher.setQueryTemplateList(Arrays.asList(messagePushCountRise, messagePushSuccessRateLow));
//        System.out.println(JSON.toJSONString(messagePushFailRateHigher, false));

        MetricTemplateSaveCmd messagePushRise = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushCountR = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushCountChange = new MetricQueryTemplateSaveCmd();

        messagePushRise.setName("消息推送总体推送量突增");
        messagePushRise.setSupportTypes(Arrays.asList(0));
        messagePushRise.setTags(Arrays.asList("biz"));
        messagePushRise.setCombinatorialLogic("AND");
        messagePushRise.setBu("main");
        messagePushRise.setTriggerLevel("notice");
        messagePushRise.setPeriod(1);
        messagePushRise.setTimeUnit("m");
        messagePushRise.setContinuousCount(3);

        messagePushCountR.setName("消息推送总体推送量突增@每分钟推送次数");
        messagePushCountR.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        messagePushCountR.setTargetTagName("clientId");
        messagePushCountR.setDetectionMethod("THRESHOLD");
        messagePushCountR.setComparisonOperator("GTE");
        messagePushCountR.setRightVal(Double.valueOf(3000));

        messagePushCountChange.setName("消息推送总体推送量突增@每分钟推送量变化");
        messagePushCountChange.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        messagePushCountChange.setTargetTagName("clientId");
        messagePushCountChange.setDetectionMethod("CHANGE");
        messagePushCountChange.setComparisonStrategy("DAY_ON_DAY");
        messagePushCountChange.setComparisonOperator("INCREASE_GT");
        messagePushCountChange.setRightVal(300.0);

        messagePushRise.setQueryTemplateList(Arrays.asList(messagePushCountR, messagePushCountChange));
//        System.out.println(JSON.toJSONString(messagePushRise, false));


        MetricTemplateSaveCmd messagePushSingleFailRate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushSingleQpm = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushSingleSuccessRate = new MetricQueryTemplateSaveCmd();

        messagePushSingleFailRate.setName("消息推送单个Topic失败率高");
        messagePushSingleFailRate.setSupportTypes(Arrays.asList(0));
        messagePushSingleFailRate.setTags(Arrays.asList("biz"));
        messagePushSingleFailRate.setCombinatorialLogic("AND");
        messagePushSingleFailRate.setBu("main");
        messagePushSingleFailRate.setTriggerLevel("critical");
        messagePushSingleFailRate.setPeriod(1);
        messagePushSingleFailRate.setTimeUnit("m");
        messagePushSingleFailRate.setContinuousCount(3);

        messagePushSingleQpm.setName("消息推送单个Topic失败率高@每分钟推送次数");
        messagePushSingleQpm.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"bizType\"], sum>");
        messagePushSingleQpm.setTargetTagName("clientId");
        messagePushSingleQpm.setDetectionMethod("THRESHOLD");
        messagePushSingleQpm.setComparisonOperator("GTE");
        messagePushSingleQpm.setRightVal(Double.valueOf(600));

        messagePushSingleSuccessRate.setName("消息推送单个Topic失败率高@每分钟推送成功率");
        messagePushSingleSuccessRate.setQueryMql("bifrost-push-admin.msg-push.success_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"bizType\"], sum>");
        messagePushSingleSuccessRate.setTargetTagName("clientId");
        messagePushSingleSuccessRate.setDetectionMethod("THRESHOLD");
        messagePushSingleSuccessRate.setComparisonOperator("LTE");
        messagePushSingleSuccessRate.setRightVal(Double.valueOf(0.5));

        messagePushSingleFailRate.setQueryTemplateList(Arrays.asList(messagePushSingleQpm, messagePushSingleSuccessRate));
//        System.out.println(JSON.toJSONString(messagePushSingleFailRate, false));

        MetricTemplateSaveCmd messagePushRateLower = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushSingleQpmLow = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd messagePushSingleCountChange = new MetricQueryTemplateSaveCmd();

        messagePushRateLower.setName("消息推送单个Topic成功率突降");
        messagePushRateLower.setSupportTypes(Arrays.asList(0));
        messagePushRateLower.setTags(Arrays.asList("biz"));
        messagePushRateLower.setCombinatorialLogic("AND");
        messagePushRateLower.setBu("main");
        messagePushRateLower.setTriggerLevel("warning");
        messagePushRateLower.setPeriod(1);
        messagePushRateLower.setTimeUnit("m");
        messagePushRateLower.setContinuousCount(3);

        messagePushSingleQpmLow.setName("消息推送单个Topic成功率突降@每分钟推送次数");
        messagePushSingleQpmLow.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"bizType\"], sum>");
        messagePushSingleQpmLow.setTargetTagName("clientId");
        messagePushSingleQpmLow.setDetectionMethod("THRESHOLD");
        messagePushSingleQpmLow.setComparisonOperator("GTE");
        messagePushSingleQpmLow.setRightVal(Double.valueOf(60));

        messagePushSingleCountChange.setName("消息推送单个Topic成功率突降@每分钟推送成功率变化");
        messagePushSingleCountChange.setQueryMql("bifrost-push-admin.msg-push.success_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"bizType\"], sum>");
        messagePushSingleCountChange.setTargetTagName("clientId");
        messagePushSingleCountChange.setDetectionMethod("CHANGE");
        messagePushSingleCountChange.setComparisonStrategy("DAY_ON_DAY");
        messagePushSingleCountChange.setComparisonOperator("DECREASE_GT");
        messagePushSingleCountChange.setRightVal(Double.valueOf(20));

        messagePushRateLower.setQueryTemplateList(Arrays.asList(messagePushSingleQpmLow, messagePushSingleCountChange));
//        System.out.println(JSON.toJSONString(messagePushRateLower, false));

        MetricTemplateSaveCmd openApiFailRate = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openApiCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openApiSuccessRate = new MetricQueryTemplateSaveCmd();

        openApiFailRate.setName("有赞云开放接口调用总体失败率高");
        openApiFailRate.setSupportTypes(Arrays.asList(0));
        openApiFailRate.setTags(Arrays.asList("biz"));
        openApiFailRate.setCombinatorialLogic("AND");
        openApiFailRate.setBu("main");
        openApiFailRate.setTriggerLevel("critical");
        openApiFailRate.setPeriod(1);
        openApiFailRate.setTimeUnit("m");
        openApiFailRate.setContinuousCount(3);

        openApiCount.setName("有赞云开放接口调用总体失败率高@每分钟API调用次数");
        openApiCount.setQueryMql("bifrost-gateway.api.qpm_by_clientid{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        openApiCount.setTargetTagName("clientId");
        openApiCount.setDetectionMethod("THRESHOLD");
        openApiCount.setComparisonOperator("GTE");
        openApiCount.setRightVal(Double.valueOf(300));

        openApiSuccessRate.setName("有赞云开放接口调用总体失败率高@每分钟API调用成功率");
        openApiSuccessRate.setQueryMql("bifrost-gateway.api.success_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        openApiSuccessRate.setTargetTagName("clientId");
        openApiSuccessRate.setDetectionMethod("THRESHOLD");
        openApiSuccessRate.setComparisonOperator("LTE");
        openApiSuccessRate.setRightVal(0.5);

        openApiFailRate.setQueryTemplateList(Arrays.asList(openApiCount, openApiSuccessRate));
//        System.out.println(JSON.toJSONString(openApiFailRate, false));


        MetricTemplateSaveCmd openApiFailRateSingle = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openApiCountSingle = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openApiSuccessRateSingle = new MetricQueryTemplateSaveCmd();

        openApiFailRateSingle.setName("有赞云单个开放接口调用失败率高");
        openApiFailRateSingle.setSupportTypes(Arrays.asList(0));
        openApiFailRateSingle.setTags(Arrays.asList("biz"));
        openApiFailRateSingle.setCombinatorialLogic("AND");
        openApiFailRateSingle.setBu("main");
        openApiFailRateSingle.setTriggerLevel("critical");
        openApiFailRateSingle.setPeriod(1);
        openApiFailRateSingle.setTimeUnit("m");
        openApiFailRateSingle.setContinuousCount(2);

        openApiCountSingle.setName("有赞云单个开放接口调用失败率高@每分钟调用次数");
        openApiCountSingle.setQueryMql("bifrost-gateway.api.qpm_by_api{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        openApiCountSingle.setTargetTagName("clientId");
        openApiCountSingle.setDetectionMethod("THRESHOLD");
        openApiCountSingle.setComparisonOperator("GTE");
        openApiCountSingle.setRightVal(Double.valueOf(20));

        openApiSuccessRateSingle.setName("有赞云单个开放接口调用失败率高@每分钟调用成功率");
        openApiSuccessRateSingle.setQueryMql("bifrost-gateway.api.success_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        openApiSuccessRateSingle.setTargetTagName("clientId");
        openApiSuccessRateSingle.setDetectionMethod("THRESHOLD");
        openApiSuccessRateSingle.setComparisonOperator("LTE");
        openApiSuccessRateSingle.setRightVal(0.01);

        openApiFailRateSingle.setQueryTemplateList(Arrays.asList(openApiCountSingle, openApiSuccessRateSingle));
//        System.out.println(JSON.toJSONString(openApiFailRateSingle, false));

        MetricTemplateSaveCmd openApiFailRateLower = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openApiCountS = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openApiSuccessRateS = new MetricQueryTemplateSaveCmd();

        openApiFailRateLower.setName("有赞云单个开放接口调用成功率突降");
        openApiFailRateLower.setSupportTypes(Arrays.asList(0));
        openApiFailRateLower.setTags(Arrays.asList("biz"));
        openApiFailRateLower.setCombinatorialLogic("AND");
        openApiFailRateLower.setBu("main");
        openApiFailRateLower.setTriggerLevel("warning");
        openApiFailRateLower.setPeriod(1);
        openApiFailRateLower.setTimeUnit("m");
        openApiFailRateLower.setContinuousCount(3);

        openApiCountS.setName("有赞云单个开放接口调用成功率突降@每分钟调用次数");
        openApiCountS.setQueryMql("bifrost-gateway.api.qpm_by_api{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        openApiCountS.setTargetTagName("clientId");
        openApiCountS.setDetectionMethod("THRESHOLD");
        openApiCountS.setComparisonOperator("GTE");
        openApiCountS.setRightVal(Double.valueOf(60));

        openApiSuccessRateS.setName("有赞云单个开放接口调用失败率高@每分钟调用成功率");
        openApiSuccessRateS.setQueryMql("bifrost-gateway.api.success_rate{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        openApiSuccessRateS.setTargetTagName("clientId");
        openApiSuccessRateS.setDetectionMethod("CHANGE");
        openApiSuccessRateS.setComparisonStrategy("DAY_ON_DAY");
        openApiSuccessRateS.setComparisonOperator("DECREASE_GT");
        openApiSuccessRateS.setRightVal(Double.valueOf(30));

        openApiFailRateLower.setQueryTemplateList(Arrays.asList(openApiCountS, openApiSuccessRateS));
//        System.out.println(JSON.toJSONString(openApiFailRateLower, false));

        MetricTemplateSaveCmd lumberjack = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd errorCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd errorCountChange = new MetricQueryTemplateSaveCmd();

        lumberjack.setName("有赞云应用错误日志数突增");
        lumberjack.setSupportTypes(Arrays.asList(0, 1));
        lumberjack.setTags(Arrays.asList("biz"));
        lumberjack.setCombinatorialLogic("AND");
        lumberjack.setBu("youzanyun");
        lumberjack.setTriggerLevel("critical");
        lumberjack.setPeriod(1);
        lumberjack.setTimeUnit("m");
        lumberjack.setContinuousCount(3);

        errorCount.setName("有赞云应用错误日志数突增@每分钟错误日志数");
        errorCount.setQueryMql("lumberjack.log_montior{logAppReporter=\"{{ logAppReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        errorCount.setTargetTagName("logAppReporter");
        errorCount.setDetectionMethod("THRESHOLD");
        errorCount.setComparisonOperator("GTE");
        errorCount.setRightVal(Double.valueOf(50));

        errorCountChange.setName("有赞云应用错误日志数突增@每分钟错误日志数提升率");
        errorCountChange.setQueryMql("lumberjack.log_montior{logAppReporter=\"{{ logAppReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        errorCountChange.setTargetTagName("logAppReporter");
        errorCountChange.setDetectionMethod("CHANGE");
        errorCountChange.setComparisonStrategy("DAY_ON_DAY");
        errorCountChange.setComparisonOperator("INCREASE_GT");
        errorCountChange.setRightVal(Double.valueOf(100));
        lumberjack.setQueryTemplateList(Arrays.asList(errorCount, errorCountChange));
//        System.out.println(JSON.toJSONString(lumberjack, false));
    }
}
