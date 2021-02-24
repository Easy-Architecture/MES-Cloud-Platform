package com.easy.mes.file.controller;

import com.easy.commonutils.commonResult;
import com.easy.mes.file.service.FRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 *<p>
 *     控制器
 *</p>
 * @author LiZiHan
 * @since 2021-02-14
 */
@RestController
@CrossOrigin
@RequestMapping("/coFilesReceive/FR")
public class FRController {
    @Autowired
    private FRService frService;
    @PostMapping
    public commonResult coFilesReceive(@RequestBody MultipartFile file){
        String url = frService.uploadFile(file);
        return commonResult.OK().data("url",url);
    }
}
