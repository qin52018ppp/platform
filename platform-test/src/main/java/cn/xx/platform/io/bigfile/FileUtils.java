package cn.xx.platform.io.bigfile;/**
 * Created by Administrator on 2018/3/21.
 */

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 14:58 2018/3/21
 * @Modified By:
 */
public final class FileUtils {
    public static void read(String file) {
        final List<String> list = new ArrayList<String>();
        BigFileReader.Builder builder = new BigFileReader.Builder(file, new IHandle() {
            //单行读取执行器
            public void handle(String line) {
                    list.add(line);
            }
        }, new IFinishHandle() {
            //所有内容读取完毕后执行器
            public void handle() {
//                String s="INSERT INTO `test`.`news_item` (`id`, `category`, `create_time`, `list_img_url`, `sketch`, `status`, `title`) VALUES ('%s', '%s', '2018-03-06 15:22:07', '%s', '%s', '1', '%s');\n";
                String s="INSERT INTO `test`.`news_item_deatil` (`detail_img_url`,`details`, `news_item_id`) VALUES ('%s','%s', '%s');\n";
                StringBuilder sb=new StringBuilder();
                int per=5;
                int len=list.size();
                int count = len / per;
                int id=100;
                int status=1;
                for (int i = 0; i < count; i++) {
                    id ++;
                    String[] data = new String[per];
                    int k=0;
                    for (int j = i * per; j < (i + 1) * per; j++) {
                        data[k] = list.get(j);
                        k++;
                    }
                    String title = data[1];
                    String listImgUrl = data[2];
                    String sketch = data[3];
                    String details = data[4];
                    if(i<10){
                        status=1;
                    }else if(i>=10&&i<20){
                        status=3;
                    }else if(i>=20&&i<30){
                        status=4;
                    }else if(i>=30&&i<40){
                        status=2;
                    }
//                    sb.append(String.format(s, id,status, listImgUrl, sketch,  title));
                    sb.append(String.format(s,listImgUrl, details.replaceAll("\'","\""), id));
                }
                writeFile("C:\\Users\\Administrator\\Desktop\\writesql.sql",sb.toString());
            }
        });
        builder.withTreahdSize(1).withCharset("utf-8").withBufferSize(1024 * 1024);
        BigFileReader bigFileReader = builder.build();
        bigFileReader.start();
    }


    public static void writeFile(String path,String messageToWrite){
        RandomAccessFile raf=null;
        try {
            File file=new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
            raf = new RandomAccessFile(file, "rw");
            raf.write(messageToWrite.getBytes());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        FileUtils.read("C:\\Users\\Administrator\\Desktop\\Noname3.txt");
    }
}
