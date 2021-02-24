package com.easy.mes.coregister10001.entity.vo;

import lombok.Data;
import java.io.Serializable;
/**
 *
 * @author LiZiHan
 * @since 2021-02-21
 */
@Data
public class ProductAndCoInfoVo implements Serializable {

    private Long pId;

    private String pName;

    private String pAddr;

    private Long coId;

    private String coName;

    private String corpTel;

    private String coEmail;

    private String coAddr;

    private String csdTel;

}
