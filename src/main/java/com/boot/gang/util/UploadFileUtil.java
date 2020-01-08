package com.boot.gang.util;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;

/**
 * @ClassName: lingang
 * @description: 上传文件工具类
 * @author: dongxiangwei
 * @create: 2020-01-08 10:35
 **/
@Component
public class UploadFileUtil {

    public void uploadImage(MultipartFile file, String path_joint, HttpSession session, HttpServletRequest request) throws Exception{

        if(file != null){
            String fileName = file.getOriginalFilename();
            if(fileName != null && !"".equals(fileName)){
                String path = session.getServletContext().getRealPath("/");
                path += path_joint;
                String suffix = fileName.substring(fileName.indexOf("."));
                fileName = System.nanoTime() + suffix;
                File targetFile = new File(path,fileName );
                if(!targetFile.exists()){
                    targetFile.mkdirs();
                }
               // 保存
                file.transferTo(targetFile);
            }
        }else {
            throw new Exception("文件不存在");
        }

    }



}
