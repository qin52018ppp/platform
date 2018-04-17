package cn.xx.platform.solr.service.impl;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.repository.SinaBlogRepository;
import cn.xx.platform.solr.repository.SinaBlogSolrRepository;
import cn.xx.platform.solr.service.ISolrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 17:16 2018/4/17
 * @Modified By:
 */
@Service
public class SolrServiceImpl implements ISolrService {
    @Autowired
    private SinaBlogRepository sinaBlogRepository;
    @Autowired
    private SinaBlogSolrRepository sinaBlogSolrRepository;
    @Override
    public void addSinaBlogToIndex() {
        
    }

    @Override
    public void updateAllIndex() {

    }

    @Override
    public void delete(String key, Pageable pageable) {

    }
}
