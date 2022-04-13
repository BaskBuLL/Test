package top.baskbull;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author liuzhuo
 * @date 2022/3/9 11:30 上午
 */
public class TestInputStream {

    public static void main(String[] args) throws IOException {
        String s = "{\"code\":200,\"msg\":\"sww\",\"data\":\"www\"}";

        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
//        Test test = new Test(inputStream, "test");
//        System.out.println(test);
//        System.out.println(JSON.toJSONString(test));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        StringBuilder responseBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            responseBuilder.append(line);
        }
        JSONObject object = JSON.parseObject(responseBuilder.toString());
        System.out.println(object);
        Object bizCode = object.get("code");
        System.out.println(bizCode);
    }
}

@AllArgsConstructor
@Data
@NoArgsConstructor
class Test {
    InputStream inputStream;
    String name;
}
