package top.baskbull;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People {

    public String name;

    public int age;

    public Phone phone;

    public String getPhonee(){
        return JSON.toJSONString(phone);
    }
}
