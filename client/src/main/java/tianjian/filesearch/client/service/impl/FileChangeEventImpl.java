package tianjian.filesearch.client.service.impl;

import file.model.file.ServiceType;
import file.model.message.RequestMessage;
import file.model.message.ResponseMessage;
import file.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import tianjian.filesearch.client.service.ClientSendMessage;
import tianjian.filesearch.client.service.FileChangeEvent;
import tianjian.filesearch.client.service.UploadFileService;
import tianjian.filesearch.client.util.RequestMessageFactory;

import java.io.File;
import java.io.IOException;

/**
 * Created by tianjian on 2017/11/26.
 * 文件变动需要实现对服务器端跟新操作类
 */
public class FileChangeEventImpl implements FileChangeEvent {

    @Autowired
    UploadFileService uploadFileService;

    @Autowired
    ClientSendMessage clientSendMessage;

    @Override
    public boolean changeFile(File orgFile) throws IOException {
        /**
         * 先发送消息让服务器删除原来已有的旧资源
         */
        deleteFile(orgFile);
        /**
         * 上传现在更新后的资源
         */
        return uploadFileService.uploadFileService(FileUtil.getFileAsBytes(orgFile));
    }

    @Override
    public boolean addFile(File file) throws IOException {
        /**
         * 通知服务器添加文件信息
         */
        RequestMessage requestMessage = RequestMessageFactory.getFileRequestMessage(ServiceType.ADD.getCode(), file.getName());
        ResponseMessage responseMessage = clientSendMessage.clientSendMessage(requestMessage);
        if(!responseMessage.isResult()) {
            return false;
        }
        /**
         * 将文件上传到服务器
         */
        return uploadFileService.uploadFileService(FileUtil.getFileAsBytes(file));
    }

    @Override
    public boolean deleteFile(File file) {
        RequestMessage requestMessage = RequestMessageFactory.getFileRequestMessage(ServiceType.ADD.getCode(), file.getName());
        ResponseMessage responseMessage = clientSendMessage.clientSendMessage(requestMessage);
        return responseMessage.isResult();

    }

}
