package com.easy.mes.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.commonutils.JwtConfig;
import com.easy.commonutils.exceptionhandler.MyException;
import com.easy.mes.login.entity.CoLogin;
import com.easy.mes.login.mapper.CoLoginMapper;
import com.easy.mes.login.service.CoLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-17
 */
@Service
public class CoLoginServiceImpl extends ServiceImpl<CoLoginMapper, CoLogin> implements CoLoginService {
    //登录
    @Override
    public String login(CoLogin coLogin) {
        String mobile = coLogin.getMobile();
        String passWord = coLogin.getPassWord();
        //电话，密码不存在
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(passWord)){
            throw new MyException(44444,"登录失败");
        }
        //电话是否正确
        QueryWrapper<CoLogin> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        CoLogin mobileCoLogin = baseMapper.selectOne(wrapper);
        if (mobileCoLogin == null){
            throw new MyException(44444,"未找到用户");
        }
        //密码是否正确(未加密版)
        if (!passWord.equals(mobileCoLogin.getPassWord())){
            throw new MyException(44444,"用户密码不匹配");
        }
        //生成token
        String jwtToken = JwtConfig.getJwtToken(mobileCoLogin.getId(),
                mobileCoLogin.getCoName());
        return jwtToken;
    }
    //注册(无验证码版)
    @Override
    public void register(CoLogin coLogin) {
        String mobile = coLogin.getMobile();
        String passWord = coLogin.getPassWord();
        String coName = coLogin.getCoName();
        //判断参数是否为空
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(passWord) || StringUtils.isEmpty(coName)){
            throw new MyException(44444,"注册失败");
        }
        //手机号唯一
        QueryWrapper<CoLogin> wrapper=new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Integer integer = baseMapper.selectCount(wrapper);
        if (integer>0){
            throw new MyException(44444,"注册失败");
        }
        //加入数据库
        CoLogin c=new CoLogin();
        c.setCoName(coName);
        c.setMobile(mobile);
        c.setPassWord(passWord);
        baseMapper.insert(c);
    }
}
