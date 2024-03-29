package com.easy.mes.coregister10001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.mes.coregister10001.entity.BusinessRegistration;
import com.easy.mes.coregister10001.mapper.BusinessRegistrationMapper;
import com.easy.mes.coregister10001.service.BusinessRegistrationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-10
 */
@Service
public class BusinessRegistrationServiceImpl extends ServiceImpl<BusinessRegistrationMapper, BusinessRegistration> implements BusinessRegistrationService {

    @Override
    public Long getCoIdByCoName(String coNameByCoId) {
        QueryWrapper<BusinessRegistration> wrapper = new QueryWrapper<>();
        wrapper.eq("co_name",coNameByCoId);
        BusinessRegistration businessRegistration = baseMapper.selectOne(wrapper);
        return businessRegistration.getCoId();
    }
}
