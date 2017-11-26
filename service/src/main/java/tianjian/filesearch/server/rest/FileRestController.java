package tianjian.filesearch.server.rest;

import file.model.message.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tianjian.filesearch.server.service.sys.DealMessage;


@RestController
@RequestMapping("/rest")
public class FileRestController {

  @Autowired
  DealMessage dealMessage;

  @Autowired
  StringRedisTemplate stringRedisTemplate;

  @RequestMapping(value = "/server", method = RequestMethod.GET)
  public String restController(String token) throws Exception {
    RequestMessage requestMessage = new RequestMessage();
    requestMessage.setCode("10002");
    requestMessage.setMessage("hahah");
    dealMessage.dealMessage(requestMessage);
    System.out.println("===========================ok===========================");
    throw new Exception("test");
    //return JSON.toJSONString(dealMessage.dealMessage(requestMessage));
  }

  @RequestMapping(value = "/api", method = RequestMethod.GET)
  public String testRestTmeplate() {
    return "test";
  }
}
