package tianjian.filesearch.server.service.file;

import file.model.file.FileList;

import java.util.List;

/**
 * Created by tianjian on 2017/11/26.
 */
public interface FileListService {
    /**
     * 为服务器提供当前服务器文件信息
     * @param token
     * @return
     */
    List<FileList> getFileListService(String token);

    /**
     * 删除服务器文件存储信息，用户注销，文件过期操作
     * @param token
     * @return
     */
    boolean deleteFileListService(String token);

    /**
     * 添加文件存储信息，更新注册等
     * @param token
     * @return
     */
    boolean addFileListServcie(String token);
}
