package top.baskbull.yml;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * @author liuzhuo
 * @date 2022/3/22 8:28 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BackendExtBizIdentity {

    private Map<String, String> platform;

    private Map<String, String> diy;
}
