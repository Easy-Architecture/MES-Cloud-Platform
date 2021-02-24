package com.easy.cloundmes.verification;

import Entity.BusinessRegistration;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaohan
 * 验证处理类
 */

@Component
public class VerificationHandler {

    public static boolean verification(String json,BusinessRegistration business) throws IOException {

        boolean tate=false;
        byte[] buffer=new byte[10000];
        byte[] buffer1=new byte[10000];
        int i=0;
        int ii=0;
        ParserConfig.getGlobalInstance().setSafeMode(true);
        BusinessRegistration business1= JSON.parseObject(json,BusinessRegistration.class);
        InputStream fis=new FileInputStream(business.getBusinessLicense());
        InputStream fis1=new FileInputStream(business1.getBusinessLicense());

        while ((i=fis.read(buffer))!=0){
        }
        while ((ii=fis1.read(buffer1))!=0){
        }

        if (business.getName().equals(business1.getName())&&buffer.equals(buffer1)){
            tate=true;
        }

        return tate;
    }

}

