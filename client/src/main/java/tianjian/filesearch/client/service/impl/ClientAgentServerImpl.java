package tianjian.filesearch.client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tianjian.filesearch.client.service.ClientAgentServer;
import tianjian.filesearch.client.service.ScanFileService;

/**
 * Created by tianjian on 2017/11/25.
 */
public class ClientAgentServerImpl implements ClientAgentServer {

    @Autowired
    ScanFileService scanFileService;


    @Override
    public String initClientAgentServer() {
        //todo 服务启动需要扫描当前文件夹文件和服务器文件进行对比
        String filedata = scanFileService.getFileData("test");
        //todo 将该消息发送到服务器



        return null;
    }

    @Override
    public String stopClientAgentServer() {
        //todo 服务关闭需要对资源进行清理
        return null;
    }
}
