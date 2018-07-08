package Util;/**
 * Created by pc on 2018/7/7.
 */

import FastFile.FastFile;
import org.apache.commons.io.FilenameUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.*;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/07/07
 */
public class FileUtil implements Serializable {
    private static final long serialVersionUID = -4462272673174266738L;
    private static TrackerClient trackerClient;
    private static TrackerServer trackerServer;
    private static StorageClient1 storageClient1;

    static {
        try {
            //clientGloble读配置文件
            ClassPathResource resource = new ClassPathResource("config.conf");
            System.out.println(resource.getClassLoader().getResource("config.conf").getPath());
            ClientGlobal.init(resource.getClassLoader().getResource("config.conf").getPath());
            trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();

            storageClient1 = new StorageClient1(trackerServer, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传
     */
    public static String upload(FastFile fastFile) {
        String path = null;
        try {
            //文件扩展名
            String ext = FilenameUtils.getExtension(fastFile.getName());
            //meta list是表文件的格式
            NameValuePair[] matalist = new NameValuePair[3];
            matalist[0] = new NameValuePair("fileName", fastFile.getName());
            matalist[1] = new NameValuePair("fileExt", ext);
            matalist[2] = new NameValuePair("fileSize", String.valueOf(fastFile.getSize()));
            path = storageClient1.upload_file1(fastFile.getContent(), ext, matalist);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return path;
    }
    public String fileDownLoad(String group,String filename){
        System.out.println("downLoad............");
        System.out.println("group : "+group);
        System.out.println("filename ： "+filename);
        try {
            byte[] bytes = storageClient1.download_file(group,filename);
            System.out.println(bytes == null);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            int i = 0;
            FileOutputStream os = new FileOutputStream("D://11.doc");
            while ((i = bais.read())!=-1){
                os.write(i);
            }
            os.flush();
            os.close();
            bais.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return "success";
    }
}