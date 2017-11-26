package tianjian.filesearch.client.service.impl;

import com.alibaba.fastjson.JSON;
import file.model.file.FileList;
import file.model.file.ServiceType;
import file.model.message.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import tianjian.filesearch.client.service.ClientSendMessage;
import tianjian.filesearch.client.service.ComparisonFile;
import tianjian.filesearch.client.util.RequestMessageFactory;

import java.util.List;

/**
 * Created by tianjian on 2017/11/26.
 * 对比文件实现类
 */
public class ComparisonFileImpl implements ComparisonFile {

    @Autowired
    ClientSendMessage clientSendMessage;

    @Override
    public boolean comparisonFileToService(List<FileList> fileLists) {
        //请求服务器文件资源清单用于对比文件
        RequestMessage requestMessage = RequestMessageFactory.getFileRequestMessage(ServiceType.FILELIST.getCode(), null);
        String data = clientSendMessage.clientSendMessage(requestMessage).getData();
        List<FileList> files = JSON.parseArray(data, FileList.class);
        dealFileDifferent(fileLists, files);
        return true;
    }
    //todo 根据本地文件和服务文件对比结果进行分析，对文件进行处理
    private String dealFileDifferent(List<FileList> clientFiles, List<FileList> serverFiles) {
        //可以先对2个清单进行数字签名迅速对比是否相同，如果相同就无需进行迭代对比处理
        return null;
    }
}
