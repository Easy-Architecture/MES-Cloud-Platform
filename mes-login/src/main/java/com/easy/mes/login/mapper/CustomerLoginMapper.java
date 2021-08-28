package com.easy.mes.login.mapper;

import com.easy.mes.login.entity.CustomerLogin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-19
 */
public interface CustomerLoginMapper extends BaseMapper<CustomerLogin> {
    @Select("SELECT COUNT(*) FROM data_statistics WHERE DATE(data_statistics.gmt_create)=#{day}")
    Integer numUserRegister(String day);
}
