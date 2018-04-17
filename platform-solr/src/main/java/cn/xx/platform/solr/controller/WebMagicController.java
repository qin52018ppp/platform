package cn.xx.platform.solr.controller;

import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.service.IWebMagicService;
import cn.xx.platform.solr.service.impl.WebMagicServiceImpl;
import cn.xx.platform.solr.webmagic.pipeline.SinaBlogPipeLine;
import cn.xx.platform.solr.webmagic.processor.SinaBlogProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import us.codecraft.webmagic.Spider;

@Controller
@RequestMapping("/webmagic")
public class WebMagicController {
    @Autowired
    private IWebMagicService webMagicService;
    @Autowired
    private SinaBlogPipeLine sinaBlogPipeLine;

    @RequestMapping("/test")
    public String test(){
      return "test";
    }
    @RequestMapping("/testSaveData")
    @ResponseBody
    public String testSaveData(){
        SinaBlog sinaBlog=new SinaBlog();
        sinaBlog.setTitle("test");
        webMagicService.save(sinaBlog);
        return "successs";
    }

    @RequestMapping("/sina")
    @ResponseBody
    public String sina(){
        Spider.create(new SinaBlogProcessor()).addUrl("http://blog.sina.com.cn/s/articlelist_1487828712_0_1.html").addPipeline(sinaBlogPipeLine).thread(5).run();
        return "successs";
    }
}
