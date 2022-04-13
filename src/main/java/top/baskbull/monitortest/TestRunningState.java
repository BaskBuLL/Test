package top.baskbull.monitortest;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/2/28 11:46 上午
 */
public class TestRunningState {

    public static void main(String[] args) {
        MetricTemplateSaveCmd jvm = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd fullGC = new MetricQueryTemplateSaveCmd();

        jvm.setName("应用单个容器FullGC频繁");
        jvm.setSupportTypes(Arrays.asList(0));
        jvm.setTags(Arrays.asList("running_state"));
        jvm.setCombinatorialLogic("AND");
        jvm.setBu("youzanyun");
        jvm.setTriggerLevel("notice");
        jvm.setPeriod(1);
        jvm.setTimeUnit("m");
        jvm.setContinuousCount(1);

        fullGC.setName("应用单个容器FullGC频繁@单实例每分钟FullGC次数");
        fullGC.setQueryMql("jvm_gc_count_sum{measuredObject=\"jvm.gc.old.trace\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        fullGC.setTargetTagName("appReporter");
        fullGC.setDetectionMethod("THRESHOLD");
        fullGC.setComparisonOperator("GTE");
        fullGC.setRightVal(Double.valueOf(10));

        jvm.setQueryTemplateList(Arrays.asList(fullGC));

//        System.out.println(JSON.toJSONString(jvm, false));

        MetricTemplateSaveCmd dubboQueue = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd maxQueue = new MetricQueryTemplateSaveCmd();

        dubboQueue.setName("应用Dubbo线程池任务队列积压");
        dubboQueue.setSupportTypes(Arrays.asList(0));
        dubboQueue.setTags(Arrays.asList("running_state"));
        dubboQueue.setCombinatorialLogic("AND");
        dubboQueue.setBu("youzanyun");
        dubboQueue.setTriggerLevel("critical");
        dubboQueue.setPeriod(1);
        dubboQueue.setTimeUnit("m");
        dubboQueue.setContinuousCount(3);

        maxQueue.setName("应用Dubbo线程池任务队列积压@单实例线程池最大队列");
        maxQueue.setQueryMql("java_thread_pool_monitoring_status_max{measurement=\"queueSize\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, max> | tag_aggr<[], max>");
        maxQueue.setTargetTagName("appReporter");
        maxQueue.setDetectionMethod("THRESHOLD");
        maxQueue.setComparisonOperator("GTE");
        maxQueue.setRightVal(Double.valueOf(5));

        dubboQueue.setQueryTemplateList(Arrays.asList(maxQueue));
//        System.out.println(JSON.toJSONString(dubboQueue, false));

        MetricTemplateSaveCmd maxThreadPool = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd maxThread = new MetricQueryTemplateSaveCmd();

        maxThreadPool.setName("应用Dubbo线程池最大活跃线程数高");
        maxThreadPool.setSupportTypes(Arrays.asList(0));
        maxThreadPool.setTags(Arrays.asList("running_state"));
        maxThreadPool.setCombinatorialLogic("AND");
        maxThreadPool.setBu("youzanyun");
        maxThreadPool.setTriggerLevel("warning");
        maxThreadPool.setPeriod(1);
        maxThreadPool.setTimeUnit("m");
        maxThreadPool.setContinuousCount(3);

        maxThread.setName("应用Dubbo线程池最大活跃线程数高@单实例最大活跃线程数");
        maxThread.setQueryMql("java_thread_pool_monitoring_status_max{measurement=\"activeCount\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, max> | tag_aggr<[], max>");
        maxThread.setTargetTagName("appReporter");
        maxThread.setDetectionMethod("THRESHOLD");
        maxThread.setComparisonOperator("GTE");
        maxThread.setRightVal(Double.valueOf(100));

        maxThreadPool.setQueryTemplateList(Arrays.asList(maxThread));
//        System.out.println(JSON.toJSONString(maxThreadPool, false));

        MetricTemplateSaveCmd tomcatThread = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd tomcatActive = new MetricQueryTemplateSaveCmd();

        tomcatThread.setName("应用Tomcat线程池最大活跃线程数高");
        tomcatThread.setSupportTypes(Arrays.asList(0));
        tomcatThread.setTags(Arrays.asList("running_state"));
        tomcatThread.setCombinatorialLogic("AND");
        tomcatThread.setBu("youzanyun");
        tomcatThread.setTriggerLevel("critical");
        tomcatThread.setPeriod(1);
        tomcatThread.setTimeUnit("m");
        tomcatThread.setContinuousCount(3);

        tomcatActive.setName("应用Tomcat线程池最大活跃线程数高@单实例Tomcat容器最大活跃线程数");
        tomcatActive.setQueryMql("cloud-http-container.pool_status_max{measurement=\"activeCount\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        tomcatActive.setTargetTagName("appReporter");
        tomcatActive.setDetectionMethod("THRESHOLD");
        tomcatActive.setComparisonOperator("GTE");
        tomcatActive.setRightVal(Double.valueOf(150));

        tomcatThread.setQueryTemplateList(Arrays.asList(tomcatActive));
//        System.out.println(JSON.toJSONString(tomcatThread, false));

        MetricTemplateSaveCmd httpClientResource = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientActive = new MetricQueryTemplateSaveCmd();

        httpClientResource.setName("应用统一接出HttpClient连接池资源将耗尽");
        httpClientResource.setSupportTypes(Arrays.asList(0));
        httpClientResource.setTags(Arrays.asList("running_state"));
        httpClientResource.setCombinatorialLogic("AND");
        httpClientResource.setBu("youzanyun");
        httpClientResource.setTriggerLevel("critical");
        httpClientResource.setPeriod(1);
        httpClientResource.setTimeUnit("m");
        httpClientResource.setContinuousCount(3);

        httpClientActive.setName("应用统一接出HttpClient连接池资源将耗尽@单实例接出HttpClient连接池活跃连接");
        httpClientActive.setQueryMql("cloud-http-client.pool_measurement_count{measurement=\"leased\",appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientActive.setTargetTagName("appReporter");
        httpClientActive.setDetectionMethod("THRESHOLD");
        httpClientActive.setComparisonOperator("GTE");
        httpClientActive.setRightVal(Double.valueOf(75));

        httpClientResource.setQueryTemplateList(Arrays.asList(httpClientActive));
//        System.out.println(JSON.toJSONString(httpClientResource, false));

        MetricTemplateSaveCmd httpClientGetConSlow = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd httpClientCost = new MetricQueryTemplateSaveCmd();

        httpClientGetConSlow.setName("应用统一接出HttpClient获取连接慢");
        httpClientGetConSlow.setSupportTypes(Arrays.asList(0));
        httpClientGetConSlow.setTags(Arrays.asList("running_state"));
        httpClientGetConSlow.setCombinatorialLogic("AND");
        httpClientGetConSlow.setBu("youzanyun");
        httpClientGetConSlow.setTriggerLevel("critical");
        httpClientGetConSlow.setPeriod(1);
        httpClientGetConSlow.setTimeUnit("m");
        httpClientGetConSlow.setContinuousCount(3);

        httpClientCost.setName("应用统一接出HttpClient获取连接慢@单实例获取接出连接平均耗时");
        httpClientCost.setQueryMql("cloud-http-client.connect_avg_rt{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        httpClientCost.setTargetTagName("appReporter");
        httpClientCost.setDetectionMethod("THRESHOLD");
        httpClientCost.setComparisonOperator("GTE");
        httpClientCost.setRightVal(Double.valueOf(500));

        httpClientGetConSlow.setQueryTemplateList(Arrays.asList(httpClientCost));
//        System.out.println(JSON.toJSONString(httpClientGetConSlow, true));


        MetricTemplateSaveCmd openSdkSlow = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd openSdkCost = new MetricQueryTemplateSaveCmd();

        openSdkSlow.setName("有赞云网关sdk获取连接慢");
        openSdkSlow.setSupportTypes(Arrays.asList(0));
        openSdkSlow.setTags(Arrays.asList("running_state"));
        openSdkSlow.setCombinatorialLogic("AND");
        openSdkSlow.setBu("youzanyun");
        openSdkSlow.setTriggerLevel("critical");
        openSdkSlow.setPeriod(1);
        openSdkSlow.setTimeUnit("m");
        openSdkSlow.setContinuousCount(3);

        openSdkCost.setName("有赞云网关sdk获取连接慢@单实例获取open-sdk连接平均耗时");
        openSdkCost.setTargetTagName("appReporter");
        openSdkCost.setDetectionMethod("THRESHOLD");
        openSdkCost.setComparisonOperator("GTE");
        openSdkCost.setRightVal(Double.valueOf(200));

        openSdkSlow.setQueryTemplateList(Arrays.asList(openSdkCost));
//        System.out.println(JSON.toJSONString(openSdkSlow, true));

        MetricTemplateSaveCmd dbResource = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd dbCost = new MetricQueryTemplateSaveCmd();

        dbResource.setName("应用数据库连接池资源将耗尽");
        dbResource.setSupportTypes(Arrays.asList(0));
        dbResource.setTags(Arrays.asList("running_state"));
        dbResource.setCombinatorialLogic("AND");
        dbResource.setBu("youzanyun");
        dbResource.setTriggerLevel("critical");
        dbResource.setPeriod(1);
        dbResource.setTimeUnit("m");
        dbResource.setContinuousCount(3);

        dbCost.setName("应用数据库连接池资源将耗尽@单实例最大活跃连接数");
        dbCost.setQueryMql("druid-db-pool.db_connection_pool_max_activeCount{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        dbCost.setTargetTagName("appReporter");
        dbCost.setDetectionMethod("THRESHOLD");
        dbCost.setComparisonOperator("GTE");
        dbCost.setRightVal(Double.valueOf(15));

        dbResource.setQueryTemplateList(Arrays.asList(dbCost));
//        System.out.println(JSON.toJSONString(dbResource, false));

        MetricTemplateSaveCmd dbGetCon = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd dbGetConCost = new MetricQueryTemplateSaveCmd();

        dbGetCon.setName("应用数据库连接获取耗时高");
        dbGetCon.setSupportTypes(Arrays.asList(0));
        dbGetCon.setTags(Arrays.asList("running_state"));
        dbGetCon.setCombinatorialLogic("AND");
        dbGetCon.setBu("youzanyun");
        dbGetCon.setTriggerLevel("critical");
        dbGetCon.setPeriod(1);
        dbGetCon.setTimeUnit("m");
        dbGetCon.setContinuousCount(3);

        dbGetConCost.setName("应用数据库连接获取耗时高@单实例连接平均耗时");
        dbGetConCost.setQueryMql("druid-db.getconnect.time.by_app_poolName_env{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        dbGetConCost.setTargetTagName("appReporter");
        dbGetConCost.setDetectionMethod("THRESHOLD");
        dbGetConCost.setComparisonOperator("GTE");
        dbGetConCost.setRightVal(Double.valueOf(500));

        dbGetCon.setQueryTemplateList(Arrays.asList(dbGetConCost));
        System.out.println(JSON.toJSONString(dbGetCon, false));
    }
}
