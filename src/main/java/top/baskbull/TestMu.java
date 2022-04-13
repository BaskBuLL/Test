package top.baskbull;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhuo
 * @date 2022/2/17 1:35 下午
 */
public class TestMu {

    public static void main(String[] args) {
//        String s = "sql.qpm_by_app{status!=\"success\",appReporter=\"{{ aaa }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>";



        String s = "bifrost-push-admin.msg-push.qpm_by_biztype{clientId=\"{{ clientId }}\"}${timeRange:TIME_RANGE} | time_aggr<${slidingWindow:SLIDING_WINDOW}, sum> | tag_aggr<[], sum>";
        Template template = Mustache.compiler().compile(s);
        Map<String, String> data = new HashMap<>();
        data.put("clientId", "40d20e20d777699564");
//        System.out.println(template.execute(data));

        String json = "{\"is_pre\":false}";

//        System.out.println(JSON.parseObject(json, IsPre.class));

        String json1 = "{\"www\":[],\"qqq\":[\"1\",\"2\"]}";
        Map<String, List<String>> map = JSON.parseObject(json1, Map.class);
        System.out.println(map);
        List<String> www = map.get("www");
        System.out.println(www);
        System.out.println(www == null);

        Map<String, Object> mmm = Maps.newHashMapWithExpectedSize(4);
        mmm.put("tag",www);
        System.out.println(mmm);
    }
}
