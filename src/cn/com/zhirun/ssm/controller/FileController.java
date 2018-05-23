package cn.com.zhirun.ssm.controller;

import com.sun.deploy.net.HttpResponse;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@Controller
public class FileController {
    @RequestMapping("/downloadFile")
    public void downloadFile(String filename, HttpServletResponse response){
        File file=new File("D:\\"+filename);
        response.addHeader("content-disposition","attachment;filename="+filename);
        try {
            FileUtils.copyFile(file,response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") CommonsMultipartFile[] tempfile,String username){
        for (CommonsMultipartFile t:tempfile) {


        System.out.println(t.getOriginalFilename());
        System.out.println(t.getName());
        System.out.println(t.getStorageDescription());
        System.out.println(t.getSize());

        try {
            FileUtils.copyInputStreamToFile(t.getInputStream(),new File("d:\\"+t.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return "result";
    }
}
