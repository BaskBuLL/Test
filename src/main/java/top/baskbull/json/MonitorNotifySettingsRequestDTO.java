package top.baskbull.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhuo
 * @date 2022/1/11 4:42 下午
 */
@Data
public class MonitorNotifySettingsRequestDTO implements Serializable {

    private static final long serialVersionUID = 7745688430221228300L;

    private List<Integer> notifyGroupIds;

    private List<NotifyPeriod> effectiveTimeRanges;

    @Data
    class NotifyPeriod implements Serializable {
        private static final long serialVersionUID = 5056935686572348726L;

        private String start;
        private String end;
    }
}
