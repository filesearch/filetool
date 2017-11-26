package tianjian.filesearch.client.service;

import file.model.file.FileList;

import java.util.List;

/**
 * Created by tianjian on 2017/11/25.
 * 根据文件名称和内容签名进行对比对能力并对服务器资源跟新
 */
public interface ComparisonFile {

    //和服务器文件进行对比确认，系统初始化需要处理
    boolean comparisonFileToService(List<FileList> filelists);

}
