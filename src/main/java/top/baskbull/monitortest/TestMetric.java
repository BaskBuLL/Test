//package top.baskbull;
//
//import com.alibaba.fastjson.JSON;
//import com.samskivert.mustache.Mustache;
//import com.samskivert.mustache.Template;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author liuzhuo
// * @date 2022/2/20 6:16 下午
// */
//public class TestMetric {
//
//    public static void main(String[] args) {
//        MetricTemplateSaveCmd save1 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query1 = new MetricQueryTemplateSaveCmd();
//
//        save1.setName("SQl请求失败次数");
//        save1.setSupportTypes(Arrays.asList(0, 1));
//        save1.setTags(Arrays.asList("db"));
//        save1.setCombinatorialLogic("AND");
//        save1.setBu("youzanyun");
//        save1.setTriggerLevel("warning");
//        save1.setPeriod(1);
//        save1.setTimeUnit("m");
//        save1.setContinuousCount(2);
//
//        query1.setName("SQL请求失败次数查询");
//        query1.setQueryMql("sql.qpm_by_app{status!=\"success\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query1.setTargetTagName("appReporter");
//        query1.setDetectionMethod("THRESHOLD");
////        query1.setComparisonStrategy("");
//        query1.setComparisonOperator("GTE");
////        query1.setLeftVal();
//        query1.setRightVal(10);
//        save1.setQueryTemplateList(Arrays.asList(query1));
//
////        System.out.println(JSON.toJSONString(save1, true));
////        System.out.println("***************");
//
//        MetricTemplateSaveCmd save2 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query2 = new MetricQueryTemplateSaveCmd();
//
//        save2.setName("扩展点请求失败次数");
//        save2.setSupportTypes(Arrays.asList(0, 1));
//        save2.setTags(Arrays.asList("扩展点"));
//        save2.setCombinatorialLogic("AND");
//        save2.setBu("main");
//        save2.setTriggerLevel("warning");
//        save2.setPeriod(1);
//        save2.setTimeUnit("m");
//        save2.setContinuousCount(2);
//
//        query2.setName("扩展点请求失败次数查询");
//        query2.setQueryMql("columbus.biz_ext_qpm{resultType=\"EXCEPTION\",appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query2.setTargetTagName("appName");
//        query2.setDetectionMethod("THRESHOLD");
//        query2.setComparisonOperator("GTE");
//        query2.setRightVal(10);
//        save2.setQueryTemplateList(Arrays.asList(query2));
//
////        System.out.println(JSON.toJSONString(save2, true));
//
//        MetricTemplateSaveCmd save3 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query3 = new MetricQueryTemplateSaveCmd();
//
//        save3.setName("扩展点QPM");
//        save3.setSupportTypes(Arrays.asList(0, 1));
//        save3.setTags(Arrays.asList("扩展点"));
//        save3.setCombinatorialLogic("AND");
//        save3.setBu("main");
//        save3.setTriggerLevel("warning");
//        save3.setPeriod(1);
//        save3.setTimeUnit("m");
//        save3.setContinuousCount(2);
//
//        query3.setName("扩展点QPM查询");
//        query3.setQueryMql("columbus.biz_ext_qpm{appName=\"{{ appName }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query3.setTargetTagName("appName");
//        query3.setDetectionMethod("THRESHOLD");
//        query3.setComparisonOperator("GTE");
//        query3.setRightVal(10000);
//        save3.setQueryTemplateList(Arrays.asList(query3));
//
////        System.out.println(JSON.toJSONString(save3, true));
//
//        MetricTemplateSaveCmd save4 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query4 = new MetricQueryTemplateSaveCmd();
//
//        save4.setName("网关API请求错误次数");
//        save4.setSupportTypes(Arrays.asList(0, 1));
//        save4.setTags(Arrays.asList("网关"));
//        save4.setCombinatorialLogic("AND");
//        save4.setBu("main");
//        save4.setTriggerLevel("warning");
//        save4.setPeriod(1);
//        save4.setTimeUnit("m");
//        save4.setContinuousCount(2);
//
//        query4.setName("网关API请求错误次数查询");
//        query4.setQueryMql("bifrost-gateway.api.qpm_by_apiname{bizCode!=\"200\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
////        query4.setTargetTagName("appName");
//        query4.setDetectionMethod("THRESHOLD");
//        query4.setComparisonOperator("GTE");
//        query4.setRightVal(10000);
//        save4.setQueryTemplateList(Arrays.asList(query4));
//
////        System.out.println(JSON.toJSONString(save4, true));
//
//        MetricTemplateSaveCmd save5 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query5 = new MetricQueryTemplateSaveCmd();
//
//        save5.setName("消息推送失败次数");
//        save5.setSupportTypes(Arrays.asList(0, 1));
//        save5.setTags(Arrays.asList("消息推送"));
//        save5.setCombinatorialLogic("AND");
//        save5.setBu("main");
//        save5.setTriggerLevel("warning");
//        save5.setPeriod(1);
//        save5.setTimeUnit("m");
//        save5.setContinuousCount(2);
//
//        query5.setName("消息推送失败次数查询");
//        query5.setQueryMql("bifrost-push-admin.msg-push.qpm_by_biztype{consumeStatus=\"Failed\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
////        query4.setTargetTagName("appName");
//        query5.setDetectionMethod("THRESHOLD");
//        query5.setComparisonOperator("GTE");
//        query5.setRightVal(10000);
//        save5.setQueryTemplateList(Arrays.asList(query5));
//
////        System.out.println(JSON.toJSONString(save5, true));
//
//        MetricTemplateSaveCmd save6 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query6 = new MetricQueryTemplateSaveCmd();
//
//        save6.setName("接出请求失败次数");
//        save6.setSupportTypes(Arrays.asList(0, 1));
//        save6.setTags(Arrays.asList("接出"));
//        save6.setCombinatorialLogic("AND");
//        save6.setBu("youzanyun");
//        save6.setTriggerLevel("warning");
//        save6.setPeriod(1);
//        save6.setTimeUnit("m");
//        save6.setContinuousCount(2);
//
//        query6.setName("接出请求失败次数查询");
//        query6.setQueryMql("cloud-http-client.request_fail_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query6.setTargetTagName("appReporter");
//        query6.setDetectionMethod("THRESHOLD");
//        query6.setComparisonOperator("GTE");
//        query6.setRightVal(100);
//        save6.setQueryTemplateList(Arrays.asList(query6));
//
////        System.out.println(JSON.toJSONString(save6, true));
//
//        MetricTemplateSaveCmd save7 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query7 = new MetricQueryTemplateSaveCmd();
//
//        save7.setName("MySQL连接池最大活跃连接数");
//        save7.setSupportTypes(Arrays.asList(0, 1));
//        save7.setTags(Arrays.asList("db"));
//        save7.setCombinatorialLogic("AND");
//        save7.setBu("youzanyun");
//        save7.setTriggerLevel("warning");
//        save7.setPeriod(1);
//        save7.setTimeUnit("m");
//        save7.setContinuousCount(2);
//
//        query7.setName("MySQL连接池最大活跃连接数");
//        query7.setQueryMql("druid-db-pool.db_connection_pool_max_activeCount{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query7.setTargetTagName("appReporter");
//        query7.setDetectionMethod("THRESHOLD");
//        query7.setComparisonOperator("GTE");
//        query7.setRightVal(30);
//        save7.setQueryTemplateList(Arrays.asList(query7));
//
////        System.out.println(JSON.toJSONString(save7, true));
//
//
//        MetricTemplateSaveCmd save8 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query8 = new MetricQueryTemplateSaveCmd();
//
//        save8.setName("接出连接池pending数");
//        save8.setSupportTypes(Arrays.asList(0, 1));
//        save8.setTags(Arrays.asList("接出"));
//        save8.setCombinatorialLogic("AND");
//        save8.setBu("youzanyun");
//        save8.setTriggerLevel("warning");
//        save8.setPeriod(1);
//        save8.setTimeUnit("m");
//        save8.setContinuousCount(2);
//
//        query8.setName("接出连接池pending数查询");
//        query8.setQueryMql("cloud-http-client.pool_measurement_count{measurement=\"pending\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query8.setTargetTagName("appReporter");
//        query8.setDetectionMethod("THRESHOLD");
//        query8.setComparisonOperator("GTE");
//        query8.setRightVal(1);
//        save8.setQueryTemplateList(Arrays.asList(query8));
//
////        System.out.println(JSON.toJSONString(save8, true));
//
//        MetricTemplateSaveCmd save9 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query9 = new MetricQueryTemplateSaveCmd();
//
//        save9.setName("FullGC次数");
//        save9.setSupportTypes(Arrays.asList(0, 1));
//        save9.setTags(Arrays.asList("JVM"));
//        save9.setCombinatorialLogic("AND");
//        save9.setBu("youzanyun");
//        save9.setTriggerLevel("warning");
//        save9.setPeriod(1);
//        save9.setTimeUnit("m");
//        save9.setContinuousCount(2);
//
//        query9.setName("FullGC次数查询");
//        query9.setQueryMql("jvm_gc_count_sum{measuredObject=\"jvm.gc.old.trace\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query9.setTargetTagName("appReporter");
//        query9.setDetectionMethod("THRESHOLD");
//        query9.setComparisonOperator("GTE");
//        query9.setRightVal(2);
//        save9.setQueryTemplateList(Arrays.asList(query9));
//
////        System.out.println(JSON.toJSONString(save9, true));
//
//        MetricTemplateSaveCmd save10 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query10 = new MetricQueryTemplateSaveCmd();
//
//        save10.setName("网关请求QPM");
//        save10.setSupportTypes(Arrays.asList(0, 1));
//        save10.setTags(Arrays.asList("网关"));
//        save10.setCombinatorialLogic("AND");
//        save10.setBu("youzanyun");
//        save10.setTriggerLevel("warning");
//        save10.setPeriod(1);
//        save10.setTimeUnit("m");
//        save10.setContinuousCount(2);
//
//        query10.setName("网关请求QPM查询");
//        query10.setQueryMql("cloud-open-sdk.request_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query10.setTargetTagName("appReporter");
//        query10.setDetectionMethod("THRESHOLD");
//        query10.setComparisonOperator("GTE");
//        query10.setRightVal(10000);
//        save10.setQueryTemplateList(Arrays.asList(query10));
//
////        System.out.println(JSON.toJSONString(save10, true));
//
//        MetricTemplateSaveCmd save11 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query11 = new MetricQueryTemplateSaveCmd();
//
//        save11.setName("网关请求失败次数");
//        save11.setSupportTypes(Arrays.asList(0, 1));
//        save11.setTags(Arrays.asList("网关"));
//        save11.setCombinatorialLogic("AND");
//        save11.setBu("youzanyun");
//        save11.setTriggerLevel("warning");
//        save11.setPeriod(1);
//        save11.setTimeUnit("m");
//        save11.setContinuousCount(2);
//
//        query11.setName("网关请求失败次数查询");
//        query11.setQueryMql("cloud-open-sdk.request_not200_qpm{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query11.setTargetTagName("appReporter");
//        query11.setDetectionMethod("THRESHOLD");
//        query11.setComparisonOperator("GTE");
//        query11.setRightVal(100);
//        save11.setQueryTemplateList(Arrays.asList(query11));
//
////        System.out.println(JSON.toJSONString(save11, true));
//
//        MetricTemplateSaveCmd save12 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query12 = new MetricQueryTemplateSaveCmd();
//
//        save12.setName("网关请求平均RT");
//        save12.setSupportTypes(Arrays.asList(0, 1));
//        save12.setTags(Arrays.asList("网关"));
//        save12.setCombinatorialLogic("AND");
//        save12.setBu("youzanyun");
//        save12.setTriggerLevel("warning");
//        save12.setPeriod(1);
//        save12.setTimeUnit("m");
//        save12.setContinuousCount(2);
//
//        query12.setName("网关请求平均RT查询");
//        query12.setQueryMql("cloud-open-sdk.request_avg_rt{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query12.setTargetTagName("appReporter");
//        query12.setDetectionMethod("THRESHOLD");
//        query12.setComparisonOperator("GTE");
//        query12.setRightVal(5000);
//        save12.setQueryTemplateList(Arrays.asList(query12));
//
////        System.out.println(JSON.toJSONString(save12, true));
//
//        MetricTemplateSaveCmd save13 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query13 = new MetricQueryTemplateSaveCmd();
//
//        save13.setName("接出请求平均RT");
//        save13.setSupportTypes(Arrays.asList(0, 1));
//        save13.setTags(Arrays.asList("接出"));
//        save13.setCombinatorialLogic("AND");
//        save13.setBu("youzanyun");
//        save13.setTriggerLevel("warning");
//        save13.setPeriod(1);
//        save13.setTimeUnit("m");
//        save13.setContinuousCount(2);
//
//        query13.setName("接出请求平均RT查询");
//        query13.setQueryMql("cloud-http-client.request_avg_rt{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query13.setTargetTagName("appReporter");
//        query13.setDetectionMethod("THRESHOLD");
//        query13.setComparisonOperator("GTE");
//        query13.setRightVal(3000);
//        save13.setQueryTemplateList(Arrays.asList(query13));
//
////        System.out.println(JSON.toJSONString(save13, true));
//
//        MetricTemplateSaveCmd save14 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query14 = new MetricQueryTemplateSaveCmd();
//
//        save14.setName("SQL请求平均RT");
//        save14.setSupportTypes(Arrays.asList(0, 1));
//        save14.setTags(Arrays.asList("db"));
//        save14.setCombinatorialLogic("AND");
//        save14.setBu("youzanyun");
//        save14.setTriggerLevel("warning");
//        save14.setPeriod(1);
//        save14.setTimeUnit("m");
//        save14.setContinuousCount(2);
//
//        query14.setName("SQL请求平均RT查询");
//        query14.setQueryMql("mysql-client.rt.avg.by_app_sqlId_db{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query14.setTargetTagName("appReporter");
//        query14.setDetectionMethod("THRESHOLD");
//        query14.setComparisonOperator("GTE");
//        query14.setRightVal(1000);
//        save14.setQueryTemplateList(Arrays.asList(query14));
//
////        System.out.println(JSON.toJSONString(save14, true));
//
//
//        MetricTemplateSaveCmd save15 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query15 = new MetricQueryTemplateSaveCmd();
//
//        save15.setName("SQL请求QPS");
//        save15.setSupportTypes(Arrays.asList(0, 1));
//        save15.setTags(Arrays.asList("db"));
//        save15.setCombinatorialLogic("AND");
//        save15.setBu("youzanyun");
//        save15.setTriggerLevel("warning");
//        save15.setPeriod(1);
//        save15.setTimeUnit("m");
//        save15.setContinuousCount(2);
//
//        query15.setName("SQL请求QPS查询");
//        query15.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query15.setTargetTagName("appReporter");
//        query15.setDetectionMethod("THRESHOLD");
//        query15.setComparisonOperator("GTE");
//        query15.setRightVal(1000);
//        save15.setQueryTemplateList(Arrays.asList(query15));
//
////        System.out.println(JSON.toJSONString(save15, true));
//
//        MetricTemplateSaveCmd save16 = new MetricTemplateSaveCmd();
//        MetricQueryTemplateSaveCmd query16 = new MetricQueryTemplateSaveCmd();
//
//        save16.setName("HTTP线程池最大活跃数量");
//        save16.setSupportTypes(Arrays.asList(0, 1));
//        save16.setTags(Arrays.asList("tomcat"));
//        save16.setCombinatorialLogic("AND");
//        save16.setBu("youzanyun");
//        save16.setTriggerLevel("warning");
//        save16.setPeriod(1);
//        save16.setTimeUnit("m");
//        save16.setContinuousCount(2);
//
//        query16.setName("HTTP线程池最大活跃数量查询");
//        query16.setQueryMql("cloud-http-container.threadpool_measurement_avg{measurement=\"activeCount\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
//        query16.setTargetTagName("appReporter");
//        query16.setDetectionMethod("THRESHOLD");
//        query16.setComparisonOperator("GTE");
//        query16.setRightVal(20);
//        save16.setQueryTemplateList(Arrays.asList(query16));
//
//        System.out.println(JSON.toJSONString(save16, true));
//
//        System.out.println("----------------------");
//        Template template = Mustache.compiler().compile(query12.getQueryMql());
//        Map<String, String> data = new HashMap<>();
//        data.put(query12.getTargetTagName(), "dennis-chain-baihuo");
//        System.out.println(template.execute(data));
//
//
//    }
//}
