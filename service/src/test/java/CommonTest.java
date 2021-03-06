import com.alibaba.fastjson.JSON;
import file.model.message.RequestMessage;
import org.junit.Test;
import tianjian.filesearch.server.service.sys.MessageService;
import tianjian.filesearch.server.service.sys.impl.DealMessageProxy;
import tianjian.filesearch.server.service.sys.impl.InitFileMessageService;
import file.util.HttpClientUtil;

import java.util.Date;
import java.util.UUID;


/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/7
 * @description
 */
public class CommonTest {

    @Test
    public void proxyDealTest() throws Exception {

        DealMessageProxy ctx = new DealMessageProxy();
        MessageService messageService0 = new InitFileMessageService("10002");
        MessageService messageService1 = new InitFileMessageService("10003");
        MessageService messageService2 = new InitFileMessageService("10004");
        MessageService messageService3 = new InitFileMessageService("10005");
        ctx.addDealMessage(messageService0);
        ctx.addDealMessage(messageService1);
        ctx.addDealMessage(messageService2);
        ctx.addDealMessage(messageService3);
        RequestMessage requestMessage = new RequestMessage();
        requestMessage.setCode("10003");
        requestMessage.setToken("token");
        requestMessage.setMessage("message");
        requestMessage.setNode("window");
        requestMessage.setTime(new Date());
        System.out.println(JSON.toJSONString(ctx.dealMessage(requestMessage)));
    }

    @Test
    public void getClientTest() {
        for(int i = 0 ; i < 1000; i++) {
            String token = UUID.randomUUID().toString();
            HttpClientUtil.httpGet(token);
        }

    }





}
