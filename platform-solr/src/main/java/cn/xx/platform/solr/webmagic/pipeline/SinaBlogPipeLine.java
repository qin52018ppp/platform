package cn.xx.platform.solr.webmagic.pipeline;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.service.impl.WebMagicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.lang.reflect.Field;
import java.util.Map;

@Component
public class SinaBlogPipeLine implements Pipeline {
    private static final Logger logger= LoggerFactory.getLogger(SinaBlogPipeLine.class);
    @Autowired
    private WebMagicService webMagicService;
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
        SinaBlog sinaBlog = new SinaBlog();
        for (Map.Entry<String, Object> entry : items.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            Field field = ReflectionUtils.findField(sinaBlog.getClass(), key);
            if (field != null) {
                ReflectionUtils.setField(field, sinaBlog, value);
            }
        }
        webMagicService.save(sinaBlog);
    }
}
