package tianjian.filesearch.server.rest;

import com.alibaba.fastjson.JSON;
import file.model.message.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tianjian.filesearch.server.service.DealMessage;

import java.util.*;

import static tianjian.filesearch.server.config.ConstantValue.COUNTING;


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
    return JSON.toJSONString(dealMessage.dealMessage(requestMessage));
  }
}
