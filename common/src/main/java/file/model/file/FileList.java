package file.model.file;

/**
 * Created by tianjian on 2017/11/26.
 * 文件清单
 */
public class FileList {

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件数字签名
     */
    private String fileContent;

    /**
     * 文件名称
     */
    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
}
