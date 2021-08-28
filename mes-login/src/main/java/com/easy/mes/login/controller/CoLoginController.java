package com.easy.mes.login.controller;


import com.easy.commonutils.JwtConfig;
import com.easy.commonutils.commonResult;
import com.easy.mes.login.entity.CoLogin;
import com.easy.mes.login.entity.CustomerLogin;
import com.easy.mes.login.service.CoLoginService;
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
 * @since 2021-02-17
 */
@RestController
@CrossOrigin
@RequestMapping("/login/co-login")
public class CoLoginController {
    @Autowired
    private CoLoginService coLoginService;
    //登录
    @PostMapping("cologin")
    public commonResult login(@RequestBody CoLogin coLogin){
       String token=coLoginService.login(coLogin);
       return commonResult.OK().data("token",token);
    }
    //注册
    @PostMapping("coregister")
    public commonResult register(@RequestBody CoLogin coLogin){
        coLoginService.register(coLogin);
        return commonResult.OK();
    }
    //根据token获取用户信息
    @GetMapping("getcoInfo")
    public commonResult getcoInfo(HttpServletRequest request){
        String idByJwtToken = JwtConfig.getIdByJwtToken(request);
        CoLogin byId = coLoginService.getById(idByJwtToken);
        return commonResult.OK().data("result",byId);
    }

    //根据用户id获取用户信息(远程调用方法)
    @GetMapping("/getCoNameById/{id}")
    public String getCoNameById(@PathVariable("id") Long id){
        return coLoginService.getCoNameById(id);
    }
}

