package tianjian.filesearch.client.service.impl;

import file.model.file.FileMetadata;
import file.util.FileUtil;
import file.util.ResourceListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static file.util.FileUtil.saveFileToEs;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/8
 * @description 这个是假对不是接口实现
 */
@Component
public class UploadFileServiceImpl {

    public void watchAndScanFile() throws ParseException, IOException {
        List<FileMetadata> fileMetadatas = new ArrayList<FileMetadata>();
        List<File> files = new ArrayList<File>();
        FileUtil.getFilesByPath(new File("D:\\watchfile"), f -> {
            if(f.getName().endsWith("doc") || f.getName().endsWith("txt")) {
                return true;
            }
            return false;
        }, files);
        for(File f : files) {
            saveFileToEs(f);
        }
        ResourceListener.addListener("D:\\watchfile");

    }
}
