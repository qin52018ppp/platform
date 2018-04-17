package cn.xx.platform.solr.repository;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.domain.SinaBlogSolr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

/**
 * solr 操作
 */
public interface SinaBlogSolrRepository extends SolrCrudRepository<SinaBlogSolr,Long> {
    List<SinaBlog> findByTitle(String title);
    // 可以把@Query注释掉， findByNameContaining就变成了 name:*?0*，仅按名称匹配
//	@Query(value = "name:*?0* or category:*?0*")
    Page<SinaBlog> findByTitleContaining(String name, Pageable pageable);
}
