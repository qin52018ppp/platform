package cn.xx.platform.common.web.util;

import cn.xx.platform.common.upload.util.FileIndex;
import cn.xx.platform.system.api.exception.base.SystemException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Web 工具类
 *
 *
 */
public final class WebUtils {

    /**
     * 文件临时存储路径
     */
    private static final String TEMP_FILE_PATH = "/tmp";

    private WebUtils() {
        throw new IllegalAccessError("Utility class");
    }

    /**
     * 文件类型转换
     *
     * @param file MultipartFile
     * @return File io
     */
    public static File transfer(MultipartFile file) {
        File upFile = new File(new File(TEMP_FILE_PATH), file.getOriginalFilename());
        try {
            file.transferTo(upFile);
        } catch (IllegalStateException | IOException ex) {
            throw new SystemException(ex);
        }
        return upFile;
    }

    /**
     * 构建FileIndex
     *
     * @param file   MultipartFile
     * @param folder 文件路径
     * @return FileIndex io index
     */
    public static FileIndex buildFileIndex(MultipartFile file, String folder) {
        return new FileIndex(transfer(file), file.getOriginalFilename(), folder);
    }

    /**
     * 获取当前登录者对象
     *
     * @param <T> the type parameter
     * @return the current user
     */
    @SuppressWarnings("unchecked")
    public static <T extends UserDetails> T getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (T) authentication.getPrincipal();
    }

}
