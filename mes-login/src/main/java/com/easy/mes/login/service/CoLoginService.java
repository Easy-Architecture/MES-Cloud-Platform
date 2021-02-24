package com.easy.mes.login.service;

import com.easy.mes.login.entity.CoLogin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-17
 */
public interface CoLoginService extends IService<CoLogin> {

    String login(CoLogin coLogin);

    void register(CoLogin coLogin);

}
