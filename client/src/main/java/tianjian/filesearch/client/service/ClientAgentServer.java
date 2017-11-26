package tianjian.filesearch.client.service;

/**
 * Created by tianjian on 2017/11/25.
 * 实现服务启动初始化操作
 */
public interface ClientAgentServer {

    /**
     * 服务启动初始化
     * @return
     */
    String initClientAgentServer();

    /**
     * 服务关闭
     * @return
     */
    String stopClientAgentServer();


}
