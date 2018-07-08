package Controller;/**
 * Created by pc on 2018/7/7.
 */

import FastFile.FastFile;
import Util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/07/07
 */
@Controller
public class FileController {
    @RequestMapping(value = "/upload",method = {RequestMethod.POST})
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file){
        System.out.println("jinlaile");
        try{
             FastFile fastFile = new FastFile(file.getBytes(),file.getOriginalFilename(),file.getSize());
             String path = FileUtil.upload(fastFile);
             System.out.println("success"+"  "+path);
             return "fileupload";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/download")
    @ResponseBody
    public String fileDownLoad(String group,String filename) {
        System.out.println("downLoad............");
        System.out.println("group : " + group);
        System.out.println("filename ： " + filename);
        FileUtil fileutil = new FileUtil();
        fileutil.fileDownLoad(group,filename);
        return "success";
    }
}
