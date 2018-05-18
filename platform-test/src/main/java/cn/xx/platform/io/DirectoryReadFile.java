package cn.xx.platform.io;/**
 * Created by Administrator on 2018/5/15.
 */
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
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
                    if (!readfile.isDirectory() && readfile.getName().contains("new_")) {
//                        String path = readfile.getAbsolutePath();
//                        System.out.println("absolutepath=" + path);
//                        String k=FileUtils.readFileToString(readfile,"utf-8");
//                       if(!k.contains("_product.getPersonalData()")){
//                            str.add(readfile.getName());
//                       }
                        List<String> l=new ArrayList<>();
                        Document doc = Jsoup.parse(readfile, "UTF-8");
                        String[] ids = new String[]{"recognizeeCartType", "applicantCartType"};
                        for (String id : ids) {
                            Element content = doc.getElementById(id);
                            if(content!=null){
                                Elements spans = content.getElementsByTag("span");
                                for (Element e : spans) {
                                    l.add(e.text());
                                }
                            }
                        }
                        if(l.size()>2)
                        System.out.println(readfile.getName() +"-------"+ Arrays.toString(l.toArray()));
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
}
