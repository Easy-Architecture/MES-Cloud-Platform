package com.easy.mes.coregister10001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.commonutils.JwtConfig;
import com.easy.mes.coregister10001.entity.SpecificScheme;
import com.easy.mes.coregister10001.entity.dto.SendToEdgeDto;
import com.easy.mes.coregister10001.feign.CoFeignService;
import com.easy.mes.coregister10001.mapper.SpecificSchemeMapper;
import com.easy.mes.coregister10001.service.BusinessRegistrationService;
import com.easy.mes.coregister10001.service.PlinePgService;
import com.easy.mes.coregister10001.service.SpecificSchemeService;
import com.easy.mes.rabbitmq.constant.MQConstant;
import com.easy.mes.rabbitmq.service.MQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-04-26
 */
@Slf4j
@Service
public class SpecificSchemeServiceImpl extends ServiceImpl<SpecificSchemeMapper, SpecificScheme> implements SpecificSchemeService {

    @Resource
    private SpecificSchemeService specificSchemeService;

    @Resource
    private CoFeignService coFeignService;

    @Resource
    private MQService mqService;

    @Resource
    private BusinessRegistrationService businessRegistrationService;

    @Resource
    private PlinePgService plinePgService;

    @Override
    public boolean mySave(SpecificScheme specificScheme, HttpServletRequest request) {
        boolean save = specificSchemeService.save(specificScheme);
//        拿到用户id，远程获取用户公司名，拿到公司co_id
        String idByJwtToken = JwtConfig.getIdByJwtToken(request);
        String coNameById = coFeignService.getCoNameById(Long.parseLong(idByJwtToken));
        Long coIdByCoName = businessRegistrationService.getCoIdByCoName(coNameById);

//        封装list中数据
        ArrayList<Long> pgIdByCoId = plinePgService.getPgIdByCoId(coIdByCoName);
        List<SpecificScheme> specificSchemeInfoByPgId = specificSchemeService.getSpecificSchemeInfoByPgId(pgIdByCoId);

//       向RabbitMQ发送消息(json格式)
        SendToEdgeDto sendToEdgeDto = new SendToEdgeDto();
        sendToEdgeDto.setCoId(coIdByCoName);
        sendToEdgeDto.setSpecificScheme(specificSchemeInfoByPgId);
        mqService.sendMessage(
                MQConstant.EXCHANGE,
                MQConstant.ROUTING_KEY,
                sendToEdgeDto);

        return save;
    }

    @Override
    public List<SpecificScheme> getSpecificSchemeInfoByPgId(ArrayList<Long> pgs) {
        QueryWrapper<SpecificScheme> wrapper = new QueryWrapper<>();
        List<SpecificScheme> specificSchemes = null;
        for (Long a : pgs){
            wrapper.eq("pg_id",a);
            specificSchemes = baseMapper.selectList(wrapper);
        }

        return specificSchemes;
    }

}
