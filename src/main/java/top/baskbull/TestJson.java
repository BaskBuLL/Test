package top.baskbull;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author liuzhuo
 * @date 2021/11/28 10:33 下午
 */
public class TestJson {

    public static void main(String[] args) {
        String json1 = "{\n" +
                "    \"mmmms\": {\n" +
                "        \"dev\": {\n" +
                "            \"ip\": \"10.60.207.0\",\n" +
                "            \"password\": \"ue7ByZrg9hZmwQopA0hyhBe1\",\n" +
                "            \"dbUser\": \"youzanyun\",\n" +
                "            \"port\": \"3306\",\n" +
                "            \"dbName\": \"mmmms\"\n" +
                "        },\n" +
                "        \"prod\": {\n" +
                "            \"ip\": \"10.60.106.46\",\n" +
                "            \"password\": \"QTHOgCAYOpttyLI5ynfUd4Ag\",\n" +
                "            \"dbUser\": \"youzanyun\",\n" +
                "            \"port\": \"3306\",\n" +
                "            \"dbName\": \"mmmms\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"testSpecialApp\": {\n" +
                "        \"dev\": {\n" +
                "            \"ip\": \"127.0.0.1\",\n" +
                "            \"password\": \"123\",\n" +
                "            \"dbUser\": \"zhuo\",\n" +
                "            \"port\": \"3306\",\n" +
                "            \"dbName\": \"test\"\n" +
                "        },\n" +
                "        \"prod\": {\n" +
                "            \"ip\": \"127.0.0.1\",\n" +
                "            \"password\": \"123\",\n" +
                "            \"dbUser\": \"hongling\",\n" +
                "            \"port\": \"3306\",\n" +
                "            \"dbName\": \"test\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
//        Map<String, Map<String, JSONObject>> map1 = JSON.parseObject(json1, Map.class);
//        String name = "mmmms";
//        String env = "devw";
//        Map<String, JSONObject> appMap = map1.get(name);
//        if(appMap != null && !appMap.isEmpty()){
//            JSONObject jsonObject = appMap.get(env);
//            if(jsonObject != null){
//                SpecialAppInfo specialAppInfo = jsonObject.toJavaObject(SpecialAppInfo.class);
//                System.out.println(specialAppInfo);
//            }
//        }
//        Map<String, Map<String, Object>> map1 = JSON.parseObject(json1, Map.class);
//        String name = "mmmms";
//        String env = "devw";
//        Map<String, Object> appMap = map1.get(name);
//        if(appMap != null && !appMap.isEmpty()){
//            Object o = appMap.get(env);
//            if(o != null){
//                SpecialAppInfo specialAppInfo = JSON.parseObject(JSON.toJSONString(o), SpecialAppInfo.class);
//                System.out.println(specialAppInfo);
//            }
//        }
//        String zone = "dev";
//        System.out.println(dev2qa(zone));
//        System.out.println(zone);

        Phone phone = new Phone();
        phone.setKdtId(123L);
        People people = new People();
        people.phone = phone;
        people.name = "123";
        people.age = 3;
        System.out.println(people);
        System.out.println(JSON.toJSONString(people));

        Map<String, List<String>> map = new HashMap<>();
        List<String> tagList = new ArrayList<>();
        tagList.add("标签1");
        tagList.add("标签2");
        map.put("/a/b/运维规范.md", tagList);
        String jsonString = JSON.toJSONString(map);
        System.out.println(jsonString);
        System.out.println("--------");
        Map<String, List<String>> parseObject = JSON.parseObject(jsonString, Map.class);
        System.out.println(parseObject);

        String s = "{\"mmmms\":[\"ALI.001\",\"ALI.002\"],\"test\":[\"ALT.001\"]}";

        System.out.println(JSON.parseObject(s, Map.class));

        String mapp = "{\n" +
                "    \"有赞云介绍.md\":[\n" +
                "        \"介绍\",\n" +
                "        \"有赞云\"\n" +
                "    ]\n" +
                "}";
        Map<String, List<String>> tagMap = JSON.parseObject(mapp, Map.class);

        System.out.println(tagMap);
        System.out.println("www.md".split(".md")[0]);


        String ssss = "\\\\{xxxx";
        JSON.parseObject(ssss);
    }

    private static String dev2qa(String zone) {
        if (Objects.equals(zone, "dev")) {
            zone = "qa";
        }
        return zone;
    }
}
