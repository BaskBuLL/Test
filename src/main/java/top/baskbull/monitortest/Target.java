package top.baskbull.monitortest;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhuo
 * @date 2022/3/21 10:45 上午
 */
public class Target {

    public static void main(String[] args) {
        String s = "invoke com.youzan.cloud.monitor.api.systemalert.TargetManageService" +
                ".createNewTarget({\"targetType\":0,\"targetName\":\"%s\"})";

        List<String> app = Arrays.asList("manningshkcrossborder",
                "dennis-shop",
                "ssj",
                "jp-app1",
                "wlywenlv",
                "beauty-yst",
                "jzjjkyf-upate",
                "semir",
                "mobil",
                "lcyx",
                "yszg", "dyson-stylist");

        for (String s1 : app) {
            System.out.println(String.format(s, s1));
        }
    }
}
