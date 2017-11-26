package tianjian.filesearch.server.service.file;

/**
 * Created by tianjian on 2017/11/26.
 * 验证用户token信息
 */
public interface CheckTokenService {
    boolean checkToken(String token);
}
