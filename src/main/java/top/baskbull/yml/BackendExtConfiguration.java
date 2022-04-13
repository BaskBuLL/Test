package top.baskbull.yml;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author liuzhuo
 * @date 2022/3/22 8:27 下午
 */
@Data
public class BackendExtConfiguration {

    private Boolean enable;

    private String name;

    private String bean;

    private String tag;

    @JSONField(name = "biz-identity")
    private BackendExtBizIdentity bizIdentity;

    public Boolean getEnable() {
        if (enable == null) {
            return false;
        }
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
        if (enable == null) {
            this.enable = false;
        }
    }
}
