package com.easy.mes.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy.commonutils.JwtConfig;
import com.easy.commonutils.exceptionhandler.MyException;
import com.easy.mes.login.entity.CustomerLogin;
import com.easy.mes.login.mapper.CustomerLoginMapper;
import com.easy.mes.login.service.CustomerLoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-19
 */
@Service
public class CustomerLoginServiceImpl extends ServiceImpl<CustomerLoginMapper, CustomerLogin> implements CustomerLoginService {
    //登录
    @Override
    public String culogin(CustomerLogin customerLogin) {
        String mobile = customerLogin.getMobile();
        String passWord = customerLogin.getPassWord();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(passWord)) {
            throw new MyException(44444, "登录失败");
        }
        QueryWrapper<CustomerLogin> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile", mobile);
        CustomerLogin mobileCulogin = baseMapper.selectOne(wrapper);
        if (mobileCulogin == null) {
            throw new MyException(44444, "未找到用户");
        }
        if (!passWord.equals(mobileCulogin.getPassWord())) {
            throw new MyException(44444, "用户密码不匹配");
        }

        String jwtToken = JwtConfig.getJwtToken(mobileCulogin.getId(),
                mobileCulogin.getNickname());
        return jwtToken;
    }

    //注册
    @Override
    public void curegister(CustomerLogin customerLogin) {
        String mobile = customerLogin.getMobile();
        String passWord = customerLogin.getPassWord();
        String nickname = customerLogin.getNickname();
        if (StringUtils.isEmpty(mobile) || StringUtils.isEmpty(passWord) || StringUtils.isEmpty(nickname)){
            throw new MyException(44444,"注册失败");
        }
        QueryWrapper<CustomerLogin> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Integer integer = baseMapper.selectCount(wrapper);
        if (integer>0){
            throw new MyException(44444,"该手机号已被注册");
        }
        wrapper.eq("nickname",nickname);
        Integer integer1 = baseMapper.selectCount(wrapper);
        if (integer1>0){
            throw new MyException(44444,"该昵称已被使用");
        }
        CustomerLogin c=new CustomerLogin();
        c.setNickname(nickname);
        c.setMobile(mobile);
        c.setPassWord(passWord);
        baseMapper.insert(c);
    }

    //返回用户数据(远程调用)
    @Override
    public List<CustomerLogin> getCuInfoById(Long id) {
        return this.list(new QueryWrapper<CustomerLogin>().eq("id",id));
    }

    //返回当天注册人数
    @Override
    public Integer numUserRegister(String day) {
        return baseMapper.numUserRegister(day);
    }
}
