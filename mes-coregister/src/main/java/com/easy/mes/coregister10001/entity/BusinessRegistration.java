package com.easy.mes.coregister10001.entity;

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
 * @since 2021-02-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="BusinessRegistration对象", description="")
public class BusinessRegistration implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "co_id", type = IdType.ASSIGN_ID)
    private Long coId;

    private String coName;

    private String corp;

    private String corpTel;

    private String coEmail;

    private String coAddr;

    private String mdTel;

    private String csdTel;

    private String blUrl;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;


}
