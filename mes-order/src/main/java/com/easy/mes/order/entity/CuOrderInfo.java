package com.easy.mes.order.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("cu_order_info")
@ApiModel(value="CuOrderInfo对象", description="")
public class CuOrderInfo implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long orderId;

    private Long coId;

    private String coName;

    private String csdTel;

    private Long pId;

    private String pAddr;

    private String pTypeChoose;

    private String ptype;

    private String packMethod;

    private String packSp;

    private Integer materialUsage;

    private Long totalQuantity;

    private BigDecimal totalAmount;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
