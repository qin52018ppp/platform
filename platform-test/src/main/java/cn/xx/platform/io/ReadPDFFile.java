package cn.xx.platform.io;/**
 * Created by Administrator on 2018/5/18.
 */

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 14:40 2018/5/18
 * @Modified By:
 */
public class ReadPDFFile {
    private static final Logger LOGGER= LoggerFactory.getLogger(ReadPDFFile.class);
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static String readPDFFile(File file) {
        if (!file.exists())
            return "";
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            PDDocumentInformation info = document.getDocumentInformation();
           LOGGER.info( "标题:" + info.getTitle() );
           LOGGER.info( "主题:" + info.getSubject() );
           LOGGER.info( "作者:" + info.getAuthor() );
           LOGGER.info( "关键字:" + info.getKeywords() );

           LOGGER.info( "应用程序:" + info.getCreator() );
           LOGGER.info( "pdf 制作程序:" + info.getProducer() );

           LOGGER.info( "作者:" + info.getTrapped() );

            LOGGER.info("创建时间:" + DateFormatUtils.format(info.getCreationDate(), DATE_FORMAT));
            LOGGER.info("修改时间:" + DateFormatUtils.format(info.getModificationDate(), DATE_FORMAT));
            
            int lastPage = document.getNumberOfPages();
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setStartPage(5);
            stripper.setEndPage(lastPage);
            String content= stripper.getText(document);
//            int idx = content.indexOf("【轻症疾病】") ;
//            idx=content.indexOf("【白血病】");
            int idx=content.indexOf("【白血病】");
            if (idx > 0) {
                content = content.substring(idx).replaceAll(" . / "+lastPage+" \r","\r");
            }
            System.out.println(content.replaceAll("\r\n","<br>").replaceAll("<br><br> <br>","<br>"));
            /** 文档页面信息 **/
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
               if(document!=null) document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static boolean isPageIndex(String v,int lastPage) {
        Pattern pattern = Pattern.compile(" * / 7 \r");// 匹配的模式
        Matcher m = pattern.matcher(v);
        int i = 0;
        while (m.find()) {
            i++;
        }
        return i == 1;
    }
    public static void main(String[] args) {
        File file = new File("E:\\20161128\\核心系统\\泰康疾病综合\\条款\\e顺轻症疾病保险条款.pdf");
        readPDFFile(file);
    }
}
