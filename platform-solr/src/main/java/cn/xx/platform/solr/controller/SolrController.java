package cn.xx.platform.solr.controller;

import cn.xx.platform.solr.service.ISolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
@RestController
@RequestMapping("/solr")
public class SolrController {

    @Autowired
    private SolrClient client;
    @Autowired
    private ISolrService solrService;

    @RequestMapping("/test")
    public String testSolr() throws IOException, SolrServerException {
        SolrDocument document = client.getById("test", "fe7a5124-d75b-40b2-93fe-5555512ea6d2");
        return document.toString();
    }

    @PostMapping("/addSolr")
    public void addSolr() {
        solrService.addSinaBlogToIndex();
    }



}
