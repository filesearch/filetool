package tianjian.filesearch.client.service;

import file.model.file.FileList;

import java.util.List;

/**
 * Created by tianjian on 2017/11/25.
 * 根据提供对文件路径对文件进行扫描分析生成文件清单
 */
public interface ScanFileService {
    //获取文件夹下文件信息
    List<FileList> getFileData(String filepath);

}
