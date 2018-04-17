package cn.xx.platform.solr.controller;

import cn.xx.platform.solr.webmagic.pipeline.SinaBlogPipeLine;
import cn.xx.platform.solr.webmagic.processor.SinaBlogProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import us.codecraft.webmagic.Spider;

@RequestMapping("/webmagic")
public class WebMagicController {
/*    @Autowired
    private IWebMagicService webMagicService;*/
    @Autowired
    private SinaBlogPipeLine sinaBlogPipeLine;

    @RequestMapping("/test")
    public String test(){
      return "test";
    }

   /* @RequestMapping("/testSaveData")
    public String testSaveData(){
        SinaBlog sinaBlog=new SinaBlog();
        sinaBlog.setTitle("test");
        webMagicService.save(sinaBlog);
        return "successs";
    }*/

    @RequestMapping("/sina")
    public void sina() {
        Spider.create(new SinaBlogProcessor())
                .addUrl("http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html")
                .addPipeline(sinaBlogPipeLine)
                .thread(5)
                .run();
    }
}
