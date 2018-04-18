
package cn.xx.platform.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/*@Configuration
@EnableSolrRepositories("cn.xx.platform.solr")
public class SolrCloudConfig {

	@Value("${spring.data.solr.host}")
	private String url;

	@Bean
	public SolrClient solrClient() {
		CloudSolrClient client=new CloudSolrClient(url);
		client.setDefaultCollection("sinablog");
		client.setZkClientTimeout(30000);
		client.setZkConnectTimeout(30000);
		return client;
	}

	@Bean
	public SolrTemplate solrTemplate() throws Exception {
		return new SolrTemplate(solrClient());
	}
}*/
