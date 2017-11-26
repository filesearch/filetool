package tianjian.filesearch.client.service;

import file.model.message.RequestMessage;
import file.model.message.ResponseMessage;

/**
 * Created by tianjian on 2017/11/25.
 * 实现和服务器端通信能力
 */
public interface ClientSendMessage {

    /**
     *
     * @param message
     * @return
     */
    ResponseMessage clientSendMessage(RequestMessage message);

}
