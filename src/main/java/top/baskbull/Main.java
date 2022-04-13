package top.baskbull;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        Integer i = null;
//        switch (i){
//            case 1 :
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            default:
//                System.out.println("null");
//        }
//        Base base = new BaseImpl();
//        base.print3();
//        People p = new People();
//        p.setAge(1);
//        p.setName("xiaoming");
//        Phone phone = new Phone();
//        phone.setAppId("100003224");
//        phone.setStatus(6);
//        phone.setBusinessType(1);
//        phone.setAccountType(2);
//        phone.setKdtId(55326404L);
//        p.setPhone(phone);
//        System.out.println(JSON.toJSONString(p));
//        Date date = new Date();
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        calendar.add(Calendar.YEAR, -10);
//        Date time = calendar.getTime();
//        System.out.println(date.getTime() - time.getTime());
////        for (int i = 0; i < 12; i++) {
////            calendar.add(Calendar.MONTH, -1);
////
//////            System.out.println(calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1));
////            System.out.println(TimeUtils.date2String(calendar.getTime(), TimeUtils.TimeFormat.YYYY_MM));
////        }
//        Double d = 0.6666666;
//        int i = (int) (d*100) ;
//        System.out.println(i + "%");

//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
//        SimpleDateFormat dateFormat2 = new SimpleDateFormat("MM");
//        System.out.println(dateFormat.format(time));
//        System.out.println(dateFormat2.format(time));
        int ms = 1000 * 60 * 60 * 30;

//        System.out.println(ms / (1000 * 60 * 60));
//        System.out.println((((15-16) * 100) / 16) + "%");
//
//        Long i = 1L;
//        System.out.println(i.doubleValue());
//
//        String id = "[12345678,123123123]";
//        List<Long> longs = JSONObject.parseArray(id, Long.class);
//        longs.forEach(System.out::println);
//        System.out.println(System.currentTimeMillis());


//        System.out.println(new Timestamp(System.currentTimeMillis()).getTime());
//        System.out.println(new Timestamp(System.currentTimeMillis()).toString());
//        Main main = new Main();
//        for (int i = 0; i < 10; i++) {
//            main.putSqlCache(i);
//        }
//        ThreadPoolConfig.SQL_CACHE_POOL.execute(() -> {
//            System.out.println(System.currentTimeMillis());
//        });

        String s = "[{\"appName\":\"mmmms\",\"bizInstanceId\":\"\",\"ip\":\"\",\"password\":\"\",\"dbUser\":\"\",\"port\":\"\",\"region\":\"\",\"zone\":\"\",\"dbName\":\"\"},{\"appName\":\"mms\",\"bizInstanceId\":\"\",\"ip\":\"\",\"password\":\"\",\"dbUser\":\"\",\"port\":\"\",\"region\":\"\",\"zone\":\"\",\"dbName\":\"\"}]";
        String s2 = "[]";
        List<SpecialAppInfo> specialAppInfos = JSON.parseArray(s, SpecialAppInfo.class);
        System.out.println(specialAppInfos);
        System.out.println(JSON.parseArray(s2, SpecialAppInfo.class));

        String text = "[\n" +
                "    {\n" +
                "        \"app1\":{\n" +
                "            \"dev\":{\n" +
                "                \"ip\":\"\",\n" +
                "                \"password\":\"\",\n" +
                "                \"dbUser\":\"\",\n" +
                "                \"port\":\"\",\n" +
                "                \"dbName\":\"\"\n" +
                "            },\n" +
                "            \"prod\":{\n" +
                "                \"ip\":\"\",\n" +
                "                \"password\":\"\",\n" +
                "                \"dbUser\":\"\",\n" +
                "                \"port\":\"\",\n" +
                "                \"dbName\":\"\"\n" +
                "            }\n" +
                "        },\n" +
                "        \"app2\":{\n" +
                "            \"dev\":{\n" +
                "                \"ip\":\"\",\n" +
                "                \"password\":\"\",\n" +
                "                \"dbUser\":\"\",\n" +
                "                \"port\":\"\",\n" +
                "                \"dbName\":\"\"\n" +
                "            },\n" +
                "            \"prod\":{\n" +
                "                \"ip\":\"\",\n" +
                "                \"password\":\"\",\n" +
                "                \"dbUser\":\"\",\n" +
                "                \"port\":\"\",\n" +
                "                \"dbName\":\"\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "]";
        String map2 = "{\n" +
                "    \"app1\":{\n" +
                "        \"dev\":{\n" +
                "            \"ip\":\"127.0.0.1\",\n" +
                "            \"password\":\"123\",\n" +
                "            \"dbUser\":\"123\",\n" +
                "            \"port\":\"123\",\n" +
                "            \"dbName\":\"213\"\n" +
                "        },\n" +
                "        \"prod\":{\n" +
                "            \"ip\":\"\",\n" +
                "            \"password\":\"\",\n" +
                "            \"dbUser\":\"\",\n" +
                "            \"port\":\"\",\n" +
                "            \"dbName\":\"\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"app2\":{\n" +
                "        \"dev\":{\n" +
                "            \"ip\":\"1231231231\",\n" +
                "            \"password\":\"\",\n" +
                "            \"dbUser\":\"\",\n" +
                "            \"port\":\"\",\n" +
                "            \"dbName\":\"\"\n" +
                "        },\n" +
                "        \"prod\":{\n" +
                "            \"ip\":\"\",\n" +
                "            \"password\":\"\",\n" +
                "            \"dbUser\":\"\",\n" +
                "            \"port\":\"\",\n" +
                "            \"dbName\":\"\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        String name = "mmmms";
