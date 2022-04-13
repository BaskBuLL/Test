package top.baskbull.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuzhuo
 * @date 2022/1/11 2:06 下午
 */
@Data
public class MonitorNoticeComparisonDTO implements Serializable {

    private static final long serialVersionUID = -4349297904818212712L;

    private String queryName;

    private String operator;

    private ValueExtent valueExtent;

    @Data
    class ValueExtent implements Serializable {
        private static final long serialVersionUID = 5056935686572348726L;

        private Integer start;
        private Integer end;
    }
}
