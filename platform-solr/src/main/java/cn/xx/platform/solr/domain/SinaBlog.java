package cn.xx.platform.solr.domain;/**
 * Created by Administrator on 2018/4/17.
 */

import javax.persistence.*;

/**
 * SinaBlogPipeLine 专用
 */
@Entity
@Table(name = "sina_blog")
public class SinaBlog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Lob
    private String content;
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
