package top.baskbull.yml;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StreamUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuzhuo
 * @date 2022/3/11 11:56 上午
 */
public class SnakeyamlTest {

    public static void main(String[] args) throws Exception {
        File file = new File("/Users/baskbull/IdeaProjects/Test/src/main/java/top/baskbull/yml/yzcloud-ext-config.yml");

        FileInputStream fileInputStream = new FileInputStream(file);
        String content = StreamUtils.copyToString(fileInputStream, StandardCharsets.UTF_8);

        Map<String, List<BackendExtConfiguration>> load = new HashMap<>(8);
        Yaml yaml = new Yaml();
        try {
            Map<String, Object> load1 = yaml.load(content);
            for (Map.Entry<String, Object> entry : load1.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof List) {
                    List<BackendExtConfiguration> list = new ArrayList<>();
                    for (Object o : (List) value) {
                        String json = JSON.toJSONString(o);
                        BackendExtConfiguration backendExtConfiguration = JSON.parseObject(json, BackendExtConfiguration.class);
                        list.add(backendExtConfiguration);
                    }
                    load.put(key, list);
                    continue;
                }
                if (value instanceof Map) {
                    List<BackendExtConfiguration> list = new ArrayList<>();
                    list.add(JSON.parseObject(JSON.toJSONString(value), BackendExtConfiguration.class));
                    load.put(key, list);
                    continue;
                }
            }
        } catch (Exception e) {
            System.out.println("yaml格式不合法");
            throw e;
        }
        System.out.println(JSON.toJSONString(load));
//        System.out.println(JSON.toJSONString(load, true));
    }
}
