package tianjian.filesearch.server.service.file;

/**
 * Created by tianjian on 2017/11/26.
 * 检查文件信息用户所有的资源只要一份
 */
public interface CheckFileService {

    boolean checkFileIsExist(String md5Info);

}
