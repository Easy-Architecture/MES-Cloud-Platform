package com.easy.mes.order.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="CuOrder对象", description="")
public class CuOrder implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long orderId;

    private Long pId;

    private String pName;

    private Long coId;

    private String coName;

    private String coAddr;

    private String csdTel;

    private Long memberId;

    private String nickname;

    private String mobile;

    private String province;

    private String city;

    private String area;

    private String detailedAddr;

    private String orderNote;

    private BigDecimal totalAmount;

    private Integer payType;

    private Integer status;

    private String deliveryMode;

    private Boolean isDeleted;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