//        SpecialAppInfo specialAppInfo = specialAppInfos.stream().filter(app -> name.equals(app.getAppName())).findFirst().orElse(null);
//        System.out.println(specialAppInfo);
        Map<String, Map<String, SpecialAppInfo>> map = new HashMap<>();
//        Class<? extends Map> aClass = map.getClass();
//        List<? extends Map> maps = JSON.parseArray(text, aClass);
//        for (Map map1 : maps) {
//            System.out.println(map1);
//        }

//        List<HashMap> hashMaps = JSON.parseArray(text, HashMap.class);
//        for (HashMap hashMap : hashMaps) {
//            hashMap.get("app1");
//        }
        String appName1 = "app1";
        String env = "dev";
        Map<String, Map<String, SpecialAppInfo>> map1 = JSON.parseObject(map2, Map.class);
        SpecialAppInfo specialAppInfo = map1.entrySet().stream()
                .filter(i -> i.getKey().equals(appName1))
                .map(Map.Entry::getValue)
                .findFirst()
                .map(e -> JSON.parseObject(JSON.toJSONString(e.get(env)),SpecialAppInfo.class))
                .get();
        System.out.println(specialAppInfo);

//        System.out.println("1111" + specialAppInfo);
//
//        Map<String, SpecialAppInfo> envMap = map1.entrySet().stream()
//                .filter(i -> i.getKey().equals(appName1))
//                .findFirst()
//                .get().getValue();
//        SpecialAppInfo value = JSON.parseObject(JSON.toJSONString(envMap.entrySet()
//                .stream()
//                .filter(i -> i.getKey().equals(env))
//                .findFirst()
//                .orElse(null)
//                .getValue()), SpecialAppInfo.class);

//        System.out.println(value);

        String n = "\\n";
        System.out.print("\n");
        System.out.println("nni");


    }


    private static final String PLACE_HOLDER_REGEX = "[\\t\\n\\r]";
    private static final String BLACK_SPACE_REGEX = "\\s+";

    public void putSqlCache(int sql) {
        CompletableFuture.runAsync(
                () -> System.out.println(sql),
                ThreadPoolConfig.SQL_CACHE_POOL
        );
    }
}

