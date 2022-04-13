package top.baskbull.monitortest;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/2/26 9:32 上午
 */
public class DependencyMetric {

    public static void main(String[] args) {
        MetricTemplateSaveCmd openSdkNot200 = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openSdkNot200Count = new MetricQueryTemplateSaveCmd();

        openSdkNot200.setName("有赞云网关请求状态码大量错误");
        openSdkNot200.setSupportTypes(Arrays.asList(0));
        openSdkNot200.setTags(Arrays.asList("dependency"));
        openSdkNot200.setCombinatorialLogic("AND");
        openSdkNot200.setBu("youzanyun");
        openSdkNot200.setTriggerLevel("critical");
        openSdkNot200.setPeriod(1);
        openSdkNot200.setTimeUnit("m");
        openSdkNot200.setContinuousCount(3);

        openSdkNot200Count.setName("有赞云网关请求状态码大量错误@每分钟网关请求返回状态码非200数量");
        openSdkNot200Count.setQueryMql("cloud-open-sdk.request_not200_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        openSdkNot200Count.setTargetTagName("appReporter");
        openSdkNot200Count.setDetectionMethod("THRESHOLD");
        openSdkNot200Count.setComparisonOperator("GTE");
        openSdkNot200Count.setRightVal(Double.valueOf(60));

        openSdkNot200.setQueryTemplateList(Arrays.asList(openSdkNot200Count));
//        System.out.println(JSON.toJSONString(openSdkNot200, false));

        MetricTemplateSaveCmd openSdkToken = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openSdkTokenCount = new MetricQueryTemplateSaveCmd();

        openSdkToken.setName("获取有赞云网关token大量报错");
        openSdkToken.setSupportTypes(Arrays.asList(0));
        openSdkToken.setTags(Arrays.asList("dependency"));
        openSdkToken.setCombinatorialLogic("AND");
        openSdkToken.setBu("youzanyun");
        openSdkToken.setTriggerLevel("critical");
        openSdkToken.setPeriod(1);
        openSdkToken.setTimeUnit("m");
        openSdkToken.setContinuousCount(3);

        openSdkTokenCount.setName("获取有赞云网关token大量报错@每分钟网关获取token错误数");
        openSdkTokenCount.setQueryMql("cloud-open-sdk.request_fail_bizcode_qpm{bizCode=~\"1...\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        openSdkTokenCount.setTargetTagName("appReporter");
        openSdkTokenCount.setDetectionMethod("THRESHOLD");
        openSdkTokenCount.setComparisonOperator("GTE");
        openSdkTokenCount.setRightVal(Double.valueOf(5));

        openSdkToken.setQueryTemplateList(Arrays.asList(openSdkTokenCount));
//        System.out.println(JSON.toJSONString(openSdkToken, false));

        MetricTemplateSaveCmd openSdkError = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openSdkErrorCount = new MetricQueryTemplateSaveCmd();

        openSdkError.setName("有赞云网关请求大量报错");
        openSdkError.setSupportTypes(Arrays.asList(0));
        openSdkError.setTags(Arrays.asList("dependency"));
        openSdkError.setCombinatorialLogic("AND");
        openSdkError.setBu("youzanyun");
        openSdkError.setTriggerLevel("critical");
        openSdkError.setPeriod(1);
        openSdkError.setTimeUnit("m");
        openSdkError.setContinuousCount(3);

        openSdkErrorCount.setName("有赞云网关请求大量报错@每分钟网关处理错误错误数");
        openSdkErrorCount.setQueryMql("cloud-open-sdk.request_fail_bizcode_qpm{bizCode=~\"4...\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        openSdkErrorCount.setTargetTagName("appReporter");
        openSdkErrorCount.setDetectionMethod("THRESHOLD");
        openSdkErrorCount.setComparisonOperator("GTE");
        openSdkErrorCount.setRightVal(Double.valueOf(10));

        openSdkError.setQueryTemplateList(Arrays.asList(openSdkErrorCount));
//        System.out.println(JSON.toJSONString(openSdkError, false));

        MetricTemplateSaveCmd httpClientError = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientErrorCount = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientErrorRate = new MetricQueryTemplateSaveCmd();

        httpClientError.setName("三方接口请求大量报错");
        httpClientError.setSupportTypes(Arrays.asList(0));
        httpClientError.setTags(Arrays.asList("dependency"));
        httpClientError.setCombinatorialLogic("AND");
        httpClientError.setBu("youzanyun");
        httpClientError.setTriggerLevel("critical");
        httpClientError.setPeriod(1);
        httpClientError.setTimeUnit("m");
        httpClientError.setContinuousCount(3);

        httpClientErrorCount.setName("三方接口请求大量报错@每分钟三方接口请求报错数量");
        httpClientErrorCount.setQueryMql("cloud-http-client.request_status{statusCode!~\"2..\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientErrorCount.setTargetTagName("appReporter");
        httpClientErrorCount.setDetectionMethod("THRESHOLD");
        httpClientErrorCount.setComparisonOperator("GTE");
        httpClientErrorCount.setRightVal(Double.valueOf(600));

        httpClientErrorRate.setName("三方接口请求大量报错@每分钟三方接口请求成功率");
        httpClientErrorRate.setQueryMql("cloud-http-client.request_success_rate{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientErrorRate.setTargetTagName("appReporter");
        httpClientErrorRate.setDetectionMethod("THRESHOLD");
        httpClientErrorRate.setComparisonOperator("LTE");
        httpClientErrorRate.setRightVal(Double.valueOf(0.6));

        httpClientError.setQueryTemplateList(Arrays.asList(httpClientErrorCount, httpClientErrorRate));
//        System.out.println(JSON.toJSONString(httpClientError, false));


        MetricTemplateSaveCmd httpClientSlow = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientQps = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientRT = new MetricQueryTemplateSaveCmd();

        httpClientSlow.setName("三方接口请求返回慢");
        httpClientSlow.setSupportTypes(Arrays.asList(0));
        httpClientSlow.setTags(Arrays.asList("dependency"));
        httpClientSlow.setCombinatorialLogic("AND");
        httpClientSlow.setBu("youzanyun");
        httpClientSlow.setTriggerLevel("critical");
        httpClientSlow.setPeriod(1);
        httpClientSlow.setTimeUnit("m");
        httpClientSlow.setContinuousCount(3);

        httpClientQps.setName("三方接口请求返回慢@每分钟三方接口请求QPS");
        httpClientQps.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientQps.setTargetTagName("appReporter");
        httpClientQps.setDetectionMethod("THRESHOLD");
        httpClientQps.setComparisonOperator("GTE");
        httpClientQps.setRightVal(Double.valueOf(100));

        httpClientRT.setName("三方接口请求返回慢@每分钟三方接口请求RT");
        httpClientRT.setQueryMql("cloud-http-client.httpclient_rt_centroid{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, centroid<20>> | tag_aggr<[], quantile<[75]>>");
        httpClientRT.setTargetTagName("appReporter");
        httpClientRT.setDetectionMethod("THRESHOLD");
        httpClientRT.setComparisonOperator("GTE");
        httpClientRT.setRightVal(Double.valueOf(1000));

        httpClientSlow.setQueryTemplateList(Arrays.asList(httpClientQps, httpClientRT));
//        System.out.println(JSON.toJSONString(httpClientSlow, false));


        MetricTemplateSaveCmd httpClientRequestChange = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientRequestQps = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientRequestChangeCount = new MetricQueryTemplateSaveCmd();

        httpClientRequestChange.setName("三方接口请求量暴涨");
        httpClientRequestChange.setSupportTypes(Arrays.asList(0));
        httpClientRequestChange.setTags(Arrays.asList("dependency"));
        httpClientRequestChange.setCombinatorialLogic("AND");
        httpClientRequestChange.setBu("youzanyun");
        httpClientRequestChange.setTriggerLevel("notice");
        httpClientRequestChange.setPeriod(1);
        httpClientRequestChange.setTimeUnit("m");
        httpClientRequestChange.setContinuousCount(3);

        httpClientRequestQps.setName("三方接口请求量暴涨@每分钟三方接口请求QPS");
        httpClientRequestQps.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientRequestQps.setTargetTagName("appReporter");
        httpClientRequestQps.setDetectionMethod("THRESHOLD");
        httpClientRequestQps.setComparisonOperator("GTE");
        httpClientRequestQps.setRightVal(Double.valueOf(300));

        httpClientRequestChangeCount.setName("三方接口请求量暴涨@三方接口请求量变化");
        httpClientRequestChangeCount.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientRequestChangeCount.setTargetTagName("appReporter");
        httpClientRequestChangeCount.setDetectionMethod("CHANGE");
        httpClientRequestChangeCount.setComparisonStrategy("DAY_ON_DAY");
        httpClientRequestChangeCount.setComparisonOperator("INCREASE_GT");
        httpClientRequestChangeCount.setRightVal(300.0);

        httpClientRequestChange.setQueryTemplateList(Arrays.asList(httpClientRequestQps, httpClientRequestChangeCount));
//        System.out.println(JSON.toJSONString(httpClientRequestChange, false));

        MetricTemplateSaveCmd httpClientSingle = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientSingleQps = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientSingleSuccessRate = new MetricQueryTemplateSaveCmd();

        httpClientSingle.setName("三方接口请求单个地址成功率跌0");
        httpClientSingle.setSupportTypes(Arrays.asList(0));
        httpClientSingle.setTags(Arrays.asList("dependency"));
        httpClientSingle.setCombinatorialLogic("AND");
        httpClientSingle.setBu("youzanyun");
        httpClientSingle.setTriggerLevel("critical");
        httpClientSingle.setPeriod(1);
        httpClientSingle.setTimeUnit("m");
        httpClientSingle.setContinuousCount(3);

        httpClientSingleQps.setName("三方接口请求单个地址成功率跌0@每分钟三方接口请求单个地址数量");
        httpClientSingleQps.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"destHost\"], sum>");
        httpClientSingleQps.setTargetTagName("appReporter");
        httpClientSingleQps.setDetectionMethod("THRESHOLD");
        httpClientSingleQps.setComparisonOperator("GTE");
        httpClientSingleQps.setRightVal(Double.valueOf(5));

        httpClientSingleSuccessRate.setName("三方接口请求单个地址成功率跌0@每分钟三方接口请求成功率");
        httpClientSingleSuccessRate.setQueryMql("cloud-http-client.request_success_rate{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"destHost\"], sum>");
        httpClientSingleSuccessRate.setTargetTagName("appReporter");
        httpClientSingleSuccessRate.setDetectionMethod("THRESHOLD");
        httpClientSingleSuccessRate.setComparisonOperator("LTE");
        httpClientSingleSuccessRate.setRightVal(0.01);

        httpClientSingle.setQueryTemplateList(Arrays.asList(httpClientSingleQps, httpClientSingleSuccessRate));
//        System.out.println(JSON.toJSONString(httpClientSingle, false));

        MetricTemplateSaveCmd httpClientSingleChange = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientSingleQpsChange = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientSingleSuccessRateChange = new MetricQueryTemplateSaveCmd();

        httpClientSingleChange.setName("三方接口请求单个地址成功率变化");
        httpClientSingleChange.setSupportTypes(Arrays.asList(0));
        httpClientSingleChange.setTags(Arrays.asList("dependency"));
        httpClientSingleChange.setCombinatorialLogic("AND");
        httpClientSingleChange.setBu("youzanyun");
        httpClientSingleChange.setTriggerLevel("critical");
        httpClientSingleChange.setPeriod(1);
        httpClientSingleChange.setTimeUnit("m");
        httpClientSingleChange.setContinuousCount(3);

        httpClientSingleQpsChange.setName("三方接口请求单个地址成功率变化@每分钟三方接口请求单个地址数量");
        httpClientSingleQpsChange.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"destHost\"], sum>");
        httpClientSingleQpsChange.setTargetTagName("appReporter");
        httpClientSingleQpsChange.setDetectionMethod("THRESHOLD");
        httpClientSingleQpsChange.setComparisonOperator("GTE");
        httpClientSingleQpsChange.setRightVal(Double.valueOf(300));

        httpClientSingleSuccessRateChange.setName("三方接口请求单个地址成功率变化@每分钟三方接口请求成功率变化");
        httpClientSingleSuccessRateChange.setQueryMql("cloud-http-client.request_success_rate{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"destHost\"], sum>");
        httpClientSingleSuccessRateChange.setTargetTagName("appReporter");
        httpClientSingleSuccessRateChange.setComparisonStrategy("DAY_ON_DAY");
        httpClientSingleSuccessRateChange.setDetectionMethod("CHANGE");
        httpClientSingleSuccessRateChange.setComparisonOperator("DECREASE_GT");
        httpClientSingleSuccessRateChange.setRightVal(30.0);
        httpClientSingleChange.setQueryTemplateList(Arrays.asList(httpClientSingleQpsChange, httpClientSingleSuccessRateChange));
//        System.out.println(JSON.toJSONString(httpClientSingleChange, false));

        MetricTemplateSaveCmd httpClientSingleCh = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientSingleQpsCh = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientSingleSuccessRateCh = new MetricQueryTemplateSaveCmd();

        httpClientSingleCh.setName("三方接口请求平均RT突升");
        httpClientSingleCh.setSupportTypes(Arrays.asList(0));
        httpClientSingleCh.setTags(Arrays.asList("dependency"));
        httpClientSingleCh.setCombinatorialLogic("AND");
        httpClientSingleCh.setBu("youzanyun");
        httpClientSingleCh.setTriggerLevel("warning");
        httpClientSingleCh.setPeriod(1);
        httpClientSingleCh.setTimeUnit("m");
        httpClientSingleCh.setContinuousCount(3);

        httpClientSingleQpsCh.setName("三方接口请求平均RT突升@每分钟三方接口请求单个地址数量");
        httpClientSingleQpsCh.setQueryMql("cloud-http-client.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"destHost\"], sum>");
        httpClientSingleQpsCh.setTargetTagName("appReporter");
        httpClientSingleQpsCh.setDetectionMethod("THRESHOLD");
        httpClientSingleQpsCh.setComparisonOperator("GTE");
        httpClientSingleQpsCh.setRightVal(Double.valueOf(300));

        httpClientSingleSuccessRateCh.setName("三方接口请求平均RT突升@每分钟三方接口请求平均RT变化");
        httpClientSingleSuccessRateCh.setQueryMql("cloud-http-client.request_avg_rt{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"destHost\"], sum>");
        httpClientSingleSuccessRateCh.setTargetTagName("appReporter");
        httpClientSingleSuccessRateCh.setComparisonStrategy("DAY_ON_DAY");
        httpClientSingleSuccessRateCh.setDetectionMethod("CHANGE");
        httpClientSingleSuccessRateCh.setComparisonOperator("INCREASE_GT");
        httpClientSingleSuccessRateCh.setRightVal(50.0);

        httpClientSingleCh.setQueryTemplateList(Arrays.asList(httpClientSingleQpsCh, httpClientSingleSuccessRateCh));
//        System.out.println(JSON.toJSONString(httpClientSingleCh, false));

        MetricTemplateSaveCmd sqlSlow = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd sqlQps = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd sqlRt = new MetricQueryTemplateSaveCmd();

        sqlSlow.setName("数据库总体查询较慢");
        sqlSlow.setSupportTypes(Arrays.asList(0));
        sqlSlow.setTags(Arrays.asList("dependency"));
        sqlSlow.setCombinatorialLogic("AND");
        sqlSlow.setBu("youzanyun");
        sqlSlow.setTriggerLevel("critical");
        sqlSlow.setPeriod(1);
        sqlSlow.setTimeUnit("m");
        sqlSlow.setContinuousCount(3);

        sqlQps.setName("数据库总体查询较慢@每分钟数据库查询平均QPS");
        sqlQps.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        sqlQps.setTargetTagName("appReporter");
        sqlQps.setDetectionMethod("THRESHOLD");
        sqlQps.setComparisonOperator("GTE");
        sqlQps.setRightVal(Double.valueOf(50));

        sqlRt.setName("数据库总体查询较慢@每分钟数据库执行RT");
        sqlRt.setQueryMql("sql.rt_centroid_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, centroid<20>> | tag_aggr<[], quantile<[50]>>");
        sqlRt.setTargetTagName("appReporter");
        sqlRt.setDetectionMethod("THRESHOLD");
        sqlRt.setComparisonOperator("GTE");
        sqlRt.setRightVal(800.0);

        sqlSlow.setQueryTemplateList(Arrays.asList(sqlQps, sqlRt));
//        System.out.println(JSON.toJSONString(sqlSlow, false));


        MetricTemplateSaveCmd singleSqlSlow = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd singleSqlQps = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd singleSqlRt = new MetricQueryTemplateSaveCmd();

        singleSqlSlow.setName("单个SQL查询慢查");
        singleSqlSlow.setSupportTypes(Arrays.asList(0));
        singleSqlSlow.setTags(Arrays.asList("dependency"));
        singleSqlSlow.setCombinatorialLogic("AND");
        singleSqlSlow.setBu("youzanyun");
        singleSqlSlow.setTriggerLevel("critical");
        singleSqlSlow.setPeriod(1);
        singleSqlSlow.setTimeUnit("m");
        singleSqlSlow.setContinuousCount(3);

        singleSqlQps.setName("单个SQL查询慢查@SQL查询QPS");
        singleSqlQps.setQueryMql("sql.qpm_by_sqlId{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"sqlId\"], sum>");
        singleSqlQps.setTargetTagName("appReporter");
        singleSqlQps.setDetectionMethod("THRESHOLD");
        singleSqlQps.setComparisonOperator("GTE");
        singleSqlQps.setRightVal(Double.valueOf(30));

        singleSqlRt.setName("单个SQL查询慢查@每分钟数据库执行RT");
        singleSqlRt.setQueryMql("mysql-client.rt.avg.by_app_sqlId_db{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"sqlId\"], sum>");
        singleSqlRt.setTargetTagName("appReporter");
        singleSqlRt.setDetectionMethod("THRESHOLD");
        singleSqlRt.setComparisonOperator("GTE");
        singleSqlRt.setRightVal(1000.0);

        singleSqlSlow.setQueryTemplateList(Arrays.asList(singleSqlQps, singleSqlRt));
//        System.out.println(JSON.toJSONString(singleSqlSlow, false));

        MetricTemplateSaveCmd singleSqlSlowSerious = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd singleSqlQpsSerious = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd singleSqlRtSerious = new MetricQueryTemplateSaveCmd();

        singleSqlSlowSerious.setName("单个SQL查询慢查");
        singleSqlSlowSerious.setSupportTypes(Arrays.asList(0));
        singleSqlSlowSerious.setTags(Arrays.asList("dependency"));
        singleSqlSlowSerious.setCombinatorialLogic("AND");
        singleSqlSlowSerious.setBu("youzanyun");
        singleSqlSlowSerious.setTriggerLevel("critical");
        singleSqlSlowSerious.setPeriod(1);
        singleSqlSlowSerious.setTimeUnit("m");
        singleSqlSlowSerious.setContinuousCount(2);

        singleSqlQpsSerious.setName("单个SQL查询慢查@SQL查询QPS");
        singleSqlQpsSerious.setQueryMql("sql.qpm_by_sqlId{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"sqlId\"], sum>");
        singleSqlQpsSerious.setTargetTagName("appReporter");
        singleSqlQpsSerious.setDetectionMethod("THRESHOLD");
        singleSqlQpsSerious.setComparisonOperator("GTE");
        singleSqlQpsSerious.setRightVal(Double.valueOf(30));

        singleSqlRtSerious.setName("单个SQL查询慢查@SQL查询平均RT");
        singleSqlRtSerious.setQueryMql("mysql-client.rt.avg.by_app_sqlId_db{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"sqlId\"], sum>");
        singleSqlRtSerious.setTargetTagName("appReporter");
        singleSqlRtSerious.setDetectionMethod("THRESHOLD");
        singleSqlRtSerious.setComparisonOperator("GTE");
        singleSqlRtSerious.setRightVal(1000.0);

        singleSqlSlowSerious.setQueryTemplateList(Arrays.asList(singleSqlQpsSerious, singleSqlRtSerious));
//        System.out.println(JSON.toJSONString(singleSqlSlowSerious, false));

        MetricTemplateSaveCmd sqlChange = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd sqlChangeQps = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd sqlChangeCount = new MetricQueryTemplateSaveCmd();

        sqlChange.setName("数据库SQL总体查询量突增");
        sqlChange.setSupportTypes(Arrays.asList(0));
        sqlChange.setTags(Arrays.asList("dependency"));
        sqlChange.setCombinatorialLogic("AND");
        sqlChange.setBu("youzanyun");
        sqlChange.setTriggerLevel("notice");
        sqlChange.setPeriod(1);
        sqlChange.setTimeUnit("m");
        sqlChange.setContinuousCount(3);

        sqlChangeQps.setName("数据库SQL总体查询量突增@每分钟数据库查询平均QPS");
        sqlChangeQps.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        sqlChangeQps.setTargetTagName("appReporter");
        sqlChangeQps.setDetectionMethod("THRESHOLD");
        sqlChangeQps.setComparisonOperator("GTE");
        sqlChangeQps.setRightVal(Double.valueOf(400));

        sqlChangeCount.setName("数据库SQL总体查询量突增@每分钟调用量变化");
        sqlChangeCount.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        sqlChangeCount.setTargetTagName("appReporter");
        sqlChangeCount.setDetectionMethod("CHANGE");
        sqlChangeCount.setComparisonStrategy("DAY_ON_DAY");
        sqlChangeCount.setComparisonOperator("INCREASE_GT");
        sqlChangeCount.setRightVal(200.0);


        sqlChange.setQueryTemplateList(Arrays.asList(sqlChangeQps, sqlChangeCount));

//        System.out.println(JSON.toJSONString(sqlChange, true));

        MetricTemplateSaveCmd sqlTest = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd sqlTestQuery = new MetricQueryTemplateSaveCmd();

        sqlTest.setName("数据库SQL测试RT");
        sqlTest.setSupportTypes(Arrays.asList(0));
        sqlTest.setTags(Arrays.asList("dependency"));
        sqlTest.setCombinatorialLogic("AND");
        sqlTest.setBu("youzanyun");
        sqlTest.setTriggerLevel("critical");
        sqlTest.setPeriod(1);
        sqlTest.setTimeUnit("m");
        sqlTest.setContinuousCount(1);

        sqlTestQuery.setName("数据库SQL测试RT@每分钟数据库查询平均QPS");
        sqlTestQuery.setQueryMql("mysql-client.max_rt_by_app_db_sqlId{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        sqlTestQuery.setTargetTagName("appReporter");
        sqlTestQuery.setDetectionMethod("THRESHOLD");
        sqlTestQuery.setComparisonOperator("GTE");
        sqlTestQuery.setRightVal(Double.valueOf(1));

        sqlTest.setQueryTemplateList(Arrays.asList(sqlTestQuery));
        System.out.println(JSON.toJSONString(sqlTest, false));


    }
}
