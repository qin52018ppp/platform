package cn.xx.platform.io;/**
 * Created by Administrator on 2018/5/15.
 */

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 17:34 2018/5/15
 * @Modified By:
 */
public class DirectoryReadFile {
    /**
     * 读取某个文件夹下的所有文件
     */
    public static boolean readfile(String filepath) {
        try {
            List<String> str=new ArrayList<>();
            File file = new File(filepath);
            if (file.isDirectory()) {
                String[] fileList = file.list();
                for (int i = 0; i < fileList.length; i++) {
                    File readfile = new File(filepath + File.separator + fileList[i]);
                    if (!readfile.isDirectory()) {
                        String path = readfile.getAbsolutePath();
                        System.out.println("absolutepath=" + path);
                        String k=FileUtils.readFileToString(readfile,"utf-8");
                       if(!k.contains("_product.getPersonalData()")){
                            str.add(readfile.getName());
                       }
                    } else if (readfile.isDirectory()) {
                        readfile(filepath + File.separator + fileList[i]);
                    }
                }
            } else {
                System.out.println("path=" + file.getPath() + "absolutepath=" + file.getAbsolutePath() + "name=" + file.getName());
            }
            for (int i = 0; i < str.size(); i++) {
                System.out.println(str.get(i));
            }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return true;
    }

    /**
     * 删除某个文件夹下的所有文件夹和文件
     */

    public static boolean deletefile(String delpath)
            throws FileNotFoundException, IOException {
        try {

            File file = new File(delpath);
            if (!file.isDirectory()) {
                System.out.println("1");
                file.delete();
            } else if (file.isDirectory()) {
                System.out.println("2");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File delfile = new File(delpath + "\\" + filelist[i]);
                    if (!delfile.isDirectory()) {
                        System.out.println("path=" + delfile.getPath());
                        System.out.println("absolutepath="
                                + delfile.getAbsolutePath());
                        System.out.println("name=" + delfile.getName());
                        delfile.delete();
                        System.out.println("删除文件成功");
                    } else if (delfile.isDirectory()) {
                        deletefile(delpath + "\\" + filelist[i]);
                    }
                }
                file.delete();

            }

        } catch (FileNotFoundException e) {
            System.out.println("deletefile()   Exception:" + e.getMessage());
        }
        return true;
    }
}
