package top.baskbull;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuzhuo
 * @date 2021/11/27 4:54 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SqlAnalysisReportRequest implements Serializable {

    private static final long serialVersionUID = 4233021369481683304L;

    private List<Long> idList;


    public static void main(String[] args) {
        SqlAnalysisReportRequest sqlAnalysisReportRequest = new SqlAnalysisReportRequest(Arrays.asList(1L, 2L));
        System.out.println(JSON.toJSONString(sqlAnalysisReportRequest));
    }
}
