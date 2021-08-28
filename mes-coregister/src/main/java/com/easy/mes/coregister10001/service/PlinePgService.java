package com.easy.mes.coregister10001.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easy.mes.coregister10001.entity.PlinePg;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-04-26
 */
public interface PlinePgService extends IService<PlinePg> {
    ArrayList<Long> getPgIdByCoId(Long coIdByCoName);
}
