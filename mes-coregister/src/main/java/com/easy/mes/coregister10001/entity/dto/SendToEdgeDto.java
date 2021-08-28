package com.easy.mes.coregister10001.entity.dto;

import com.easy.mes.coregister10001.entity.SpecificScheme;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Data
//@Component
public class SendToEdgeDto implements Serializable {
    //公司id
    private Long coId;
    //方案id
//    private String cId;
    //流水线id
//    private String mId;
    //具体方案内容元件及其控制流程
    private List<SpecificScheme> SpecificScheme;
    /*
    方案支持的生产种类  Bottle 类下的容量字段或者 Water 类下的酒水类型字段

    在数组中添加元素 capacity=10
    type【0】=10
    再添加第二个元Water 酒水类型 type=“雪碧”
    type【1】=“雪碧”
    一个方案可以添加多种生产类型，所以用数组
     */
//    private ArrayList <String> type;
}
