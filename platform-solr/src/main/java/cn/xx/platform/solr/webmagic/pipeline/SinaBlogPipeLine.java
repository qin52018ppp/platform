package cn.xx.platform.solr.webmagic.pipeline;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.service.IWebMagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Map;

@Component("sinaBlogPipeLine")
public class SinaBlogPipeLine implements Pipeline {
    @Autowired
    private IWebMagicService webMagicService;
    /**
     * Process extracted results.
     *
     * @param resultItems resultItems
     * @param task        task
     */
    @Override
    public void process(ResultItems resultItems, Task task) {
        Map<String, Object> items = resultItems.getAll();
        if(items==null || items.isEmpty())
            return;
        try {
            SinaBlog sinaBlog = new SinaBlog();
            for (Map.Entry<String, Object> entry : items.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if(key.equals("title")){
                    sinaBlog.setTitle(value.toString());
                }else if(key.equals("content")){
                    sinaBlog.setContent(value.toString());
                }else if(key.equals("date")){
                    sinaBlog.setDate(value.toString());
                }
            }
            webMagicService.save(sinaBlog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
