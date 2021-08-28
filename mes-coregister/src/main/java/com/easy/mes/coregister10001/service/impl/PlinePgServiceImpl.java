package com.easy.mes.coregister10001.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy.mes.coregister10001.entity.PlinePg;
import com.easy.mes.coregister10001.mapper.PlinePgMapper;
import com.easy.mes.coregister10001.service.PlinePgService;
import org.springframework.stereotype.Service;

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
@Service
public class PlinePgServiceImpl extends ServiceImpl<PlinePgMapper, PlinePg> implements PlinePgService {

    @Override
    public ArrayList<Long> getPgIdByCoId(Long coIdByCoName) {
        QueryWrapper<PlinePg> wrapper = new QueryWrapper<>();
        wrapper.eq("co_id",coIdByCoName);
        List<PlinePg> plinePgs = baseMapper.selectList(wrapper);
        ArrayList<Long> PgIdList = new ArrayList<>();
        for (PlinePg p :plinePgs){
            Long pgId = p.getPgId();
            PgIdList.add(pgId);
        }
        return PgIdList;
    }
}
