package cn.xx.platform;

import cn.xx.platform.solr.Application;
import cn.xx.platform.solr.domain.SinaBlog;
import cn.xx.platform.solr.domain.SinaBlogSolr;
import cn.xx.platform.solr.repository.SinaBlogRepository;
import cn.xx.platform.solr.service.ISolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SolrServiceTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SolrServiceTest.class);
    @Autowired
    private ISolrService solrService;

    @Autowired
    private SinaBlogRepository sinaBlogRepository;

    @Autowired
    private SolrClient solrClient;
    @Ignore
    @Test
    public void test() {
        Assert.assertEquals(1,1);
    }

    /**
     * 使用SolrCrudRepository永远报错  带求解
     * nested exception is org.apache.solr.client.solrj.impl.HttpSolrClient$RemoteSolrException: Error from server at http://127.0.0.1:8983/solr/sinablog: Expected mime type application/octet-stream but got text/html.
     */
    @Ignore
    @Test
    public void testAddSinaBlogToIndex() {
       solrService.addSinaBlogToIndex();
    }

    /**
     * 非注解模式直接提交
     */
    @Test
    public void insertBySolrInputDocument() {
        List<SinaBlog> sinaBlogs = sinaBlogRepository.findAll();
        for (SinaBlog sinaBlog : sinaBlogs) {
            SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", sinaBlog.getId());
            doc.addField("title", sinaBlog.getTitle());
            doc.addField("content", sinaBlog.getContent());
            doc.addField("date", sinaBlog.getDate());
            try {
                solrClient.add(doc);
                solrClient.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 注解模式直接提交Bean
     */
    @Test
    public void insert() {
        List<SinaBlog> sinaBlogs = sinaBlogRepository.findAll();
        for (SinaBlog sinaBlog : sinaBlogs) {
            try {
                SinaBlogSolr sinaBlogSlor = new SinaBlogSolr();
                BeanUtils.copyProperties(sinaBlog, sinaBlogSlor);
                solrClient.addBean(sinaBlogSlor);
                solrClient.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void deleteAll() {
        try {
            UpdateResponse response = solrClient.deleteByQuery("id:id");
            solrClient.commit();
            int status = response.getStatus();
            LOGGER.info("status = " + status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testQuery(/*String qString, Integer pageNum, Integer pageSize*/) {
        try {
            String qString="原理";
            Integer pageNum=1;
            Integer pageSize=5;
            SolrQuery query = new SolrQuery("title:WEB");// 查询字符串
            query.setStart((pageNum - 1) * pageSize);// 设置查询开始下标
            query.setRows(pageSize);// 查询行数
            //高亮配置
            query.setHighlight(true);
            query.setHighlightSimplePre("<em>");
            query.setHighlightSimplePost("</em>");
            query.addHighlightField("title");

            QueryResponse response = solrClient.query(query);// 获取查询返回对象

            SolrDocumentList docs = response.getResults();// 获取查询得到的所有Document
            //查询高亮信息
            Map<String, Map<String, List<String>>> highlightings = response.getHighlighting();
            List<SinaBlogSolr> list = new ArrayList<SinaBlogSolr>();
            for (SolrDocument doc : docs) {
                // 获取每个Document的详细信息
                SinaBlogSolr sinaBlogSolr = new SinaBlogSolr();
                sinaBlogSolr.setId(Long.parseLong(doc.getFieldValue("id").toString()));
                sinaBlogSolr.setTitle(doc.getFieldValue("title").toString());
                sinaBlogSolr.setContent(doc.getFieldValue("content").toString());
                list.add(sinaBlogSolr);
            }

            //其他查询信息
            NamedList responseHeader = response.getResponseHeader();
            SimpleOrderedMap params = (SimpleOrderedMap) responseHeader.get("params");
            NamedList<Object> responseResponse = response.getResponse();
            SolrDocumentList responseBean = (SolrDocumentList) responseResponse.get("response");

            int qTime = response.getQTime();
            int status = response.getStatus();

            Object q = params.get("q");
            Object fq = params.get("fq");
            Object numFound = responseBean.getNumFound();

            Object start = responseBean.getStart();


            LOGGER.info("==================================================" + list.size());
        } catch (Exception e) {
            LOGGER.error("solr server exception:", e);
        }
    }


    @Test
    public void deleteById() {
        try {
            UpdateResponse response = solrClient.deleteById("158");
            solrClient.commit();
            int status = response.getStatus();
            LOGGER.info("status = " + status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
