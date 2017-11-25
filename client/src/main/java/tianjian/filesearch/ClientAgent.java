package tianjian.filesearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tianjian.filesearch.client.User;
import tianjian.filesearch.client.service.ClientSendMessage;
import tianjian.filesearch.client.service.impl.UploadFileServiceImpl;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author <a href="mailto:Administrator@gtmap.cn">Administrator</a>
 * @version 1.0, 2017/11/8
 * @description
 */
@EnableAsync
@SpringBootApplication
@RestController
public class ClientAgent {
    @Bean(name="processExecutor")
    public TaskExecutor workExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadNamePrefix("Async-");
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(20);
        threadPoolTaskExecutor.setQueueCapacity(600);
        threadPoolTaskExecutor.afterPropertiesSet();
        return threadPoolTaskExecutor;
    }

    @Autowired
    User user;

    @Autowired
    UploadFileServiceImpl uploadFileService;

    @Autowired
    ClientSendMessage clientSendMessage;

    @RequestMapping("haha")
    String home() throws IOException, ParseException {
        user.test();
//        uploadFileService.watchAndScanFile();
        clientSendMessage.clientSendMessage("test");
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ClientAgent.class, args);
    }

}