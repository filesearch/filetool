package tianjian.filesearch.client.service.impl;

import file.model.file.FileList;
import org.springframework.beans.factory.annotation.Autowired;
import tianjian.filesearch.client.service.ClientAgentServer;
import tianjian.filesearch.client.service.ComparisonFile;
import tianjian.filesearch.client.service.ScanFileService;

import java.util.List;

/**
 * Created by tianjian on 2017/11/25.
 * 客户端启动初始化类操作
 */
public class ClientAgentServerImpl implements ClientAgentServer {

    @Autowired
    ScanFileService scanFileService;

    @Autowired
    ComparisonFile comparisonFile;


    @Override
    public String initClientAgentServer() {
        //todo 服务启动需要扫描当前文件夹文件和服务器文件进行对比
        List<FileList> filedatas = scanFileService.getFileData("test");

        comparisonFile.comparisonFileToService(filedatas);

        return null;
    }

    @Override
    public String stopClientAgentServer() {
        //todo 服务关闭需要对资源进行清理
        return null;
    }
}
