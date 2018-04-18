package cn.xx.platform.generate.entity;/**
 * Created by Administrator on 2018/4/18.
 */

import javax.persistence.*;

/**
 * @Company:
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 16:45 2018/4/18
 * @Modified By:
 */
@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue
    private Long id;
    private String fircode;
    private String seccode;
    private String thicode;
    private String firname;
    private String secname;
    private String thirname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFircode() {
        return fircode;
    }

    public void setFircode(String fircode) {
        this.fircode = fircode;
    }

    public String getSeccode() {
        return seccode;
    }

    public void setSeccode(String seccode) {
        this.seccode = seccode;
    }

    public String getThicode() {
        return thicode;
    }

    public void setThicode(String thicode) {
        this.thicode = thicode;
    }

    public String getFirname() {
        return firname;
    }

    public void setFirname(String firname) {
        this.firname = firname;
    }

    public String getSecname() {
        return secname;
    }

    public void setSecname(String secname) {
        this.secname = secname;
    }

    public String getThirname() {
        return thirname;
    }

    public void setThirname(String thirname) {
        this.thirname = thirname;
    }


    public Area(String fircode, String firname) {
        this.fircode = fircode;
        this.firname = firname;
    }


}
