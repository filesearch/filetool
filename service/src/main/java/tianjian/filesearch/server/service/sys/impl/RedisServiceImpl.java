package tianjian.filesearch.server.service.sys.impl;

import org.springframework.stereotype.Service;
import tianjian.filesearch.server.model.RedisModel;
import tianjian.filesearch.server.service.sys.IRedisService;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/13
 * @description
 */
@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {
    private static final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}