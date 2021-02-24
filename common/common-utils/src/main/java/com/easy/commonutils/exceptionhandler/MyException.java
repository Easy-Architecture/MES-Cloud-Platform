package com.easy.commonutils.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
/**
 *
 * @author LiZiHan
 * @since 2021-02-17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException{
    private Integer code;
    private String msg;
}
