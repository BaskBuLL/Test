package top.baskbull;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;

/**
 * @author liuzhuo
 * @date 2022/1/26 9:59 上午
 */
public class TestBase64 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "IyDmlrDlop7mtYvor5UKCuaWsOWinuS4gOS4quaWsOaWh+aho++8n++8n++8n++8nwrjgILjgILjgILjgILjgIIK44CB44CB44CB44CB44CB";
//        System.out.println(new String(Base64Utils.decodeFromString(s)));

        String w = "平台公告/2021年/1#新增.md";
        String[] split = w.split("/");
//        System.out.println(Arrays.toString(split));
//        String GET_FILE = "https://gitlab.qima-inc.com/api/v4/projects/%s/repository/files/%s";

//        String url = String.format(GET_FILE, 13558, URLEncoder.encode("平台公告/2023年/测试建空的文件夹/1#test1.md", "UTF-8"));
//        System.out.println(url);

        String ss= "T3JkZXJDcmVhdGVTZWxmVmFsaWRhdGVFeHRQb2ludDoKICAtIGltcGw6CiAgICAgIGVuYWJsZTogdHJ1ZQogICAgICBuYW1lOiBvcmRlckNyZWF0ZVNlbGZWYWxpZGF0ZUV4dFBvaW50RmFpbGVkCiAgICAgIGJlYW46IG9yZGVyQ3JlYXRlU2VsZlZhbGlkYXRlRXh0UG9pbnRGYWlsZWQKICAgICAgdGFnOgogICAgICBiaXotaWRlbnRpdGllczoKICAgICAgICBwbGF0Zm9ybToKICAgICAgICAgIHNob3AtdHlwZToKICAgICAgICAgIGFjdGl2aXR5LXR5cGU6CiAgICAgICAgZGl5OgogICAgICAgICAgc2hvcDogI+WmguaenOS7peWQjuaWsOWinuS6huagh+ivhgogICAgICAgICAgb3JkZXI6CiAgLSBpbXBsOgogICAgICBlbmFibGU6IGZhbHNlICPlpoLmnpzmsqHmnIllbmFibGUKCgo=";
        System.out.println(new String(Base64Utils.decodeFromString(ss)));
    }
}
