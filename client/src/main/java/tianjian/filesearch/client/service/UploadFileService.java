package tianjian.filesearch.client.service;

/**
 * Created by tianjian on 2017/11/25.
 * 文件上传服务器
 */
public interface UploadFileService {

    //文件修改或添加需要上传文件
    boolean uploadFileService(byte[] bytes);

}
