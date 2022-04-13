package top.baskbull;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhuo
 * @date 2021/12/25 4:47 下午
 */
public class TestMap {

    public static void main(String[] args) {
        Map<String, List<Issue>> map = new HashMap<>();
        Issue issue = new Issue(1, "API调用 - API调用咨询-交易");
        Issue issue2 = new Issue(2, "API调用 - API调用咨询-交易");

//        map.put("API调用 - API调用咨询-交易", new ArrayList<>());
//        List<Issue> issues = map.get("API调用 - API调用咨询-交易");
//        issues.add(issue);
//        issues.add(issue2);
//        map.put("API调用 - API调用咨询-交易", issues);
//        System.out.println(JSON.toJSONString(map));
        List<Issue> issues1 = map.get("API调用 - API调用咨询-交易");
        issues1.add(issue);
        map.put("API调用 - API调用咨询-交易", issues1);
        System.out.println(JSON.toJSONString(map));

        issues1 = issues1 == null ? issues1 : null;
        // "分类1" : [Issue1,Issue2]
        //
    }
}

@Data
@AllArgsConstructor
class Issue {
    private int id;

    private String name;
}
