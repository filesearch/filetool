package tianjian.filesearch.server.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;
import tianjian.filesearch.server.service.DealMessage;
import tianjian.filesearch.server.service.MessageService;
import tianjian.filesearch.server.service.impl.DealMessageProxy;
import tianjian.filesearch.server.service.impl.InitFileMessageService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjian on 2017/11/12.
 */
@Configurable
@Service
public class MyConfiguration {
    @Bean
    public DealMessage getMessageServcie() {
        DealMessageProxy ctx = new DealMessageProxy();
        MessageService messageService = new InitFileMessageService("10002");
        MessageService messageService1 = new InitFileMessageService("10003");
        ctx.addDealMessage(messageService);
        ctx.addDealMessage(messageService1);
        return ctx;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        ActionFilter actionFilter = new ActionFilter();
        registrationBean.setFilter(actionFilter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/service/extract/json/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }

}
