package tianjian.filesearch.client.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static file.util.FileUtil.saveFileToEs;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/8
 * @description 实现对文件集监听能力，服务启动，对文件夹操作实现监听，这个实现需要考虑
 */
//todo 这个类需要考虑重新实现，现在对逻辑不是太好
public class ResourceListener {

    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    private WatchService ws;
    private String listenerPath;
    private ResourceListener(String path) {
        try {
            ws = FileSystems.getDefault().newWatchService();
            this.listenerPath = path;
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        fixedThreadPool.execute(new Listner(ws,this.listenerPath));
    }

    public static void addListener(String path) throws IOException {
        ResourceListener resourceListener = new ResourceListener(path);
        Path p = Paths.get(path);
        p.register(resourceListener.ws,StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_CREATE);
    }


    public static void main(String[] args) throws IOException {
        ResourceListener.addListener("E:/aaa");
    }
}

class Listner implements Runnable {
    private WatchService service;
    private String rootPath;

    @Autowired
    FileChangeEvent fileChangeEvent;

    public Listner(WatchService service, String rootPath) {
        this.service = service;
        this.rootPath = rootPath;
    }

    public void run() {
        try {
            while(true){
                WatchKey watchKey = service.take();
                List<WatchEvent<?>> watchEvents = watchKey.pollEvents();
                for(WatchEvent<?> event : watchEvents){
                    if(event.kind().name().equals("ENTRY_CREATE")) {
                        fileChangeEvent.addFile(new File("file"));
                        saveFileToEs(new File(rootPath+"/"+event.context()));
                    }
                    //TODO 根据事件类型采取不同的操作。。。。。。。
                    System.out.println("["+rootPath+"/"+event.context()+"]文件发生了["+event.kind()+"]事件");
                }
                watchKey.reset();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            System.out.println("fdsfsdf");
            try {
                service.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
