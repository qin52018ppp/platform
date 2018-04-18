
package cn.xx.platform.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = {"cn.xx.platform.solr"})
public class SolrConfig {

	@Value("${spring.data.solr.host}")
	private String url;

	@Bean
	public SolrClient solrClient() {
		SolrClient client=new HttpSolrClient(url);
		return client;
	}

	@Bean
	public SolrTemplate solrTemplate() throws Exception {
		return new SolrTemplate(solrClient());
	}
}
