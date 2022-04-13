package top.baskbull;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;

/**
 * @author liuzhuo
 * @date 2021/12/21 8:56 下午
 */
public class TestRestTemplate {

    public static void main(String[] args) throws UnsupportedEncodingException {
//        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
//        param.set("ref", "master");
//        String s = "%25E5%25B9%25B3%25E5%258F%25B0%25E5%2585%25AC%25E5%2591%258A%252F2021%25E5%25B9%25B4%252F%25E6%2596%25B0%25E5%25A2%259E%252F1%2523add.md";
//        System.out.println(URLDecoder.decode(s, "UTF-8"));

//        String GET_FILE = "http://gitlab.qima-inc.com/api/v4/projects/%s/repository/files/%s";
//        String filePath = "平台公告/2021年/新增/1#add.md";
//        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(GET_FILE);
//        String url = uriComponentsBuilder.queryParams(param).build().toUriString();
//        url = String.format(GET_FILE, 111111, URLEncoder.encode(filePath, "UTF-8"));
//
//        System.out.println(URLDecoder.decode(URLDecode
//
//        r.decode("%25E5%25B9%25B3%25E5%258F%25B0%25E5%2585%25AC%25E5%2591%258A%252F2021%25E5%25B9%25B4%252F%25E6%2596%25B0%25E5%25A2%259E%252F1%2523add.md")));
//        System.out.println(url);
        String pre = "https://ops.qima-inc.com/v3/skynet/#/main/prod/";
        String url = "i/d%2FcYmulcb7k%2Fyou-zan-yun-saasye-wu-kuo-zhan-dian-diao-yong%3ForgId%3D1";
//        System.out.println(pre + URLEncoder.encode("%2F"));

//        System.out.println(URLDecoder.decode("%26var-granularity%3D60%26var-appName%3Ddennis-shop"));

        String appName = "dennis-chain";
        String saas = "https://ops.qima-inc.com/v3/skynet/#/main/prod/i/d%252FcYmulcb7k%252Fyou-zan-yun-saasye-wu-kuo-zhan-dian-diao-yong%3ForgId%3D1";
        URI uri = URI.create(saas);
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUri(uri);

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.set("orgId", String.valueOf(1));
        param.set("var-granularity", String.valueOf(60));
        param.set("var-appName", appName);
        uriComponentsBuilder.queryParams(param);

        String join = Joiner.on("%26").withKeyValueSeparator("%3D").join(ImmutableMap.of("var-granularity", String.valueOf(60), "var-appName", appName));
        System.out.println(join);
        System.out.println(saas + "%26" + join);
        System.out.println(URLDecoder.decode("%3D"));
        System.out.println(URLDecoder.decode("%26"));
//        System.out.println(uriComponentsBuilder.build().toUriString());
//        System.out.println(URLDecoder.decode("https://ops.qima-inc.com/v3/skynet/#/main/prod/i/d%2FcYmulcb7k%2Fyou-zan-yun-saasye-wu-kuo-zhan-dian-diao-yong%3ForgId%3D1%26var-granularity%3D60%26var-appName%3Ddennis-shop"));
    }
}


