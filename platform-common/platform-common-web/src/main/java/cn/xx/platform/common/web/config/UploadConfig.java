package cn.xx.platform.common.web.config;

import cn.xx.platform.common.upload.DiskFileOperator;
import cn.xx.platform.common.upload.FileOperator;
import cn.xx.platform.common.upload.util.FileManager;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件上传配置
 *
 *
 */
@Configuration
public class UploadConfig {

    /**
     * Oss io operator oss io operator.
     *
     * @return the oss io operator
     */
    @Bean
    @ConfigurationProperties("upload")
    public DiskFileOperator diskFileOperator() {
        return new DiskFileOperator();
    }

    /**
     * File manager io manager.
     *
     * @param fileOperator the io operator
     * @return the io manager
     */
    @Bean
    public FileManager fileManager(FileOperator fileOperator) {
        FileManager fileManager = new FileManager();
        fileManager.setFileOperator(fileOperator);
        return fileManager;
    }

}