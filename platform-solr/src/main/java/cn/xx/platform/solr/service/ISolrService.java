package cn.xx.platform.solr.service;/**
 * Created by Administrator on 2018/4/17.
 */

import org.springframework.data.domain.Pageable;

/**
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 17:15 2018/4/17
 * @Modified By:
 */
public interface ISolrService {
    void addSinaBlogToIndex();
    void updateAllIndex();
    void delete(String key, Pageable pageable);
}
