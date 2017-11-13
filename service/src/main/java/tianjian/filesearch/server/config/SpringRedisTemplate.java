package tianjian.filesearch.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/13
 * @description
 */
@Component
public class SpringRedisTemplate {

    private StringRedisTemplate template;

    @Autowired
    public SpringRedisTemplate(StringRedisTemplate template) {
        this.template = template;
    }

    public StringRedisTemplate getTemplate() {
        return template;
    }

    public void setTemplate(StringRedisTemplate template) {
        this.template = template;
    }
}
