package cn.xx.platform.solr.webmagic;

import cn.xx.platform.solr.webmagic.pipeline.SinaBlogPipeLine;
import cn.xx.platform.solr.webmagic.processor.SinaBlogProcessor;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;

/**
 * Created by Administrator on 2018/4/17.
 */
public class SinaBlogScrapyTest {
    public static void main(String[] args) {
        Spider.create(new SinaBlogProcessor())
                //从"http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html"开始抓
                .addUrl("http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html")
                //例如我们通过“控制台输出结果”这件事也是通过一个内置的Pipeline完成的，它叫做ConsolePipeline。那么，我现在想要把结果用Json的格式保存下来，怎么做呢？我只需要将Pipeline的实现换成"JsonFilePipeline"就可以了。
//                .addPipeline(new JsonFilePipeline("E:\\webmagic"))
                .addPipeline(new SinaBlogPipeLine())
                //开启5个线程抓取
                .thread(5)
                //启动爬虫
                .run();
    }
}
