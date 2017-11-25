package tianjian.filesearch.client.service.impl;

import tianjian.filesearch.client.service.EncryptFile;
import tianjian.filesearch.client.service.UploadFileService;

/**
 * Created by tianjian on 2017/11/25.
 */
public class EncryptUploadFileService implements UploadFileService{

    EncryptFile encryptFile;

    UploadFileService uploadFileService;

    public EncryptUploadFileService(UploadFileService uploadFileService) {
        this.uploadFileService = uploadFileService;
    }

    @Override
    public String uploadFileService(byte[] file) {
        return uploadFileService.uploadFileService(encryptFile.encryptFile(file));
    }

}
