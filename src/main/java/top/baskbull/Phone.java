package top.baskbull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Phone {

    /**
     * 店铺kdtId
     */
    private Long kdtId;

    /**
     * 小程序类型:  (目前仅支持2:微信小程序.)
     * 2:微信小程序
     * 6:百度小程序
     * 10:支付宝小程序
     * 11:QQ小程序
     */
    private Integer accountType;

    /**
     * 业务类型, (目前仅支持1)
     * 1:商城业务 (主要部分)
     * 2:品牌宣传业务
     */
    private Integer businessType;

    /**
     * 变更对应的状态:
     * 3: 已提交审核，审核中
     * 5: 审核失败，原因见auditReason
     * 6: 发布上线
     */
    private Integer status;

    /**
     * 审核失败的原因
     * 当status=5的时候auditReason会有具体的失败原因
     */
    private String auditReason;

    /**
     * 小程序appId
     */
    private String appId;

    /**
     * 本次变更的时间
     */
    private Long updateTime;

}
