package top.baskbull;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhuo
 * @date 2021/12/16 11:21 上午
 */
public class Test格式 {

    public static void main(String[] args) {

        SonarRuleProfile sonarRuleProfile = new SonarRuleProfile();
        sonarRuleProfile.setAppName("dennis-chain");
        sonarRuleProfile.setRuleProfile(Arrays.asList("FindBugs", "Sonar way"));


        SonarRuleProfile sonarRuleProfile2 = new SonarRuleProfile();
        sonarRuleProfile2.setAppName("ssj");
        sonarRuleProfile2.setRuleProfile(Arrays.asList("FindBugs", "Sonar way"));

        List<SonarRuleProfile> list = new ArrayList<>();
        list.add(sonarRuleProfile);
        list.add(sonarRuleProfile2);

        System.out.println(JSON.toJSONString(list));


        List<String> stringList = Arrays.asList("FindBugs", "Sonar way");
        System.out.println(JSON.toJSONString(stringList));


        Map<String, String> ruleMap = new HashMap<>();
        ruleMap.put("dennis-chain", stringList.toString());
        ruleMap.put("ssj", stringList.toString());
        System.out.println(ruleMap);
        System.out.println(JSON.toJSONString(ruleMap));
//        String s = "{dennis-chain=[FindBugs, Sonar way], ssj=[FindBugs, Sonar way]}";
//        Map<String, String> map = JSON.parseObject(JSON.toJSONString(ruleMap), Map.class);
//        if (map.containsKey("ssj")) {
//            String ssj = map.get("ssj");
//            String jsonValue = JSON.toJSONString(ssj);
//            System.out.println(jsonValue);
//
//            System.out.println(JSON.parseArray(jsonValue, List.class));
//        }
        String s = "{\"dennis-chain\":[\"FindBugs\",\"Sonar way\"],\"ssj\":[\"FindBugs\",\"Sonar way\"]}";
        Map<String, List<String>> map = JSON.parseObject(s, Map.class);
        List<String> ssj = map.get("ssj");
        System.out.println(ssj);


        List<Long> ids = new ArrayList<>();
        //800 1300
        //1301 1800 1800 2300
        for (Long i = 7000L; i < 7600; i++) {
            ids.add(i);
        }
        System.out.println(ids);
//        String s = "[{\"appName\":\"dennis-chain\",\"ruleProfile\":[\"FindBugs\",\"Sonar way\"]},{\"appName\":\"ssj\",\"ruleProfile\":[\"FindBugs\",\"Sonar way\"]}]";
//        List<SonarRuleProfile> sonarRuleProfiles = JSON.parseArray(s, SonarRuleProfile.class);
//        System.out.println(sonarRuleProfiles);

        String test = "{\"timestamp\":1639992666919,\"webhookEvent\":\"comment_created\",\"comment\":{\"self\":\"https://jira.qima-inc.com/rest/api/2/issue/797122/comment/1638711\",\"id\":\"1638711\",\"author\":{\"self\":\"https://jira.qima-inc.com/rest/api/2/user?username=yingxiaocui\",\"name\":\"yingxiaocui\",\"key\":\"JIRAUSER25949\",\"emailAddress\":\"yingxiaocui@youzan.com\",\"avatarUrls\":{\"48x48\":\"https://jira.qima-inc.com/secure/useravatar?avatarId=10122\",\"24x24\":\"https://jira.qima-inc.com/secure/useravatar?size=small&avatarId=10122\",\"16x16\":\"https://jira.qima-inc.com/secure/useravatar?size=xsmall&avatarId=10122\",\"32x32\":\"https://jira.qima-inc.com/secure/useravatar?size=medium&avatarId=10122\"},\"displayName\":\"应晓翠(不留)\",\"active\":true,\"timeZone\":\"Asia/Shanghai\"},\"body\":\"您好， 这边看日志您传入的就是这些数据： !screenshot-1.png|thumbnail! \\r\\n\\r\\n您可以在店铺后台操作下能否传入您希望的标签值，如果店铺后台不支持的话， 接口也是无法实现的，您可以将需求反馈给店铺后台的在线客服。如果店铺后台支持，您可以提供下原来的文本信息和截图。\",\"updateAuthor\":{\"self\":\"https://jira.qima-inc.com/rest/api/2/user?username=yingxiaocui\",\"name\":\"yingxiaocui\",\"key\":\"JIRAUSER25949\",\"emailAddress\":\"yingxiaocui@youzan.com\",\"avatarUrls\":{\"48x48\":\"https://jira.qima-inc.com/secure/useravatar?avatarId=10122\",\"24x24\":\"https://jira.qima-inc.com/secure/useravatar?size=small&avatarId=10122\",\"16x16\":\"https://jira.qima-inc.com/secure/useravatar?size=xsmall&avatarId=10122\",\"32x32\":\"https://jira.qima-inc.com/secure/useravatar?size=medium&avatarId=10122\"},\"displayName\":\"应晓翠(不留)\",\"active\":true,\"timeZone\":\"Asia/Shanghai\"},\"created\":\"2021-12-20T17:31:06.919+0800\",\"updated\":\"2021-12-20T17:31:06.919+0800\"}} ";
        System.out.println(test.replace("https://jira.qima-inc.com/", "http://jira-api.s.qima-inc.com/"));

    }

}

@Data
class SonarRuleProfile {

    private String appName;

    private List<String> ruleProfile;

}
