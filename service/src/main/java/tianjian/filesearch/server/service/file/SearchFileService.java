package tianjian.filesearch.server.service.file;

import java.util.List;
import java.util.Map;

/**
 * Created by tianjian on 2017/11/26.
 * 查找文件服务
 */
public interface SearchFileService {
    List<String> getFileBySearch(Map<String,String> paramters);
}
