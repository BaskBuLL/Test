package top.baskbull.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuzhuo
 * @date 2022/1/11 2:04 下午
 */
@Data
public class MonitorNoticeTriggerDTO implements Serializable {

    private static final long serialVersionUID = -5503296761578628434L;

    private Integer continuingTimes;

    private List<MonitorNoticeComparisonDTO> comparisons;

    private List<String> notifyChannels;
}
