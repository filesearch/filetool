package file.model.file;

/**
 * Created by tianjian on 2017/11/26.
 */
public enum ServiceType {

    DELETE("delete", "00000"), ADD("add", "00001"), FILELIST("filelist", "00002");


    private String name ;
    private String code ;

    private ServiceType(String name , String code ){
        this.name = name ;
        this.code = code ;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
