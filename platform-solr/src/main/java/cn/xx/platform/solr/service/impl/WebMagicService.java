package cn.xx.platform.solr.service.impl;
import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.repository.SinaBlogRepository;
import cn.xx.platform.solr.service.IWebMagicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebMagicService implements IWebMagicService {
    @Autowired
    private SinaBlogRepository sinaBlogRepository;
    /**
     * 插入
     *
     * @param sinaBlog
     */
    @Override
    public void save(SinaBlog sinaBlog) {
        sinaBlogRepository.save(sinaBlog);
    }
}
