package top.baskbull.monitortest;

import com.alibaba.fastjson.JSON;
import top.baskbull.MetricQueryTemplateSaveCmd;
import top.baskbull.MetricTemplateSaveCmd;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/2/25 9:27 上午
 */
public class TestUseMetric {

    public static void main(String[] args) {
        MetricTemplateSaveCmd sqlSlow = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd sqlRtQuery = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd sqlQpsQuery = new MetricQueryTemplateSaveCmd();

        sqlSlow.setName("SQL查询慢查");
        sqlSlow.setSupportTypes(Arrays.asList(0));
        sqlSlow.setTags(Arrays.asList("dependency"));
        sqlSlow.setCombinatorialLogic("AND");
        sqlSlow.setBu("youzanyun");
        sqlSlow.setTriggerLevel("warning");
        sqlSlow.setPeriod(1);
        sqlSlow.setTimeUnit("m");
        sqlSlow.setContinuousCount(1);

        sqlRtQuery.setName("SQL查询慢查@SQL查询平均RT");
        sqlRtQuery.setQueryMql("mysql-client.rt.avg.by_app_sqlId_db{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        sqlRtQuery.setTargetTagName("appReporter");
        sqlRtQuery.setDetectionMethod("THRESHOLD");
        sqlRtQuery.setComparisonOperator("GTE");
        sqlRtQuery.setLeftVal(-1.0);
        sqlRtQuery.setRightVal(1.0);

        sqlQpsQuery.setName("SQL查询慢查@SQL查询QPS");
        sqlQpsQuery.setQueryMql("sql.qpm_by_app{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        sqlQpsQuery.setTargetTagName("appReporter");
        sqlQpsQuery.setDetectionMethod("THRESHOLD");
        sqlQpsQuery.setComparisonOperator("GTE");
        sqlQpsQuery.setLeftVal(-1.0);
        sqlQpsQuery.setRightVal(1.0);

        sqlSlow.setQueryTemplateList(Arrays.asList(sqlRtQuery, sqlQpsQuery));
        System.out.println(JSON.toJSONString(sqlSlow));
        System.out.println("-------------------------------");

        MetricTemplateSaveCmd API接口调用 = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd API接口调用QPM = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd 网关apirt查询测试 = new MetricQueryTemplateSaveCmd();

        API接口调用.setName("API接口调用");
        API接口调用.setSupportTypes(Arrays.asList(0));
        API接口调用.setTags(Arrays.asList("biz"));
        API接口调用.setCombinatorialLogic("AND");
        API接口调用.setBu("main");
        API接口调用.setTriggerLevel("critical");
        API接口调用.setPeriod(1);
        API接口调用.setTimeUnit("m");
        API接口调用.setContinuousCount(1);

        API接口调用QPM.setName("API接口调用@API接口调用QPM");
        API接口调用QPM.setQueryMql("bifrost-gateway.api.qpm_by_apiname{}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        API接口调用QPM.setTargetTagName("null");
        API接口调用QPM.setDetectionMethod("THRESHOLD");
        API接口调用QPM.setComparisonOperator("GTE");
        API接口调用QPM.setRightVal(Double.valueOf(1));

        网关apirt查询测试.setName("API接口调用@API接口调用RT");
        网关apirt查询测试.setQueryMql("bifrost-gateway.api.rt_by_apiname{}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[\"apiName\"], sum>");
        网关apirt查询测试.setTargetTagName("null");
        网关apirt查询测试.setDetectionMethod("THRESHOLD");
        网关apirt查询测试.setComparisonOperator("GTE");
        网关apirt查询测试.setRightVal(Double.valueOf(1));

        API接口调用.setQueryTemplateList(Arrays.asList(API接口调用QPM, 网关apirt查询测试));

        System.out.println(JSON.toJSONString(API接口调用));
        System.out.println("-------------------------------");

        MetricTemplateSaveCmd dbPool = new MetricTemplateSaveCmd();
        MetricQueryTemplateSaveCmd activeCon = new MetricQueryTemplateSaveCmd();
        MetricQueryTemplateSaveCmd userTIme = new MetricQueryTemplateSaveCmd();


        dbPool.setName("数据库连接池资源紧张");
        dbPool.setSupportTypes(Arrays.asList(0));
        dbPool.setTags(Arrays.asList("running_state"));
        dbPool.setCombinatorialLogic("OR");
        dbPool.setBu("youzanyun");
        dbPool.setTriggerLevel("critical");
        dbPool.setPeriod(1);
        dbPool.setTimeUnit("m");
        dbPool.setContinuousCount(1);

        activeCon.setName("数据库连接池资源紧张@单实例最大活跃连接数");
        activeCon.setQueryMql("druid-db-pool.db_connection_pool_max_activeCount{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        activeCon.setTargetTagName("appReporter");
        activeCon.setDetectionMethod("THRESHOLD");
        activeCon.setComparisonOperator("GTE");
        activeCon.setRightVal(Double.valueOf(1));

        userTIme.setName("数据库连接池资源紧张@连接使用时间");
        userTIme.setQueryMql("dbConn.useTime_max_by_dbUrl{appReporter=\"{{ appReporter }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>");
        userTIme.setTargetTagName("appReporter");
        userTIme.setDetectionMethod("THRESHOLD");
        userTIme.setComparisonOperator("GTE");
        userTIme.setRightVal(Double.valueOf(1));

        dbPool.setQueryTemplateList(Arrays.asList(activeCon, userTIme));

        System.out.println(JSON.toJSONString(dbPool));
        System.out.println("-------------------------------");

//        System.out.println("mmmms-SQL查询慢查告警");
//        System.out.println("title:");
//        System.out.println("-------------------------------");
//        System.out.println("SQL查询慢查-warning-[1]次\n触发原因:SQL查询QPS-触发值范围(92.00-92.00),SQL查询平均RT-触发值范围(5.89-5.89)\n");
//        System.out.println("content:");
//        System.out.println("-------------------------------");
//        System.out.println("告警对象:mmmms\n核心告警项:SQL查询慢查-warning-[1]次\n触发原因:SQL查询QPS-触发值范围(92.00-92.00),SQL查询平均RT-触发值范围(5.89-5.89)\n\n外部依赖告警项:SQL查询慢查-warning-[1]次\n触发原因:SQL查询QPS-触发值范围(92.00-92.00),SQL查询平均RT-触发值范围(5.89-5.89)\n\n");
        System.out.println("title:");
        System.out.println("mmmms-API接口调用-critical-[2404]次告警");
        System.out.println("content:");
//        System.out.println("告警对象:mmmms\n核心告警项:SQL查询慢查-warning-[1]次\n触发原因:SQL查询QPS——触发值范围(35.00-35.00),SQL查询平均RT——触发值范围(29.93-29.93)\n\n外部依赖告警项:SQL查询慢查-warning-[1]次\n触发原因:SQL查询QPS——触发值范围(35.00-35.00),SQL查询平均RT——触发值范围(29.93-29.93)\n\n");
//        System.out.println("告警对象:mmmms\n核心告警项:数据库连接池资源紧张-critical-[3]次\n触发原因:连接使用时间——触发值范围(8.42-55.98)\n\n运行状态告警项:数据库连接池资源紧张-critical-[3]次\n触发原因:连接使用时间——触发值范围(8.42-55.98)\n\n外部依赖告警项:SQL查询慢查-warning-[3]次\n触发原因:SQL查询QPS——触发值范围(15.00-120.00),SQL查询平均RT——触发值范围(5.37-8.53)\n\n最近发生的变更:变更事件:后端服务发布 时间:2022-02-25 10:07:46 详情:应用生产发布，变更内容：xxxx\n");
        System.out.println("告警对象:mmmms\n核心告警项:API接口调用-critical-[2404]次\n触发原因:API接口调用QPM——触发值范围(1.00-141567.00),API接口调用RT——触发值范围(3.00-16585157.00)\n\n业务告警项:API接口调用-critical-[2404]次\n触发原因:API接口调用QPM——触发值范围(1.00-141567.00),API接口调用RT——触发值范围(3.00-16585157.00)\n\n运行状态告警项:数据库连接池资源紧张-critical-[1]次\n触发原因:连接使用时间——触发值范围(9.35-9.35)\n\n外部依赖告警项:SQL查询慢查-warning-[1]次\n触发原因:SQL查询QPS——触发值范围(15.00-15.00),SQL查询平均RT——触发值范围(8.09-8.09)\n\n最近发生的变更:变更事件:后端服务发布 时间:2022-02-25 10:07:46 详情:应用生产发布，变更内容：xxxx\n");
    }
}
