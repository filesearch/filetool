package tianjian.filesearch.client.service;

import java.io.File;
import java.io.IOException;

/**
 * Created by tianjian on 2017/11/25.
 * 监听的文件夹发生变化需要通知客户端进行操作
 */
public interface FileChangeEvent {

    //文件修改客户端需要做的动作
    boolean changeFile(File orgFile) throws IOException;

    //文件添加客户端需要的动作
    boolean addFile(File file) throws IOException;

    //文件删除客户端需要的动作
    boolean deleteFile(File file);

}
