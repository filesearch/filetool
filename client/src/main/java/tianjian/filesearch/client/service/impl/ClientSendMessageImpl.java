package tianjian.filesearch.client.service.impl;

import file.model.message.RequestMessage;
import file.model.message.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tianjian.filesearch.client.service.ClientSendMessage;

/**
 * Created by tianjian on 2017/11/26.
 * 客户端和服务器端通信实现类
 */
@Service
public class ClientSendMessageImpl implements ClientSendMessage {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseMessage clientSendMessage(RequestMessage message) {
        String u = restTemplate.exchange("http://localhost:8080/rest/api", HttpMethod.GET, null, String.class).getBody();
        System.out.println(u);
        return null;
    }
}
