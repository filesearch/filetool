package tianjian.filesearch.client.service;

import java.io.File;

/**
 * Created by tianjian on 2017/11/25.
 * 监听的文件夹发生变化需要通知客户端进行操作
 */
public interface WatcherFile {

    //文件修改客户端需要做的动作
    String changeFile(File orgFile);

    //文件添加客户端需要的动作
    String addFile(File file);

    //文件删除客户端需要的动作
    String deleteFile(File file);

}
