package top.baskbull.json;

import org.springframework.beans.BeanUtils;

import java.util.Arrays;

/**
 * @author liuzhuo
 * @date 2022/1/17 7:34 下午
 */
public class TestJson {

    public static void main(String[] args) {
//        String s = "{\"noticeTrigger\":{\"continuingTimes\":1,\"comparisons\":[{\"queryName\":\"string\",\"operator\":\"GT\",\"value\":{\"start\":0,\"end\":9999}}],\"notifyChannels\":[\"WEB_HOOK\"]},\"name\":\"dennis-chain-SQL失败次数告警\",\"creator\":\"刘卓\",\"owningApp\":\"dennis-chain\",\"description\":\"有赞云监控告警，请勿修改\",\"metricQueries\":[{\"name\":\"string\",\"rawQuery\":\"mysql-client.crud.failed.by_app_db_type_sqlId{appReporter=\"dennis-chain\"}${timeRange:TIME_RANGE} | time_aggr&lt;${slidingWindow:SLIDING_WINDOW}, sum&gt; | tag_aggr&lt;[], sum&gt;\",\"detectionMethod\":\"THRESHOLD\"}],\"evaluationWindow\":{\"len\":1,\"unit\":\"m\"},\"combinatorialLogic\":\"AND\",\"notifyingSettings\":{\"notifyGroupIds\":[36],\"effectiveTimeRanges\":[{\"start\":\"00:00:00\",\"end\":\"23:59:59\"}]}}";
//        MonitorCreateDTO monitorCreateDTO = JSON.parseObject(s, MonitorCreateDTO.class);
//        System.out.println(monitorCreateDTO);

//        TestDO testDO = new TestDO();
//
//        Set<String> sql = new HashSet<>();
//        sql.add("select * from student");
//        sql.add("select www from s");
//
//        System.out.println(JSON.toJSONString(sql));

//        TestDO testDO = new TestDO();
//        testDO.setIdList("[1,2,3]");
//        Test test = new Test();
//        BeanUtils.copyProperties(testDO, test);
//        System.out.println(test);
//        test.setIdList(JSON.parseObject(testDO.getIdList(), List.class));
//        System.out.println(test);

        TestDO testDO = new TestDO();
        testDO.setIdList(Arrays.asList(1L, 2L, 3L));
        Test test = new Test();
        BeanUtils.copyProperties(testDO, test);
        System.out.println(test);
//        test.setIdList(JSON.parseObject(testDO.getIdList(), List.class));
//        System.out.println(test);
    }
}
