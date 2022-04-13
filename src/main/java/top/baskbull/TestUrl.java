package top.baskbull;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author liuzhuo
 * @date 2021/12/9 2:03 下午
 */
public class TestUrl {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String uri = "https://rds-meta-manager.s.youzanyun.net/api/1/ddl/operate/schema/?name=";
        String p = "sql.rt_sum_by_app";
        System.out.println(URLEncoder.encode(p,"UTF-8"));
//        String s = new String("123", StandardCharsets.UTF_8);
        String eUrl = URLEncoder.encode("https://yingyong.youzan.com/message-reminder?title=意见反馈回复通知&type=message&yz_from=yz_wx_template", "UTF-8");
        System.out.println("eUrl:" + eUrl);
        String dUrl = URLDecoder.decode(eUrl, "utf-8");
        System.out.println("dUrl:" + dUrl);
        System.out.println(URLDecoder.decode(dUrl, "UTF-8"));
        int protocolEnd = uri.toString().indexOf("://");
        String remainUrl = uri.toString().substring(protocolEnd + 3);
        int hostEnd = remainUrl.indexOf("/");
        String suffixUrl = "";

        if (hostEnd > 0) {
            suffixUrl = remainUrl.substring(hostEnd);
        }

        String proxyUrl = "https://rds.com";
        if (!StringUtils.isEmpty(suffixUrl)) {
            proxyUrl = proxyUrl + suffixUrl;
        }
        try {
            URI result = new URI(proxyUrl);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        String u = "平台公告/2022年/1#2023年新增 code.md";
        System.out.println(URLEncoder.encode(u,"utf-8").replaceAll("\\+", "%20"));

//        System.out.println("%20");

        System.out.println(URLEncoder.encode("%3D"));

        String ss = "select tid, express_type as expresstype, pay_type as paytype, team_type as teamtype, status , success_time as successtime, update_time as updatetime, expired_time as expiredtime, created, pay_time as paytime, consign_time as consigntime, close_type as closetype, close_reason as closereason, root_kdt_id as rootkdtid , node_kdt_id as nodekdtid, offline_id as offlineid, kdt_name as kdtname, kdt_id as kdtid, real_payment as realpayment, payment, post_fee as postfee, total_fee as totalfee, transaction , outer_transactions as outertransactions, buyer_phone as buyerphone, fans_nickname as fansnickname, receiver_name as receivername, receiver_tel as receivertel, platform, refund_type as refundtype, refund_state as refundstate, refund_fee as refundfee, refund_id as refundid, refund_reason as refundreason, buyer_message as buyermessage, seller_message as sellermessage, piking_status as pikingstatus, delivery_end_time as deliveryendtime, delivery_start_time as deliverystarttime, print_statu as printstatu, pink_statu as pinkstatu, supply_ktdid as supplykdtid, oid, num, title, user_time as usertime from order where ? = ? and supply_ktdid = ? and tid = ? and created >= ? and created <= ? and piking_status = false and status = wait_seller_send_goods and kdt_id = ? group by tid order by tid desc limit ?, ?";
        String bb = "select tid, express_type as expresstype, pay_type as paytype, team_type as teamtype, status , success_time as successtime, update_time as updatetime, expired_time as expiredtime, created, pay_time as paytime, consign_time as consigntime, close_type as closetype, close_reason as closereason, root_kdt_id as rootkdtid , node_kdt_id as nodekdtid, offline_id as offlineid, kdt_name as kdtname, kdt_id as kdtid, real_payment as realpayment, payment, post_fee as postfee, total_fee as totalfee, transaction , outer_transactions as outertransactions, buyer_phone as buyerphone, fans_nickname as fansnickname, receiver_name as receivername, receiver_tel as receivertel, platform, refund_type as refundtype, refund_state as refundstate, refund_fee as refundfee, refund_id as refundid, refund_reason as refundreason, buyer_message as buyermessage, seller_message as sellermessage, piking_status as pikingstatus, delivery_end_time as deliveryendtime, delivery_start_time as deliverystarttime, print_statu as printstatu, pink_statu as pinkstatu, supply_ktdid as supplykdtid, oid, num, title, user_time as usertime from order where ? = ? and supply_ktdid = ? and tid = ? and created >= ? and created <= ? and refund_state in(?+) and ( status != ?) and kdt_id = ? group by tid order by tid desc limit ?, ?";
        String aa = "select tid, express_type as expresstype, pay_type as paytype, team_type as teamtype, status , success_time as successtime, update_time as updatetime, expired_time as expiredtime, created, pay_time as paytime, consign_time as consigntime, close_type as closetype, close_reason as closereason, root_kdt_id as rootkdtid , node_kdt_id as nodekdtid, offline_id as offlineid, kdt_name as kdtname, kdt_id as kdtid, real_payment as realpayment, payment, post_fee as postfee, total_fee as totalfee, transaction , outer_transactions as outertransactions, buyer_phone as buyerphone, fans_nickname as fansnickname, receiver_name as receivername, receiver_tel as receivertel, platform, refund_type as refundtype, refund_state as refundstate, refund_fee as refundfee, refund_id as refundid, refund_reason as refundreason, buyer_message as buyermessage, seller_message as sellermessage, piking_status as pikingstatus, delivery_end_time as deliveryendtime, delivery_start_time as deliverystarttime, print_statu as printstatu, pink_statu as pinkstatu, supply_ktdid as supplykdtid, oid, num, title, user_time as usertime from order where ? = ? and supply_ktdid != ? and platform = ? and created >= ? and created <= ? and status = ? and brand_id in(?+) and kdt_id = ? group by tid order by delivery_start_time desc limit ?, ?";
    }
}
