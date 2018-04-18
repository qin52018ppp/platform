package cn.xx.platform.generate.repository;/**
 * Created by Administrator on 2018/4/17.
 */
import cn.xx.platform.generate.entity.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * JPA 操作数据
 */
public interface AreaRepository extends JpaRepository<Area,String> {
    @Query("SELECT new cn.xx.platform.generate.entity.Area(t.fircode,t.firname) FROM Area t GROUP BY t.fircode,t.firname")
    List<Area> findGroupFirCode();
    @Query("select new cn.xx.platform.generate.entity.Area(t.seccode as fircode,t.secname as firname) from Area t where t.fircode=?1 group by t.seccode,t.secname")
    List<Area> findGroupSecCode(String firCode);
    @Query("select new cn.xx.platform.generate.entity.Area(t.thicode as fircode,t.thirname as firname) from Area t where t.seccode=?1")
    List<Area> findGroupThiCode(String secCode);
}
