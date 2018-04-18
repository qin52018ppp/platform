package cn.xx.platform.solr.service;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.domain.SinaBlogSolr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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
    List<SinaBlog> findByTitle(String title);
    // 可以把@Query注释掉， findByNameContaining就变成了 name:*?0*，仅按名称匹配
//	@Query(value = "name:*?0* or category:*?0*")
    Page<SinaBlog> findByTitleContaining(String name, Pageable pageable);
}
