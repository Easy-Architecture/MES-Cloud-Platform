package com.easy.mes.login.controller;

import com.easy.commonutils.JwtConfig;
import com.easy.commonutils.commonResult;
import com.easy.mes.login.entity.CustomerLogin;
import com.easy.mes.login.service.CustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LiZiHan
 * @since 2021-02-19
 */
@RestController
@CrossOrigin
@RequestMapping("/login/customer-login")
public class CustomerLoginController {
    @Autowired
    private CustomerLoginService customerLoginService;
    //登录
    @PostMapping("culogin")
    public commonResult culogin(@RequestBody CustomerLogin customerLogin){
        String token =customerLoginService.culogin(customerLogin);
        return commonResult.OK().data("cu_token",token);
    }

    //注册
    @PostMapping("curegister")
    public commonResult curegister(@RequestBody CustomerLogin customerLogin){
        customerLoginService.curegister(customerLogin);
        return commonResult.OK();
    }

    //根据token获取用户信息
    @GetMapping("getcuInfo")
    public commonResult getcuInfo(HttpServletRequest request){
        String id = JwtConfig.getIdByJwtToken(request);
        CustomerLogin byId = customerLoginService.getById(id);
        return commonResult.OK().data("result",byId);
    }

    //根据用户id获取用户信息(远程调用方法)
    @GetMapping("getCuInfoById/{id}")
    public List<CustomerLogin> getCuInfoById(@PathVariable("id") Long id){
        return customerLoginService.getCuInfoById(id);
    }

    //远程查询当天注册用户数
    @GetMapping("numUserRegister/{day}")
    public commonResult numUserRegister(@PathVariable("day") String day){
        Integer num = customerLoginService.numUserRegister(day);
        return commonResult.OK().data("result",num);
    }
}

