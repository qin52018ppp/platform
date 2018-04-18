package cn.xx.platform.generate;/**
 * Created by Administrator on 2018/4/18.
 */

import cn.xx.platform.generate.generate.AreaGenerate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Company:新概念保险
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 17:17 2018/4/18
 * @Modified By:
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class AreaGenerateTest {

    @Autowired
    private AreaGenerate areaGenerate;

    /**
     *
     */
    @Test
    public void testGenerateFromDbToJson(){
        areaGenerate.generateFromDbToJson();
    }
}
