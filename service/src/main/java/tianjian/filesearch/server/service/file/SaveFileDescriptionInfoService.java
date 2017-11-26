package tianjian.filesearch.server.service.file;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by tianjian on 2017/11/26.
 * 将搜索信息写入服务器
 */
public interface SaveFileDescriptionInfoService {
    boolean saveFileDesciptionToService(JSONObject jsonObject);
}
