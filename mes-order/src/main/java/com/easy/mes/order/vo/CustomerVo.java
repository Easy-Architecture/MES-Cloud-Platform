package com.easy.mes.order.vo;

import lombok.Data;
/**
 *
 * @author LiZiHan
 * @since 2021-02-21
 */

@Data
public class CustomerVo{

    private Long id;

    private String avater;

    private String nickname;

    private String mobile;

    private String passWord;

    private String weixinId;

    private Integer age;

    private String sex;

}
