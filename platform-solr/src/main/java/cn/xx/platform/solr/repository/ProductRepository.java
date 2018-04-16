package cn.xx.platform.solr.repository;
import cn.xx.platform.solr.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface ProductRepository extends SolrCrudRepository<Product, String> {
	
	
	List<Product> findByName(String name);


	// 可以把@Query注释掉， findByNameContaining就变成了 name:*?0*，仅按名称匹配
//	@Query(value = "name:*?0* or category:*?0*")
	Page<Product> findByNameContaining(String name, Pageable pageable);
}

