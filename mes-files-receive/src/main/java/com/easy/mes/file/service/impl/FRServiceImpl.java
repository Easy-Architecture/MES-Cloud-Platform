package com.easy.mes.file.service.impl;

import com.easy.mes.file.service.FRService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.UUID;
/**
 *
 * <p>
 *  服务实现类
 * </p>
 * @author LiZiHan
 * @since 2021-02-14
 */
@Service
public class FRServiceImpl implements FRService {
    String filename=null;
    InputStream inputStream = null;
    OutputStream os =null;
    String path = null;
    @Override
    public String uploadFile(MultipartFile file) {
        try {
            inputStream = file.getInputStream();
            filename=file.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            filename = uuid+filename;
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            path = "/home/apple/FRTest";//改成本地存储路径
            byte[] bs = new byte[1024];
            int len;
            File tempFile=new File(path);
            if (!tempFile.exists()){
                tempFile.mkdirs();
            }
            os = new FileOutputStream(tempFile.getPath()+File.separator+filename);
            while ((len = inputStream.read(bs)) != -1){
                os.write(bs,0,len);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String url = path+File.separator+filename;
        return url;
    }
}
