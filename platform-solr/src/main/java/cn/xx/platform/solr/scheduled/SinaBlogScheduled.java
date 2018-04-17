package cn.xx.platform.solr.scheduled;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.webmagic.pipeline.SinaBlogPipeLine;
import cn.xx.platform.solr.webmagic.processor.SinaBlogProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import us.codecraft.webmagic.Spider;

/**
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 15:28 2018/4/17
 * @Modified By:
 */
public class SinaBlogScheduled {
    private static final Logger LOGGER= LoggerFactory.getLogger(SinaBlogScheduled.class);
//    fixRate和fixDelay参数都指定了函数每隔某个毫秒数执行一次，但是他们之间也有细小的差别。fixRate的计时是相对于系统时间的，也就是一定相隔会固定时间执行。
    @Scheduled(fixedDelay = 10000L)
    public void hello() {
        LOGGER.debug("=================hello world==========");
    }
    /*
    @Scheduled(fixedDelay = 10000L)
    public void send() {
        Spider.create(new SinaBlogProcessor())
                .addUrl("http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html")
                .addPipeline(new SinaBlogPipeLine())
                .thread(5)
                .run();
    }*/
}
