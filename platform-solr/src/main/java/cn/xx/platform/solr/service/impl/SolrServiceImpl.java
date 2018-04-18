package cn.xx.platform.solr.service.impl;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.domain.SinaBlogSolr;
import cn.xx.platform.solr.repository.SinaBlogRepository;
import cn.xx.platform.solr.repository.SinaBlogSolrRepository;
import cn.xx.platform.solr.service.ISolrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 17:16 2018/4/17
 * @Modified By:
 */
@Service
public class SolrServiceImpl implements ISolrService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SolrServiceImpl.class);
    @Autowired
    private SinaBlogRepository sinaBlogRepository;
    @Autowired
    private SinaBlogSolrRepository sinaBlogSolrRepository;

    @Override
    public void addSinaBlogToIndex() {
        List<SinaBlog> sinaBlogs = sinaBlogRepository.findAll();
        for (SinaBlog sinaBlog : sinaBlogs) {
            SinaBlogSolr sinaBlogSlor = new SinaBlogSolr();
            BeanUtils.copyProperties(sinaBlog, sinaBlogSlor);
            try {
                SinaBlogSolr s=sinaBlogSolrRepository.save(sinaBlogSlor);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }

    @Override
    public void updateAllIndex() {

    }

    @Override
    public void delete(String key, Pageable pageable) {

    }

    @Override
    public List<SinaBlog> findByTitle(String title) {
        return sinaBlogSolrRepository.findByTitle(title);
    }

    @Override
    public Page<SinaBlog> findByTitleContaining(String name, Pageable pageable) {
        return sinaBlogSolrRepository.findByTitleContaining(name,pageable);
    }
}
