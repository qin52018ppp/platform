package cn.xx.platform.solr.repository;/**
 * Created by Administrator on 2018/4/17.
 */

import cn.xx.platform.solr.domain.SinaBlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SinaBlogRepository extends JpaRepository<SinaBlog,Long> {
}
