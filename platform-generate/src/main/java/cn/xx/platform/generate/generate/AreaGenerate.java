package cn.xx.platform.generate.generate;/**
 * Created by Administrator on 2018/4/18.
 */

import cn.xx.platform.common.utils.FileHelper;
import cn.xx.platform.generate.entity.Area;
import cn.xx.platform.generate.repository.AreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


/**
 * @Company:TOdb
 * @Auth:秦盼（Q）
 * @Description:秦盼（Q）
 * @Date:Created in 16:43 2018/4/18
 * @Modified By:
 */
@Component
public class AreaGenerate {
    private static final Logger LOGGER = LoggerFactory.getLogger(AreaGenerate.class);

    @Autowired
    private AreaRepository areaRepository;
    public void generateFromDbToJson() {
        List<Area> list = areaRepository.findGroupFirCode();
        StringBuffer sb = new StringBuffer("[");
        int firSize = list.size();
        for (int b = 0; b < firSize; b++) {
            Area m=list.get(b);
            String fircode = m.getFircode();
            String firname = m.getFirname();
            sb.append("{name: \" " +firname  + "\",code: \"" + fircode + "\"");
            List<Area> secList = areaRepository.findGroupSecCode(fircode);
            int secSize=secList.size();
            if (secSize > 0) {
                sb.append(",child: [");
                for (int q = 0; q < secSize; q++) {
                    Area a = secList.get(q);
                    String secCode = a.getFircode();
                    sb.append("{name: \" " + a.getFirname() + "\",code: \"" + secCode + "\"");
                    List<Area> thiAres = areaRepository.findGroupThiCode(secCode);
                    int thiSize=thiAres.size();
                    if (thiSize > 0) {
                        sb.append(",child: [");
                        for (int j = 0; j < thiSize; j++) {
                            Area k = thiAres.get(j);
                            sb.append("{name: \" " + k.getFirname() + "\",code: \"" + k.getFircode() + "\"}");
                            if (j != thiSize - 1) {
                                sb.append(",");
                            }
                        }
                        sb.append("]}");
                    }else{
                        sb.append("}");
                    }
                    if(q!=secSize-1){
                        sb.append(",");
                    }
                }
                sb.append("]}");
            }else{
                sb.append("}");
            }
            if (b != firSize - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        LOGGER.info("=====================================\n" + sb.toString());
        try {
            FileHelper.saveData("D:\\node_static\\coreProduct\\static\\public\\js\\test.js",sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
