package tianjian.filesearch.client.util;

import file.model.message.RequestMessage;

import java.util.Date;

/**
 * Created by tianjian on 2017/11/26.
 */
public class RequestMessageFactory {
    public static RequestMessage getFileRequestMessage(String code, String fileName){
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setCode(code);
        requestMessage.setTime(new Date());
        requestMessage.setFileName(fileName);
        requestMessage.setToken("token");
        requestMessage.setNode("clientCode");
        return requestMessage;
    }

}
